package com.jeecms.cms.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jeecms.cms.dao.CmsMemberGroupDao;
import com.jeecms.cms.entity.CmsMemberGroup;
import com.jeecms.core.JeeCoreDaoImpl;

@Repository
public class CmsMemberGroupDaoImpl extends JeeCoreDaoImpl<CmsMemberGroup>
		implements CmsMemberGroupDao {
	@SuppressWarnings("unchecked")
	public List<CmsMemberGroup> getList(Long webId, int fromLevel, boolean asc) {
		String hql = "from CmsMemberGroup g where g.website.id=?";
		if (asc) {
			hql += " and g.level>=? order by g.level asc";
		} else {
			hql += " and g.level<=? order by g.level desc";
		}
		return find(hql, webId, fromLevel);
	}
}