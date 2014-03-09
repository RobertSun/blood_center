package com.jeecms.core.manager.impl;

import java.util.List;

import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeecms.common.hibernate3.OrderBy;
import com.jeecms.common.page.Pagination;
import com.jeecms.core.JeeCoreManagerImpl;
import com.jeecms.core.dao.WebsiteDao;
import com.jeecms.core.entity.Website;
import com.jeecms.core.manager.WebsiteMng;

/**
 * 站点管理实现。
 * <p>
 * 系统启动时，加载所有站点信息。使用hibernate二级缓存，应用缓存保存域名domain到id的关系。
 * </p>
 * <ul>
 * <li>修改website是检查是否修改域名，否则清空缓存。</li>
 * <li>添加站点时，加入缓存</li>
 * </ul>
 * 
 * @author liufang
 * 
 */
@Service
@Transactional
public class WebsiteMngImpl extends JeeCoreManagerImpl<Website> implements
		WebsiteMng {
	public List<Website> getAllWebsite() {
		return findAll();
	}

	public Pagination getAllWebsite(int page, int countPerPage) {
		return findAll(page, countPerPage, new OrderBy[] { OrderBy.desc("id") });
	}

	public List<Website> getListForUpdate(Long webId) {
		return getDao().getListForUpdate(webId);
	}

	public Website removeWebsite(Long id) {
		Website website = getDao().load(id);
		getDao().delete(website);
		websiteDomainCache.remove(website.getDomain());
		return website;
	}

	public Website getWebsite(Long id) {
		Website w = null;
		w = getDao().load(id);
		return w;
	}

	public Website getWebsite(String domainName) {
		Element e = websiteDomainCache.get(domainName);
		if (e != null) {
			Object websiteId = e.getObjectValue();
            Website website = getWebsite((Long) websiteId);
            if(website != null){
                website.setCurrentAccessDomain(domainName);
            }
			return website;
		} else {
			log.warn("get website from cache, domain not exist:{}", domainName);
			return null;
		}
	}

	public Website save(Website website) {
		getDao().save(website);
		return website;
	}

	public Website getByAlias(String domainName) {
		Element e = websiteAliasCache.get(domainName);
		if (e != null) {
			Object webId = e.getObjectValue();
			return getWebsite((Long) webId);
		} else {
			log.warn("get website by alias from cache, domain not exist:{}",
					domainName);
			return null;
		}
	}

	public List<Website> getListByUserId(Long unitedId) {
		return getDao().getListByUserId(unitedId);
	}

	public void loadAllWebsiteToCache() {
		websiteDomainCache.removeAll();
		websiteAliasCache.removeAll();
		List<Website> ws = getDao().findAll();
		for (Website w : ws) {
            this.updateWebsiteDomainCache(w.getDomains(),w.getId());
			String[] alias = w.getAlias();
			if (alias != null) {
				for (String a : alias) {
					websiteAliasCache.put(new Element(a, w.getId()));
				}
			}
		}
	}
    private void removeWebsiteDomainCache(String[] domains){
        for(String domain : domains){
            websiteDomainCache.remove(domain);
        }
    }

    private void updateWebsiteDomainCache(String[] domains, Long websiteId){
        for(String domain : domains){
            websiteDomainCache
                    .put(new Element(domain, websiteId));
        }
    }

	public Website updateWebsite(Website website) {
		Website before = getWebsite(website.getId());
		String beforeDomain = before.getDomain();
		String beforeAlias = before.getDomainAlias();
		String[] beforeAliasArr = before.getAlias();
		Website after = (Website) getDao().updateDefault(website);
		if (!StringUtils.equals(beforeDomain, after.getDomain())) {
            this.removeWebsiteDomainCache(before.getDomains());
            this.updateWebsiteDomainCache(after.getDomains(), after.getId());
		}
		if (!StringUtils.equals(beforeAlias, after.getDomainAlias())) {
			if (beforeAliasArr != null) {
				for (String a : beforeAliasArr) {
					websiteAliasCache.remove(a);
				}
			}
			String[] afterAliasArr = after.getAlias();
			if (afterAliasArr != null) {
				for (String a : afterAliasArr) {
					websiteAliasCache.put(new Element(a, after.getId()));
				}
			}
		}
		return after;
	}

	public boolean checkDomain(String domain) {
		return getDao().countByProperty("domain", domain) <= 0;
	}

	public boolean checkResPath(String resPath) {
		return getDao().countByProperty("resPath", resPath) <= 0;
	}

	private Ehcache websiteDomainCache;
	private Ehcache websiteAliasCache;

	@Autowired
	public void setWebsiteDomainCache(
			@Qualifier("websiteDomain") Ehcache websiteDomainCache) {
		this.websiteDomainCache = websiteDomainCache;
	}

	@Autowired
	public void setWebsiteAliasCache(
			@Qualifier("websiteAlias") Ehcache websiteAliasCache) {
		this.websiteAliasCache = websiteAliasCache;
	}

	@Autowired
	public void setWebsiteDao(WebsiteDao dao) {
		super.setDao(dao);
	}

	public WebsiteDao getDao() {
		return (WebsiteDao) super.getDao();
	}
}
