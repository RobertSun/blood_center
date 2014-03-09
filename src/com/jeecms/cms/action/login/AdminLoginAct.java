package com.jeecms.cms.action.login;

import static com.jeecms.common.util.ComUtils.JSESSION_COOKIE;

import java.util.Set;

import javax.servlet.http.Cookie;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.jeecms.common.struts2.ContextPvd;
import com.jeecms.core.Constants;
import com.jeecms.core.JeeCoreAction;
import com.jeecms.core.entity.Admin;
import com.jeecms.core.entity.User;
import com.jeecms.core.entity.Website;
import com.jeecms.core.manager.FunctionMng;
import com.octo.captcha.service.image.ImageCaptchaService;

@SuppressWarnings("serial")
@Scope("prototype")
@Controller("cms.adminLoginAct")
public class AdminLoginAct extends JeeCoreAction {
	public String loginInput() {
		Website web = websiteMng.getWebsite(domainName);
		if (web == null) {
			web = websiteMng.getByAlias(domainName);
			if (web != null) {
				return redirect(web.getWebUrl());
			} else {
				return Constants.WEBSITE_NOT_FOUND;
			}
		}
		return "loginInput";
	}

	public String login() {
		boolean isHuman = imageCaptchaService.validateResponseForID(contextPvd
				.getSessionId(false), checkCode);
		if (!isHuman) {
			addActionError("验证码错误！");
			return loginInput();
		}
		User user = userMng.authenticate(loginName, password);
		if (user == null) {
			addActionError("用户名不存在或密码错误！");
			return loginInput();
		}
		Admin admin = adminMng.getByUserId(getWebId(), user.getId());
		if (admin == null) {
			addActionError("您没有本站的管理权限！");
			return loginInput();
		} else if (admin.getAdminDisabled()) {
			addActionError("您的帐号已经被禁止！");
			return loginInput();
		}
		// 清除以前登录信息
		contextPvd.logout();
		// 保存当前登录信息
		contextPvd.setSessionAttr(User.USER_KEY, user.getId());
		contextPvd.setSessionAttr(Admin.ADMIN_KEY, admin.getId());
		userMng.updateLoginInfo(user);
		// 将权限集放入session
		Set<String> fiSet = functionMng.getFunctionItems(admin.getId());
		contextPvd.setSessionAttr(Admin.RIGHTS_KEY, fiSet);
		// 处理次级域名单点登录
		Website web = getWeb();
		if (!StringUtils.isBlank(web.getBaseDomain())) {
			Cookie c = new Cookie(JSESSION_COOKIE, contextPvd
					.getSessionId(false));
			c.setPath("/");
			c.setDomain(web.getTopDomain(true));
			contextPvd.addCookie(c);
		}
		return SUCCESS;
	}

	public String logout() {
		contextPvd.logout();
		return "logout";
	}

	@Autowired
	private ImageCaptchaService imageCaptchaService;
	@Autowired
	private ContextPvd contextPvd;
	@Autowired
	private FunctionMng functionMng;
	private String loginName;
	private String password;
	private String checkCode;

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCheckCode() {
		return checkCode;
	}

	public void setCheckCode(String checkCode) {
		this.checkCode = checkCode;
	}
}
