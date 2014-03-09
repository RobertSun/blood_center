package com.jeecms.core;

import static com.jeecms.core.Constants.SPT;
import static com.jeecms.core.Constants.TPL_SUFFIX;

import java.io.File;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.jeecms.common.page.Pagination;
import com.jeecms.common.struts2.interceptor.UrlAware;

/**
 * Ƭ��ģ�����
 * <p>
 * �ṩվ����Ϣ����ȡģ�巽����
 * </p>
 *
 * @author liufang
 *
 */
public abstract class PartBaseAction extends FrontAction implements UrlAware {
	public static final String INNER_LIST = "n_list";
	public static final String INNER_PAGE = "n_pagination";
	/**
	 * ʹ��ϵͳģ��ʱ������result��name��
	 */
	public static final String SYS_TPL = "sysTpl";
	/**
	 * ��ǩ��ǰ׺
	 */
	public static final String TAG_RPEFIX = "tag_";

	protected String handleResult(String tplName) {
		if (sysTpl == 1) {
			return SYS_TPL;
		} else {
			String solution = getWeb().getSolutions().get(getSysType());
			tplPath = getTplBySolution(solution, tplName);
			File f = new File(contextPvd.getAppRealPath(tplPath));
			// ��ģ�岻���ڣ���ʹ��Ĭ��ģ�塣
			if (!f.exists()) {
				tplPath = getTplBySolution(Constants.TPL_DEF_SOLUTION, tplName);
			}
			return SUCCESS;
		}
	}

	private String getTplBySolution(String solution, String tplName) {
		return getWeb().getTplRoot().append(SPT).append(getSysType()).append(
				SPT).append(solution).append(SPT).append(TAG_RPEFIX).append(
				tplName).append(TPL_SUFFIX).toString();
	}

	protected abstract String getSysType();

	/**
	 * ��ñ�Ӧ�õ�Ψһ����
	 *
	 * @return
	 */
	public synchronized Integer getUniqueNumber() {
		Integer n = (Integer) contextPvd.getApplicationAttr(UNIQUE_NUMBER);
		if (n == null) {
			n = new Integer(1);
		} else if (n >= Integer.MAX_VALUE) {
			n = new Integer(1);
		} else {
			n += 1;
		}
		contextPvd.setApplicationAttr(UNIQUE_NUMBER, n);
		return n;
	}

	protected boolean isSplitPage() {
		return "1".equals(isPage) ? true : false;
	}

	protected int checkPageSize() {
		if (count > 200) {
			count = 200;
		}
		if (count < 1) {
			count = 1;
		}
		return count;
	}

	protected Boolean cb(String s) {
		if ("-1".equals(s)) {
			return null;
		} else if ("1".equals(s)) {
			return true;
		} else {
			return false;
		}
	}

	protected boolean cbs(String s) {
		if ("1".equals(s)) {
			return true;
		} else {
			return false;
		}
	}

	@SuppressWarnings("rawtypes")
	protected List list;
	protected Pagination pagination;

	protected int count;
	protected int firstResult;
	protected int orderBy;
	protected int pageNo;
	protected String isPage;

	protected String cssClass;
	protected String cssStyle;
	protected String showLinkStyle;

	protected int sysTpl;
	protected String style;
	protected String sysContent;
	protected String userContent;
	protected String sysPage;
	protected String userPage;
	protected String upSolution;
	protected String upWebRes;
	protected String pageClass;
	protected String pageStyle;
	protected String customs;
	private String[] custom;

	public static final String UNIQUE_NUMBER = "_unique_number";

	public void setPageLink(String pageLink) {
		this.pageLink = pageLink;
	}

	public void setPageSuffix(String pageSuffix) {
		this.pageSuffix = pageSuffix;
	}

	public String[] getCustom() {
		if (custom == null) {
			custom = StringUtils.split(customs, '|');
		}
		return custom;
	}

	public String getSysContent() {
		return sysContent;
	}

	public void setSysContent(String sysContent) {
		this.sysContent = sysContent;
	}

	public String getUserContent() {
		return userContent;
	}

	public void setUserContent(String userContent) {
		this.userContent = userContent;
	}

	public String getSysPage() {
		return sysPage;
	}

	public void setSysPage(String sysPage) {
		this.sysPage = sysPage;
	}

	public String getUserPage() {
		return userPage;
	}

	public void setUserPage(String userPage) {
		this.userPage = userPage;
	}

	public int getSysTpl() {
		return sysTpl;
	}

	public void setSysTpl(int sysTpl) {
		this.sysTpl = sysTpl;
	}

	@SuppressWarnings("rawtypes")
	public List getList() {
		return list;
	}

	public Pagination getPagination() {
		return pagination;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(int orderBy) {
		this.orderBy = orderBy;
	}

	public String getIsPage() {
		return isPage;
	}

	public void setIsPage(String isPage) {
		this.isPage = isPage;
	}

	public int getFirstResult() {
		return firstResult;
	}

	public void setFirstResult(int firstResult) {
		this.firstResult = firstResult;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public void setPathParams(String[] pathParams) {
		// do nothing
	}

	public void setOtherParams(String[] otherParams) {
		// do nothing
	}

	public void setWholeUrl(String wholeUrl) {
		// do nothing
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public String getCustoms() {
		return customs;
	}

	public void setCustoms(String customs) {
		this.customs = customs;
	}

	public String getUpSolution() {
		return upSolution;
	}

	public void setUpSolution(String upSolution) {
		this.upSolution = upSolution;
	}

	public String getUpWebRes() {
		return upWebRes;
	}

	public void setUpWebRes(String upWebRes) {
		this.upWebRes = upWebRes;
	}

	public String getPageClass() {
		return pageClass;
	}

	public void setPageClass(String pageClass) {
		this.pageClass = pageClass;
	}

	public String getPageStyle() {
		return pageStyle;
	}

	public void setPageStyle(String pageStyle) {
		this.pageStyle = pageStyle;
	}

	public String getCssClass() {
		return cssClass;
	}

	public void setCssClass(String cssClass) {
		this.cssClass = cssClass;
	}

	public String getCssStyle() {
		return cssStyle;
	}

	public void setCssStyle(String cssStyle) {
		this.cssStyle = cssStyle;
	}

	public String getShowLinkStyle() {
		return showLinkStyle;
	}

	public void setShowLinkStyle(String showLinkStyle) {
		this.showLinkStyle = showLinkStyle;
	}
}
