package com.jeecms.core;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.jeecms.common.struts2.ContextPvd;
import com.jeecms.common.struts2.interceptor.DomainNameAware;
import com.jeecms.core.entity.Admin;
import com.jeecms.core.entity.Member;
import com.jeecms.core.entity.User;
import com.jeecms.core.entity.Website;
import com.jeecms.core.manager.AdminMng;
import com.jeecms.core.manager.MemberMng;
import com.jeecms.core.manager.UserMng;
import com.jeecms.core.manager.WebsiteMng;
import com.opensymphony.xwork2.Action;

public class JeeCoreAjaxAction implements Action, DomainNameAware {
	private static final Logger log = LoggerFactory
			.getLogger(JeeCoreAjaxAction.class);

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
	 * ֱ�����HTML.
	 */
	protected String renderHtml(String html) {
		return render(html, "text/html;charset=UTF-8");
	}

	/**
	 * ֱ�����XML.
	 */
	protected String renderXML(String xml) {
		return render(xml, "text/xml;charset=UTF-8");
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
		Website website = websiteMng.getWebsite(domainName);
		if (website == null) {
			throw new RuntimeException("�������������ƥ���վ�㣺"
					+ ServletActionContext.getRequest().getAttribute(
							DomainNameAware.DOMAIN_NAME));
		}
		return website;
	}

	/**
	 * ����û�ID
	 *
	 * @return
	 */
	public Long getUserId() {
		return (Long) contextPvd.getSessionAttr(User.USER_KEY);
	}

	/**
	 * ����û�����
	 *
	 * @return
	 */
	public User getUser() {
		return userMng.findById(getUserId());
	}

	/**
	 * ��ù���ԱID
	 *
	 * @return
	 */
	public Long getAdminId() {
		return (Long) contextPvd.getSessionAttr(Admin.ADMIN_KEY);
	}

	/**
	 * ��ù���Ա����
	 *
	 * @return
	 */
	public Admin getAdmin() {
		return adminMng.findById(getAdminId());
	}

	/**
	 * ��û�ԱID
	 *
	 * @return
	 */
	public Long getMemberId() {
		return getMember().getId();
	}

	/**
	 * ��û�Ա����
	 *
	 * @return
	 */
	public Member getMember() {
		Long memberId = (Long) contextPvd.getSessionAttr(Member.MEMBER_KEY);
		return memberMng.getLoginMember(getWebId(), getUserId(), memberId);
	}

	protected Map<String, Object> jsonRoot = new HashMap<String, Object>();
	protected String domainName;

	@Autowired
	protected WebsiteMng websiteMng;
	@Autowired
	protected ContextPvd contextPvd;
	@Autowired
	protected UserMng userMng;
	@Autowired
	protected AdminMng adminMng;
	@Autowired
	protected MemberMng memberMng;

	public String execute() throws Exception {
		return SUCCESS;
	}

	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}

	public Map<String, Object> getJsonRoot() {
		return jsonRoot;
	}

	public void setJsonRoot(Map<String, Object> jsonRoot) {
		this.jsonRoot = jsonRoot;
	}
}
