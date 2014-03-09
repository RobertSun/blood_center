package com.jeecms.core;

import java.io.IOException;

import org.apache.commons.lang.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.jeecms.core.service.ChannelCacheSvc;
import com.jeecms.core.service.HomepageCacheSvc;

@SuppressWarnings("unchecked")
public abstract class PageBaseAction extends IntegrityAction {
	public static final String INDEX = "index";
	public static final int HOMEPAGE_CACHE = 1;
	public static final int CHANNEL_CACHE = 2;
	public static final String PAGE_CACHE_RESULT = "pageCache";

	private void handlePathParams() {
		len = pathParams.length;
		pathName = pathParams[0];
		pageName = pathParams[len - 1];
	}

	@Override
	public String execute() throws Exception {
		handlePathParams();
		pageName = pathParams[len - 1];
		if (len == 1 && pageName.equals(INDEX)) {
			// 首页
			return sysIndex();
		} else if (len == 1 && NumberUtils.isDigits(pageName)) {
			// 内容
			try {
				return content(null, Long.parseLong(pageName));
			} catch (NumberFormatException nfe) {
				return pageNotFound();
			}
		} else if (len == 1) {
			return alone(pageName);
		} else if (len == 2 && pageName.equals(INDEX)) {
			return chnlIndex(pathName);
		} else if (len == 2 && NumberUtils.isDigits(pageName)) {
			try {
				return content(pathName, Long.parseLong(pageName));
			} catch (NumberFormatException nfe) {
				return pageNotFound();
			}
		} else {
			return pageNotFound();
		}
	}

	/**
	 * 系统首页
	 */
	protected abstract String sysIndex() throws IOException;

	/**
	 * 栏目页
	 */
	protected abstract String chnlIndex(String chnlName) throws IOException;

	/**
	 * 内容页
	 */
	protected abstract String content(String chnlName, Long id)
			throws IOException;

	/**
	 * 单页
	 */
	protected abstract String alone(String chnlName) throws IOException;

	/**
	 * 页面找不到
	 * 
	 * @return
	 */
	protected abstract String pageNotFound();

	protected String[] pathParams;
	protected int len = 0;
	protected String pathName;
	protected String pageName;

	@Autowired
	protected HomepageCacheSvc homepageCacheSvc;
	protected Long ckHomepage;

	@Autowired
	protected ChannelCacheSvc channelCacheSvc;
	protected String ckChannel;

	protected int cacheType;

	public void setPathParams(String[] pathParams) {
		this.pathParams = pathParams;
	}

	public void setWholeUrl(String wholeUrl) {
		this.wholeUrl = wholeUrl;
	}

	public void setPageLink(String pageLink) {
		this.pageLink = pageLink;
	}

	public void setPageSuffix(String pageSuffix) {
		this.pageSuffix = pageSuffix;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public Long getCkHomepage() {
		return ckHomepage;
	}

	public void setCkHomepage(Long ckHomepage) {
		this.ckHomepage = ckHomepage;
	}

	public String getCkChannel() {
		return ckChannel;
	}

	public void setCkChannel(String ckChannel) {
		this.ckChannel = ckChannel;
	}

	public int getCacheType() {
		return cacheType;
	}

	public void setCacheType(int cacheType) {
		this.cacheType = cacheType;
	}
}
