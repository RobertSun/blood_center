package com.jeecms.cms.action.front;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.jeecms.cms.CmsPartAction;
import com.jeecms.cms.Constants;

@Scope("prototype")
@Controller("cms.loginPartAct")
public class LoginPartAct extends CmsPartAction {
	public String ajaxLogin() {
		return handleResult("AjaxLogin");
	}

	@Override
	protected String getSysType() {
		return Constants.MEMBER_SYS;
	}
}
