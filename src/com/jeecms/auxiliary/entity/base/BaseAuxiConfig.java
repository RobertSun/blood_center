package com.jeecms.auxiliary.entity.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the AUXI_CONFIG table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="AUXI_CONFIG"
 */

public abstract class BaseAuxiConfig  implements Serializable {

	private static final long serialVersionUID = 2504164170913402470L;
	public static String REF = "AuxiConfig";
	public static String PROP_MSG_ANONYMITY = "msgAnonymity";
	public static String PROP_MSG_NEED_CHECK = "msgNeedCheck";
	public static String PROP_MSG_MAX_SIZE = "msgMaxSize";
	public static String PROP_MSG_IS_OPEN = "msgIsOpen";
	public static String PROP_WEBSITE = "website";
	public static String PROP_ID = "id";


	// constructors
	public BaseAuxiConfig () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseAuxiConfig (java.lang.Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Long id;

	// fields
	private java.lang.Boolean msgNeedCheck;
	private java.lang.Boolean msgIsOpen;
	private java.lang.String msgAnonymity;
	private java.lang.Integer msgMaxSize;

	// one to one
	private com.jeecms.core.entity.Website website;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="foreign"
     *  column="CONFIG_ID"
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
	 * Return the value associated with the column: MSG_NEED_CHECK
	 */
	public java.lang.Boolean getMsgNeedCheck () {
		return msgNeedCheck;
	}

	/**
	 * Set the value related to the column: MSG_NEED_CHECK
	 * @param msgNeedCheck the MSG_NEED_CHECK value
	 */
	public void setMsgNeedCheck (java.lang.Boolean msgNeedCheck) {
		this.msgNeedCheck = msgNeedCheck;
	}



	/**
	 * Return the value associated with the column: MSG_IS_OPEN
	 */
	public java.lang.Boolean getMsgIsOpen () {
		return msgIsOpen;
	}

	/**
	 * Set the value related to the column: MSG_IS_OPEN
	 * @param msgIsOpen the MSG_IS_OPEN value
	 */
	public void setMsgIsOpen (java.lang.Boolean msgIsOpen) {
		this.msgIsOpen = msgIsOpen;
	}



	/**
	 * Return the value associated with the column: MSG_ANONYMITY
	 */
	public java.lang.String getMsgAnonymity () {
		return msgAnonymity;
	}

	/**
	 * Set the value related to the column: MSG_ANONYMITY
	 * @param msgAnonymity the MSG_ANONYMITY value
	 */
	public void setMsgAnonymity (java.lang.String msgAnonymity) {
		this.msgAnonymity = msgAnonymity;
	}



	/**
	 * Return the value associated with the column: MSG_MAX_SIZE
	 */
	public java.lang.Integer getMsgMaxSize () {
		return msgMaxSize;
	}

	/**
	 * Set the value related to the column: MSG_MAX_SIZE
	 * @param msgMaxSize the MSG_MAX_SIZE value
	 */
	public void setMsgMaxSize (java.lang.Integer msgMaxSize) {
		this.msgMaxSize = msgMaxSize;
	}



	/**
	 * Return the value associated with the column: website
	 */
	public com.jeecms.core.entity.Website getWebsite () {
		return website;
	}

	/**
	 * Set the value related to the column: website
	 * @param website the website value
	 */
	public void setWebsite (com.jeecms.core.entity.Website website) {
		this.website = website;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.jeecms.auxiliary.entity.AuxiConfig)) return false;
		else {
			com.jeecms.auxiliary.entity.AuxiConfig auxiConfig = (com.jeecms.auxiliary.entity.AuxiConfig) obj;
			if (null == this.getId() || null == auxiConfig.getId()) return false;
			else return (this.getId().equals(auxiConfig.getId()));
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