package com.jeecms.common.struts2.interceptor;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.StrutsStatics;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * ����ִ�п�ʼʱ��
 * 
 * @author liufang
 * 
 */
@SuppressWarnings("serial")
public class ProcessingStartInterceptor extends AbstractInterceptor {
	/**
	 * ��ʼִ��ʱ��
	 */
	public static final String PROCESSING_START = "_proc_start";

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		ActionContext ctx = invocation.getInvocationContext();
		HttpServletRequest req = (HttpServletRequest) ctx
				.get(StrutsStatics.HTTP_REQUEST);
		if (req.getAttribute(PROCESSING_START) == null) {
			req.setAttribute(PROCESSING_START, System.nanoTime());
		}
		return invocation.invoke();
	}
}