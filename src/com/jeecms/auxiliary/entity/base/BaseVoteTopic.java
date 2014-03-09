package com.jeecms.auxiliary.entity.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the VOTE_TOPIC table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="VOTE_TOPIC"
 */

public abstract class BaseVoteTopic  implements Serializable {

	private static final long serialVersionUID = 8067814865594173135L;
	public static String REF = "VoteTopic";
	public static String PROP_MULTI_SELECT = "multiSelect";
	public static String PROP_RESTRICT_COOKIE = "restrictCookie";
	public static String PROP_WEBSITE = "website";
	public static String PROP_DISABLED = "disabled";
	public static String PROP_RESTRICT_MEMBER = "restrictMember";
	public static String PROP_RESTRICT_IP = "restrictIp";
	public static String PROP_TOTAL_COUNT = "totalCount";
	public static String PROP_CURRENT = "current";
	public static String PROP_REPEATE_HOUR = "repeateHour";
	public static String PROP_END_TIME = "endTime";
	public static String PROP_START_TIME = "startTime";
	public static String PROP_DESCRIPTION = "description";
	public static String PROP_TITLE = "title";
	public static String PROP_ID = "id";


	// constructors
	public BaseVoteTopic () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseVoteTopic (java.lang.Long id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseVoteTopic (
		java.lang.Long id,
		com.jeecms.core.entity.Website website,
		java.lang.Boolean restrictMember,
		java.lang.Boolean restrictIp,
		java.lang.Boolean restrictCookie,
		java.lang.Boolean disabled,
		java.lang.Boolean current) {

		this.setId(id);
		this.setWebsite(website);
		this.setRestrictMember(restrictMember);
		this.setRestrictIp(restrictIp);
		this.setRestrictCookie(restrictCookie);
		this.setDisabled(disabled);
		this.setCurrent(current);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Long id;

	// fields
	private java.lang.String title;
	private java.lang.String description;
	private java.lang.Long totalCount;
	private java.util.Date startTime;
	private java.util.Date endTime;
	private java.lang.Integer repeateHour;
	private java.lang.Integer multiSelect;
	private java.lang.Boolean restrictMember;
	private java.lang.Boolean restrictIp;
	private java.lang.Boolean restrictCookie;
	private java.lang.Boolean disabled;
	private java.lang.Boolean current;

	// many to one
	private com.jeecms.core.entity.Website website;

	// collections
	private java.util.Set<com.jeecms.auxiliary.entity.VoteRecord> records;
	private java.util.Set<com.jeecms.auxiliary.entity.VoteItem> items;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="VTOPIC_ID"
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
	 * Return the value associated with the column: TITLE
	 */
	public java.lang.String getTitle () {
		return title;
	}

	/**
	 * Set the value related to the column: TITLE
	 * @param title the TITLE value
	 */
	public void setTitle (java.lang.String title) {
		this.title = title;
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
	 * Return the value associated with the column: TOTAL_COUNT
	 */
	public java.lang.Long getTotalCount () {
		return totalCount;
	}

	/**
	 * Set the value related to the column: TOTAL_COUNT
	 * @param totalCount the TOTAL_COUNT value
	 */
	public void setTotalCount (java.lang.Long totalCount) {
		this.totalCount = totalCount;
	}



	/**
	 * Return the value associated with the column: START_TIME
	 */
	public java.util.Date getStartTime () {
		return startTime;
	}

	/**
	 * Set the value related to the column: START_TIME
	 * @param startTime the START_TIME value
	 */
	public void setStartTime (java.util.Date startTime) {
		this.startTime = startTime;
	}



	/**
	 * Return the value associated with the column: END_TIME
	 */
	public java.util.Date getEndTime () {
		return endTime;
	}

	/**
	 * Set the value related to the column: END_TIME
	 * @param endTime the END_TIME value
	 */
	public void setEndTime (java.util.Date endTime) {
		this.endTime = endTime;
	}



	/**
	 * Return the value associated with the column: REPEATE_HOUR
	 */
	public java.lang.Integer getRepeateHour () {
		return repeateHour;
	}

	/**
	 * Set the value related to the column: REPEATE_HOUR
	 * @param repeateHour the REPEATE_HOUR value
	 */
	public void setRepeateHour (java.lang.Integer repeateHour) {
		this.repeateHour = repeateHour;
	}



	/**
	 * Return the value associated with the column: MULTI_SELECT
	 */
	public java.lang.Integer getMultiSelect () {
		return multiSelect;
	}

	/**
	 * Set the value related to the column: MULTI_SELECT
	 * @param multiSelect the MULTI_SELECT value
	 */
	public void setMultiSelect (java.lang.Integer multiSelect) {
		this.multiSelect = multiSelect;
	}



	/**
	 * Return the value associated with the column: IS_RESTRICT_MEMBER
	 */
	public java.lang.Boolean getRestrictMember () {
		return restrictMember;
	}

	/**
	 * Set the value related to the column: IS_RESTRICT_MEMBER
	 * @param restrictMember the IS_RESTRICT_MEMBER value
	 */
	public void setRestrictMember (java.lang.Boolean restrictMember) {
		this.restrictMember = restrictMember;
	}



	/**
	 * Return the value associated with the column: IS_RESTRICT_IP
	 */
	public java.lang.Boolean getRestrictIp () {
		return restrictIp;
	}

	/**
	 * Set the value related to the column: IS_RESTRICT_IP
	 * @param restrictIp the IS_RESTRICT_IP value
	 */
	public void setRestrictIp (java.lang.Boolean restrictIp) {
		this.restrictIp = restrictIp;
	}



	/**
	 * Return the value associated with the column: IS_RESTRICT_COOKIE
	 */
	public java.lang.Boolean getRestrictCookie () {
		return restrictCookie;
	}

	/**
	 * Set the value related to the column: IS_RESTRICT_COOKIE
	 * @param restrictCookie the IS_RESTRICT_COOKIE value
	 */
	public void setRestrictCookie (java.lang.Boolean restrictCookie) {
		this.restrictCookie = restrictCookie;
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
	 * Return the value associated with the column: IS_CURRENT
	 */
	public java.lang.Boolean getCurrent () {
		return current;
	}

	/**
	 * Set the value related to the column: IS_CURRENT
	 * @param current the IS_CURRENT value
	 */
	public void setCurrent (java.lang.Boolean current) {
		this.current = current;
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
	 * Return the value associated with the column: records
	 */
	public java.util.Set<com.jeecms.auxiliary.entity.VoteRecord> getRecords () {
		return records;
	}

	/**
	 * Set the value related to the column: records
	 * @param records the records value
	 */
	public void setRecords (java.util.Set<com.jeecms.auxiliary.entity.VoteRecord> records) {
		this.records = records;
	}



	/**
	 * Return the value associated with the column: items
	 */
	public java.util.Set<com.jeecms.auxiliary.entity.VoteItem> getItems () {
		return items;
	}

	/**
	 * Set the value related to the column: items
	 * @param items the items value
	 */
	public void setItems (java.util.Set<com.jeecms.auxiliary.entity.VoteItem> items) {
		this.items = items;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.jeecms.auxiliary.entity.VoteTopic)) return false;
		else {
			com.jeecms.auxiliary.entity.VoteTopic voteTopic = (com.jeecms.auxiliary.entity.VoteTopic) obj;
			if (null == this.getId() || null == voteTopic.getId()) return false;
			else return (this.getId().equals(voteTopic.getId()));
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