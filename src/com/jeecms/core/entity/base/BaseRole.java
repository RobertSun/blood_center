package com.jeecms.core.entity.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the CORE_ROLE table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="CORE_ROLE"
 */

public abstract class BaseRole  implements Serializable {

	private static final long serialVersionUID = 3105573602801737909L;
	public static String REF = "Role";
	public static String PROP_DESCRIPTION = "description";
	public static String PROP_NAME = "name";
	public static String PROP_ID = "id";


	// constructors
	public BaseRole () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseRole (java.lang.Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Long id;

	// fields
	private java.lang.String name;
	private java.lang.String description;

	// collections
	private java.util.Set<com.jeecms.core.entity.Admin> admins;
	private java.util.Set<com.jeecms.core.entity.Function> functions;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="ROLE_ID"
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
	 * Return the value associated with the column: admins
	 */
	public java.util.Set<com.jeecms.core.entity.Admin> getAdmins () {
		return admins;
	}

	/**
	 * Set the value related to the column: admins
	 * @param admins the admins value
	 */
	public void setAdmins (java.util.Set<com.jeecms.core.entity.Admin> admins) {
		this.admins = admins;
	}

	public void addToadmins (com.jeecms.core.entity.Admin admin) {
		if (null == getAdmins()) setAdmins(new java.util.TreeSet<com.jeecms.core.entity.Admin>());
		getAdmins().add(admin);
	}



	/**
	 * Return the value associated with the column: functions
	 */
	public java.util.Set<com.jeecms.core.entity.Function> getFunctions () {
		return functions;
	}

	/**
	 * Set the value related to the column: functions
	 * @param functions the functions value
	 */
	public void setFunctions (java.util.Set<com.jeecms.core.entity.Function> functions) {
		this.functions = functions;
	}

	public void addTofunctions (com.jeecms.core.entity.Function function) {
		if (null == getFunctions()) setFunctions(new java.util.TreeSet<com.jeecms.core.entity.Function>());
		getFunctions().add(function);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.jeecms.core.entity.Role)) return false;
		else {
			com.jeecms.core.entity.Role role = (com.jeecms.core.entity.Role) obj;
			if (null == this.getId() || null == role.getId()) return false;
			else return (this.getId().equals(role.getId()));
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