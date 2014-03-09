package com.jeecms.core.entity;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

import com.jeecms.core.entity.base.BaseEmailSender;

public class EmailSender extends BaseEmailSender {
	private static final long serialVersionUID = 1L;

	public void send(String addTo, String addName, String pwd)
			throws EmailException {
		HtmlEmail email = new HtmlEmail();
		// ����
		email.setCharset(getCharset());
		// �ռ���
		email.addTo(addTo, addName);
		// �������ʼ����ͷ�����
		email.setHostName(getHostname());
		// �����������ʺš�����������
		email.setFrom(getAccount(), getUserName());
		// �����������¼�û���������
		email.setAuthentication(getUserId(), getUserPwd());
		// ����
		email.setSubject(getSubject());
		// ����
		String content = getContent().replaceAll("#(username)", addName);
		content = content.replaceAll("#(userpwd)", pwd);
		email.setHtmlMsg(content);
		// ����
		email.send();
	}

	/* [CONSTRUCTOR MARKER BEGIN] */
	public EmailSender () {
		super();
	}

	/* [CONSTRUCTOR MARKER END] */
}