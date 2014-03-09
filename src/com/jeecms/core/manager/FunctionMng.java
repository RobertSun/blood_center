package com.jeecms.core.manager;

import java.util.List;
import java.util.Set;

import com.jeecms.core.JeeCoreManager;
import com.jeecms.core.entity.Function;

public interface FunctionMng extends JeeCoreManager<Function> {

	/**
	 * 获得管理员权限
	 * 
	 * @param adminId
	 * @return
	 */
	public List<Function> getFunctions(Long adminId);

	/**
	 * 获得管理员权限项集合
	 * 
	 * @param adminId
	 * @return
	 */
	public Set<String> getFunctionItems(Long adminId);

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