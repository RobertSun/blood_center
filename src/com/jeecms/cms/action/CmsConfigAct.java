package com.jeecms.cms.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.jeecms.cms.entity.CmsConfig;
import com.jeecms.cms.manager.CmsConfigMng;
import com.jeecms.core.entity.Control;
import com.jeecms.core.entity.Website;

@SuppressWarnings("serial")
@Scope("prototype")
@Controller("cms.cmsConfigAct")
public class CmsConfigAct extends com.jeecms.core.JeeCoreAction {

	public String configEdit() {
		this.bean = cmsConfigMng.findById(getWebId());
		this.control = getWeb().getControl();
		return EDIT;
	}

	public String configUpdate() {
		bean.setId(getWebId());
		cmsConfigMng.updateDefault(bean);
		Website web = new Website();
		web.setId(getWebId());
		web.setControl(control);
		websiteMng.updateWebsite(web);
		addActionMessage("ÐÞ¸Ä³É¹¦");
		return configEdit();
	}

	@Autowired
	private CmsConfigMng cmsConfigMng;
	private CmsConfig bean;
	private Control control;

	public CmsConfig getBean() {
		return bean;
	}

	public void setBean(CmsConfig bean) {
		this.bean = bean;
	}

	public Control getControl() {
		return control;
	}

	public void setControl(Control control) {
		this.control = control;
	}
}
