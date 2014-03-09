package com.jeecms.core.entity.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the CORE_ATTACHMENT table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="CORE_ATTACHMENT"
 */

public abstract class BaseAttachment  implements Serializable {

	private static final long serialVersionUID = 4190920604288235180L;
	public static String REF = "Attachment";
	public static String PROP_WEBSITE = "website";
	public static String PROP_DOWN_COUNT = "downCount";
	public static String PROP_CREATE_TIME = "createTime";
	public static String PROP_USER = "user";
	public static String PROP_LOST = "lost";
	public static String PROP_FILE_NAME = "fileName";
	public static String PROP_OWNER_NAME = "ownerName";
	public static String PROP_OWNER_ID = "ownerId";
	public static String PROP_FILE_PATH = "filePath";
	public static String PROP_DESCRIPTION = "description";
	public static String PROP_FREE = "free";
	public static String PROP_NAME = "name";
	public static String PROP_OWNER_URL = "ownerUrl";
	public static String PROP_PICTURE = "picture";
	public static String PROP_ID = "id";
	public static String PROP_OWNER_CTG = "ownerCtg";
	public static String PROP_FILE_SIZE = "fileSize";


	// constructors
	public BaseAttachment () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseAttachment (java.lang.Long id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseAttachment (
		java.lang.Long id,
		com.jeecms.core.entity.Website website,
		java.lang.Boolean free,
		java.lang.Boolean lost) {

		this.setId(id);
		this.setWebsite(website);
		this.setFree(free);
		this.setLost(lost);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Long id;

	// fields
	private java.lang.String name;
	private java.lang.String description;
	private java.lang.String filePath;
	private java.lang.String fileName;
	private java.lang.Integer fileSize;
	private java.lang.Long downCount;
	private java.lang.String ownerName;
	private java.lang.String ownerUrl;
	private java.lang.Long ownerId;
	private java.lang.String ownerCtg;
	private java.util.Date createTime;
	private java.lang.Boolean free;
	private java.lang.Boolean lost;
	private java.lang.Boolean picture;

	// many to one
	private com.jeecms.core.entity.Website website;
	private com.jeecms.core.entity.User user;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="ATTACHMENT_ID"
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
	 * Return the value associated with the column: FILE_PATH
	 */
	public java.lang.String getFilePath () {
		return filePath;
	}

	/**
	 * Set the value related to the column: FILE_PATH
	 * @param filePath the FILE_PATH value
	 */
	public void setFilePath (java.lang.String filePath) {
		this.filePath = filePath;
	}



	/**
	 * Return the value associated with the column: FILE_NAME
	 */
	public java.lang.String getFileName () {
		return fileName;
	}

	/**
	 * Set the value related to the column: FILE_NAME
	 * @param fileName the FILE_NAME value
	 */
	public void setFileName (java.lang.String fileName) {
		this.fileName = fileName;
	}



	/**
	 * Return the value associated with the column: FILE_SIZE
	 */
	public java.lang.Integer getFileSize () {
		return fileSize;
	}

	/**
	 * Set the value related to the column: FILE_SIZE
	 * @param fileSize the FILE_SIZE value
	 */
	public void setFileSize (java.lang.Integer fileSize) {
		this.fileSize = fileSize;
	}



	/**
	 * Return the value associated with the column: DOWN_COUNT
	 */
	public java.lang.Long getDownCount () {
		return downCount;
	}

	/**
	 * Set the value related to the column: DOWN_COUNT
	 * @param downCount the DOWN_COUNT value
	 */
	public void setDownCount (java.lang.Long downCount) {
		this.downCount = downCount;
	}



	/**
	 * Return the value associated with the column: OWNER_NAME
	 */
	public java.lang.String getOwnerName () {
		return ownerName;
	}

	/**
	 * Set the value related to the column: OWNER_NAME
	 * @param ownerName the OWNER_NAME value
	 */
	public void setOwnerName (java.lang.String ownerName) {
		this.ownerName = ownerName;
	}



	/**
	 * Return the value associated with the column: OWNER_URL
	 */
	public java.lang.String getOwnerUrl () {
		return ownerUrl;
	}

	/**
	 * Set the value related to the column: OWNER_URL
	 * @param ownerUrl the OWNER_URL value
	 */
	public void setOwnerUrl (java.lang.String ownerUrl) {
		this.ownerUrl = ownerUrl;
	}



	/**
	 * Return the value associated with the column: OWNER_ID
	 */
	public java.lang.Long getOwnerId () {
		return ownerId;
	}

	/**
	 * Set the value related to the column: OWNER_ID
	 * @param ownerId the OWNER_ID value
	 */
	public void setOwnerId (java.lang.Long ownerId) {
		this.ownerId = ownerId;
	}



	/**
	 * Return the value associated with the column: OWNER_CTG
	 */
	public java.lang.String getOwnerCtg () {
		return ownerCtg;
	}

	/**
	 * Set the value related to the column: OWNER_CTG
	 * @param ownerCtg the OWNER_CTG value
	 */
	public void setOwnerCtg (java.lang.String ownerCtg) {
		this.ownerCtg = ownerCtg;
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
	 * Return the value associated with the column: IS_FREE
	 */
	public java.lang.Boolean getFree () {
		return free;
	}

	/**
	 * Set the value related to the column: IS_FREE
	 * @param free the IS_FREE value
	 */
	public void setFree (java.lang.Boolean free) {
		this.free = free;
	}



	/**
	 * Return the value associated with the column: IS_LOST
	 */
	public java.lang.Boolean getLost () {
		return lost;
	}

	/**
	 * Set the value related to the column: IS_LOST
	 * @param lost the IS_LOST value
	 */
	public void setLost (java.lang.Boolean lost) {
		this.lost = lost;
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
		if (!(obj instanceof com.jeecms.core.entity.Attachment)) return false;
		else {
			com.jeecms.core.entity.Attachment attachment = (com.jeecms.core.entity.Attachment) obj;
			if (null == this.getId() || null == attachment.getId()) return false;
			else return (this.getId().equals(attachment.getId()));
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

	public java.lang.Boolean getPicture() {
		return picture;
	}

	public void setPicture(java.lang.Boolean picture) {
		this.picture = picture;
	}


}