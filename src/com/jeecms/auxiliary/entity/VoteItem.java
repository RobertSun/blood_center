package com.jeecms.auxiliary.entity;

import com.jeecms.auxiliary.entity.base.BaseVoteItem;
import com.jeecms.core.util.PriorityInterface;

public class VoteItem extends BaseVoteItem implements PriorityInterface {
	private static final long serialVersionUID = 1L;

	/**
	 * 获得投票项的百分比
	 * 
	 * @return
	 */
	public int getPercent() {
		Long total = getTopic().getTotalCount();
		if (total == 0) {
			return 0;
		} else {
			return (int) (getVoteCount() * 100 / total);
		}
	}

	/* [CONSTRUCTOR MARKER BEGIN] */
	public VoteItem() {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public VoteItem(java.lang.Long id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public VoteItem(java.lang.Long id,
			com.jeecms.auxiliary.entity.VoteTopic topic,
			java.lang.Integer priority) {

		super(id, topic, priority);
	}

	/* [CONSTRUCTOR MARKER END] */

}