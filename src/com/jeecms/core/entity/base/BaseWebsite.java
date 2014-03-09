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

public abstract class BaseWebsite  implements Serializable {

	private static final long serialVersionUID = -373778035242064981L;
	public static String REF = "Website";
	public static String PROP_RGT = "rgt";
	public static String PROP_CREATE_TIME = "createTime";
	public static String PROP_USER_ID = "userId";
	public static String PROP_PHONE_CODE = "phoneCode";
	public static String PROP_CLOSE = "close";
	public static String PROP_CURRENT_SYSTEM = "currentSystem";
	public static String PROP_SUFFIX = "suffix";
	public static String PROP_CHARSET = "charset";
	public static String PROP_SUBJECT = "subject";
	public static String PROP_DOMAIN_ALIAS = "domainAlias";
	public static String PROP_NAME = "name";
	public static String PROP_CONTENT = "content";
	public static String PROP_USER_NAME = "userName";
	public static String PROP_MOBILE_CODE = "mobileCode";
	public static String PROP_GLOBAL = "global";
	public static String PROP_ACCOUNT = "account";
	public static String PROP_FRONT_IPS = "frontIps";
	public static String PROP_DOMAIN = "domain";
	public static String PROP_USER_PWD = "userPwd";
	public static String PROP_HOSTNAME = "hostname";
	public static String PROP_OWNER_NAME = "ownerName";
	public static String PROP_RES_PATH = "resPath";
	public static String PROP_COOKIE_KEY = "cookieKey";
	public static String PROP_BASE_DOMAIN = "baseDomain";
	public static String PROP_ADMIN_IPS = "adminIps";
	public static String PROP_RES_DOMAIN = "resDomain";
	public static String PROP_CLOSE_REASON = "closeReason";
	public static String PROP_COPYRIGHT = "copyright";
	public static String PROP_RECORD_CODE = "recordCode";
	public static String PROP_EMAIL = "email";
	public static String PROP_OWNER_IDENTITY = "ownerIdentity";
	public static String PROP_SHORT_NAME = "shortName";
	public static String PROP_LFT = "lft";
	public static String PROP_RESERVED_WORDS = "reservedWords";
	public static String PROP_PARENT = "parent";
	public static String PROP_COMPANY = "company";
	public static String PROP_ID = "id";
	public static String PROP_NAME_MIN_LEN = "nameMinLen";


	// constructors
	public BaseWebsite () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseWebsite (java.lang.Long id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseWebsite (
		java.lang.Long id,
		com.jeecms.core.entity.Global global,
		java.lang.String domain,
		java.lang.String resPath,
		java.lang.Integer lft,
		java.lang.Integer rgt,
		java.lang.String name,
		java.util.Date createTime,
		java.lang.Boolean close) {

		this.setId(id);
		this.setGlobal(global);
		this.setDomain(domain);
		this.setResPath(resPath);
		this.setLft(lft);
		this.setRgt(rgt);
		this.setName(name);
		this.setCreateTime(createTime);
		this.setClose(close);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Long id;

	// fields
	private java.lang.String domain;
	private java.lang.String resPath;
	private java.lang.Integer lft;
	private java.lang.Integer rgt;
	private java.lang.String resDomain;
	private java.lang.String baseDomain;
	private java.lang.String domainAlias;
	private java.lang.String name;
	private java.lang.String shortName;
	private java.lang.String suffix;
	private java.lang.String currentSystem;
	private java.lang.String cookieKey;
	private java.lang.String ownerName;
	private java.lang.String ownerIdentity;
	private java.lang.String company;
	private java.lang.String copyright;
	private java.lang.String recordCode;
	private java.lang.String email;
	private java.lang.String phoneCode;
	private java.lang.String mobileCode;
	private java.util.Date createTime;
	private java.lang.String closeReason;
	private java.lang.Boolean close;

	// components
	 com.jeecms.core.entity.EmailSender m_emailSender;
	 com.jeecms.core.entity.Control m_control;

	// many to one
	private com.jeecms.core.entity.Website parent;
	private com.jeecms.core.entity.Global global;

	// collections
	private java.util.Set<com.jeecms.core.entity.Website> child;
	private java.util.Map<java.lang.String, java.lang.String> solutions;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="WEBSITE_ID"
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
	 * Return the value associated with the column: DOMAIN
	 */
	public java.lang.String getDomain () {
		return domain;
	}

	/**
	 * Set the value related to the column: DOMAIN
	 * @param domain the DOMAIN value
	 */
	public void setDomain (java.lang.String domain) {
		this.domain = domain;
	}



	/**
	 * Return the value associated with the column: RES_PATH
	 */
	public java.lang.String getResPath () {
		return resPath;
	}

	/**
	 * Set the value related to the column: RES_PATH
	 * @param resPath the RES_PATH value
	 */
	public void setResPath (java.lang.String resPath) {
		this.resPath = resPath;
	}



	/**
	 * Return the value associated with the column: LFT
	 */
	public java.lang.Integer getLft () {
		return lft;
	}

	/**
	 * Set the value related to the column: LFT
	 * @param lft the LFT value
	 */
	public void setLft (java.lang.Integer lft) {
		this.lft = lft;
	}



	/**
	 * Return the value associated with the column: RGT
	 */
	public java.lang.Integer getRgt () {
		return rgt;
	}

	/**
	 * Set the value related to the column: RGT
	 * @param rgt the RGT value
	 */
	public void setRgt (java.lang.Integer rgt) {
		this.rgt = rgt;
	}



	/**
	 * Return the value associated with the column: RES_DOMAIN
	 */
	public java.lang.String getResDomain () {
		return resDomain;
	}

	/**
	 * Set the value related to the column: RES_DOMAIN
	 * @param resDomain the RES_DOMAIN value
	 */
	public void setResDomain (java.lang.String resDomain) {
		this.resDomain = resDomain;
	}



	/**
	 * Return the value associated with the column: BASE_DOMAIN
	 */
	public java.lang.String getBaseDomain () {
		return baseDomain;
	}

	/**
	 * Set the value related to the column: BASE_DOMAIN
	 * @param baseDomain the BASE_DOMAIN value
	 */
	public void setBaseDomain (java.lang.String baseDomain) {
		this.baseDomain = baseDomain;
	}



	/**
	 * Return the value associated with the column: DOMAIN_ALIAS
	 */
	public java.lang.String getDomainAlias () {
		return domainAlias;
	}

	/**
	 * Set the value related to the column: DOMAIN_ALIAS
	 * @param domainAlias the DOMAIN_ALIAS value
	 */
	public void setDomainAlias (java.lang.String domainAlias) {
		this.domainAlias = domainAlias;
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
	 * Return the value associated with the column: SUFFIX
	 */
	public java.lang.String getSuffix () {
		return suffix;
	}

	/**
	 * Set the value related to the column: SUFFIX
	 * @param suffix the SUFFIX value
	 */
	public void setSuffix (java.lang.String suffix) {
		this.suffix = suffix;
	}



	/**
	 * Return the value associated with the column: CURRENT_SYSTEM
	 */
	public java.lang.String getCurrentSystem () {
		return currentSystem;
	}

	/**
	 * Set the value related to the column: CURRENT_SYSTEM
	 * @param currentSystem the CURRENT_SYSTEM value
	 */
	public void setCurrentSystem (java.lang.String currentSystem) {
		this.currentSystem = currentSystem;
	}



	/**
	 * Return the value associated with the column: COOKIE_KEY
	 */
	public java.lang.String getCookieKey () {
		return cookieKey;
	}

	/**
	 * Set the value related to the column: COOKIE_KEY
	 * @param cookieKey the COOKIE_KEY value
	 */
	public void setCookieKey (java.lang.String cookieKey) {
		this.cookieKey = cookieKey;
	}



	/**
	 * Return the value associated with the column: OWNER_NAME
	 */
	public java.lang.String getOwnerName () {
		return ownerName;
	}

	/**
	 * Set the value related to the column: OWNER_NAME
	 * @param ownerName the OWNER_NAME value
	 */
	public void setOwnerName (java.lang.String ownerName) {
		this.ownerName = ownerName;
	}



	/**
	 * Return the value associated with the column: OWNER_IDENTITY
	 */
	public java.lang.String getOwnerIdentity () {
		return ownerIdentity;
	}

	/**
	 * Set the value related to the column: OWNER_IDENTITY
	 * @param ownerIdentity the OWNER_IDENTITY value
	 */
	public void setOwnerIdentity (java.lang.String ownerIdentity) {
		this.ownerIdentity = ownerIdentity;
	}



	/**
	 * Return the value associated with the column: COMPANY
	 */
	public java.lang.String getCompany () {
		return company;
	}

	/**
	 * Set the value related to the column: COMPANY
	 * @param company the COMPANY value
	 */
	public void setCompany (java.lang.String company) {
		this.company = company;
	}



	/**
	 * Return the value associated with the column: COPYRIGHT
	 */
	public java.lang.String getCopyright () {
		return copyright;
	}

	/**
	 * Set the value related to the column: COPYRIGHT
	 * @param copyright the COPYRIGHT value
	 */
	public void setCopyright (java.lang.String copyright) {
		this.copyright = copyright;
	}



	/**
	 * Return the value associated with the column: RECORD_CODE
	 */
	public java.lang.String getRecordCode () {
		return recordCode;
	}

	/**
	 * Set the value related to the column: RECORD_CODE
	 * @param recordCode the RECORD_CODE value
	 */
	public void setRecordCode (java.lang.String recordCode) {
		this.recordCode = recordCode;
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
	 * Return the value associated with the column: PHONE_CODE
	 */
	public java.lang.String getPhoneCode () {
		return phoneCode;
	}

	/**
	 * Set the value related to the column: PHONE_CODE
	 * @param phoneCode the PHONE_CODE value
	 */
	public void setPhoneCode (java.lang.String phoneCode) {
		this.phoneCode = phoneCode;
	}



	/**
	 * Return the value associated with the column: MOBILE_CODE
	 */
	public java.lang.String getMobileCode () {
		return mobileCode;
	}

	/**
	 * Set the value related to the column: MOBILE_CODE
	 * @param mobileCode the MOBILE_CODE value
	 */
	public void setMobileCode (java.lang.String mobileCode) {
		this.mobileCode = mobileCode;
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
	 * Return the value associated with the column: CLOSE_REASON
	 */
	public java.lang.String getCloseReason () {
		return closeReason;
	}

	/**
	 * Set the value related to the column: CLOSE_REASON
	 * @param closeReason the CLOSE_REASON value
	 */
	public void setCloseReason (java.lang.String closeReason) {
		this.closeReason = closeReason;
	}



	/**
	 * Return the value associated with the column: IS_CLOSE
	 */
	public java.lang.Boolean getClose () {
		return close;
	}

	/**
	 * Set the value related to the column: IS_CLOSE
	 * @param close the IS_CLOSE value
	 */
	public void setClose (java.lang.Boolean close) {
		this.close = close;
	}



	public com.jeecms.core.entity.EmailSender getEmailSender () {
		return m_emailSender;
	}

	/**
	 * Set the value related to the column: ${prop.Column}
	 * @param m_emailSender the ${prop.Column} value
	 */
	public void setEmailSender (com.jeecms.core.entity.EmailSender m_emailSender) {
		this.m_emailSender = m_emailSender;
	}



	public com.jeecms.core.entity.Control getControl () {
		return m_control;
	}

	/**
	 * Set the value related to the column: ${prop.Column}
	 * @param m_control the ${prop.Column} value
	 */
	public void setControl (com.jeecms.core.entity.Control m_control) {
		this.m_control = m_control;
	}



	/**
	 * Return the value associated with the column: PARENT
	 */
	public com.jeecms.core.entity.Website getParent () {
		return parent;
	}

	/**
	 * Set the value related to the column: PARENT
	 * @param parent the PARENT value
	 */
	public void setParent (com.jeecms.core.entity.Website parent) {
		this.parent = parent;
	}



	/**
	 * Return the value associated with the column: GLOBAL_ID
	 */
	public com.jeecms.core.entity.Global getGlobal () {
		return global;
	}

	/**
	 * Set the value related to the column: GLOBAL_ID
	 * @param global the GLOBAL_ID value
	 */
	public void setGlobal (com.jeecms.core.entity.Global global) {
		this.global = global;
	}



	/**
	 * Return the value associated with the column: child
	 */
	public java.util.Set<com.jeecms.core.entity.Website> getChild () {
		return child;
	}

	/**
	 * Set the value related to the column: child
	 * @param child the child value
	 */
	public void setChild (java.util.Set<com.jeecms.core.entity.Website> child) {
		this.child = child;
	}



	/**
	 * Return the value associated with the column: solutions
	 */
	public java.util.Map<java.lang.String, java.lang.String> getSolutions () {
		return solutions;
	}

	/**
	 * Set the value related to the column: solutions
	 * @param solutions the solutions value
	 */
	public void setSolutions (java.util.Map<java.lang.String, java.lang.String> solutions) {
		this.solutions = solutions;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.jeecms.core.entity.Website)) return false;
		else {
			com.jeecms.core.entity.Website website = (com.jeecms.core.entity.Website) obj;
			if (null == this.getId() || null == website.getId()) return false;
			else return (this.getId().equals(website.getId()));
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