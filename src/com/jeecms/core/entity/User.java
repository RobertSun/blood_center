package com.jeecms.core.entity;

import com.jeecms.core.entity.base.BaseUser;

public class User extends BaseUser {
	private static final long serialVersionUID = 1L;

	/**
	 * 在session的保存的key。
	 */
	public static final String USER_KEY = "_user_key";

	/* [CONSTRUCTOR MARKER BEGIN] */
	public User () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public User (java.lang.Long id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public User (
		java.lang.Long id,
		java.lang.String loginName,
		java.lang.String email,
		java.lang.Integer unreadMsg,
		java.lang.Boolean disabled) {

		super (
			id,
			loginName,
			email,
			unreadMsg,
			disabled);
	}

	/* [CONSTRUCTOR MARKER END] */
}