package com.jeecms.cms.action.front;

import static com.jeecms.common.util.ComUtils.JSESSION_COOKIE;

import javax.servlet.http.Cookie;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.interceptor.validation.SkipValidation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.jeecms.cms.CmsIndeAction;
import com.jeecms.cms.Constants;
import com.jeecms.cms.entity.CmsMember;
import com.jeecms.core.entity.Member;
import com.jeecms.core.entity.User;
import com.jeecms.core.entity.Website;
import com.octo.captcha.service.image.ImageCaptchaService;

/**
 * ��¼����ģ��
 * 
 * @author liufang
 * 
 */
@SuppressWarnings("unchecked")
@Scope("prototype")
@Controller("cms.loginIndeAct")
public class LoginIndeAct extends CmsIndeAction {
	private static final Logger log = LoggerFactory
			.getLogger(LoginIndeAct.class);
	public static final String LOGIN_FRAME_INPUT = "LoginFrameInput";
	public static final String LOGIN_FRAME_WELCOME = "LoginFrameWelcome";
	public static final String LOGIN_ALONE_INPUT = "LoginAloneInput";

	@SkipValidation
	public String loginFrameInput() {
		Long memberId = (Long) contextPvd.getSessionAttr(Member.MEMBER_KEY);
		cmsMemberMng.autoRegist(getWebId(), memberId);
		if (getCmsMember() == null) {
			return handleResult(LOGIN_FRAME_INPUT);
		} else {
			return handleResult(LOGIN_FRAME_WELCOME);
		}
	}

	public String loginFrameSubmit() {
		if (login()) {
			return handleResult(LOGIN_FRAME_INPUT);
		} else {
			return handleResult(LOGIN_FRAME_WELCOME);
		}
	}

	@SkipValidation
	public String loginFrameLogout() {
		contextPvd.logout();
		return "logout";
	}

	@SkipValidation
	public String loginAloneInput() {
		Long memberId = (Long) contextPvd.getSessionAttr(Member.MEMBER_KEY);
		cmsMemberMng.autoRegist(getWebId(), memberId);
		return handleResult(LOGIN_ALONE_INPUT);
	}

	public String loginAloneSubmit() {
		if (login()) {
			return showError();
		} else if (!StringUtils.isBlank(redirectUrl)) {
			return "lastUrl";
		} else {
			return INDEX_PAGE;
		}
	}

	@SkipValidation
	public String loginAloneLogout() {
		contextPvd.logout();
		return INDEX_PAGE;
	}

	/**
	 * ��ܵ�¼�Ͷ�����¼�����¼�߼�
	 */
	private boolean login() {
		if (hasErrors()) {
			return true;
		}
		boolean isHuman = imageCaptchaService.validateResponseForID(contextPvd
				.getSessionId(false), checkCode);
		if (!isHuman) {
			addActionError("��֤�����");
			return true;
		}
		User user = userMng.authenticate(username, password);
		if (user == null) {
			addActionError("�û��������ڻ��������");
			return true;
		}
		Member member = memberMng.getByUserId(getWebId(), user.getId());
		if (member == null) {
			addActionError("��û���ڱ�վע��");
			return true;
		}
		CmsMember cmsMember = cmsMemberMng.findById(member.getId());
		if (cmsMember == null) {
			addActionError("��û���ڱ�ϵͳע��");
			return true;
		} else if (cmsMember.getMemberDisabled()) {
			addActionError("�����ʺ��Ѿ�������");
			return true;
		}
		// �����ǰ��¼��Ϣ
		contextPvd.logout();
		// ���浱ǰ��¼��Ϣ
		contextPvd.setSessionAttr(User.USER_KEY, user.getId());
		contextPvd.setSessionAttr(Member.MEMBER_KEY, member.getId());
		// ����μ����������¼
		Website web = getWeb();
		if (!StringUtils.isBlank(web.getBaseDomain())) {
			Cookie c = new Cookie(JSESSION_COOKIE, contextPvd
					.getSessionId(false));
			c.setPath("/");
			c.setDomain(web.getTopDomain(true));
			contextPvd.addCookie(c);
		}
		userMng.updateLoginInfo(user);
		log.info("��Ա {} ��¼�ɹ�", username);
		return false;
	}

	@Override
	protected String getSysType() {
		return Constants.MEMBER_SYS;
	}

	@Autowired
	private ImageCaptchaService imageCaptchaService;
	private String username;
	private String password;
	private String checkCode;

	private String redirectUrl;
	private String errorMsg;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public String getRedirectUrl() {
		return redirectUrl;
	}

	public void setRedirectUrl(String redirectUrl) {
		this.redirectUrl = redirectUrl;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
}