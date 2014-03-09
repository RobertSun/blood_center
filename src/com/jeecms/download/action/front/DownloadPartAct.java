package com.jeecms.download.action.front;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.jeecms.cms.CmsPartAction;
import com.jeecms.cms.Constants;
import com.jeecms.cms.manager.CmsMemberMng;
import com.jeecms.cms.manager.ContentCtgMng;
import com.jeecms.common.struts2.ContextPvd;
import com.jeecms.core.manager.MemberMng;
import com.jeecms.download.entity.Download;
import com.jeecms.download.manager.DownloadMng;

@Scope("prototype")
@Controller("download.downloadPartAct")
public class DownloadPartAct extends CmsPartAction {
	private void tagDownloadList() {
		Boolean hasTitleImg;
		switch (hasImg) {
		case 2:
			hasTitleImg = false;
			break;
		case 1:
			hasTitleImg = true;
			break;
		default:
			hasTitleImg = null;
		}
		Long ctgId = null;
		if (!StringUtils.isBlank(attr)) {
			ctgId = artiCtgMng.getContentCtg(getRootWebId(), attr).getId();
		}
		pagination = downloadMng.getForTag(getWebId(), chnlId, ctgId,
				searchKey, hasTitleImg, recommend == 1 ? true : false,
				topLevel, orderBy, "1".equals(isPage) ? true : false,
				firstResult, pageNo, count);
	}

	public String downloadList() {
		tagDownloadList();
		if (newday > 0) {
			for (int i = 0; i < pagination.getList().size(); i++) {
				Download download = (Download) pagination.getList().get(i);
				download.checkNew(newday);
				if (!download.isIfNew()) {
					break;
				}
			}
		}
		return handleResult("downloadList");
	}

	public String downloadListInner() {
		tagDownloadList();
		contextPvd.setRequestAttr(INNER_PAGE, pagination);
		return SUCCESS;
	}

	public String downSortList() {
		pagination = downloadMng.getDownloadBySort(getWebId(), chnlId, typeId,
				status, null, orderBy, pageNo, count);
		return handleResult("downloadList");
	}

	@Override
	public String getSysType() {
		return Constants.DOWNLOAD_SYS;
	}

	private Long chnlId;
	private String attr;
	private int hasImg;
	private int recommend;
	private int topLevel;
	private String searchKey;

	private int titLen;
	private String target;
	private String headMark;
	private String lineHeight;
	private String bottomLine;
	private String ctgForm;
	private String ctgClass;
	private String dateFormat;
	private String datePosition;

	private String picWidth;
	private String picHeight;

	private String rollDisplayHeight;
	private String rollLineHeight;
	private String rightPadding;
	private int rollCols;
	private String rollSpeed;
	private String isSleep;
	private String rollSleepTime;
	private String rollCount;
	private String rollSpan;

	private int newday;
	private Long id;
	private Long typeId;
	private int status;

	private String flashWidth;
	private String flashHeight;
	private String textHeight;
	@Autowired
	private DownloadMng downloadMng;
	@Autowired
	private ContentCtgMng artiCtgMng;
	@Autowired
	protected MemberMng memberMng;
	@Autowired
	protected CmsMemberMng cmsMemberMng;
	@Autowired
	private ContextPvd contextPvd;

	public int getRecommend() {
		return recommend;
	}

	public void setRecommend(int recommend) {
		this.recommend = recommend;
	}

	public String getSearchKey() {
		return searchKey;
	}

	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}

	public Long getChnlId() {
		return chnlId;
	}

	public void setChnlId(Long chnlId) {
		this.chnlId = chnlId;
	}

	public int getHasImg() {
		return hasImg;
	}

	public void setHasImg(int hasImg) {
		this.hasImg = hasImg;
	}

	public String getPicWidth() {
		return picWidth;
	}

	public void setPicWidth(String picWidth) {
		this.picWidth = picWidth;
	}

	public String getPicHeight() {
		return picHeight;
	}

	public void setPicHeight(String picHeight) {
		this.picHeight = picHeight;
	}

	public String getRollDisplayHeight() {
		return rollDisplayHeight;
	}

	public void setRollDisplayHeight(String rollDisplayHeight) {
		this.rollDisplayHeight = rollDisplayHeight;
	}

	public String getRollLineHeight() {
		return rollLineHeight;
	}

	public void setRollLineHeight(String rollLineHeight) {
		this.rollLineHeight = rollLineHeight;
	}

	public String getRollSpeed() {
		return rollSpeed;
	}

	public void setRollSpeed(String rollSpeed) {
		this.rollSpeed = rollSpeed;
	}

	public String getRollSleepTime() {
		return rollSleepTime;
	}

	public void setRollSleepTime(String rollSleepTime) {
		this.rollSleepTime = rollSleepTime;
	}

	public String getRollCount() {
		return rollCount;
	}

	public void setRollCount(String rollCount) {
		this.rollCount = rollCount;
	}

	public String getRollSpan() {
		return rollSpan;
	}

	public void setRollSpan(String rollSpan) {
		this.rollSpan = rollSpan;
	}

	public String getIsSleep() {
		return isSleep;
	}

	public void setIsSleep(String isSleep) {
		this.isSleep = isSleep;
	}

	public String getFlashWidth() {
		return flashWidth;
	}

	public void setFlashWidth(String flashWidth) {
		this.flashWidth = flashWidth;
	}

	public String getFlashHeight() {
		return flashHeight;
	}

	public void setFlashHeight(String flashHeight) {
		this.flashHeight = flashHeight;
	}

	public String getTextHeight() {
		return textHeight;
	}

	public void setTextHeight(String textHeight) {
		this.textHeight = textHeight;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String getHeadMark() {
		return headMark;
	}

	public void setHeadMark(String headMark) {
		this.headMark = headMark;
	}

	public String getLineHeight() {
		return lineHeight;
	}

	public void setLineHeight(String lineHeight) {
		this.lineHeight = lineHeight;
	}

	public String getBottomLine() {
		return bottomLine;
	}

	public void setBottomLine(String bottomLine) {
		this.bottomLine = bottomLine;
	}

	public String getCtgForm() {
		return ctgForm;
	}

	public void setCtgForm(String ctgForm) {
		this.ctgForm = ctgForm;
	}

	public String getCtgClass() {
		return ctgClass;
	}

	public void setCtgClass(String ctgClass) {
		this.ctgClass = ctgClass;
	}

	public String getDateFormat() {
		return dateFormat;
	}

	public void setDateFormat(String dateFormat) {
		this.dateFormat = dateFormat;
	}

	public String getDatePosition() {
		return datePosition;
	}

	public void setDatePosition(String datePosition) {
		this.datePosition = datePosition;
	}

	public String getAttr() {
		return attr;
	}

	public void setAttr(String attr) {
		this.attr = attr;
	}

	public int getTitLen() {
		return titLen;
	}

	public void setTitLen(int titLen) {
		this.titLen = titLen;
	}

	public int getRollCols() {
		return rollCols;
	}

	public void setRollCols(int rollCols) {
		this.rollCols = rollCols;
	}

	public String getRightPadding() {
		return rightPadding;
	}

	public void setRightPadding(String rightPadding) {
		this.rightPadding = rightPadding;
	}

	public int getNewday() {
		return newday;
	}

	public void setNewday(int newday) {
		this.newday = newday;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getTopLevel() {
		return topLevel;
	}

	public void setTopLevel(int topLevel) {
		this.topLevel = topLevel;
	}

	public Long getTypeId() {
		return typeId;
	}

	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
}
