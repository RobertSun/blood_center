package com.jeecms.common.struts2.interceptor;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.math.NumberUtils;
import org.apache.struts2.StrutsStatics;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

/**
 * URL��ַ������
 * 
 * ���ҳ��α��̬��ַ����Ҫ����������
 * 
 * @author liufang
 * 
 */
public class UrlInterceptor extends MethodFilterInterceptor {
	private static final long serialVersionUID = 1L;

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		Object action = invocation.getAction();
		ActionContext ctx = invocation.getInvocationContext();
		HttpServletRequest req = (HttpServletRequest) ctx
				.get(StrutsStatics.HTTP_REQUEST);
		if (action instanceof UrlAware) {
			UrlAware aware = (UrlAware) action;
			String url = req.getRequestURL().toString();
			int pointIndex = url.indexOf('.', url.lastIndexOf('/'));
			if (pointIndex == -1) {
				url += "index.do";
				pointIndex = url.indexOf('.', url.lastIndexOf('/'));
			}
			String paramStr = req.getQueryString();
			if (paramStr != null && !paramStr.trim().equals("")) {
				url += "?" + paramStr;
			}
			aware.setWholeUrl(url);
			int lineIndex = url.indexOf('_', url.lastIndexOf('/'));
			int mlineIndex = url.indexOf('-', url.lastIndexOf('/'));
			// ǰ·��������
			int preIndex = 0;
			if (lineIndex != -1) {
				// ���»��ߣ��з�ҳ��
				preIndex = lineIndex;
			} else if (mlineIndex != -1) {
				// ���л��ߣ��ж��Ʋ�����
				preIndex = mlineIndex;
			} else {
				// ʲô��û��
				preIndex = pointIndex;
			}
			aware.setPageLink(url.substring(0, preIndex));
			// ��·����ʼ��
			int suffixIndex = 0;
			if (mlineIndex != -1) {
				// ���л���
				suffixIndex = mlineIndex;
			} else {
				suffixIndex = pointIndex;
			}
			aware.setPageSuffix(url.substring(suffixIndex));
			// ȡҳ���͸��Ӳ���
			if (preIndex == suffixIndex) {
				// û�з�ҳ��Ϊ��һҳ��
				aware.setPageNo(1);
			} else {
				// ȥ���»���"_"��
				String page = url.substring(preIndex + 1, suffixIndex);
				aware.setPageNo(NumberUtils.toInt(page, 1));
			}
			// ·������
			String pathParm = ctx.getName();
			lineIndex = pathParm.indexOf("_");
			mlineIndex = pathParm.indexOf("-");
			if (lineIndex != -1) {
				pathParm = pathParm.substring(0, lineIndex);
			} else if (mlineIndex != -1) {
				pathParm = pathParm.substring(0, mlineIndex);
			}
			aware.setPathParams(pathParm.split("/"));
			// ���Ӳ���
			if (mlineIndex != -1) {
				String otherParam = ctx.getName().substring(mlineIndex + 1);
				aware.setOtherParams(otherParam.split("-"));
			}
		}
		return invocation.invoke();
	}
}
