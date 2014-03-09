package com.jeecms.core.entity;

import org.apache.commons.lang.StringUtils;

import com.jeecms.core.entity.base.BaseMember;

public class Member extends BaseMember {
	private static final long serialVersionUID = 1L;

	/**
	 * ��õ�¼��
	 * 
	 * @return
	 */
	public String getLoginName() {
		User user = getUser();
		if (user != null) {
			return user.getLoginName();
		} else {
			return null;
		}
	}

	/**
	 * ������֡������ǳƣ��粻�����򷵻ص�¼����
	 * 
	 * @return
	 */
	public String getName() {
		String s = getNickName();
		if (!StringUtils.isBlank(s)) {
			return s;
		} else {
			return getLoginName();
		}
	}

	/**
	 * ��Ա�Ƿ���á�����ȡ���ڻ�Ա����״̬����ȡ����user״̬��
	 * 
	 * @return
	 */
	public Boolean getMemberDisabled() {
		Boolean b = getDisabled();
		if (b == null || b == true) {
			return b;
		} else {
			return getUser().getDisabled();
		}
	}

	/**
	 * ��session�ı����key��
	 */
	public static final String MEMBER_KEY = "_member_key";

	/* [CONSTRUCTOR MARKER BEGIN] */
	public Member () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public Member (java.lang.Long id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public Member (
		java.lang.Long id,
		com.jeecms.core.entity.Website website,
		com.jeecms.core.entity.User user,
		java.util.Date createTime,
		java.lang.Boolean disabled) {

		super (
			id,
			website,
			user,
			createTime,
			disabled);
	}

	/* [CONSTRUCTOR MARKER END] */

}