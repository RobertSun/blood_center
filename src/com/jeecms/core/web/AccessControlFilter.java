package com.jeecms.core.web;

import java.io.IOException;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.jeecms.core.entity.Admin;
import com.jeecms.core.entity.User;
import com.jeecms.core.manager.AdminMng;

public class AccessControlFilter implements Filter {
	@SuppressWarnings("unused")
	private static Logger log = LoggerFactory
			.getLogger(AccessControlFilter.class);
	private boolean isControl;
	private static final String BEAN_NAME = "adminMngImpl";
	private AdminMng adminMng;

	public void init(FilterConfig filterConfig) throws ServletException {
		String control = filterConfig.getInitParameter("isControl");
		if ("false".equals(control)) {
			isControl = false;
		} else {
			isControl = true;
		}
		WebApplicationContext wac = WebApplicationContextUtils
				.getRequiredWebApplicationContext(filterConfig
						.getServletContext());
		adminMng = (AdminMng) wac.getBean(BEAN_NAME, AdminMng.class);
	}

	@SuppressWarnings("unchecked")
	public void doFilter(ServletRequest servletRequest,
			ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) servletRequest;
		HttpServletResponse resp = (HttpServletResponse) servletResponse;
		HttpSession session = req.getSession(false);
		if (isControl) {
			if (session == null) {
				resp.sendRedirect(req.getContextPath() + "/no_login.html");
				// resp.sendError(HttpServletResponse.SC_FORBIDDEN);
				return;
			}
			String domain = req.getServerName();
			Long userId = (Long) session.getAttribute(User.USER_KEY);
			Long adminId = (Long) session.getAttribute(Admin.ADMIN_KEY);
			Admin admin = adminMng.getLoginAdmin(domain, adminId, userId,
					session);
			if (admin == null) {
				resp.sendError(HttpServletResponse.SC_FORBIDDEN);
				return;
			}
			// ���ڱ�վע��ĳ�������Ա����Ȩ�޿���
			if (userId.equals(1L)) {
				chain.doFilter(servletRequest, servletResponse);
				return;
			}
			// �����ʵ�ַ�Ƿ��ڹ���Ա��Ȩ�޼���
			String url = getUrl(req);
			Set<String> fiSet = (Set<String>) session
					.getAttribute(Admin.RIGHTS_KEY);
			if (fiSet == null || !fiSet.contains(url)) {
				resp.sendError(HttpServletResponse.SC_FORBIDDEN);
				return;
			}
			chain.doFilter(servletRequest, servletResponse);
			return;
		} else {
			// ���ڿ���״̬
			if (session == null) {
				session = req.getSession(true);
			}
			session.setAttribute(Admin.ADMIN_KEY, 1L);
			session.setAttribute(User.USER_KEY, 1L);
			chain.doFilter(servletRequest, servletResponse);
		}
	}

	private String getUrl(HttpServletRequest req) {
		String url = req.getRequestURI();
		String context = req.getContextPath();
		if (url.indexOf(".") != -1) {
			return url.substring(context.length(), url.indexOf("."));
		} else if (url.indexOf("?") != -1) {
			return url.substring(context.length(), url.indexOf("?"));
		} else {
			return url.substring(context.length());
		}
	}

	public void destroy() {
	}
}
