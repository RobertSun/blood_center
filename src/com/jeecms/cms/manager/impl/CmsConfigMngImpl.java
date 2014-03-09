package com.jeecms.cms.manager.impl;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeecms.auxiliary.entity.AuxiConfig;
import com.jeecms.auxiliary.manager.AuxiConfigMng;
import com.jeecms.cms.dao.CmsConfigDao;
import com.jeecms.cms.entity.CmsAdmin;
import com.jeecms.cms.entity.CmsConfig;
import com.jeecms.cms.manager.CmsAdminMng;
import com.jeecms.cms.manager.CmsConfigMng;
import com.jeecms.common.hibernate3.Updater;
import com.jeecms.common.struts2.ContextPvd;
import com.jeecms.common.util.ComUtils;
import com.jeecms.core.Constants;
import com.jeecms.core.JeeCoreManagerImpl;
import com.jeecms.core.entity.Admin;
import com.jeecms.core.entity.Role;
import com.jeecms.core.entity.User;
import com.jeecms.core.entity.Website;
import com.jeecms.core.exception.UserRegisterException;
import com.jeecms.core.manager.RoleMng;
import com.jeecms.core.manager.WebsiteMng;

@Service
@Transactional
public class CmsConfigMngImpl extends JeeCoreManagerImpl<CmsConfig> implements
		CmsConfigMng {
	@Override
	public Object updateByUpdater(Updater updater) {
		CmsConfig config = (CmsConfig) super.updateByUpdater(updater);
		return config;
	}

	@Override
	public CmsConfig save(CmsConfig config) {
		super.save(config);
		return config;
	}

	@Override
	public CmsConfig findById(Serializable id) {
		CmsConfig config = super.findById(id);
		return config;
	}

	@Override
	public CmsConfig deleteById(Serializable id) {
		CmsConfig config = super.deleteById(id);
		return config;
	}

	public void saveWebsite(Website currWeb, Website w, User user) {
		w.setGlobal(currWeb.getGlobal());
		w.setSuffix(Website.DEF_SUFFIX);
		w.setCreateTime(ComUtils.now());
		w.setControl(currWeb.getControl());
		Map<String, String> solutions = currWeb.getSolutions();
		Map<String, String> nsolutions = new HashMap<String, String>();
		for (String key : solutions.keySet()) {
			nsolutions.put(key, solutions.get(key));
		}
		w.setSolutions(nsolutions);
		websiteMng.save(w);
		websiteDomainCache.put(new Element(w.getDomain(), w.getId()));
		String[] alias = w.getAlias();
		if (alias != null) {
			for (String a : alias) {
				websiteAliasCache.put(new Element(a, w.getId()));
			}
		}
		// 创建管理员
		CmsAdmin cmsAdmin = new CmsAdmin();
		cmsAdmin.setCheckRight(0);
		cmsAdmin.setSelfOnly(false);
		Admin admin = new Admin();
		admin.setRoles(new HashSet<Role>(roleMng.findAll()));
		try {
			cmsAdminMng.register(w.getId(), user, admin, cmsAdmin, true);
		} catch (UserRegisterException e1) {
			throw new RuntimeException(e1);
		}
		// 创建配置对象
		CmsConfig cc = findById(currWeb.getId());
		AuxiConfig ac = auxiConfigMng.findById(currWeb.getId());
		CmsConfig ncc = new CmsConfig();
		AuxiConfig nac = new AuxiConfig();
		BeanUtils.copyProperties(cc, ncc);
		BeanUtils.copyProperties(ac, nac);
		ncc.setWebsite(w);
		nac.setWebsite(w);
		save(ncc);
		auxiConfigMng.save(nac);
		// 创建模板
		String otpl = currWeb.getTplRoot().toString();
		String ores = currWeb.getResRoot();
		String ctpl = w.getTplRoot().toString();
		String cres = w.getResRoot();
		otpl = contextPvd.getAppRealPath(otpl);
		ores = contextPvd.getAppRealPath(ores);
		ctpl = contextPvd.getAppRealPath(ctpl);
		cres = contextPvd.getAppRealPath(cres);
		try {
			FileUtils.copyDirectory(new File(otpl), new File(ctpl));
			log.debug("原模板路径：{}", otpl);
			log.debug("目标模板路径：{}", ctpl);
		} catch (IOException e) {
			log.error("拷贝模板出错", e);
		}
		try {
			File[] subRes = new File(ores).listFiles(new FileFilter() {
				public boolean accept(File pathname) {
					if (pathname.getName().equals(Constants.UPLOAD_PATH)) {
						return false;
					} else {
						return true;
					}
				}
			});
			File cresFile = new File(cres);
			for (int i = 0; i < subRes.length; i++) {
				FileUtils.copyDirectory(subRes[i], new File(cresFile, subRes[i]
						.getName()));
				log.debug("原资源路径：{}", subRes[i].getAbsolutePath());
				log.debug("目标资源路径：{}/{}", cresFile.getAbsolutePath(), subRes[i]
						.getName());
			}
		} catch (IOException e) {
			log.error("拷贝资源出错", e);
		}
	}

	private WebsiteMng websiteMng;
	private RoleMng roleMng;
	private CmsAdminMng cmsAdminMng;
	private AuxiConfigMng auxiConfigMng;
	private Ehcache websiteDomainCache;
	private Ehcache websiteAliasCache;
	private ContextPvd contextPvd;

	public CmsConfigDao getCmsConfigDao() {
		return (CmsConfigDao) super.getDao();
	}

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
	public void setWebsiteMng(WebsiteMng websiteMng) {
		this.websiteMng = websiteMng;
	}

	@Autowired
	public void setCmsConfigDao(CmsConfigDao dao) {
		super.setDao(dao);
	}

	@Autowired
	public void setRoleMng(RoleMng roleMng) {
		this.roleMng = roleMng;
	}

	@Autowired
	public void setCmsAdminMng(CmsAdminMng cmsAdminMng) {
		this.cmsAdminMng = cmsAdminMng;
	}

	@Autowired
	public void setContextPvd(ContextPvd contextPvd) {
		this.contextPvd = contextPvd;
	}

	@Autowired
	public void setAuxiConfigMng(AuxiConfigMng auxiConfigMng) {
		this.auxiConfigMng = auxiConfigMng;
	}

}
