package com.jeecms.core.entity.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the CORE_ADMIN table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="CORE_ADMIN"
 */

public abstract class BaseAdmin  implements Serializable {

	private static final long serialVersionUID = 4774846147660179274L;
	public static String REF = "Admin";
	public static String PROP_WEBSITE = "website";
	public static String PROP_CREATE_TIME = "createTime";
	public static String PROP_DISABLED = "disabled";
	public static String PROP_USER = "user";
	public static String PROP_ID = "id";


	// constructors
	public BaseAdmin () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseAdmin (java.lang.Long id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseAdmin (
		java.lang.Long id,
		com.jeecms.core.entity.Website website,
		com.jeecms.core.entity.User user,
		java.util.Date createTime,
		java.lang.Boolean disabled) {

		this.setId(id);
		this.setWebsite(website);
		this.setUser(user);
		this.setCreateTime(createTime);
		this.setDisabled(disabled);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Long id;

	// fields
	private java.util.Date createTime;
	private java.lang.Boolean disabled;

	// many to one
	private com.jeecms.core.entity.Website website;
	private com.jeecms.core.entity.User user;

	// collections
	private java.util.Set<com.jeecms.core.entity.Role> roles;
	private java.util.Set<com.jeecms.core.entity.Function> functions;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="ADMIN_ID"
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
		if (!(obj instanceof com.jeecms.core.entity.Admin)) return false;
		else {
			com.jeecms.core.entity.Admin admin = (com.jeecms.core.entity.Admin) obj;
			if (null == this.getId() || null == admin.getId()) return false;
			else return (this.getId().equals(admin.getId()));
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