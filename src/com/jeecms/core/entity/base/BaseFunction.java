package com.jeecms.core.entity.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the core_function table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="core_function"
 */

public abstract class BaseFunction  implements Serializable {

	private static final long serialVersionUID = -8356889986443869903L;
	public static String REF = "Function";
	public static String PROP_MENU = "menu";
	public static String PROP_NAME = "name";
	public static String PROP_PARENT = "parent";
	public static String PROP_FUNCS = "funcs";
	public static String PROP_DESCRIPTION = "description";
	public static String PROP_URL = "url";
	public static String PROP_ID = "id";
	public static String PROP_PRIORITY = "priority";


	// constructors
	public BaseFunction () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseFunction (java.lang.Long id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseFunction (
		java.lang.Long id,
		java.lang.Integer priority,
		java.lang.Boolean menu) {

		this.setId(id);
		this.setPriority(priority);
		this.setMenu(menu);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Long id;

	// fields
	private java.lang.String name;
	private java.lang.String url;
	private java.lang.String funcs;
	private java.lang.String description;
	private java.lang.Integer priority;
	private java.lang.Boolean menu;

	// many to one
	private com.jeecms.core.entity.Function parent;

	// collections
	private java.util.Set<com.jeecms.core.entity.Admin> admins;
	private java.util.Set<com.jeecms.core.entity.Role> roles;
	private java.util.Set<com.jeecms.core.entity.Function> child;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="FUNCTION_ID"
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
	 * Return the value associated with the column: URL
	 */
	public java.lang.String getUrl () {
		return url;
	}

	/**
	 * Set the value related to the column: URL
	 * @param url the URL value
	 */
	public void setUrl (java.lang.String url) {
		this.url = url;
	}



	/**
	 * Return the value associated with the column: FUNCS
	 */
	public java.lang.String getFuncs () {
		return funcs;
	}

	/**
	 * Set the value related to the column: FUNCS
	 * @param funcs the FUNCS value
	 */
	public void setFuncs (java.lang.String funcs) {
		this.funcs = funcs;
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
	 * Return the value associated with the column: IS_MENU
	 */
	public java.lang.Boolean getMenu () {
		return menu;
	}

	/**
	 * Set the value related to the column: IS_MENU
	 * @param menu the IS_MENU value
	 */
	public void setMenu (java.lang.Boolean menu) {
		this.menu = menu;
	}



	/**
	 * Return the value associated with the column: PARENT_ID
	 */
	public com.jeecms.core.entity.Function getParent () {
		return parent;
	}

	/**
	 * Set the value related to the column: PARENT_ID
	 * @param parent the PARENT_ID value
	 */
	public void setParent (com.jeecms.core.entity.Function parent) {
		this.parent = parent;
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
	 * Return the value associated with the column: roles
	 */
	public java.util.Set<com.jeecms.core.entity.Role> getRoles () {
		return roles;
	}

	/**
	 * Set the value related to the column: roles
	 * @param roles the roles value
	 */
	public void setRoles (java.util.Set<com.jeecms.core.entity.Role> roles) {
		this.roles = roles;
	}

	public void addToroles (com.jeecms.core.entity.Role role) {
		if (null == getRoles()) setRoles(new java.util.TreeSet<com.jeecms.core.entity.Role>());
		getRoles().add(role);
	}



	/**
	 * Return the value associated with the column: child
	 */
	public java.util.Set<com.jeecms.core.entity.Function> getChild () {
		return child;
	}

	/**
	 * Set the value related to the column: child
	 * @param child the child value
	 */
	public void setChild (java.util.Set<com.jeecms.core.entity.Function> child) {
		this.child = child;
	}

	public void addTochild (com.jeecms.core.entity.Function function) {
		if (null == getChild()) setChild(new java.util.TreeSet<com.jeecms.core.entity.Function>());
		getChild().add(function);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.jeecms.core.entity.Function)) return false;
		else {
			com.jeecms.core.entity.Function function = (com.jeecms.core.entity.Function) obj;
			if (null == this.getId() || null == function.getId()) return false;
			else return (this.getId().equals(function.getId()));
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