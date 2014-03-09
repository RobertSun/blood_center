package com.jeecms.cms.entity.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the CMS_ADMIN table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="CMS_ADMIN"
 */

public abstract class BaseCmsAdmin  implements Serializable {

	private static final long serialVersionUID = 7443040769732004710L;
	public static String REF = "CmsAdmin";
	public static String PROP_SELF_ONLY = "selfOnly";
	public static String PROP_WEBSITE = "website";
	public static String PROP_CHECK_RIGHT = "checkRight";
	public static String PROP_ADMIN = "admin";
	public static String PROP_ID = "id";


	// constructors
	public BaseCmsAdmin () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseCmsAdmin (java.lang.Long id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseCmsAdmin (
		java.lang.Long id,
		com.jeecms.core.entity.Website website,
		java.lang.Integer checkRight,
		java.lang.Boolean selfOnly) {

		this.setId(id);
		this.setWebsite(website);
		this.setCheckRight(checkRight);
		this.setSelfOnly(selfOnly);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Long id;

	// fields
	private java.lang.Integer checkRight;
	private java.lang.Boolean selfOnly;

	// one to one
	private com.jeecms.core.entity.Admin admin;

	// many to one
	private com.jeecms.core.entity.Website website;

	// collections
	private java.util.Set<com.jeecms.cms.entity.CmsChannel> channels;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="foreign"
     *  column="ADMIN_ID"
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
	 * Return the value associated with the column: CHECK_RIGHT
	 */
	public java.lang.Integer getCheckRight () {
		return checkRight;
	}

	/**
	 * Set the value related to the column: CHECK_RIGHT
	 * @param checkRight the CHECK_RIGHT value
	 */
	public void setCheckRight (java.lang.Integer checkRight) {
		this.checkRight = checkRight;
	}



	/**
	 * Return the value associated with the column: IS_SELF_ONLY
	 */
	public java.lang.Boolean getSelfOnly () {
		return selfOnly;
	}

	/**
	 * Set the value related to the column: IS_SELF_ONLY
	 * @param selfOnly the IS_SELF_ONLY value
	 */
	public void setSelfOnly (java.lang.Boolean selfOnly) {
		this.selfOnly = selfOnly;
	}



	/**
	 * Return the value associated with the column: admin
	 */
	public com.jeecms.core.entity.Admin getAdmin () {
		return admin;
	}

	/**
	 * Set the value related to the column: admin
	 * @param admin the admin value
	 */
	public void setAdmin (com.jeecms.core.entity.Admin admin) {
		this.admin = admin;
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
	 * Return the value associated with the column: channels
	 */
	public java.util.Set<com.jeecms.cms.entity.CmsChannel> getChannels () {
		return channels;
	}

	/**
	 * Set the value related to the column: channels
	 * @param channels the channels value
	 */
	public void setChannels (java.util.Set<com.jeecms.cms.entity.CmsChannel> channels) {
		this.channels = channels;
	}

	public void addTochannels (com.jeecms.cms.entity.CmsChannel cmsChannel) {
		if (null == getChannels()) setChannels(new java.util.TreeSet<com.jeecms.cms.entity.CmsChannel>());
		getChannels().add(cmsChannel);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.jeecms.cms.entity.CmsAdmin)) return false;
		else {
			com.jeecms.cms.entity.CmsAdmin cmsAdmin = (com.jeecms.cms.entity.CmsAdmin) obj;
			if (null == this.getId() || null == cmsAdmin.getId()) return false;
			else return (this.getId().equals(cmsAdmin.getId()));
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