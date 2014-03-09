package com.jeecms.download.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jeecms.core.JeeCoreDaoImpl;
import com.jeecms.download.dao.DownTypeDao;
import com.jeecms.download.entity.DownType;

@Repository
public class DownTypeDaoImpl extends JeeCoreDaoImpl<DownType> implements DownTypeDao {
	@SuppressWarnings("unchecked")
	public List<DownType> getList(Long webId, boolean all) {
		String hql = "select l from DownType l where l.website.id=?";
		if (!all) {
			hql += " and l.disabled = false";
		}
		hql += " order by l.priority asc";
		List<DownType> list = find(hql, webId);
		return list;
	}
}