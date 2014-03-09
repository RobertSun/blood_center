package com.jeecms.auxiliary.entity;

import com.jeecms.auxiliary.entity.base.BaseVoteTopic;



public class VoteTopic extends BaseVoteTopic {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public VoteTopic () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public VoteTopic (java.lang.Long id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public VoteTopic (
		java.lang.Long id,
		com.jeecms.core.entity.Website website,
		java.lang.Boolean restrictMember,
		java.lang.Boolean restrictIp,
		java.lang.Boolean restrictCookie,
		java.lang.Boolean disabled,
		java.lang.Boolean current) {

		super (
			id,
			website,
			restrictMember,
			restrictIp,
			restrictCookie,
			disabled,
			current);
	}

/*[CONSTRUCTOR MARKER END]*/


}