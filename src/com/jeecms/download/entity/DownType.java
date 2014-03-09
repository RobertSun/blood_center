package com.jeecms.download.entity;

import com.jeecms.download.entity.base.BaseDownType;



public class DownType extends BaseDownType {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public DownType () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public DownType (java.lang.Long id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public DownType (
		java.lang.Long id,
		com.jeecms.core.entity.Website website,
		java.lang.Boolean disabled) {

		super (
			id,
			website,
			disabled);
	}

/*[CONSTRUCTOR MARKER END]*/


}