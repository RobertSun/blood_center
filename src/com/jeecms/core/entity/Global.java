package com.jeecms.core.entity;

import com.jeecms.core.entity.base.BaseGlobal;



public class Global extends BaseGlobal {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public Global () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public Global (java.lang.Long id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public Global (
		java.lang.Long id,
		java.lang.String contextPath,
		java.lang.Integer port) {

		super (
			id,
			contextPath,
			port);
	}

/*[CONSTRUCTOR MARKER END]*/


}