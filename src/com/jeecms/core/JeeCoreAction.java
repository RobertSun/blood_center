package com.jeecms.core;

import javax.servlet.http.Cookie;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.jeecms.common.struts2.ContextPvd;
import com.jeecms.common.struts2.action.BaseAction;
import com.jeecms.common.struts2.interceptor.DomainNameAware;
import com.jeecms.common.struts2.interceptor.ProcessingStartInterceptor;
import com.jeecms.core.entity.Admin;
import com.jeecms.core.entity.Member;
import com.jeecms.core.entity.User;
import com.jeecms.core.entity.Website;
import com.jeecms.core.manager.AdminMng;
import com.jeecms.core.manager.MemberMng;
import com.jeecms.core.manager.UserMng;
import com.jeecms.core.manager.WebsiteMng;

/**
 * jeesys��action���ȡ�
 * <p>
 * ���������û���¼������·������Ϣ
 * </p>
 *
 * @author liufang
 *
 */
@SuppressWarnings({ "serial", "unchecked" })
public class JeeCoreAction extends BaseAction implements DomainNameAware {
	/**
	 * ������ʾҳ��
	 */
	public static final String SHOW_ERROR = "showError";
	/**
	 * ָ����¼���cookie���
	 */
	public static final String COOKIE_COUNT = "_countPerPage";
	/**
	 * cookie��ָ��������¼��
	 */
	public static final int COOKIE_MAX_COUNT = 200;
	/**
	 * Ĭ�ϼ�¼��
	 */
	public static final int DEFAULT_COUNT = 20;
	/**
	 * �����磺www.sina.com
	 */
	protected String domainName;

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
	 * ��ø�վ��ID
	 *
	 * @return
	 */
	public Long getRootWebId() {
		return getRootWeb().getId();
	}

	/**
	 * ��ø�վ�����
	 *
	 * @return
	 */
	public Website getRootWeb() {
		return getWeb().getRootWeb();
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
		Long userId = getUserId();
		if (userId == null) {
			return null;
		} else {
			return userMng.findById(userId);
		}
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
		Long adminId = getAdminId();
		if (adminId == null) {
			return null;
		} else {
			return adminMng.findById(adminId);
		}
	}

	/**
	 * ��û�ԱID
	 *
	 * @return
	 */
	public Long getMemberId() {
		Member member = getMember();
		if (member == null) {
			return null;
		} else {
			return member.getId();
		}
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

	/**
	 * ���ҳ��ִ��ʱ��ms
	 *
	 * @return ����ҳ��ִ��ʱ��(s)��-1���û���ҵ�ҳ�濪ʼִ��ʱ�䡣
	 */
	public float getProcessedIn() {
		Long time = (Long) contextPvd
				.getRequestAttr(ProcessingStartInterceptor.PROCESSING_START);
		if (time != null) {
			return (System.nanoTime() - time) / 1000 / 1000000F;
		} else {
			return -1;
		}
	}

	/**
	 * ҳ���ض���
	 *
	 * @param url
	 * @return
	 */
	protected String redirect(String url) {
		this.redirectUrl = url;
		return Constants.REDIRECT;
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
	/**
	 * ҳ���ض���
	 */
	private String redirectUrl;

	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}

	public String getRedirectUrl() {
		return redirectUrl;
	}

	public void setRedirectUrl(String redirectUrl) {
		this.redirectUrl = redirectUrl;
	}
}
