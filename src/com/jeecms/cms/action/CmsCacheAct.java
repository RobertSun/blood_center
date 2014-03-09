package com.jeecms.cms.action;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.jeecms.article.lucene.LuceneArticleSvc;
import com.jeecms.cms.Constants;
import com.jeecms.cms.entity.CmsConfig;
import com.jeecms.cms.manager.CmsConfigMng;
import com.jeecms.common.struts2.ContextPvd;
import com.jeecms.core.service.ChannelCacheSvc;
import com.jeecms.core.service.HomepageCacheSvc;

@SuppressWarnings("serial")
@Scope("prototype")
@Controller("cms.cmsCacheAct")
public class CmsCacheAct extends com.jeecms.core.JeeCoreAction {
	private static final Logger log = LoggerFactory
			.getLogger(CmsCacheAct.class);

	public String configEdit() {
		CmsConfig config = cmsConfigMng.findById(getWebId());
		cacheHomepage = config.getCacheHomepage();
		cacheChannel = config.getCacheChannel();
		return EDIT;
	}

	public String configUpdate() {
		CmsConfig config = cmsConfigMng.findById(getWebId());
		if (cacheHomepage != null) {
			config.setCacheHomepage(cacheHomepage);
		}
		if (cacheChannel != null) {
			config.setCacheChannel(cacheChannel);
		}
		cmsConfigMng.update(config);
		addActionMessage("修改成功");
		return configEdit();
	}

	public String clearHomepageCache() {
		homepageCacheSvc.remove(getWebId());
		jsonRoot.put("success", true);
		jsonRoot.put("msg", "清除成功");
		return SUCCESS;
	}

	public String clearChannelCache() {
		channelCacheSvc.remove(getWebId());
		jsonRoot.put("success", true);
		jsonRoot.put("msg", "清除成功");
		return SUCCESS;
	}

	public String lucene() {
		int count;
		try {
			count = luceneArticleSvc.index(contextPvd
					.getAppRealPath(Constants.LUCENE_ARTICLE_PATH), startDate);
			jsonRoot.put("success", true);
			jsonRoot.put("count", count);
		} catch (Exception e) {
			jsonRoot.put("success", false);
			jsonRoot.put("msg", e.getMessage());
			log.error("创建文章全文检索索引时出错", e);
		}
		return SUCCESS;
	}

	@Autowired
	private CmsConfigMng cmsConfigMng;
	@Autowired
	protected HomepageCacheSvc homepageCacheSvc;
	@Autowired
	protected ChannelCacheSvc channelCacheSvc;
	@Autowired
	private LuceneArticleSvc luceneArticleSvc;
	@Autowired
	private ContextPvd contextPvd;
	private Boolean cacheHomepage;
	private Boolean cacheChannel;
	private Date startDate;

	private Map<String, Object> jsonRoot = new HashMap<String, Object>();

	public Boolean getCacheHomepage() {
		return cacheHomepage;
	}

	public void setCacheHomepage(Boolean cacheHomepage) {
		this.cacheHomepage = cacheHomepage;
	}

	public Boolean getCacheChannel() {
		return cacheChannel;
	}

	public void setCacheChannel(Boolean cacheChannel) {
		this.cacheChannel = cacheChannel;
	}

	public Map<String, Object> getJsonRoot() {
		return jsonRoot;
	}

	public void setJsonRoot(Map<String, Object> jsonRoot) {
		this.jsonRoot = jsonRoot;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
}
