package com.jeecms.core.dao;

import java.util.List;

import com.jeecms.core.JeeCoreDao;
import com.jeecms.core.entity.Function;

public interface FunctionDao extends JeeCoreDao<Function> {

	/**
	 * ��ù���Ա��Ȩ��
	 * 
	 * @param adminId
	 * @return
	 */
	public List<Function> getFunctions(Long adminId);

	/**
	 * ������и��ڵ�
	 * 
	 * @return
	 */
	public List<Function> getRoots();

	/**
	 * ����ӽڵ�
	 * 
	 * @param pid
	 * @return
	 */
	public List<Function> getChild(Long pid);
}