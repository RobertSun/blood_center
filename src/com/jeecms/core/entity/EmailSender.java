package com.jeecms.core.entity;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

import com.jeecms.core.entity.base.BaseEmailSender;

public class EmailSender extends BaseEmailSender {
	private static final long serialVersionUID = 1L;

	public void send(String addTo, String addName, String pwd)
			throws EmailException {
		HtmlEmail email = new HtmlEmail();
		// 编码
		email.setCharset(getCharset());
		// 收件人
		email.addTo(addTo, addName);
		// 发件人邮件发送服务器
		email.setHostName(getHostname());
		// 发件人邮箱帐号、发件人姓名
		email.setFrom(getAccount(), getUserName());
		// 发件人邮箱登录用户名、密码
		email.setAuthentication(getUserId(), getUserPwd());
		// 标题
		email.setSubject(getSubject());
		// 内容
		String content = getContent().replaceAll("#(username)", addName);
		content = content.replaceAll("#(userpwd)", pwd);
		email.setHtmlMsg(content);
		// 发送
		email.send();
	}

	/* [CONSTRUCTOR MARKER BEGIN] */
	public EmailSender () {
		super();
	}

	/* [CONSTRUCTOR MARKER END] */
}