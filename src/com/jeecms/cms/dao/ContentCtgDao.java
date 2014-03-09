package com.jeecms.cms.dao;

import com.jeecms.cms.entity.ContentCtg;
import com.jeecms.core.JeeCoreDao;

public interface ContentCtgDao extends JeeCoreDao<ContentCtg> {
	/**
	 * 根据站点ID和lebel获得对象
	 * 
	 * @param webId
	 * @param label
	 * @return
	 */
	public ContentCtg getContentCtg(Long webId, String label);
}