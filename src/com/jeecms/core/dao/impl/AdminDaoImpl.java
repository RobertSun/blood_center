package com.jeecms.core.dao.impl;

import org.springframework.stereotype.Repository;

import com.jeecms.core.JeeCoreDaoImpl;
import com.jeecms.core.dao.AdminDao;
import com.jeecms.core.entity.Admin;

@Repository
public class AdminDaoImpl extends JeeCoreDaoImpl<Admin> implements AdminDao {
	public Admin getAdminByUser(Long webId, Long unitedId) {
		String hql = "from Admin u where u.website.id=? and u.user.id=?";
		return (Admin) findUnique(hql, webId, unitedId);
	}
}