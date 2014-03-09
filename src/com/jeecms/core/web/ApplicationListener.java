package com.jeecms.core.web;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.jeecms.core.manager.WebsiteMng;

public final class ApplicationListener implements ServletContextListener {
	private static final String BEAN_NAME = "websiteMngImpl";
	private static final Logger log = LoggerFactory
			.getLogger(ApplicationListener.class);

	public void contextDestroyed(ServletContextEvent event) {
	}

	public void contextInitialized(ServletContextEvent event) {
		WebApplicationContext wac = WebApplicationContextUtils
				.getRequiredWebApplicationContext(event.getServletContext());
		websiteMng = (WebsiteMng) wac.getBean(BEAN_NAME, WebsiteMng.class);
		log.info("系统启动，读取所有站点信息到缓存。");
		websiteMng.loadAllWebsiteToCache();
	}

	private WebsiteMng websiteMng;
}
