package com.jeecms.cms.entity.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the CMS_MEMBER_GROUP table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="CMS_MEMBER_GROUP"
 */

public abstract class BaseCmsMemberGroup  implements Serializable {

	private static final long serialVersionUID = 7409414973175105119L;
	public static String REF = "CmsMemberGroup";
	public static String PROP_UPLOAD_SIZE = "uploadSize";
	public static String PROP_DESCRIPTION = "description";
	public static String PROP_WEBSITE = "website";
	public static String PROP_NAME = "name";
	public static String PROP_ID = "id";
	public static String PROP_LEVEL = "level";


	// constructors
	public BaseCmsMemberGroup () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseCmsMemberGroup (java.lang.Long id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseCmsMemberGroup (
		java.lang.Long id,
		com.jeecms.core.entity.Website website) {

		this.setId(id);
		this.setWebsite(website);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Long id;

	// fields
	private java.lang.String name;
	private java.lang.Integer level;
	private java.lang.String description;
	private java.lang.Integer uploadSize;

	// many to one
	private com.jeecms.core.entity.Website website;

	// collections
	private java.util.Set<com.jeecms.cms.entity.CmsMember> members;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="GROUP_ID"
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
	 * Return the value associated with the column: NAME
	 */
	public java.lang.String getName () {
		return name;
	}

	/**
	 * Set the value related to the column: NAME
	 * @param name the NAME value
	 */
	public void setName (java.lang.String name) {
		this.name = name;
	}



	/**
	 * Return the value associated with the column: GROUP_LEVEL
	 */
	public java.lang.Integer getLevel () {
		return level;
	}

	/**
	 * Set the value related to the column: GROUP_LEVEL
	 * @param level the GROUP_LEVEL value
	 */
	public void setLevel (java.lang.Integer level) {
		this.level = level;
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
	 * Return the value associated with the column: UPLOAD_SIZE
	 */
	public java.lang.Integer getUploadSize () {
		return uploadSize;
	}

	/**
	 * Set the value related to the column: UPLOAD_SIZE
	 * @param uploadSize the UPLOAD_SIZE value
	 */
	public void setUploadSize (java.lang.Integer uploadSize) {
		this.uploadSize = uploadSize;
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
	 * Return the value associated with the column: members
	 */
	public java.util.Set<com.jeecms.cms.entity.CmsMember> getMembers () {
		return members;
	}

	/**
	 * Set the value related to the column: members
	 * @param members the members value
	 */
	public void setMembers (java.util.Set<com.jeecms.cms.entity.CmsMember> members) {
		this.members = members;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.jeecms.cms.entity.CmsMemberGroup)) return false;
		else {
			com.jeecms.cms.entity.CmsMemberGroup cmsMemberGroup = (com.jeecms.cms.entity.CmsMemberGroup) obj;
			if (null == this.getId() || null == cmsMemberGroup.getId()) return false;
			else return (this.getId().equals(cmsMemberGroup.getId()));
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