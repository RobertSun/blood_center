package com.jeecms.core.web;

import java.util.Enumeration;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.jeecms.core.util.UploadRule;

public class UploadFileListerner implements HttpSessionListener {
	public void sessionCreated(HttpSessionEvent se) {
	}

	@SuppressWarnings("unchecked")
	public void sessionDestroyed(HttpSessionEvent se) {
		// 清理上传文件
		HttpSession session = se.getSession();
		Enumeration<String> em = session.getAttributeNames();
		while (em.hasMoreElements()) {
			Object o = session.getAttribute(em.nextElement());
			if (o instanceof UploadRule) {
				UploadRule ur = (UploadRule) o;
				ur.clearUploadFile();
			}
		}
	}
}
