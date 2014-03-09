package com.jeecms.cms.entity;

import com.jeecms.cms.entity.base.BaseCmsMemberGroup;



public class CmsMemberGroup extends BaseCmsMemberGroup {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public CmsMemberGroup () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public CmsMemberGroup (java.lang.Long id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public CmsMemberGroup (
		java.lang.Long id,
		com.jeecms.core.entity.Website website) {

		super (
			id,
			website);
	}

/*[CONSTRUCTOR MARKER END]*/


}