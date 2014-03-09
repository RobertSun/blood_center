package com.jeecms.cms.web;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.Serializable;

import javax.servlet.http.HttpServletResponse;

import net.sf.ehcache.constructs.web.GenericResponseWrapper;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.views.freemarker.FreemarkerResult;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.jeecms.core.service.PageCacheSvc;
import com.jeecms.core.service.impl.ChannelCacheSvcImpl;
import com.jeecms.core.service.impl.HomepageCacheSvcImpl;
import com.jeecms.core.PageBaseAction;
import com.opensymphony.xwork2.ActionInvocation;

import freemarker.template.Template;
import freemarker.template.TemplateModel;

public class PageCacheResult extends FreemarkerResult {
	private static final long serialVersionUID = 1L;
	private static final String CK_HOMEPAGE = "ckHomepage";
	private static final String HOMEPAGE_BEAN = "homepageCacheSvcImpl";
	private static final String CK_CHANNEL = "ckChannel";
	private static final String CHANNEL_BEAN = "channelCacheSvcImpl";
	private static final String CACHE_TYPE = "cacheType";

	private HttpServletResponse response;
	private ByteArrayOutputStream outstr;
	private GenericResponseWrapper wrapper;

	@Override
	public void execute(ActionInvocation invocation) throws Exception {
		outstr = new ByteArrayOutputStream();
		response = ServletActionContext.getResponse();
		wrapper = new GenericResponseWrapper(response, outstr);
		ServletActionContext.setResponse(wrapper);

		super.execute(invocation);
	}

	protected void postTemplateProcess(Template template, TemplateModel data)
			throws IOException {
		ServletActionContext.setResponse(response);
		try {
			wrapper.flush();
			byte[] bytes = outstr.toByteArray();
			WriteCache(bytes);
			response.setContentLength(bytes.length);
			outstr.writeTo(response.getOutputStream());
		} finally {
			if (outstr != null) {
				outstr.close();
			}
		}
	}

	private void WriteCache(byte[] b) {
		WebApplicationContext wac = WebApplicationContextUtils
				.getRequiredWebApplicationContext(ServletActionContext
						.getServletContext());
		Integer cacheKey = (Integer) invocation.getStack()
				.findValue(CACHE_TYPE);
		PageCacheSvc cacheSvc;
		Serializable key;
		if (cacheKey == PageBaseAction.HOMEPAGE_CACHE) {
			cacheSvc = (PageCacheSvc) wac.getBean(HOMEPAGE_BEAN,
					HomepageCacheSvcImpl.class);
			key = (Serializable) invocation.getStack().findValue(CK_HOMEPAGE);
		} else if (cacheKey == PageBaseAction.CHANNEL_CACHE) {
			cacheSvc = (PageCacheSvc) wac.getBean(CHANNEL_BEAN,
					ChannelCacheSvcImpl.class);
			key = (Serializable) invocation.getStack().findValue(CK_CHANNEL);
		} else {
			throw new RuntimeException("不支持的缓存类型：" + cacheKey);
		}
		cacheSvc.put(key, b);
	}
}
