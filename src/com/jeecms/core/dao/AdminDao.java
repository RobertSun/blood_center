package com.jeecms.core.dao;

import com.jeecms.core.JeeCoreDao;
import com.jeecms.core.entity.Admin;

public interface AdminDao extends JeeCoreDao<Admin> {
	/**
	 * ͨ��ͳһ�û�ID��ù���Ա
	 * 
	 * @param webId
	 * @param unitedId
	 * @return
	 */
	public Admin getAdminByUser(Long webId, Long unitedId);
}