package com.jeecms.core;

import static com.jeecms.core.Constants.SPT;
import static com.jeecms.core.Constants.TPL_DEF_SOLUTION;
import static com.jeecms.core.Constants.TPL_SUFFIX;

import java.io.File;
import java.util.Collection;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.jeecms.common.struts2.interceptor.ProcessingStartInterceptor;
import com.jeecms.core.entity.Member;
import com.jeecms.core.entity.User;
import com.jeecms.core.manager.MemberMng;
import com.jeecms.core.manager.UserMng;
import com.opensymphony.xwork2.ValidationAware;
import com.opensymphony.xwork2.ValidationAwareSupport;

/**
 * ǰ̨����ҳ�����
 *
 * @author liufang
 *
 */
@SuppressWarnings("unchecked")
public abstract class IntegrityAction extends FrontAction implements
		ValidationAware {
	/**
	 * ����ҳģ��ǰ׺
	 */
	public static final String INDE_PRIFIX = "sys_";
	/**
	 * ��Ŀ¼�ض������
	 */
	public static final String INDEX_PAGE = "indexPage";
	/**
	 * ������ʾҳ��
	 */
	public static final String SHOW_ERROR = "ShowError";
	/**
	 * ��Ϣ��ʾҳ��
	 */
	public static final String SHOW_MESSAGE = "ShowMessage";
	/**
	 * �ɹ���ʾҳ��
	 */
	public static final String SHOW_SUCCESS = "ShowSuccess";
	/**
	 * ҳ���Ҳ�����ʾҳ��
	 */
	public static final String PAGE_NOT_FOUND = "PageNotFound";

	/**
	 * �Ȳ��ҷ���ģ�壬��������ʹ��Ĭ��ģ��
	 *
	 * @param tplName
	 * @return
	 */
	protected String handleResult(String tplName) {
		return handleResult(tplName, getSysType());
	}

	protected String handleResult(String tplName, String sysType) {
		return handleResult(tplName, sysType, getSolution());
	}

	protected String handleResult(String tplName, String sysType,
			String solution) {
		tplPath = getSolutionTpl(solution, tplName, sysType);
		String real = contextPvd.getAppRealPath(tplPath);
		if (!new File(real).exists()) {
			tplPath = getSolutionTpl(TPL_DEF_SOLUTION, tplName, sysType);
		}
		return SUCCESS;
	}

	private String getSolutionTpl(String solution, String tplName,
			String sysType) {
		StringBuilder sb = getWeb().getTplRoot().append(SPT).append(sysType)
				.append(SPT).append(solution).append(SPT).append(INDE_PRIFIX)
				.append(tplName).append(TPL_SUFFIX);
		return sb.toString();
	}

	protected abstract String getSolution();

	protected abstract String getSysType();

	/**
	 * �û���Դ���ַ���磺http://www.sina.com/res_base/sina_com_www
	 *
	 * @return
	 */
	public String getRoot() {
		if (root == null) {
			root = getWeb().getUserResUrl();
		}
		return root;
	}

	/**
	 * ϵͳ��Դ���ַ���磺http://www.sina.com/front_res
	 *
	 * @return
	 */
	public String getSysResRoot() {
		if (sysResRoot == null) {
			sysResRoot = getWeb().getSysResUrl();
		}
		return sysResRoot;
	}

	public int getPageNo() {
		return pageNo;
	}

	/**
	 * ��û�ԱID
	 *
	 * @return
	 */
	public Long getMemberId() {
		Member m = getMember();
		if (m == null) {
			return null;
		} else {
			return m.getId();
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
	 * ���ҳ��ִ��ʱ��ms
	 *
	 * @return ����ҳ��ִ��ʱ�䡣-1���û���ҵ�ҳ�濪ʼִ��ʱ�䡣
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

	public String[] getPrefix() {
		if (prefix == null && otherParams != null && otherParams.length != 0) {
			prefix = new String[otherParams.length];
			int len = 1;
			prefix[0] = pageLink + "-";
			for (int i = 1; i < otherParams.length; i++) {
				len += otherParams[i - 1].length() + 1;
				prefix[i] = pageLink + pageSuffix.substring(len);
			}
		}
		return prefix;
	}

	private String[] prefix;

	public String[] suffix() {
		if (suffix == null && otherParams != null && otherParams.length != 0) {
			suffix = new String[otherParams.length];
			int len = 0;
			for (int i = 0; i < otherParams.length; i++) {
				len += otherParams[i].length() + 1;
				suffix[i] = pageLink + pageSuffix.substring(len);
			}
		}
		return suffix;
	}

	private String[] suffix;

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

	public void setActionErrors(@SuppressWarnings("rawtypes") Collection errorMessages) {
		validationAware.setActionErrors(errorMessages);
	}

	@SuppressWarnings("rawtypes")
	public Collection getActionErrors() {
		return validationAware.getActionErrors();
	}

	public void setActionMessages(@SuppressWarnings("rawtypes") Collection messages) {
		validationAware.setActionMessages(messages);
	}

	@SuppressWarnings("rawtypes")
	public Collection getActionMessages() {
		return validationAware.getActionMessages();
	}

	public void setFieldErrors(@SuppressWarnings("rawtypes") Map errorMap) {
		validationAware.setFieldErrors(errorMap);
	}

	@SuppressWarnings("rawtypes")
	public Map getFieldErrors() {
		return validationAware.getFieldErrors();
	}

	public boolean hasActionErrors() {
		return validationAware.hasActionErrors();
	}

	public boolean hasActionMessages() {
		return validationAware.hasActionMessages();
	}

	public boolean hasErrors() {
		return validationAware.hasErrors();
	}

	public boolean hasFieldErrors() {
		return validationAware.hasFieldErrors();
	}

	public void addActionError(String anErrorMessage) {
		validationAware.addActionError(anErrorMessage);
	}

	public void addActionMessage(String aMessage) {
		validationAware.addActionMessage(aMessage);
	}

	public void addFieldError(String fieldName, String errorMessage) {
		validationAware.addFieldError(fieldName, errorMessage);
	}

	private final ValidationAwareSupport validationAware = new ValidationAwareSupport();
	/**
	 * վ����Դ�ĸ��ַ
	 */
	private String root;
	/**
	 * ϵͳǰ̨��Դ���ַ
	 */
	private String sysResRoot;
	/**
	 * ��վ���url��ַ
	 */
	protected String rootWebUrl;
	/**
	 * ��ǰ�������url��ַ
	 */
	protected String wholeUrl;
	/**
	 * ҳ���ض���
	 */
	private String redirectUrl;
	/**
	 * ��ǰҳ��
	 */
	protected int pageNo = 0;

	protected String[] otherParams;

	@Autowired
	protected MemberMng memberMng;
	@Autowired
	protected UserMng userMng;

	public String getWholeUrl() {
		return wholeUrl;
	}

	public void setWholeUrl(String wholeUrl) {
		this.wholeUrl = wholeUrl;
	}

	public String getRootWebUrl() {
		return rootWebUrl;
	}

	public void setRootWebUrl(String rootWebUrl) {
		this.rootWebUrl = rootWebUrl;
	}

	public String getRedirectUrl() {
		return redirectUrl;
	}

	public void setRedirectUrl(String redirectUrl) {
		this.redirectUrl = redirectUrl;
	}

	public String[] getOtherParams() {
		return otherParams;
	}

	public void setOtherParams(String[] otherParams) {
		this.otherParams = otherParams;
	}

}
