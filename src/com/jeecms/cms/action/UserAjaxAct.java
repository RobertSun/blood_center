package com.jeecms.cms.action;

import org.apache.commons.lang.StringUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.jeecms.core.JeeCoreAjaxAction;
import com.jeecms.core.entity.User;

@Scope("prototype")
@Controller("core.userAjaxAct")
public class UserAjaxAct extends JeeCoreAjaxAction {
	public String updatePassword() {
		User user = getUser();
		boolean isSucess = userMng.updatePwdEmail(user, oldPwd, newPwd, null);
		if (isSucess) {
			jsonRoot.put("success", isSucess);
			jsonRoot.put("msg", "修改成功！");
		} else {
			jsonRoot.put("success", isSucess);
			jsonRoot.put("msg", "原密码错误！");
		}
		return SUCCESS;
	}

	/**
	 * 判断前台用户注册
	 * 
	 * @return
	 */
	public String checkUserName() {
		boolean b = true;
		if (StringUtils.isBlank(username)) {
			b = false;
		}
		if (b) {
			b = getWeb().getControl().checkReservedWords(username);
		}
		if (b) {
			b = userMng.checkLoginName(username);
		}
		return renderText(b ? "true" : "false");
	}

	public String checkEmail() {
		// 不能为空
		if (StringUtils.isBlank(email)) {
			return renderText("false");
		}
		// 可以和原邮箱相同
		if (StringUtils.endsWith(email, origEmail)) {
			return renderText("true");
		}
		User u = userMng.getUserByEmail(email);
		if (u == null) {
			return renderText("true");
		} else {
			return renderText("false");
		}
	}

	private String oldPwd;
	private String newPwd;
	private String username;
	private String email;
	private String origEmail;

	public String getOldPwd() {
		return oldPwd;
	}

	public void setOldPwd(String oldPwd) {
		this.oldPwd = oldPwd;
	}

	public String getNewPwd() {
		return newPwd;
	}

	public void setNewPwd(String newPwd) {
		this.newPwd = newPwd;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getOrigEmail() {
		return origEmail;
	}

	public void setOrigEmail(String origEmail) {
		this.origEmail = origEmail;
	}
}
