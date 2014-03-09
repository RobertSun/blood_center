package com.jeecms.auxiliary.entity;

import com.jeecms.auxiliary.entity.base.BaseVoteRecord;



public class VoteRecord extends BaseVoteRecord {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public VoteRecord () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public VoteRecord (java.lang.Long id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public VoteRecord (
		java.lang.Long id,
		com.jeecms.auxiliary.entity.VoteTopic topic) {

		super (
			id,
			topic);
	}

/*[CONSTRUCTOR MARKER END]*/


}