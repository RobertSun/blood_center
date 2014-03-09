package com.jeecms.core.manager;

import java.util.List;
import java.util.Set;

import com.jeecms.core.JeeCoreManager;
import com.jeecms.core.entity.Function;

public interface FunctionMng extends JeeCoreManager<Function> {

	/**
	 * ��ù���ԱȨ��
	 * 
	 * @param adminId
	 * @return
	 */
	public List<Function> getFunctions(Long adminId);

	/**
	 * ��ù���ԱȨ�����
	 * 
	 * @param adminId
	 * @return
	 */
	public Set<String> getFunctionItems(Long adminId);

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