package com.jeecms.cms.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jeecms.cms.entity.CmsTopic;
import com.jeecms.cms.dao.CmsTopicDao;
import com.jeecms.common.hibernate3.Finder;
import com.jeecms.common.page.Pagination;
import com.jeecms.core.JeeCoreDaoImpl;

@Repository
public class CmsTopicDaoImpl extends JeeCoreDaoImpl<CmsTopic> implements
		CmsTopicDao {

	public Pagination getForTag(boolean isPage, int firstResult, int pageNo,
			int pageSize) {
		Finder f = Finder.create("select bean from CmsTopic bean");
		f.append(" order by bean.priority asc,bean.id desc");
		if (isPage) {
			return find(f, pageNo, pageSize);
		} else {
			f.setFirstResult(firstResult);
			f.setMaxResults(pageSize);
			@SuppressWarnings("rawtypes")
			List list = find(f);
			return new Pagination(pageNo, list.size(), pageSize, list);
		}
	}
}