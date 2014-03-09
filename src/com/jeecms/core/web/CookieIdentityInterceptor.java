package com.jeecms.core.web;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.StrutsStatics;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.jeecms.common.struts2.ContextPvd;
import com.jeecms.core.entity.Website;
import com.jeecms.core.manager.WebsiteMng;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

/**
 * cookie识别码拦截器
 * 
 * 使用cookie标识浏览器，可用于投票、流量统计等功能。
 * 
 * @author liufang
 * 
 */
@SuppressWarnings("serial")
public class CookieIdentityInterceptor extends MethodFilterInterceptor {
	private WebsiteMng websiteMng;
	private ContextPvd contextPvd;

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		if (websiteMng == null || contextPvd == null) {
			WebApplicationContext wac = WebApplicationContextUtils
					.getRequiredWebApplicationContext(ServletActionContext
							.getServletContext());
			websiteMng = (WebsiteMng) wac.getBean("websiteMngImpl",
					WebsiteMng.class);
			contextPvd = (ContextPvd) wac.getBean("contextPvd",
					ContextPvd.class);
		}
		ActionContext ctx = invocation.getInvocationContext();
		HttpServletRequest req = (HttpServletRequest) ctx
				.get(StrutsStatics.HTTP_REQUEST);
		Website web = websiteMng.getWebsite(req.getServerName());
		if (web == null) {
			return invocation.invoke();
		}
		Cookie cookie = contextPvd.getCookie(web.getCookieKey());
		if (cookie == null) {
			String s = RandomStringUtils.randomAlphanumeric(10);
			Cookie c = new Cookie(web.getCookieKey(), s);
			c.setDomain(web.getTopDomain(true));
			c.setMaxAge(Integer.MAX_VALUE);
			c.setPath("/");
			contextPvd.addCookie(c);
		}
		return invocation.invoke();
	}
}