package com.jeecms.cms.entity.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the CMS_CHNL_MODEL table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="CMS_CHNL_MODEL"
 */

public abstract class BaseChnlModel  implements Serializable {

	private static final long serialVersionUID = 8650872875499669170L;
	public static String REF = "ChnlModel";
	public static String PROP_TPL_PREFIX_CHANNEL = "tplPrefixChannel";
	public static String PROP_HAS_CHILD = "hasChild";
	public static String PROP_WEBSITE = "website";
	public static String PROP_SHORT_NAME = "shortName";
	public static String PROP_DISPLAY = "display";
	public static String PROP_PRIORITY = "priority";
	public static String PROP_TPL_PREFIX_CONTENT = "tplPrefixContent";
	public static String PROP_SYS_TYPE = "sysType";
	public static String PROP_NAME = "name";
	public static String PROP_ID = "id";


	// constructors
	public BaseChnlModel () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseChnlModel (java.lang.Long id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseChnlModel (
		java.lang.Long id,
		com.jeecms.core.entity.Website website,
		java.lang.Integer priority,
		java.lang.Boolean display,
		java.lang.Boolean hasChild) {

		this.setId(id);
		this.setWebsite(website);
		this.setPriority(priority);
		this.setDisplay(display);
		this.setHasChild(hasChild);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Long id;

	// fields
	private java.lang.String sysType;
	private java.lang.String name;
	private java.lang.String shortName;
	private java.lang.String tplPrefixChannel;
	private java.lang.String tplPrefixContent;
	private java.lang.Integer priority;
	private java.lang.Boolean display;
	private java.lang.Boolean hasChild;

	// many to one
	private com.jeecms.core.entity.Website website;

	// collections
	private java.util.Set<com.jeecms.cms.entity.ChnlModelItem> items;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="MODEL_ID"
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
	 * Return the value associated with the column: SYS_TYPE
	 */
	public java.lang.String getSysType () {
		return sysType;
	}

	/**
	 * Set the value related to the column: SYS_TYPE
	 * @param sysType the SYS_TYPE value
	 */
	public void setSysType (java.lang.String sysType) {
		this.sysType = sysType;
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
	 * Return the value associated with the column: SHORT_NAME
	 */
	public java.lang.String getShortName () {
		return shortName;
	}

	/**
	 * Set the value related to the column: SHORT_NAME
	 * @param shortName the SHORT_NAME value
	 */
	public void setShortName (java.lang.String shortName) {
		this.shortName = shortName;
	}



	/**
	 * Return the value associated with the column: TPL_PREFIX_CHANNEL
	 */
	public java.lang.String getTplPrefixChannel () {
		return tplPrefixChannel;
	}

	/**
	 * Set the value related to the column: TPL_PREFIX_CHANNEL
	 * @param tplPrefixChannel the TPL_PREFIX_CHANNEL value
	 */
	public void setTplPrefixChannel (java.lang.String tplPrefixChannel) {
		this.tplPrefixChannel = tplPrefixChannel;
	}



	/**
	 * Return the value associated with the column: TPL_PREFIX_CONTENT
	 */
	public java.lang.String getTplPrefixContent () {
		return tplPrefixContent;
	}

	/**
	 * Set the value related to the column: TPL_PREFIX_CONTENT
	 * @param tplPrefixContent the TPL_PREFIX_CONTENT value
	 */
	public void setTplPrefixContent (java.lang.String tplPrefixContent) {
		this.tplPrefixContent = tplPrefixContent;
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
	 * Return the value associated with the column: IS_DISPLAY
	 */
	public java.lang.Boolean getDisplay () {
		return display;
	}

	/**
	 * Set the value related to the column: IS_DISPLAY
	 * @param display the IS_DISPLAY value
	 */
	public void setDisplay (java.lang.Boolean display) {
		this.display = display;
	}



	/**
	 * Return the value associated with the column: HAS_CHILD
	 */
	public java.lang.Boolean getHasChild () {
		return hasChild;
	}

	/**
	 * Set the value related to the column: HAS_CHILD
	 * @param hasChild the HAS_CHILD value
	 */
	public void setHasChild (java.lang.Boolean hasChild) {
		this.hasChild = hasChild;
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
	 * Return the value associated with the column: items
	 */
	public java.util.Set<com.jeecms.cms.entity.ChnlModelItem> getItems () {
		return items;
	}

	/**
	 * Set the value related to the column: items
	 * @param items the items value
	 */
	public void setItems (java.util.Set<com.jeecms.cms.entity.ChnlModelItem> items) {
		this.items = items;
	}

	public void addToitems (com.jeecms.cms.entity.ChnlModelItem chnlModelItem) {
		if (null == getItems()) setItems(new java.util.TreeSet<com.jeecms.cms.entity.ChnlModelItem>());
		getItems().add(chnlModelItem);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.jeecms.cms.entity.ChnlModel)) return false;
		else {
			com.jeecms.cms.entity.ChnlModel chnlModel = (com.jeecms.cms.entity.ChnlModel) obj;
			if (null == this.getId() || null == chnlModel.getId()) return false;
			else return (this.getId().equals(chnlModel.getId()));
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