package com.jeecms.cms.dao;

import java.util.List;

import com.jeecms.cms.entity.CmsMemberGroup;
import com.jeecms.core.JeeCoreDao;

public interface CmsMemberGroupDao extends JeeCoreDao<CmsMemberGroup> {
	/**
	 * ����û����б�
	 * 
	 * @param webId
	 *            վ��ID
	 * @param fromLevel
	 *            ��ʼ����
	 * @param asc
	 *            ���鼶���������
	 * @return
	 */
	public List<CmsMemberGroup> getList(Long webId, int fromLevel, boolean asc);
}