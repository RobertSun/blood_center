package com.jeecms.download.dao;

import java.util.List;

import com.jeecms.core.JeeCoreDao;
import com.jeecms.download.entity.DownType;

public interface DownTypeDao extends JeeCoreDao<DownType> {
	/**
	 * ����վ�������������б���priority����
	 * 
	 * @param webId
	 *            վ��ID
	 * @param all
	 *            true������������ԣ�false��δ�����������
	 * @return
	 */
	public List<DownType> getList(Long webId, boolean all);
}