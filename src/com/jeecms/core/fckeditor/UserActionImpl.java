package com.jeecms.core.fckeditor;

import javax.servlet.http.HttpServletRequest;

import com.jeecms.core.util.UploadRule;

import net.fckeditor.requestcycle.UserAction;

/**
 * fckeditor用户权限
 * 
 * @author liufang
 * 
 */
public class UserActionImpl implements UserAction {
	public boolean isEnabledForFileBrowsing(HttpServletRequest request) {
		String uploadRuleId = request.getParameter("uploadRuleId");
		UploadRule rule = (UploadRule) request.getSession().getAttribute(
				UploadRule.KEY + uploadRuleId);
		if (rule != null) {
			return rule.isAllowFileBrowsing();
		} else {
			return false;
		}
	}

	public boolean isEnabledForFileUpload(HttpServletRequest request) {
		String uploadRuleId = request.getParameter("uploadRuleId");
		UploadRule rule = (UploadRule) request.getSession().getAttribute(
				UploadRule.KEY + uploadRuleId);
		if (rule == null || !rule.isAllowUpload() || rule.getAllowSize() == 0) {
			return false;
		} else {
			return true;
		}
	}
}
