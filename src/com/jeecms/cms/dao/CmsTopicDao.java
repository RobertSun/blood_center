package com.jeecms.cms.dao;

import com.jeecms.cms.entity.CmsTopic;
import com.jeecms.common.page.Pagination;
import com.jeecms.core.JeeCoreDao;

public interface CmsTopicDao extends JeeCoreDao<CmsTopic> {
	public Pagination getForTag(boolean isPage, int firstResult, int pageNo,
			int pageSize);
}