package com.jeecms.cms.dao.impl;

import org.springframework.stereotype.Repository;

import com.jeecms.cms.dao.ContentCtgDao;
import com.jeecms.cms.entity.ContentCtg;
import com.jeecms.core.JeeCoreDaoImpl;

@Repository
public class ContentCtgDaoImpl extends JeeCoreDaoImpl<ContentCtg> implements
		ContentCtgDao {
	public ContentCtg getContentCtg(Long webId, String label) {
		String hql = "from ContentCtg a where a.website.id=? and a.label=?";
		return (ContentCtg) findUnique(hql, webId, label);
	}
}