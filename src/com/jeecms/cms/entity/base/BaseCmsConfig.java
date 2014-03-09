package com.jeecms.cms.entity.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the CMS_CONFIG table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="CMS_CONFIG"
 */

public abstract class BaseCmsConfig  implements Serializable {

	private static final long serialVersionUID = -2918468399408518626L;
	public static String REF = "CmsConfig";
	public static String PROP_CHECK_COUNT = "checkCount";
	public static String PROP_WEBSITE = "website";
	public static String PROP_COMMENT_NEED_CHECK = "commentNeedCheck";
	public static String PROP_REGISTER_RULE = "registerRule";
	public static String PROP_DEF_DOWNLOAD_MODEL = "defDownloadModel";
	public static String PROP_AUTO_REGISTER = "autoRegister";
	public static String PROP_DEFAULT_SYSTEM = "defaultSystem";
	public static String PROP_REGISTER_STATUS = "registerStatus";
	public static String PROP_COMMENT_NEED_LOGIN = "commentNeedLogin";
	public static String PROP_CACHE_CHANNEL = "cacheChannel";
	public static String PROP_MEMBER_GROUP = "memberGroup";
	public static String PROP_COMMENT_SORT = "commentSort";
	public static String PROP_COMMENT_MAX_LENGTH = "commentMaxLength";
	public static String PROP_CACHE_HOMEPAGE = "cacheHomepage";
	public static String PROP_ID = "id";
	public static String PROP_DEF_ARTICLE_MODEL = "defArticleModel";


	// constructors
	public BaseCmsConfig () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseCmsConfig (java.lang.Long id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseCmsConfig (
		java.lang.Long id,
		java.lang.Integer checkCount,
		java.lang.String defaultSystem,
		java.lang.Boolean commentNeedCheck,
		java.lang.Boolean commentNeedLogin,
		java.lang.Boolean commentSort,
		java.lang.Integer commentMaxLength,
		java.lang.Boolean cacheHomepage,
		java.lang.Boolean cacheChannel) {

		this.setId(id);
		this.setCheckCount(checkCount);
		this.setDefaultSystem(defaultSystem);
		this.setCommentNeedCheck(commentNeedCheck);
		this.setCommentNeedLogin(commentNeedLogin);
		this.setCommentSort(commentSort);
		this.setCommentMaxLength(commentMaxLength);
		this.setCacheHomepage(cacheHomepage);
		this.setCacheChannel(cacheChannel);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Long id;

	// fields
	private java.lang.Integer checkCount;
	private java.lang.String defaultSystem;
	private java.lang.Boolean commentNeedCheck;
	private java.lang.Boolean commentNeedLogin;
	private java.lang.Boolean commentSort;
	private java.lang.Integer commentMaxLength;
	private java.lang.Integer registerStatus;
	private java.lang.Boolean autoRegister;
	private java.lang.String registerRule;
	private java.lang.Boolean cacheHomepage;
	private java.lang.Boolean cacheChannel;

	// one to one
	private com.jeecms.core.entity.Website website;

	// many to one
	private com.jeecms.cms.entity.ChnlModel defArticleModel;
	private com.jeecms.cms.entity.ChnlModel defDownloadModel;
	private com.jeecms.cms.entity.CmsMemberGroup memberGroup;



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
	 * Return the value associated with the column: CHECK_COUNT
	 */
	public java.lang.Integer getCheckCount () {
		return checkCount;
	}

	/**
	 * Set the value related to the column: CHECK_COUNT
	 * @param checkCount the CHECK_COUNT value
	 */
	public void setCheckCount (java.lang.Integer checkCount) {
		this.checkCount = checkCount;
	}



	/**
	 * Return the value associated with the column: DEFAULT_SYSTEM
	 */
	public java.lang.String getDefaultSystem () {
		return defaultSystem;
	}

	/**
	 * Set the value related to the column: DEFAULT_SYSTEM
	 * @param defaultSystem the DEFAULT_SYSTEM value
	 */
	public void setDefaultSystem (java.lang.String defaultSystem) {
		this.defaultSystem = defaultSystem;
	}



	/**
	 * Return the value associated with the column: COMMENT_NEED_CHECK
	 */
	public java.lang.Boolean getCommentNeedCheck () {
		return commentNeedCheck;
	}

	/**
	 * Set the value related to the column: COMMENT_NEED_CHECK
	 * @param commentNeedCheck the COMMENT_NEED_CHECK value
	 */
	public void setCommentNeedCheck (java.lang.Boolean commentNeedCheck) {
		this.commentNeedCheck = commentNeedCheck;
	}



	/**
	 * Return the value associated with the column: COMMENT_NEED_LOGIN
	 */
	public java.lang.Boolean getCommentNeedLogin () {
		return commentNeedLogin;
	}

	/**
	 * Set the value related to the column: COMMENT_NEED_LOGIN
	 * @param commentNeedLogin the COMMENT_NEED_LOGIN value
	 */
	public void setCommentNeedLogin (java.lang.Boolean commentNeedLogin) {
		this.commentNeedLogin = commentNeedLogin;
	}



	/**
	 * Return the value associated with the column: COMMENT_SORT
	 */
	public java.lang.Boolean getCommentSort () {
		return commentSort;
	}

	/**
	 * Set the value related to the column: COMMENT_SORT
	 * @param commentSort the COMMENT_SORT value
	 */
	public void setCommentSort (java.lang.Boolean commentSort) {
		this.commentSort = commentSort;
	}



	/**
	 * Return the value associated with the column: COMMENT_MAX_LENGTH
	 */
	public java.lang.Integer getCommentMaxLength () {
		return commentMaxLength;
	}

	/**
	 * Set the value related to the column: COMMENT_MAX_LENGTH
	 * @param commentMaxLength the COMMENT_MAX_LENGTH value
	 */
	public void setCommentMaxLength (java.lang.Integer commentMaxLength) {
		this.commentMaxLength = commentMaxLength;
	}



	/**
	 * Return the value associated with the column: REGISTER_STATUS
	 */
	public java.lang.Integer getRegisterStatus () {
		return registerStatus;
	}

	/**
	 * Set the value related to the column: REGISTER_STATUS
	 * @param registerStatus the REGISTER_STATUS value
	 */
	public void setRegisterStatus (java.lang.Integer registerStatus) {
		this.registerStatus = registerStatus;
	}



	/**
	 * Return the value associated with the column: AUTO_REGISTER
	 */
	public java.lang.Boolean getAutoRegister () {
		return autoRegister;
	}

	/**
	 * Set the value related to the column: AUTO_REGISTER
	 * @param autoRegister the AUTO_REGISTER value
	 */
	public void setAutoRegister (java.lang.Boolean autoRegister) {
		this.autoRegister = autoRegister;
	}



	/**
	 * Return the value associated with the column: REGISTER_RULE
	 */
	public java.lang.String getRegisterRule () {
		return registerRule;
	}

	/**
	 * Set the value related to the column: REGISTER_RULE
	 * @param registerRule the REGISTER_RULE value
	 */
	public void setRegisterRule (java.lang.String registerRule) {
		this.registerRule = registerRule;
	}



	/**
	 * Return the value associated with the column: IS_CACHE_HOMEPAGE
	 */
	public java.lang.Boolean getCacheHomepage () {
		return cacheHomepage;
	}

	/**
	 * Set the value related to the column: IS_CACHE_HOMEPAGE
	 * @param cacheHomepage the IS_CACHE_HOMEPAGE value
	 */
	public void setCacheHomepage (java.lang.Boolean cacheHomepage) {
		this.cacheHomepage = cacheHomepage;
	}



	/**
	 * Return the value associated with the column: IS_CACHE_CHANNEL
	 */
	public java.lang.Boolean getCacheChannel () {
		return cacheChannel;
	}

	/**
	 * Set the value related to the column: IS_CACHE_CHANNEL
	 * @param cacheChannel the IS_CACHE_CHANNEL value
	 */
	public void setCacheChannel (java.lang.Boolean cacheChannel) {
		this.cacheChannel = cacheChannel;
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



	/**
	 * Return the value associated with the column: DEF_ARTICLE_MODEL
	 */
	public com.jeecms.cms.entity.ChnlModel getDefArticleModel () {
		return defArticleModel;
	}

	/**
	 * Set the value related to the column: DEF_ARTICLE_MODEL
	 * @param defArticleModel the DEF_ARTICLE_MODEL value
	 */
	public void setDefArticleModel (com.jeecms.cms.entity.ChnlModel defArticleModel) {
		this.defArticleModel = defArticleModel;
	}



	/**
	 * Return the value associated with the column: DEF_DOWNLOAD_MODEL
	 */
	public com.jeecms.cms.entity.ChnlModel getDefDownloadModel () {
		return defDownloadModel;
	}

	/**
	 * Set the value related to the column: DEF_DOWNLOAD_MODEL
	 * @param defDownloadModel the DEF_DOWNLOAD_MODEL value
	 */
	public void setDefDownloadModel (com.jeecms.cms.entity.ChnlModel defDownloadModel) {
		this.defDownloadModel = defDownloadModel;
	}



	/**
	 * Return the value associated with the column: REGISTER_GROUP
	 */
	public com.jeecms.cms.entity.CmsMemberGroup getMemberGroup () {
		return memberGroup;
	}

	/**
	 * Set the value related to the column: REGISTER_GROUP
	 * @param memberGroup the REGISTER_GROUP value
	 */
	public void setMemberGroup (com.jeecms.cms.entity.CmsMemberGroup memberGroup) {
		this.memberGroup = memberGroup;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.jeecms.cms.entity.CmsConfig)) return false;
		else {
			com.jeecms.cms.entity.CmsConfig cmsConfig = (com.jeecms.cms.entity.CmsConfig) obj;
			if (null == this.getId() || null == cmsConfig.getId()) return false;
			else return (this.getId().equals(cmsConfig.getId()));
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