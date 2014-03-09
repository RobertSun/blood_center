package com.jeecms.core.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.Validateable;
import com.opensymphony.xwork2.ValidationAware;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import com.opensymphony.xwork2.interceptor.PrefixMethodInvocationUtil;

/**
 * 错误拦截器
 * 
 * 用于验证组件发现非法数据后，将页面转向一个信息提示页面。
 * 
 * @author liufang
 * 
 */
@SuppressWarnings("serial")
public class ErrorWorkflowInterceptor extends MethodFilterInterceptor {
	private static final Logger log = LoggerFactory
			.getLogger(ErrorWorkflowInterceptor.class);

	private final static String VALIDATE_PREFIX = "validate";
	private final static String ALT_VALIDATE_PREFIX = "validateDo";

	private boolean alwaysInvokeValidate = true;

	private String inputResultName = "showError";

	/**
	 * Determine if {@link Validateable}'s <code>validate()</code> should always
	 * be invoked. Default to "true".
	 * 
	 * @param alwaysInvokeValidate
	 */
	public void setAlwaysInvokeValidate(String alwaysInvokeValidate) {
		this.alwaysInvokeValidate = Boolean.parseBoolean(alwaysInvokeValidate);
	}

	/**
	 * Set the <code>inputResultName</code> (result name to be returned when a
	 * action / field error is found registered). Default to
	 * {@link Action#INPUT}
	 * 
	 * @param inputResultName
	 */
	public void setInputResultName(String inputResultName) {
		this.inputResultName = inputResultName;
	}

	/**
	 * Intercept {@link ActionInvocation} and returns a
	 * <code>inputResultName</code> when action / field errors is found
	 * registered.
	 * 
	 * @return String result name
	 */
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		Object action = invocation.getAction();

		if (action instanceof Validateable
				&& !(action instanceof ValidationAware && ((ValidationAware) action)
						.hasErrors())) {
			// keep exception that might occured in validateXXX or validateDoXXX
			Exception exception = null;
			Validateable validateable = (Validateable) action;
			log.debug("Invoking validate() on action {}", validateable);
			try {
				PrefixMethodInvocationUtil.invokePrefixMethod(invocation,
						new String[] { VALIDATE_PREFIX, ALT_VALIDATE_PREFIX });
			} catch (Exception e) {
				// If any exception occurred while doing reflection, we want
				// validate() to be executed
				log
						.warn(
								"an exception occured while executing the prefix method",
								e);
				exception = e;
			}
			if (alwaysInvokeValidate) {
				validateable.validate();
			}
			if (exception != null) {
				// rethrow if something is wrong while doing validateXXX /
				// validateDoXXX
				throw exception;
			}
		}
		if (action instanceof ValidationAware) {
			ValidationAware validationAwareAction = (ValidationAware) action;
			if (validationAwareAction.hasErrors()) {
				log.debug("Errors on action {}, returning result name '{}'",
						validationAwareAction, inputResultName);
				return inputResultName;
			}
		}
		return invocation.invoke();
	}
}