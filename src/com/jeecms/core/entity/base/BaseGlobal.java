package com.jeecms.core.entity.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the CORE_GLOBAL table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="CORE_GLOBAL"
 */

public abstract class BaseGlobal  implements Serializable {

	private static final long serialVersionUID = 7818795608437827810L;
	public static String REF = "Global";
	public static String PROP_CONTEXT_PATH = "contextPath";
	public static String PROP_PORT = "port";
	public static String PROP_ID = "id";


	// constructors
	public BaseGlobal () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseGlobal (java.lang.Long id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseGlobal (
		java.lang.Long id,
		java.lang.String contextPath,
		java.lang.Integer port) {

		this.setId(id);
		this.setContextPath(contextPath);
		this.setPort(port);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Long id;

	// fields
	private java.lang.String contextPath;
	private java.lang.Integer port;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="GLOBAL_ID"
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
	 * Return the value associated with the column: CONTEXT_PATH
	 */
	public java.lang.String getContextPath () {
		return contextPath;
	}

	/**
	 * Set the value related to the column: CONTEXT_PATH
	 * @param contextPath the CONTEXT_PATH value
	 */
	public void setContextPath (java.lang.String contextPath) {
		this.contextPath = contextPath;
	}



	/**
	 * Return the value associated with the column: PORT
	 */
	public java.lang.Integer getPort () {
		return port;
	}

	/**
	 * Set the value related to the column: PORT
	 * @param port the PORT value
	 */
	public void setPort (java.lang.Integer port) {
		this.port = port;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.jeecms.core.entity.Global)) return false;
		else {
			com.jeecms.core.entity.Global global = (com.jeecms.core.entity.Global) obj;
			if (null == this.getId() || null == global.getId()) return false;
			else return (this.getId().equals(global.getId()));
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