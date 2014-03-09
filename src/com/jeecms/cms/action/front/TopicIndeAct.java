package com.jeecms.cms.action.front;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.jeecms.cms.CmsIndeAction;
import com.jeecms.cms.Constants;
import com.jeecms.cms.entity.CmsTopic;
import com.jeecms.cms.manager.CmsTopicMng;

/**
 * ע�����ģ��
 *
 * @author liufang
 *
 */
@SuppressWarnings("unchecked")
@Scope("prototype")
@Controller("cms.topicIndeAct")
public class TopicIndeAct extends CmsIndeAction {
	@SuppressWarnings("unused")
	private static final Logger log = LoggerFactory
			.getLogger(TopicIndeAct.class);
	public static final String TOPIC_LIST = "TopicList";
	public static final String TOPIC_ITEM = "TopicItem";

	public String topic() {
		if (topicId != null) {
			topic = topicMng.findById(topicId);
			if (topic != null) {
				return handleResult(TOPIC_ITEM);
			}
		}
		return handleResult(TOPIC_LIST);
	}

	@Override
	protected String getSysType() {
		return Constants.ARTICLE_SYS;
	}

	private Long topicId;
	private CmsTopic topic;
	@Autowired
	private CmsTopicMng topicMng;

	public Long getTopicId() {
		return topicId;
	}

	public void setTopicId(Long topicId) {
		this.topicId = topicId;
	}

	public CmsTopic getTopic() {
		return topic;
	}

	public void setTopic(CmsTopic topic) {
		this.topic = topic;
	}
}