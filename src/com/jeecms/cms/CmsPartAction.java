package com.jeecms.cms;

import org.springframework.beans.factory.annotation.Autowired;

import com.jeecms.cms.entity.CmsConfig;
import com.jeecms.cms.manager.CmsConfigMng;
import com.jeecms.core.PartBaseAction;

/**
 * jeecms��ǩ����
 * 
 * �ṩjeecms������Ϣ
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
