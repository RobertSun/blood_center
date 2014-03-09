package com.jeecms.download.dao;

import java.util.List;

import com.jeecms.core.JeeCoreDao;
import com.jeecms.download.entity.DownType;

public interface DownTypeDao extends JeeCoreDao<DownType> {
	/**
	 * 根据站点查找软件类型列表，按priority升序
	 * 
	 * @param webId
	 *            站点ID
	 * @param all
	 *            true：所有软件语言，false：未禁用软件语言
	 * @return
	 */
	public List<DownType> getList(Long webId, boolean all);
}