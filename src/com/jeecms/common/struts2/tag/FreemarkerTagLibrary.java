package com.jeecms.common.struts2.tag;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.views.TagLibraryDirectiveProvider;
import org.apache.struts2.views.TagLibraryModelProvider;

import com.opensymphony.xwork2.util.ValueStack;

public class FreemarkerTagLibrary implements TagLibraryModelProvider, TagLibraryDirectiveProvider {
	public Object getFreemarkerModels(ValueStack stack, HttpServletRequest req,
			HttpServletResponse res) {
		return new FreemarkerModels(stack, req, res);
	}

	@SuppressWarnings("rawtypes")
	public List<Class> getVelocityDirectiveClasses() {
		throw new RuntimeException(
				"velocity not supported, please select freemarker!");
	}

	@Override
	public List<Class> getDirectiveClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getModels(ValueStack arg0, HttpServletRequest arg1,
			HttpServletResponse arg2) {
		// TODO Auto-generated method stub
		return null;
	}
}
