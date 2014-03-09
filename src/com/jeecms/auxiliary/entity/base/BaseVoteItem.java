package com.jeecms.auxiliary.entity.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the VOTE_ITEM table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="VOTE_ITEM"
 */

public abstract class BaseVoteItem  implements Serializable {

	private static final long serialVersionUID = -997079069348808273L;
	public static String REF = "VoteItem";
	public static String PROP_DESCRIPTION = "description";
	public static String PROP_TOPIC = "topic";
	public static String PROP_PRIORITY = "priority";
	public static String PROP_TITLE = "title";
	public static String PROP_VOTE_COUNT = "voteCount";
	public static String PROP_ID = "id";


	// constructors
	public BaseVoteItem () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseVoteItem (java.lang.Long id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseVoteItem (
		java.lang.Long id,
		com.jeecms.auxiliary.entity.VoteTopic topic,
		java.lang.Integer priority) {

		this.setId(id);
		this.setTopic(topic);
		this.setPriority(priority);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Long id;

	// fields
	private java.lang.String title;
	private java.lang.String description;
	private java.lang.Long voteCount;
	private java.lang.Integer priority;

	// many to one
	private com.jeecms.auxiliary.entity.VoteTopic topic;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="VOTEITEM_ID"
     */
	public java.lang.Long getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (java.lang.Long id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: TITLE
	 */
	public java.lang.String getTitle () {
		return title;
	}

	/**
	 * Set the value related to the column: TITLE
	 * @param title the TITLE value
	 */
	public void setTitle (java.lang.String title) {
		this.title = title;
	}



	/**
	 * Return the value associated with the column: DESCRIPTION
	 */
	public java.lang.String getDescription () {
		return description;
	}

	/**
	 * Set the value related to the column: DESCRIPTION
	 * @param description the DESCRIPTION value
	 */
	public void setDescription (java.lang.String description) {
		this.description = description;
	}



	/**
	 * Return the value associated with the column: VOTE_COUNT
	 */
	public java.lang.Long getVoteCount () {
		return voteCount;
	}

	/**
	 * Set the value related to the column: VOTE_COUNT
	 * @param voteCount the VOTE_COUNT value
	 */
	public void setVoteCount (java.lang.Long voteCount) {
		this.voteCount = voteCount;
	}



	/**
	 * Return the value associated with the column: PRIORITY
	 */
	public java.lang.Integer getPriority () {
		return priority;
	}

	/**
	 * Set the value related to the column: PRIORITY
	 * @param priority the PRIORITY value
	 */
	public void setPriority (java.lang.Integer priority) {
		this.priority = priority;
	}



	/**
	 * Return the value associated with the column: VTOPIC_ID
	 */
	public com.jeecms.auxiliary.entity.VoteTopic getTopic () {
		return topic;
	}

	/**
	 * Set the value related to the column: VTOPIC_ID
	 * @param topic the VTOPIC_ID value
	 */
	public void setTopic (com.jeecms.auxiliary.entity.VoteTopic topic) {
		this.topic = topic;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.jeecms.auxiliary.entity.VoteItem)) return false;
		else {
			com.jeecms.auxiliary.entity.VoteItem voteItem = (com.jeecms.auxiliary.entity.VoteItem) obj;
			if (null == this.getId() || null == voteItem.getId()) return false;
			else return (this.getId().equals(voteItem.getId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}