package com.jeecms.cms.entity;

import com.jeecms.cms.entity.base.BaseContentCtg;

public class ContentCtg extends BaseContentCtg {
	private static final long serialVersionUID = 1L;

	/**
	 * 获得带注释的名称
	 * 
	 * @return
	 */
	public String getNameWithComment() {
		return getName() + " attr='" + getLabel() + "'";
	}

	/* [CONSTRUCTOR MARKER BEGIN] */
	public ContentCtg () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public ContentCtg (java.lang.Long id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public ContentCtg (
		java.lang.Long id,
		com.jeecms.core.entity.Website website,
		java.lang.String label,
		java.lang.Boolean hasTitleimg,
		java.lang.Boolean disabled) {

		super (
			id,
			website,
			label,
			hasTitleimg,
			disabled);
	}

	/* [CONSTRUCTOR MARKER END] */

}