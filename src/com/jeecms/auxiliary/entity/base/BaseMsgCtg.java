package com.jeecms.auxiliary.entity.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the AUXI_MSG_CTG table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="AUXI_MSG_CTG"
 */

public abstract class BaseMsgCtg  implements Serializable {

	private static final long serialVersionUID = -4040958180592200616L;
	public static String REF = "MsgCtg";
	public static String PROP_DESCRIPTION = "description";
	public static String PROP_WEBSITE = "website";
	public static String PROP_NAME = "name";
	public static String PROP_ID = "id";


	// constructors
	public BaseMsgCtg () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMsgCtg (java.lang.Long id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseMsgCtg (
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
	private java.lang.String description;

	// many to one
	private com.jeecms.core.entity.Website website;

	// collections
	private java.util.Set<com.jeecms.auxiliary.entity.Msg> msgs;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="MSGCTG_ID"
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
	 * Return the value associated with the column: msgs
	 */
	public java.util.Set<com.jeecms.auxiliary.entity.Msg> getMsgs () {
		return msgs;
	}

	/**
	 * Set the value related to the column: msgs
	 * @param msgs the msgs value
	 */
	public void setMsgs (java.util.Set<com.jeecms.auxiliary.entity.Msg> msgs) {
		this.msgs = msgs;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.jeecms.auxiliary.entity.MsgCtg)) return false;
		else {
			com.jeecms.auxiliary.entity.MsgCtg msgCtg = (com.jeecms.auxiliary.entity.MsgCtg) obj;
			if (null == this.getId() || null == msgCtg.getId()) return false;
			else return (this.getId().equals(msgCtg.getId()));
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