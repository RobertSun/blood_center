package com.jeecms.cms.action.front;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.jeecms.cms.CmsPartAction;
import com.jeecms.cms.Constants;
import com.jeecms.cms.manager.CmsChannelMng;
import com.jeecms.common.page.Pagination;

@Scope("prototype")
@Controller("cms.chnlPartAct")
public class ChnlPartAct extends CmsPartAction {
	public String chnlList() {
		pagination = tagChnlList();
		return handleResult("ChnlList");
	}

	public String chnlListInner() {
		contextPvd.setRequestAttr(INNER_PAGE, tagChnlList());
		return SUCCESS;
	}

	private Pagination tagChnlList() {
		list = cmsChannelMng.getChild(getWebId(), sysType, chnlId, orderBy,
				isDisplay == 1 ? true : false, hasContent == 1 ? true : false,
				firstResult, count);
		pagination = new Pagination(pageNo, count, list.size(), list);
		return pagination;
	}

	private String sysType;
	private Long chnlId;
	private int isDisplay;
	private int hasContent;

	private String linkClass;
	private String linkTarget;
	@Autowired
	private CmsChannelMng cmsChannelMng;

	@Override
	public String getSysType() {
		return Constants.COMMON_SYS;
	}

	public Long getChnlId() {
		return chnlId;
	}

	public void setChnlId(Long chnlId) {
		this.chnlId = chnlId;
	}

	public String getLinkClass() {
		return linkClass;
	}

	public void setLinkClass(String linkClass) {
		this.linkClass = linkClass;
	}

	public int getIsDisplay() {
		return isDisplay;
	}

	public void setIsDisplay(int isDisplay) {
		this.isDisplay = isDisplay;
	}

	public String getLinkTarget() {
		return linkTarget;
	}

	public void setLinkTarget(String linkTarget) {
		this.linkTarget = linkTarget;
	}

	public int getHasContent() {
		return hasContent;
	}

	public void setHasContent(int hasContent) {
		this.hasContent = hasContent;
	}

	public void setSysType(String sysType) {
		this.sysType = sysType;
	}

}
