package com.jeecms.cms.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.jeecms.common.struts2.interceptor.DomainNameAware;
import com.jeecms.common.struts2.interceptor.UrlAware;
import com.jeecms.core.Constants;
import com.jeecms.core.entity.Website;
import com.jeecms.core.manager.WebsiteMng;
import com.opensymphony.xwork2.Action;

@Scope("prototype")
@Controller("core.dynamicSystemAct")
public class DynamicSystemAct implements Action, DomainNameAware, UrlAware {
	public String execute() {
		Website web = websiteMng.getWebsite(domainName);
		if (web == null) {
			// ¼ì²é±ðÃû
			web = websiteMng.getByAlias(domainName);
			if (web != null) {
				redirectUrl = web.getWebUrl();
				return Constants.REDIRECT;
			} else {
				return Constants.WEBSITE_NOT_FOUND;
			}
		}
		String sys = web.getCurrentSystem();
		namespace = "/jeedynamic/" + sys;
		actionName = "Page";
		return SUCCESS;
	}

	private String namespace;
	private String actionName;
	private String pageName;
	private String pathName;
	private String domainName;

	private String[] pathParams;
	private String[] otherParams;
	private String wholeUrl;
	private String pageLink;
	private String pageSuffix;
	private int pageNo = 1;

	private String redirectUrl;
	@Autowired
	private WebsiteMng websiteMng;

	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}

	public void setPathParams(String[] pathParams) {
		this.pathParams = pathParams;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public void setPageLink(String pageLink) {
		this.pageLink = pageLink;
	}

	public void setPageSuffix(String pageSuffix) {
		this.pageSuffix = pageSuffix;
	}

	public void setWholeUrl(String wholeUrl) {
		this.wholeUrl = wholeUrl;
	}

	public String getNamespace() {
		return namespace;
	}

	public void setNamespace(String namespace) {
		this.namespace = namespace;
	}

	public String getActionName() {
		return actionName;
	}

	public void setActionName(String actionName) {
		this.actionName = actionName;
	}

	public String getPageName() {
		return pageName;
	}

	public void setPageName(String pageName) {
		this.pageName = pageName;
	}

	public String getPathName() {
		return pathName;
	}

	public void setPathName(String pathName) {
		this.pathName = pathName;
	}

	public String getDomainName() {
		return domainName;
	}

	public String[] getPathParams() {
		return pathParams;
	}

	public String getWholeUrl() {
		return wholeUrl;
	}

	public String getPageLink() {
		return pageLink;
	}

	public String getPageSuffix() {
		return pageSuffix;
	}

	public int getPageNo() {
		return pageNo;
	}

	public String getRedirectUrl() {
		return redirectUrl;
	}

	public void setRedirectUrl(String redirectUrl) {
		this.redirectUrl = redirectUrl;
	}

	public String[] getOtherParams() {
		return otherParams;
	}

	public void setOtherParams(String[] otherParams) {
		this.otherParams = otherParams;
	}
}
