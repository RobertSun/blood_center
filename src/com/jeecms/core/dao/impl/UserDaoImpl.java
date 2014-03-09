package com.jeecms.core.dao.impl;

import org.springframework.stereotype.Repository;

import com.jeecms.core.JeeCoreDaoImpl;
import com.jeecms.core.dao.UserDao;
import com.jeecms.core.entity.User;

@Repository
public class UserDaoImpl extends JeeCoreDaoImpl<User> implements UserDao {
	public User getUserByLoginName(String loginName) {
		String hql = "from User u where u.loginName=?";
		return (User) findUnique(hql, loginName);
	}
}