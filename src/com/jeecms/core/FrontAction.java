package com.jeecms.core;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.jeecms.common.struts2.ContextPvd;
import com.jeecms.common.struts2.interceptor.DomainNameAware;
import com.jeecms.core.entity.Website;
import com.jeecms.core.manager.WebsiteMng;
import com.opensymphony.xwork2.Action;

/**
 * ǰ̨Action����
 *
 * @author liufang
 *
 */
public class FrontAction implements Action {
	private static final Logger log = LoggerFactory
			.getLogger(FrontAction.class);

	public String execute() throws Exception {
		return SUCCESS;
	}

	/**
	 * ��ø�վ��ID
	 *
	 * @return
	 */
	public Long getRootWebId() {
		return getRootWeb().getId();
	}

	/**
	 * ��ø�վ��
	 *
	 * @return
	 */
	public Website getRootWeb() {
		return getWeb().getRootWeb();
	}

	/**
	 * ���վ��ID
	 *
	 * @return
	 */
	public Long getWebId() {
		return getWeb().getId();
	}

	/**
	 * ���վ�����
	 *
	 * @return
	 */
	public Website getWeb() {
		String domain = (String) contextPvd
				.getRequestAttr(DomainNameAware.DOMAIN_NAME);
		Website website = websiteMng.getWebsite(domain);
		if (website == null) {
			throw new RuntimeException("�������������ƥ���վ�㣺"
					+ ServletActionContext.getRequest().getAttribute(
							DomainNameAware.DOMAIN_NAME));
		}
		return website;
	}

	/**
	 * /WEB-INF/user_base/ponyjava_com_www/template
	 *
	 * @return
	 */
	public String getTplBase() {
		return getWeb().getTplRoot().toString();
	}

	/**
	 * /WEB-INF/user_base/
	 *
	 * @return
	 */
	public String getUserBase() {
		return Website.USER_ROOT;
	}

	/**
	 * ��õ�ǰʱ��
	 *
	 * @return
	 */
	public Date getCurrentTime() {
		if (currentTime == null) {
			currentTime = new Date();
		}
		return currentTime;
	}

	/**
	 * �ƹ�Template,ֱ��������ݵļ�㺯��.
	 */
	protected String render(String text, String contentType) {
		try {
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType(contentType);
			response.getWriter().write(text);
		} catch (IOException e) {
			log.error(e.getMessage(), e);
		}
		return null;
	}

	/**
	 * ֱ������ַ�.
	 */
	protected String renderText(String text) {
		return render(text, "text/plain;charset=UTF-8");
	}

	/**
	 * ֱ������ַ�GBK����.
	 */
	protected String renderHtmlGBK(String text) {
		return render(text, "text/html;charset=GBK");
	}

	/**
	 * ��ô�.�ĺ�׺���磺.htm
	 *
	 * @return
	 */
	public String getPointSuffix() {
		return "." + getWeb().getSuffix();
	}

	protected Date currentTime;
	protected String pageLink;
	protected String pageSuffix;
	protected String tplPath;
	@Autowired
	protected WebsiteMng websiteMng;
	@Autowired
	protected ContextPvd contextPvd;

	public String getTplPath() {
		return tplPath;
	}

	public void setTplPath(String tplPath) {
		this.tplPath = tplPath;
	}

	public String getPageLink() {
		return pageLink;
	}

	public String getPageSuffix() {
		return pageSuffix;
	}
}
