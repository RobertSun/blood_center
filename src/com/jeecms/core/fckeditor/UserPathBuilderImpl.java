package com.jeecms.core.fckeditor;

import javax.servlet.http.HttpServletRequest;

import com.jeecms.core.util.UploadRule;

import net.fckeditor.requestcycle.UserPathBuilder;

/**
 * fckeditor上传路径实现
 * 
 * @author liufang
 * 
 */
public class UserPathBuilderImpl implements UserPathBuilder {
	public String getUserFilesPath(HttpServletRequest request) {
		// 根据上传规则处理浏览路径
		UploadRule rule = (UploadRule) request.getSession().getAttribute(
				UploadRule.KEY + request.getParameter("uploadRuleId"));
		return rule.getRootPath() + rule.getPathPrefix();
	}
}
