package com.jeecms.cms.dao;

import java.util.List;

import com.jeecms.cms.entity.ChnlModel;
import com.jeecms.core.JeeCoreDao;

public interface ChnlModelDao extends JeeCoreDao<ChnlModel> {
	/**
	 * ���ҿ������ӽڵ��ģ��
	 * 
	 * @param webId
	 * @return
	 */
	public List<ChnlModel> getHasChild(Long webId);
}