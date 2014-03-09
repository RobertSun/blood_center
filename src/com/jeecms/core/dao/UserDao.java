package com.jeecms.core.dao;

import com.jeecms.core.JeeCoreDao;
import com.jeecms.core.entity.User;

public interface UserDao extends JeeCoreDao<User> {
	/**
	 * 根据登录名查找用户。未找到返回null。
	 * 
	 * @param loginName
	 * @return
	 */
	public User getUserByLoginName(String loginName);
}