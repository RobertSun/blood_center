package com.jeecms.core.entity.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the CORE_USER table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="CORE_USER"
 */

public abstract class BaseUser  implements Serializable {

	private static final long serialVersionUID = -1145073568509246080L;
	public static String REF = "User";
	public static String PROP_LOGIN_COUNT = "loginCount";
	public static String PROP_LAST_LOGIN_IP = "lastLoginIp";
	public static String PROP_LOGIN_NAME = "loginName";
	public static String PROP_BIRTHDAY = "birthday";
	public static String PROP_REAL_NAME = "realName";
	public static String PROP_GENDER = "gender";
	public static String PROP_UNREAD_MSG = "unreadMsg";
	public static String PROP_CREATE_TIME = "createTime";
	public static String PROP_DISABLED = "disabled";
	public static String PROP_LAST_LOGIN_TIME = "lastLoginTime";
	public static String PROP_ZIP = "zip";
	public static String PROP_TEL = "tel";
	public static String PROP_PASSWORD = "password";
	public static String PROP_CURRENT_LOGIN_TIME = "currentLoginTime";
	public static String PROP_EMAIL = "email";
	public static String PROP_FAX = "fax";
	public static String PROP_MOBILE = "mobile";
	public static String PROP_COMEFROM = "comefrom";
	public static String PROP_ADDRESS = "address";
	public static String PROP_CURRENT_LOGIN_IP = "currentLoginIp";
	public static String PROP_ID = "id";

	// ======== **add 2011.11 start =========
	public static String PROP_ID_NO = "idNo";
	// ======== **add 2011.11 end ===========

	// constructors
	public BaseUser () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseUser (java.lang.Long id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseUser (
		java.lang.Long id,
		java.lang.String loginName,
		java.lang.String email,
		java.lang.Integer unreadMsg,
		java.lang.Boolean disabled) {

		this.setId(id);
		this.setLoginName(loginName);
		this.setEmail(email);
		this.setUnreadMsg(unreadMsg);
		this.setDisabled(disabled);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Long id;

	// fields
	private java.lang.String loginName;
	private java.lang.String realName;
	private java.lang.String password;
	private java.lang.String email;
	private java.lang.Integer unreadMsg;
	private java.lang.String fax;
	private java.lang.String tel;
	private java.lang.String mobile;
	private java.lang.String zip;
	private java.lang.String comefrom;
	private java.lang.String address;
	private java.lang.Boolean gender;
	private java.util.Date birthday;
	private java.util.Date createTime;
	private java.util.Date lastLoginTime;
	private java.lang.String lastLoginIp;
	private java.util.Date currentLoginTime;
	private java.lang.String currentLoginIp;
	private java.lang.Long loginCount;
	private java.lang.Boolean disabled;
	// ======== **add 2011.11 start =========
	private java.lang.String idNo;
	// ======== **add 2011.11 end ===========

	public java.lang.String getIdNo() {
		return idNo;
	}

	public void setIdNo(java.lang.String idNo) {
		this.idNo = idNo;
	}
	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="USER_ID"
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
	 * Return the value associated with the column: LOGIN_NAME
	 */
	public java.lang.String getLoginName () {
		return loginName;
	}

	/**
	 * Set the value related to the column: LOGIN_NAME
	 * @param loginName the LOGIN_NAME value
	 */
	public void setLoginName (java.lang.String loginName) {
		this.loginName = loginName;
	}


	/**
	 * Return the value associated with the column: REAL_NAME
	 */
	public java.lang.String getRealName () {
		return realName;
	}

	/**
	 * Set the value related to the column: REAL_NAME
	 * @param realName the REAL_NAME value
	 */
	public void setRealName (java.lang.String realName) {
		this.realName = realName;
	}


	/**
	 * Return the value associated with the column: PASSWORD
	 */
	public java.lang.String getPassword () {
		return password;
	}

	/**
	 * Set the value related to the column: PASSWORD
	 * @param password the PASSWORD value
	 */
	public void setPassword (java.lang.String password) {
		this.password = password;
	}


	/**
	 * Return the value associated with the column: EMAIL
	 */
	public java.lang.String getEmail () {
		return email;
	}

	/**
	 * Set the value related to the column: EMAIL
	 * @param email the EMAIL value
	 */
	public void setEmail (java.lang.String email) {
		this.email = email;
	}


	/**
	 * Return the value associated with the column: UNREAD_MSG
	 */
	public java.lang.Integer getUnreadMsg () {
		return unreadMsg;
	}

	/**
	 * Set the value related to the column: UNREAD_MSG
	 * @param unreadMsg the UNREAD_MSG value
	 */
	public void setUnreadMsg (java.lang.Integer unreadMsg) {
		this.unreadMsg = unreadMsg;
	}


	/**
	 * Return the value associated with the column: FAX
	 */
	public java.lang.String getFax () {
		return fax;
	}

	/**
	 * Set the value related to the column: FAX
	 * @param fax the FAX value
	 */
	public void setFax (java.lang.String fax) {
		this.fax = fax;
	}


	/**
	 * Return the value associated with the column: TEL
	 */
	public java.lang.String getTel () {
		return tel;
	}

	/**
	 * Set the value related to the column: TEL
	 * @param tel the TEL value
	 */
	public void setTel (java.lang.String tel) {
		this.tel = tel;
	}


	/**
	 * Return the value associated with the column: MOBILE
	 */
	public java.lang.String getMobile () {
		return mobile;
	}

	/**
	 * Set the value related to the column: MOBILE
	 * @param mobile the MOBILE value
	 */
	public void setMobile (java.lang.String mobile) {
		this.mobile = mobile;
	}


	/**
	 * Return the value associated with the column: ZIP
	 */
	public java.lang.String getZip () {
		return zip;
	}

	/**
	 * Set the value related to the column: ZIP
	 * @param zip the ZIP value
	 */
	public void setZip (java.lang.String zip) {
		this.zip = zip;
	}


	/**
	 * Return the value associated with the column: COMEFROM
	 */
	public java.lang.String getComefrom () {
		return comefrom;
	}

	/**
	 * Set the value related to the column: COMEFROM
	 * @param comefrom the COMEFROM value
	 */
	public void setComefrom (java.lang.String comefrom) {
		this.comefrom = comefrom;
	}


	/**
	 * Return the value associated with the column: ADDRESS
	 */
	public java.lang.String getAddress () {
		return address;
	}

	/**
	 * Set the value related to the column: ADDRESS
	 * @param address the ADDRESS value
	 */
	public void setAddress (java.lang.String address) {
		this.address = address;
	}


	/**
	 * Return the value associated with the column: GENDER
	 */
	public java.lang.Boolean getGender () {
		return gender;
	}

	/**
	 * Set the value related to the column: GENDER
	 * @param gender the GENDER value
	 */
	public void setGender (java.lang.Boolean gender) {
		this.gender = gender;
	}


	/**
	 * Return the value associated with the column: BIRTHDAY
	 */
	public java.util.Date getBirthday () {
		return birthday;
	}

	/**
	 * Set the value related to the column: BIRTHDAY
	 * @param birthday the BIRTHDAY value
	 */
	public void setBirthday (java.util.Date birthday) {
		this.birthday = birthday;
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
	 * Return the value associated with the column: LAST_LOGIN_TIME
	 */
	public java.util.Date getLastLoginTime () {
		return lastLoginTime;
	}

	/**
	 * Set the value related to the column: LAST_LOGIN_TIME
	 * @param lastLoginTime the LAST_LOGIN_TIME value
	 */
	public void setLastLoginTime (java.util.Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}


	/**
	 * Return the value associated with the column: LAST_LOGIN_IP
	 */
	public java.lang.String getLastLoginIp () {
		return lastLoginIp;
	}

	/**
	 * Set the value related to the column: LAST_LOGIN_IP
	 * @param lastLoginIp the LAST_LOGIN_IP value
	 */
	public void setLastLoginIp (java.lang.String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}


	/**
	 * Return the value associated with the column: CURRENT_LOGIN_TIME
	 */
	public java.util.Date getCurrentLoginTime () {
		return currentLoginTime;
	}

	/**
	 * Set the value related to the column: CURRENT_LOGIN_TIME
	 * @param currentLoginTime the CURRENT_LOGIN_TIME value
	 */
	public void setCurrentLoginTime (java.util.Date currentLoginTime) {
		this.currentLoginTime = currentLoginTime;
	}


	/**
	 * Return the value associated with the column: CURRENT_LOGIN_IP
	 */
	public java.lang.String getCurrentLoginIp () {
		return currentLoginIp;
	}

	/**
	 * Set the value related to the column: CURRENT_LOGIN_IP
	 * @param currentLoginIp the CURRENT_LOGIN_IP value
	 */
	public void setCurrentLoginIp (java.lang.String currentLoginIp) {
		this.currentLoginIp = currentLoginIp;
	}


	/**
	 * Return the value associated with the column: LOGIN_COUNT
	 */
	public java.lang.Long getLoginCount () {
		return loginCount;
	}

	/**
	 * Set the value related to the column: LOGIN_COUNT
	 * @param loginCount the LOGIN_COUNT value
	 */
	public void setLoginCount (java.lang.Long loginCount) {
		this.loginCount = loginCount;
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



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.jeecms.core.entity.User)) return false;
		else {
			com.jeecms.core.entity.User user = (com.jeecms.core.entity.User) obj;
			if (null == this.getId() || null == user.getId()) return false;
			else return (this.getId().equals(user.getId()));
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