package com.jeecms.cms.manager;

import java.util.List;

import com.jeecms.core.JeeCoreManager;
import com.jeecms.cms.entity.CmsMemberGroup;

public interface CmsMemberGroupMng extends JeeCoreManager<CmsMemberGroup> {
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