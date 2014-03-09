package com.jeecms.auxiliary.entity.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the VOTE_RECORD table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="VOTE_RECORD"
 */

public abstract class BaseVoteRecord  implements Serializable {

	private static final long serialVersionUID = 7863846198131751614L;
	public static String REF = "VoteRecord";
	public static String PROP_VOTE_TIME = "voteTime";
	public static String PROP_VOTE_COOKIE = "voteCookie";
	public static String PROP_TOPIC = "topic";
	public static String PROP_VOTE_IP = "voteIp";
	public static String PROP_MEMBER = "member";
	public static String PROP_ID = "id";


	// constructors
	public BaseVoteRecord () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseVoteRecord (java.lang.Long id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseVoteRecord (
		java.lang.Long id,
		com.jeecms.auxiliary.entity.VoteTopic topic) {

		this.setId(id);
		this.setTopic(topic);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Long id;

	// fields
	private java.util.Date voteTime;
	private java.lang.String voteIp;
	private java.lang.String voteCookie;

	// many to one
	private com.jeecms.auxiliary.entity.VoteTopic topic;
	private com.jeecms.core.entity.Member member;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="VRECORD_ID"
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
	 * Return the value associated with the column: VOTE_TIME
	 */
	public java.util.Date getVoteTime () {
		return voteTime;
	}

	/**
	 * Set the value related to the column: VOTE_TIME
	 * @param voteTime the VOTE_TIME value
	 */
	public void setVoteTime (java.util.Date voteTime) {
		this.voteTime = voteTime;
	}



	/**
	 * Return the value associated with the column: VOTE_IP
	 */
	public java.lang.String getVoteIp () {
		return voteIp;
	}

	/**
	 * Set the value related to the column: VOTE_IP
	 * @param voteIp the VOTE_IP value
	 */
	public void setVoteIp (java.lang.String voteIp) {
		this.voteIp = voteIp;
	}



	/**
	 * Return the value associated with the column: VOTE_COOKIE
	 */
	public java.lang.String getVoteCookie () {
		return voteCookie;
	}

	/**
	 * Set the value related to the column: VOTE_COOKIE
	 * @param voteCookie the VOTE_COOKIE value
	 */
	public void setVoteCookie (java.lang.String voteCookie) {
		this.voteCookie = voteCookie;
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



	/**
	 * Return the value associated with the column: MEMBER_ID
	 */
	public com.jeecms.core.entity.Member getMember () {
		return member;
	}

	/**
	 * Set the value related to the column: MEMBER_ID
	 * @param member the MEMBER_ID value
	 */
	public void setMember (com.jeecms.core.entity.Member member) {
		this.member = member;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.jeecms.auxiliary.entity.VoteRecord)) return false;
		else {
			com.jeecms.auxiliary.entity.VoteRecord voteRecord = (com.jeecms.auxiliary.entity.VoteRecord) obj;
			if (null == this.getId() || null == voteRecord.getId()) return false;
			else return (this.getId().equals(voteRecord.getId()));
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