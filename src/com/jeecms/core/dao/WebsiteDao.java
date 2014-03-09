package com.jeecms.core.dao;

import java.util.List;

import com.jeecms.core.JeeCoreDao;
import com.jeecms.core.entity.Website;

public interface WebsiteDao extends JeeCoreDao<Website> {
	public List<Website> getListByUserId(Long userId);

	/**
	 * 获得列表。去除自身及自身的子站点
	 * 
	 * @param webId
	 * @return
	 */
	public List<Website> getListForUpdate(Long webId);
}
