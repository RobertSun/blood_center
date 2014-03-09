package com.jeecms.cms.action;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.jeecms.common.util.PwdEncoder;
import com.jeecms.core.entity.User;

@SuppressWarnings("serial")
@Scope("prototype")
@Controller("cms.selfInfoAct")
public class SelfInfoAct extends com.jeecms.core.JeeCoreAction {
	public String edit() {
		User user = getUser();
		loginName = user.getLoginName();
		email = user.getEmail();
		realName = user.getRealName();
		return EDIT;
	}

	public String update() {
		User user = getUser();
		if (!StringUtils.isBlank(password)) {
			if (StringUtils.isBlank(origPassword)) {
				addActionError("原密码不能为空");
				return edit();
			}
			if (!pwdEncoder.encodePassword(origPassword).equals(
					user.getPassword())) {
				addActionError("原密码错误");
				return edit();
			}
			user.setPassword(pwdEncoder.encodePassword(password));
		}
		user.setRealName(realName);
		user.setEmail(email);
		userMng.update(user);
		addActionMessage("修改成功");
		return edit();
	}

	public String checkEmail() {
		if (StringUtils.isBlank(email)) {
			return renderText("false");
		}
		if (StringUtils.equals(email, origEmail)) {
			return renderText("true");
		}
		if (userMng.checkEmail(email)) {
			return renderText("true");
		} else {
			return renderText("false");
		}
	}

	@Autowired
	private PwdEncoder pwdEncoder;
	private String loginName;
	private String origEmail;
	private String email;
	private String origPassword;
	private String password;
	private String realName;

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getOrigEmail() {
		return origEmail;
	}

	public void setOrigEmail(String origEmail) {
		this.origEmail = origEmail;
	}

	public String getOrigPassword() {
		return origPassword;
	}

	public void setOrigPassword(String origPassword) {
		this.origPassword = origPassword;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
