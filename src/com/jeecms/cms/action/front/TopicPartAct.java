package com.jeecms.cms.action.front;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.jeecms.cms.CmsPartAction;
import com.jeecms.cms.Constants;
import com.jeecms.cms.manager.CmsTopicMng;
import com.jeecms.common.page.Pagination;

@Scope("prototype")
@Controller("cms.topicPartAct")
public class TopicPartAct extends CmsPartAction {
	public String topicList() {
		pagination = tagTopicList();
		return handleResult("TopicList");
	}

	public String topicListInner() {
		contextPvd.setRequestAttr(INNER_PAGE, tagTopicList());
		return SUCCESS;
	}

	private Pagination tagTopicList() {
		pagination = topicMng.getForTag("1".equals(isPage) ? true : false,
				firstResult, pageNo, count);
		return pagination;
	}

	private Long topicId;
	@Autowired
	private CmsTopicMng topicMng;

	@Override
	public String getSysType() {
		return Constants.ARTICLE_SYS;
	}

	public Long getTopicId() {
		return topicId;
	}

	public void setTopicId(Long topicId) {
		this.topicId = topicId;
	}

}
