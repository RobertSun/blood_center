package com.jeecms.auxiliary;

import org.springframework.beans.factory.annotation.Autowired;

import com.jeecms.auxiliary.entity.AuxiConfig;
import com.jeecms.auxiliary.manager.AuxiConfigMng;
import com.jeecms.core.JeeCoreAjaxAction;

/**
 * ����ϵͳAJAX��action���ȡ�
 * <p>
 * ����AuxiConfig����
 * </p>
 *
 * @author liufang
 *
 */
public class AuxiAjaxAction extends JeeCoreAjaxAction {
	public AuxiConfig getConfig() {
		return auxiConfigMng.findById(getWebId());
	}

	@Autowired
	protected AuxiConfigMng auxiConfigMng;
}