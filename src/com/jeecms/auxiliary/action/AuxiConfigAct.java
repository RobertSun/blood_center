package com.jeecms.auxiliary.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.jeecms.auxiliary.entity.AuxiConfig;
import com.jeecms.auxiliary.manager.AuxiConfigMng;

@SuppressWarnings("serial")
@Scope("prototype")
@Controller("auxiliary.auxiConfigAct")
public class AuxiConfigAct extends com.jeecms.core.JeeCoreAction {
	public String configEdit() {
		this.bean = auxiConfigMng.findById(getWebId());
		return EDIT;
	}

	public String configUpdate() {
		bean.setId(getWebId());
		auxiConfigMng.updateDefault(bean);
		addActionMessage("ÐÞ¸Ä³É¹¦");
		return configEdit();
	}

	@Autowired
	private AuxiConfigMng auxiConfigMng;
	private AuxiConfig bean;

	public AuxiConfig getBean() {
		return bean;
	}

	public void setBean(AuxiConfig bean) {
		this.bean = bean;
	}
}
