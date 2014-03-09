package com.jeecms.cms.entity.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the CMS_CONTENT_CTG table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="CMS_CONTENT_CTG"
 */

public abstract class BaseContentCtg  implements Serializable {

	private static final long serialVersionUID = -4444193145622443842L;
	public static String REF = "ContentCtg";
	public static String PROP_IMG_HEIGHT = "imgHeight";
	public static String PROP_IMG_WIDTH = "imgWidth";
	public static String PROP_WEBSITE = "website";
	public static String PROP_DISABLED = "disabled";
	public static String PROP_NAME = "name";
	public static String PROP_LABEL = "label";
	public static String PROP_ID = "id";
	public static String PROP_HAS_TITLEIMG = "hasTitleimg";


	// constructors
	public BaseContentCtg () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseContentCtg (java.lang.Long id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseContentCtg (
		java.lang.Long id,
		com.jeecms.core.entity.Website website,
		java.lang.String label,
		java.lang.Boolean hasTitleimg,
		java.lang.Boolean disabled) {

		this.setId(id);
		this.setWebsite(website);
		this.setLabel(label);
		this.setHasTitleimg(hasTitleimg);
		this.setDisabled(disabled);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Long id;

	// fields
	private java.lang.String label;
	private java.lang.String name;
	private java.lang.Integer imgWidth;
	private java.lang.Integer imgHeight;
	private java.lang.Boolean hasTitleimg;
	private java.lang.Boolean disabled;

	// many to one
	private com.jeecms.core.entity.Website website;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="CTTCTG_ID"
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
	 * Return the value associated with the column: LABEL
	 */
	public java.lang.String getLabel () {
		return label;
	}

	/**
	 * Set the value related to the column: LABEL
	 * @param label the LABEL value
	 */
	public void setLabel (java.lang.String label) {
		this.label = label;
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
	 * Return the value associated with the column: IMG_WIDTH
	 */
	public java.lang.Integer getImgWidth () {
		return imgWidth;
	}

	/**
	 * Set the value related to the column: IMG_WIDTH
	 * @param imgWidth the IMG_WIDTH value
	 */
	public void setImgWidth (java.lang.Integer imgWidth) {
		this.imgWidth = imgWidth;
	}



	/**
	 * Return the value associated with the column: IMG_HEIGHT
	 */
	public java.lang.Integer getImgHeight () {
		return imgHeight;
	}

	/**
	 * Set the value related to the column: IMG_HEIGHT
	 * @param imgHeight the IMG_HEIGHT value
	 */
	public void setImgHeight (java.lang.Integer imgHeight) {
		this.imgHeight = imgHeight;
	}



	/**
	 * Return the value associated with the column: HAS_TITLEIMG
	 */
	public java.lang.Boolean getHasTitleimg () {
		return hasTitleimg;
	}

	/**
	 * Set the value related to the column: HAS_TITLEIMG
	 * @param hasTitleimg the HAS_TITLEIMG value
	 */
	public void setHasTitleimg (java.lang.Boolean hasTitleimg) {
		this.hasTitleimg = hasTitleimg;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.jeecms.cms.entity.ContentCtg)) return false;
		else {
			com.jeecms.cms.entity.ContentCtg contentCtg = (com.jeecms.cms.entity.ContentCtg) obj;
			if (null == this.getId() || null == contentCtg.getId()) return false;
			else return (this.getId().equals(contentCtg.getId()));
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