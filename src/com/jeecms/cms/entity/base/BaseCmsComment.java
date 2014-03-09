package com.jeecms.cms.entity.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the CMS_COMMENT table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="CMS_COMMENT"
 */

public abstract class BaseCmsComment  implements Serializable {

	private static final long serialVersionUID = -7745309344997439906L;
	public static String REF = "CmsComment";
	public static String PROP_CHECK = "check";
	public static String PROP_RECOMMEND = "recommend";
	public static String PROP_CREATE_TIME = "createTime";
	public static String PROP_REPLAY_TIME = "replayTime";
	public static String PROP_WEBSITE = "website";
	public static String PROP_DISABLED = "disabled";
	public static String PROP_IP = "ip";
	public static String PROP_CONTENT_MEMBER = "contentMember";
	public static String PROP_TITLE = "title";
	public static String PROP_ADMIN = "admin";
	public static String PROP_MEMBER = "member";
	public static String PROP_CONTENT_ADMIN = "contentAdmin";
	public static String PROP_ID = "id";


	// constructors
	public BaseCmsComment () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseCmsComment (java.lang.Long id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseCmsComment (
		java.lang.Long id,
		com.jeecms.core.entity.Website website,
		java.lang.Boolean check,
		java.lang.Boolean recommend,
		java.lang.Boolean disabled) {

		this.setId(id);
		this.setWebsite(website);
		this.setCheck(check);
		this.setRecommend(recommend);
		this.setDisabled(disabled);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Long id;

	// fields
	private java.lang.String title;
	private java.lang.String contentMember;
	private java.lang.String contentAdmin;
	private java.util.Date createTime;
	private java.util.Date replayTime;
	private java.lang.String ip;
	private java.lang.Boolean check;
	private java.lang.Boolean recommend;
	private java.lang.Boolean disabled;

	// many to one
	private com.jeecms.core.entity.Website website;
	private com.jeecms.cms.entity.CmsAdmin admin;
	private com.jeecms.core.entity.Member member;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="COMMENT_ID"
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
	 * Return the value associated with the column: CONTENT_MEMBER
	 */
	public java.lang.String getContentMember () {
		return contentMember;
	}

	/**
	 * Set the value related to the column: CONTENT_MEMBER
	 * @param contentMember the CONTENT_MEMBER value
	 */
	public void setContentMember (java.lang.String contentMember) {
		this.contentMember = contentMember;
	}



	/**
	 * Return the value associated with the column: CONTENT_ADMIN
	 */
	public java.lang.String getContentAdmin () {
		return contentAdmin;
	}

	/**
	 * Set the value related to the column: CONTENT_ADMIN
	 * @param contentAdmin the CONTENT_ADMIN value
	 */
	public void setContentAdmin (java.lang.String contentAdmin) {
		this.contentAdmin = contentAdmin;
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
	 * Return the value associated with the column: REPLAY_TIME
	 */
	public java.util.Date getReplayTime () {
		return replayTime;
	}

	/**
	 * Set the value related to the column: REPLAY_TIME
	 * @param replayTime the REPLAY_TIME value
	 */
	public void setReplayTime (java.util.Date replayTime) {
		this.replayTime = replayTime;
	}



	/**
	 * Return the value associated with the column: IP
	 */
	public java.lang.String getIp () {
		return ip;
	}

	/**
	 * Set the value related to the column: IP
	 * @param ip the IP value
	 */
	public void setIp (java.lang.String ip) {
		this.ip = ip;
	}



	/**
	 * Return the value associated with the column: IS_CHECK
	 */
	public java.lang.Boolean getCheck () {
		return check;
	}

	/**
	 * Set the value related to the column: IS_CHECK
	 * @param check the IS_CHECK value
	 */
	public void setCheck (java.lang.Boolean check) {
		this.check = check;
	}



	/**
	 * Return the value associated with the column: IS_RECOMMEND
	 */
	public java.lang.Boolean getRecommend () {
		return recommend;
	}

	/**
	 * Set the value related to the column: IS_RECOMMEND
	 * @param recommend the IS_RECOMMEND value
	 */
	public void setRecommend (java.lang.Boolean recommend) {
		this.recommend = recommend;
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
	 * Return the value associated with the column: ADMIN_ID
	 */
	public com.jeecms.cms.entity.CmsAdmin getAdmin () {
		return admin;
	}

	/**
	 * Set the value related to the column: ADMIN_ID
	 * @param admin the ADMIN_ID value
	 */
	public void setAdmin (com.jeecms.cms.entity.CmsAdmin admin) {
		this.admin = admin;
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
		if (!(obj instanceof com.jeecms.cms.entity.CmsComment)) return false;
		else {
			com.jeecms.cms.entity.CmsComment cmsComment = (com.jeecms.cms.entity.CmsComment) obj;
			if (null == this.getId() || null == cmsComment.getId()) return false;
			else return (this.getId().equals(cmsComment.getId()));
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