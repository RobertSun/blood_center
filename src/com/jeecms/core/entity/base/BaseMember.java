package com.jeecms.core.entity.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the CORE_MEMBER table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="CORE_MEMBER"
 */

public abstract class BaseMember  implements Serializable {

	private static final long serialVersionUID = -7585294783489695747L;
	public static String REF = "Member";
	public static String PROP_MSN = "msn";
	public static String PROP_WEBSITE = "website";
	public static String PROP_CREATE_TIME = "createTime";
	public static String PROP_DISABLED = "disabled";
	public static String PROP_USER = "user";
	public static String PROP_PERSONAL_WEBSITE = "personalWebsite";
	public static String PROP_NICK_NAME = "nickName";
	public static String PROP_QQ = "qq";
	public static String PROP_ID = "id";


	// constructors
	public BaseMember () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMember (java.lang.Long id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseMember (
		java.lang.Long id,
		com.jeecms.core.entity.Website website,
		com.jeecms.core.entity.User user,
		java.util.Date createTime,
		java.lang.Boolean disabled) {

		this.setId(id);
		this.setWebsite(website);
		this.setUser(user);
		this.setCreateTime(createTime);
		this.setDisabled(disabled);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Long id;

	// fields
	private java.lang.String nickName;
	private java.lang.String personalWebsite;
	private java.lang.String qq;
	private java.lang.String msn;
	private java.util.Date createTime;
	private java.lang.Boolean disabled;

	// many to one
	private com.jeecms.core.entity.Website website;
	private com.jeecms.core.entity.User user;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="MEMBER_ID"
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
	 * Return the value associated with the column: NICK_NAME
	 */
	public java.lang.String getNickName () {
		return nickName;
	}

	/**
	 * Set the value related to the column: NICK_NAME
	 * @param nickName the NICK_NAME value
	 */
	public void setNickName (java.lang.String nickName) {
		this.nickName = nickName;
	}



	/**
	 * Return the value associated with the column: PERSONAL_WEBSITE
	 */
	public java.lang.String getPersonalWebsite () {
		return personalWebsite;
	}

	/**
	 * Set the value related to the column: PERSONAL_WEBSITE
	 * @param personalWebsite the PERSONAL_WEBSITE value
	 */
	public void setPersonalWebsite (java.lang.String personalWebsite) {
		this.personalWebsite = personalWebsite;
	}



	/**
	 * Return the value associated with the column: QQ
	 */
	public java.lang.String getQq () {
		return qq;
	}

	/**
	 * Set the value related to the column: QQ
	 * @param qq the QQ value
	 */
	public void setQq (java.lang.String qq) {
		this.qq = qq;
	}



	/**
	 * Return the value associated with the column: MSN
	 */
	public java.lang.String getMsn () {
		return msn;
	}

	/**
	 * Set the value related to the column: MSN
	 * @param msn the MSN value
	 */
	public void setMsn (java.lang.String msn) {
		this.msn = msn;
	}



	/**
	 * Return the value associated with the column: CREATE_TIME
	 */
	public java.util.Date getCreateTime () {
		return createTime;
	}

	/**
	 * Set the value related to the column: CREATE_TIME
	 * @param createTime the CREATE_TIME value
	 */
	public void setCreateTime (java.util.Date createTime) {
		this.createTime = createTime;
	}



	/**
	 * Return the value associated with the column: IS_DISABLED
	 */
	public java.lang.Boolean getDisabled () {
		return disabled;
	}

	/**
	 * Set the value related to the column: IS_DISABLED
	 * @param disabled the IS_DISABLED value
	 */
	public void setDisabled (java.lang.Boolean disabled) {
		this.disabled = disabled;
	}



	/**
	 * Return the value associated with the column: WEBSITE_ID
	 */
	public com.jeecms.core.entity.Website getWebsite () {
		return website;
	}

	/**
	 * Set the value related to the column: WEBSITE_ID
	 * @param website the WEBSITE_ID value
	 */
	public void setWebsite (com.jeecms.core.entity.Website website) {
		this.website = website;
	}



	/**
	 * Return the value associated with the column: USER_ID
	 */
	public com.jeecms.core.entity.User getUser () {
		return user;
	}

	/**
	 * Set the value related to the column: USER_ID
	 * @param user the USER_ID value
	 */
	public void setUser (com.jeecms.core.entity.User user) {
		this.user = user;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.jeecms.core.entity.Member)) return false;
		else {
			com.jeecms.core.entity.Member member = (com.jeecms.core.entity.Member) obj;
			if (null == this.getId() || null == member.getId()) return false;
			else return (this.getId().equals(member.getId()));
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