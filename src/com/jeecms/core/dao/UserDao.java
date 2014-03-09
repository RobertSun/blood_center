package com.jeecms.core.dao;

import com.jeecms.core.JeeCoreDao;
import com.jeecms.core.entity.User;

public interface UserDao extends JeeCoreDao<User> {
	/**
	 * ���ݵ�¼�������û���δ�ҵ�����null��
	 * 
	 * @param loginName
	 * @return
	 */
	public User getUserByLoginName(String loginName);
}