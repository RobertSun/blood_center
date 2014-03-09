package com.jeecms.cms.dao;

import java.util.List;

import com.jeecms.cms.entity.ChnlModel;
import com.jeecms.core.JeeCoreDao;

public interface ChnlModelDao extends JeeCoreDao<ChnlModel> {
	/**
	 * 查找可以有子节点的模型
	 * 
	 * @param webId
	 * @return
	 */
	public List<ChnlModel> getHasChild(Long webId);
}