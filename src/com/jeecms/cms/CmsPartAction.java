package com.jeecms.cms;

import org.springframework.beans.factory.annotation.Autowired;

import com.jeecms.cms.entity.CmsConfig;
import com.jeecms.cms.manager.CmsConfigMng;
import com.jeecms.core.PartBaseAction;

/**
 * jeecms标签基类
 * 
 * 提供jeecms配置信息
 * 
 * @author liufang
 * 
 */
public abstract class CmsPartAction extends PartBaseAction {
	public CmsConfig getConfig() {
		return cmsConfigMng.findById(getWebId());
	}

	@Autowired
	protected CmsConfigMng cmsConfigMng;
}
