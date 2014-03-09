package com.jeecms.common.struts2;

import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

/**
 * Boolean����ת��
 *
 * ����Ĭ������ת��ֻ��Ϊtrue��false������Ϊnull�����⡣
 *
 * @author liufang
 *
 */
public class BooleanConverter extends StrutsTypeConverter {

	@Override
	public Object convertFromString(@SuppressWarnings("rawtypes") Map context, String[] values, @SuppressWarnings("rawtypes") Class toClass) {
		String value = values[0];
		if (value == null) {
			return null;
		}
		if ("false".equalsIgnoreCase(value) || "0".equals(value)) {
			return false;
		} else if ("true".equalsIgnoreCase(value) || "1".equals(value)) {
			return true;
		} else {
			return null;
		}
	}

	@Override
	public String convertToString(@SuppressWarnings("rawtypes") Map context, Object o) {
		Boolean value = (Boolean) o;
		return String.valueOf(value);
	}

}
