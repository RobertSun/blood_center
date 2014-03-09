package com.jeecms.core.entity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

import com.jeecms.core.entity.base.BaseControl;

public class Control extends BaseControl {
	private static final long serialVersionUID = 1L;

	/**
	 * ����û����Ƿ��ڱ��������档֧��*ͨ�����
	 * 
	 * @param username
	 * @return true ���ͨ����false ��鲻ͨ����
	 */
	public boolean checkReservedWords(String username) {
		if (StringUtils.isBlank(username)) {
			return false;
		}
		String words = getReservedWords();
		if (StringUtils.isBlank(words)) {
			return true;
		}
		words = words.replace("*", ".*");
		Pattern p;
		Matcher m;
		for (String word : StringUtils.split(words, "\n")) {
			p = Pattern.compile(word);
			m = p.matcher(username);
			if (m.matches()) {
				return false;
			}
		}
		return true;
	}

	/* [CONSTRUCTOR MARKER BEGIN] */
	public Control () {
		super();
	}

	/**
	 * Constructor for required fields
	 */
	public Control (
		java.lang.Integer nameMinLen) {

		super (
			nameMinLen);
	}

	/* [CONSTRUCTOR MARKER END] */

}