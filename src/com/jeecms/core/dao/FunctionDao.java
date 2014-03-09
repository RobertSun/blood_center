package com.jeecms.core.dao;

import java.util.List;

import com.jeecms.core.JeeCoreDao;
import com.jeecms.core.entity.Function;

public interface FunctionDao extends JeeCoreDao<Function> {

	/**
	 * 获得管理员的权限
	 * 
	 * @param adminId
	 * @return
	 */
	public List<Function> getFunctions(Long adminId);

	/**
	 * 获得所有根节点
	 * 
	 * @return
	 */
	public List<Function> getRoots();

	/**
	 * 获得子节点
	 * 
	 * @param pid
	 * @return
	 */
	public List<Function> getChild(Long pid);
}