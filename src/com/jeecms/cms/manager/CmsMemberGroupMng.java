package com.jeecms.cms.manager;

import java.util.List;

import com.jeecms.core.JeeCoreManager;
import com.jeecms.cms.entity.CmsMemberGroup;

public interface CmsMemberGroupMng extends JeeCoreManager<CmsMemberGroup> {
	/**
	 * 获得用户组列表
	 * 
	 * @param webId
	 *            站点ID
	 * @param fromLevel
	 *            开始级别
	 * @param asc
	 *            从组级别升序或降序
	 * @return
	 */
	public List<CmsMemberGroup> getList(Long webId, int fromLevel, boolean asc);
}