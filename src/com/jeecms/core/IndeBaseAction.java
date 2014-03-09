package com.jeecms.core;

import static com.jeecms.core.JeeCoreAction.*;
import java.io.IOException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jeecms.common.struts2.interceptor.DomainNameAware;
import com.jeecms.common.struts2.interceptor.UrlAware;
import com.opensymphony.xwork2.Validateable;

/**
 * ����ģ�����
 * <p>
 * �ṩѡ��ģ�幦�ܡ���÷�ҳ������Ϣ��
 * </p>
 * 
 * @author liufang
 */
@SuppressWarnings("unchecked")
public abstract class IndeBaseAction extends IntegrityAction implements
		DomainNameAware, UrlAware, Validateable {
	private static final Logger log = LoggerFactory
			.getLogger(IndeBaseAction.class);
	public static final String JSON = "json";

	public void validate() {
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
	 * ֱ������ַ���.
	 */
	protected String renderText(String text) {
		return render(text, "text/plain;charset=UTF-8");
	}

	/**
	 * ���ҳ��cookieָ����ÿҳ��ʾ��¼��
	 * 
	 * @return
	 */
	protected int getCookieCount() {
		Cookie c = contextPvd.getCookie(COOKIE_COUNT);
		int count = 0;
		if (c != null) {
			try {
				count = Integer.parseInt(c.getValue());
			} catch (Exception e) {
			}
		}
		if (count <= 0) {
			count = DEFAULT_COUNT;
		} else if (count > 200) {
			count = COOKIE_MAX_COUNT;
		}
		return count;
	}

	public void setDomainName(String domainName) {
		// empty is OK!
	}

	public void setPageLink(String pageLink) {
		this.pageLink = pageLink;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public void setPageSuffix(String pageSuffix) {
		this.pageSuffix = pageSuffix;
	}

	public void setPathParams(String[] pathParams) {
		// empty is OK!
	}

	public void setOtherParams(String[] otherParams) {
		this.otherParams = otherParams;
	}

	public void setWholeUrl(String wholeUrl) {
		this.wholeUrl = wholeUrl;
	}

	protected String backUrl;

	public String getBackUrl() {
		return backUrl;
	}

	public void setBackUrl(String backUrl) {
		this.backUrl = backUrl;
	}
}