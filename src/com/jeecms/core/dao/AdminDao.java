package com.jeecms.core.dao;

import com.jeecms.core.JeeCoreDao;
import com.jeecms.core.entity.Admin;

public interface AdminDao extends JeeCoreDao<Admin> {
	/**
	 * 通过统一用户ID获得管理员
	 * 
	 * @param webId
	 * @param unitedId
	 * @return
	 */
	public Admin getAdminByUser(Long webId, Long unitedId);
}