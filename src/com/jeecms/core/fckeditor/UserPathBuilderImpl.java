package com.jeecms.core.fckeditor;

import javax.servlet.http.HttpServletRequest;

import com.jeecms.core.util.UploadRule;

import net.fckeditor.requestcycle.UserPathBuilder;

/**
 * fckeditor�ϴ�·��ʵ��
 * 
 * @author liufang
 * 
 */
public class UserPathBuilderImpl implements UserPathBuilder {
	public String getUserFilesPath(HttpServletRequest request) {
		// �����ϴ����������·��
		UploadRule rule = (UploadRule) request.getSession().getAttribute(
				UploadRule.KEY + request.getParameter("uploadRuleId"));
		return rule.getRootPath() + rule.getPathPrefix();
	}
}
