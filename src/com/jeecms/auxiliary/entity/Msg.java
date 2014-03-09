package com.jeecms.auxiliary.entity;

import com.jeecms.auxiliary.entity.base.BaseMsg;
import com.jeecms.common.util.StrUtils;
import com.jeecms.core.entity.Member;

public class Msg extends BaseMsg {
	private static final long serialVersionUID = 1L;

	/**
	 * 获得会员名称。如会员不存在，则返回设置中的匿名名称。
	 * 
	 * @return
	 */
	public String getMemberName() {
		Member m = getMember();
		if (m != null) {
			return m.getName();
		} else {
			return getConfig().getMsgAnonymity();
		}
	}

	public String getTxtCm() {
		return StrUtils.htm2txt(getContentMember());
	}

	public String getTxtCa() {
		return StrUtils.htm2txt(getContentAdmin());
	}

	/* [CONSTRUCTOR MARKER BEGIN] */
	public Msg () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public Msg (java.lang.Long id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public Msg (
		java.lang.Long id,
		com.jeecms.auxiliary.entity.MsgCtg ctg,
		com.jeecms.core.entity.Website website,
		com.jeecms.auxiliary.entity.AuxiConfig config,
		java.lang.Boolean check,
		java.lang.Boolean recommend,
		java.lang.Boolean disabled) {

		super (
			id,
			ctg,
			website,
			config,
			check,
			recommend,
			disabled);
	}

	/* [CONSTRUCTOR MARKER END] */

}