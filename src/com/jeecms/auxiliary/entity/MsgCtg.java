package com.jeecms.auxiliary.entity;

import com.jeecms.auxiliary.entity.base.BaseMsgCtg;



public class MsgCtg extends BaseMsgCtg {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public MsgCtg () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public MsgCtg (java.lang.Long id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public MsgCtg (
		java.lang.Long id,
		com.jeecms.core.entity.Website website) {

		super (
			id,
			website);
	}

/*[CONSTRUCTOR MARKER END]*/


}