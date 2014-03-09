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

public abstract class BaseEmailSender  implements Serializable {

	private static final long serialVersionUID = 5141948913396597441L;
	public static String REF = "EmailSender";
	public static String PROP_ACCOUNT = "account";
	public static String PROP_USER_PWD = "userPwd";
	public static String PROP_CHARSET = "charset";
	public static String PROP_USER_ID = "userId";
	public static String PROP_SUBJECT = "subject";
	public static String PROP_HOSTNAME = "hostname";
	public static String PROP_CONTENT = "content";
	public static String PROP_USER_NAME = "userName";


	// constructors
	public BaseEmailSender () {
		initialize();
	}

	protected void initialize () {}



	// fields
	private java.lang.String charset;
	private java.lang.String hostname;
	private java.lang.String account;
	private java.lang.String userName;
	private java.lang.String userId;
	private java.lang.String userPwd;
	private java.lang.String subject;
	private java.lang.String content;






	/**
	 * Return the value associated with the column: EMAIL_CHARSET
	 */
	public java.lang.String getCharset () {
		return charset;
	}

	/**
	 * Set the value related to the column: EMAIL_CHARSET
	 * @param charset the EMAIL_CHARSET value
	 */
	public void setCharset (java.lang.String charset) {
		this.charset = charset;
	}



	/**
	 * Return the value associated with the column: EMAIL_HOSTNAME
	 */
	public java.lang.String getHostname () {
		return hostname;
	}

	/**
	 * Set the value related to the column: EMAIL_HOSTNAME
	 * @param hostname the EMAIL_HOSTNAME value
	 */
	public void setHostname (java.lang.String hostname) {
		this.hostname = hostname;
	}



	/**
	 * Return the value associated with the column: EMAIL_ACCOUNT
	 */
	public java.lang.String getAccount () {
		return account;
	}

	/**
	 * Set the value related to the column: EMAIL_ACCOUNT
	 * @param account the EMAIL_ACCOUNT value
	 */
	public void setAccount (java.lang.String account) {
		this.account = account;
	}



	/**
	 * Return the value associated with the column: EMAIL_USER_NAME
	 */
	public java.lang.String getUserName () {
		return userName;
	}

	/**
	 * Set the value related to the column: EMAIL_USER_NAME
	 * @param userName the EMAIL_USER_NAME value
	 */
	public void setUserName (java.lang.String userName) {
		this.userName = userName;
	}



	/**
	 * Return the value associated with the column: EMAIL_USER_ID
	 */
	public java.lang.String getUserId () {
		return userId;
	}

	/**
	 * Set the value related to the column: EMAIL_USER_ID
	 * @param userId the EMAIL_USER_ID value
	 */
	public void setUserId (java.lang.String userId) {
		this.userId = userId;
	}



	/**
	 * Return the value associated with the column: EMAIL_USER_PWD
	 */
	public java.lang.String getUserPwd () {
		return userPwd;
	}

	/**
	 * Set the value related to the column: EMAIL_USER_PWD
	 * @param userPwd the EMAIL_USER_PWD value
	 */
	public void setUserPwd (java.lang.String userPwd) {
		this.userPwd = userPwd;
	}



	/**
	 * Return the value associated with the column: EMAIL_SUBJECT
	 */
	public java.lang.String getSubject () {
		return subject;
	}

	/**
	 * Set the value related to the column: EMAIL_SUBJECT
	 * @param subject the EMAIL_SUBJECT value
	 */
	public void setSubject (java.lang.String subject) {
		this.subject = subject;
	}



	/**
	 * Return the value associated with the column: EMAIL_CONTENT
	 */
	public java.lang.String getContent () {
		return content;
	}

	/**
	 * Set the value related to the column: EMAIL_CONTENT
	 * @param content the EMAIL_CONTENT value
	 */
	public void setContent (java.lang.String content) {
		this.content = content;
	}







	public String toString () {
		return super.toString();
	}


}