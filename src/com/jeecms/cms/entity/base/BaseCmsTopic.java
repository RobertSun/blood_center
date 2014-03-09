package com.jeecms.cms.entity.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the CMS_TOPIC table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="CMS_TOPIC"
 */

public abstract class BaseCmsTopic  implements Serializable {

	private static final long serialVersionUID = 6448455159189806991L;
	public static String REF = "CmsTopic";
	public static String PROP_DESCRIPTION = "description";
	public static String PROP_WEBSITE = "website";
	public static String PROP_TPL_CHANNEL = "tplChannel";
	public static String PROP_TITLE_IMG = "titleImg";
	public static String PROP_KEYWORDS = "keywords";
	public static String PROP_PRIORITY = "priority";
	public static String PROP_NAME = "name";
	public static String PROP_ID = "id";


	// constructors
	public BaseCmsTopic () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseCmsTopic (java.lang.Long id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseCmsTopic (
		java.lang.Long id,
		com.jeecms.core.entity.Website website,
		java.lang.String name,
		java.lang.Integer priority) {

		this.setId(id);
		this.setWebsite(website);
		this.setName(name);
		this.setPriority(priority);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Long id;

	// fields
	private java.lang.String name;
	private java.lang.String keywords;
	private java.lang.String description;
	private java.lang.String titleImg;
	private java.lang.String tplChannel;
	private java.lang.Integer priority;

	// many to one
	private com.jeecms.core.entity.Website website;

	// collections
	private java.util.Set<com.jeecms.article.entity.Article> articles;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="TOPIC_ID"
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
	 * Return the value associated with the column: KEYWORDS
	 */
	public java.lang.String getKeywords () {
		return keywords;
	}

	/**
	 * Set the value related to the column: KEYWORDS
	 * @param keywords the KEYWORDS value
	 */
	public void setKeywords (java.lang.String keywords) {
		this.keywords = keywords;
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
	 * Return the value associated with the column: TITLE_IMG
	 */
	public java.lang.String getTitleImg () {
		return titleImg;
	}

	/**
	 * Set the value related to the column: TITLE_IMG
	 * @param titleImg the TITLE_IMG value
	 */
	public void setTitleImg (java.lang.String titleImg) {
		this.titleImg = titleImg;
	}


	/**
	 * Return the value associated with the column: TPL_CHANNEL
	 */
	public java.lang.String getTplChannel () {
		return tplChannel;
	}

	/**
	 * Set the value related to the column: TPL_CHANNEL
	 * @param tplChannel the TPL_CHANNEL value
	 */
	public void setTplChannel (java.lang.String tplChannel) {
		this.tplChannel = tplChannel;
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
	 * Return the value associated with the column: articles
	 */
	public java.util.Set<com.jeecms.article.entity.Article> getArticles () {
		return articles;
	}

	/**
	 * Set the value related to the column: articles
	 * @param articles the articles value
	 */
	public void setArticles (java.util.Set<com.jeecms.article.entity.Article> articles) {
		this.articles = articles;
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.jeecms.cms.entity.CmsTopic)) return false;
		else {
			com.jeecms.cms.entity.CmsTopic cmsTopic = (com.jeecms.cms.entity.CmsTopic) obj;
			if (null == this.getId() || null == cmsTopic.getId()) return false;
			else return (this.getId().equals(cmsTopic.getId()));
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