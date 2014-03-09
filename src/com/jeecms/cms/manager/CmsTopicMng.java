package com.jeecms.cms.manager;

import com.jeecms.cms.entity.CmsTopic;
import com.jeecms.common.page.Pagination;
import com.jeecms.core.JeeCoreManager;

public interface CmsTopicMng extends JeeCoreManager<CmsTopic> {

	public Pagination getForTag(boolean isPage, int firstResult, int pageNo,
			int pageSize);

	public CmsTopic saveTopic(CmsTopic topic, String articleIds);

	public Object updateTopic(CmsTopic topic, String articleIds);
}