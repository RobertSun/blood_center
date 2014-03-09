package com.jeecms.core.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jeecms.core.JeeCoreDaoImpl;
import com.jeecms.core.dao.WebsiteDao;
import com.jeecms.core.entity.Website;

@Repository
public class WebsiteDaoImpl extends JeeCoreDaoImpl<Website> implements
		WebsiteDao {
	@SuppressWarnings("unchecked")
	public List<Website> getListByUserId(Long userId) {
		String hql = "select web from Admin admin"
				+ " inner join admin.website web"
				+ " inner join admin.user user where user.id=?";
		return find(hql, userId);
	}

	@SuppressWarnings("unchecked")
	public List<Website> getListForUpdate(Long webId) {
		String hql = "select bean from Website bean,Website parent"
				+ " where (bean.lft<parent.lft or bean.rgt >parent.rgt)"
				+ " and parent.id=?";
		return find(hql, webId);
	}
}
