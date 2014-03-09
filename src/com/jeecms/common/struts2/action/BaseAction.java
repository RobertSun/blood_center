package com.jeecms.common.struts2.action;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jeecms.common.page.Pagination;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.Validateable;
import com.opensymphony.xwork2.ValidationAware;
import com.opensymphony.xwork2.ValidationAwareSupport;

@SuppressWarnings( { "serial", "unchecked" })
public class BaseAction implements Action, java.io.Serializable, Validateable,
		ValidationAware {
	private static final Logger log = LoggerFactory.getLogger(BaseAction.class);
	private final ValidationAwareSupport validationAware = new ValidationAwareSupport();
	protected Long[] ids;
	protected Long id;
	protected Pagination pagination;
	@SuppressWarnings("rawtypes")
	protected List list;
	protected int pageNo = 1;
	public static final String LIST = "list";
	public static final String EDIT = "edit";
	public static final String ADD = "add";
	public static final String SELECT = "select";
	public static final String QUERY = "query";
	public static final String LEFT = "left";
	public static final String RIGHT = "right";
	public static final String INDEX = "index";
	public static final String MAIN = "main";
	public static final String JSON = "json";

	/**
	 * ��֤��������
	 *
	 * @return
	 */
	protected boolean vldBatch() {
		if (id == null && (ids == null || ids.length <= 0)) {
			addActionError("ID����Ϊ��");
			return true;
		} else {
			if (id != null) {
				ids = new Long[] { id };
			}
		}
		return false;
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
	protected String renderHtmlGBK(String html) {
		return render(html, "text/html;charset=GBK");
	}

	/**
	 * ֱ�����XML.
	 */
	protected String renderXML(String xml) {
		return render(xml, "text/xml;charset=UTF-8");
	}

	public String main() throws Exception {
		return MAIN;
	}

	public String change() throws Exception {
		return EDIT;
	}

	public String add() throws Exception {
		return ADD;
	}

	public String select() throws Exception {
		return SELECT;
	}

	public String execute() throws Exception {
		return SUCCESS;
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

	public void validate() {
	}

	public Long[] getIds() {
		return ids;
	}

	public void setIds(Long[] ids) {
		this.ids = ids;
	}

	public Pagination getPagination() {
		return pagination;
	}

	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@SuppressWarnings("rawtypes")
	public List getList() {
		return list;
	}

	public void setList(@SuppressWarnings("rawtypes") List list) {
		this.list = list;
	}
}
