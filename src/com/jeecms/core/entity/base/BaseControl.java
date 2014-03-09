package com.jeecms.core.entity.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the CORE_WEBSITE table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="CORE_WEBSITE"
 */

public abstract class BaseControl  implements Serializable {

	private static final long serialVersionUID = 8165999857237877044L;
	public static String REF = "Control";
	public static String PROP_FRONT_IPS = "frontIps";
	public static String PROP_RESERVED_WORDS = "reservedWords";
	public static String PROP_NAME_MIN_LEN = "nameMinLen";
	public static String PROP_ADMIN_IPS = "adminIps";


	// constructors
	public BaseControl () {
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseControl (
		java.lang.Integer nameMinLen) {

		this.setNameMinLen(nameMinLen);
		initialize();
	}

	protected void initialize () {}



	// fields
	private java.lang.String frontIps;
	private java.lang.String adminIps;
	private java.lang.String reservedWords;
	private java.lang.Integer nameMinLen;






	/**
	 * Return the value associated with the column: CONTROL_FRONT_IPS
	 */
	public java.lang.String getFrontIps () {
		return frontIps;
	}

	/**
	 * Set the value related to the column: CONTROL_FRONT_IPS
	 * @param frontIps the CONTROL_FRONT_IPS value
	 */
	public void setFrontIps (java.lang.String frontIps) {
		this.frontIps = frontIps;
	}



	/**
	 * Return the value associated with the column: CONTROL_ADMIN_IPS
	 */
	public java.lang.String getAdminIps () {
		return adminIps;
	}

	/**
	 * Set the value related to the column: CONTROL_ADMIN_IPS
	 * @param adminIps the CONTROL_ADMIN_IPS value
	 */
	public void setAdminIps (java.lang.String adminIps) {
		this.adminIps = adminIps;
	}



	/**
	 * Return the value associated with the column: CONTROL_RESERVED
	 */
	public java.lang.String getReservedWords () {
		return reservedWords;
	}

	/**
	 * Set the value related to the column: CONTROL_RESERVED
	 * @param reservedWords the CONTROL_RESERVED value
	 */
	public void setReservedWords (java.lang.String reservedWords) {
		this.reservedWords = reservedWords;
	}



	/**
	 * Return the value associated with the column: CONTROL_NAME_MINLEN
	 */
	public java.lang.Integer getNameMinLen () {
		return nameMinLen;
	}

	/**
	 * Set the value related to the column: CONTROL_NAME_MINLEN
	 * @param nameMinLen the CONTROL_NAME_MINLEN value
	 */
	public void setNameMinLen (java.lang.Integer nameMinLen) {
		this.nameMinLen = nameMinLen;
	}







	public String toString () {
		return super.toString();
	}


}