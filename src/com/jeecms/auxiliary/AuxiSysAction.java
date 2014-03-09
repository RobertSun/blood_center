package com.jeecms.auxiliary;

import org.springframework.beans.factory.annotation.Autowired;

import com.jeecms.auxiliary.entity.AuxiConfig;
import com.jeecms.auxiliary.manager.AuxiConfigMng;
import com.jeecms.core.JeeCoreAction;

/**
 * ����ϵͳ��action���ȡ�
 * <p>
 * ����AuxiConfig����AuxiConfig����
 * </p>
 *
 * @author liufang
 *
 */
@SuppressWarnings({ "serial", "unchecked" })
public abstract class AuxiSysAction extends JeeCoreAction {
	public AuxiConfig getConfig() {
		return auxiConfigMng.findById(getWebId());
	}

	@Autowired
	protected AuxiConfigMng auxiConfigMng;
}
