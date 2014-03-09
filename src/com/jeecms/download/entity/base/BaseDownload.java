package com.jeecms.download.entity.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the DOWN_DOWNLOAD table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="DOWN_DOWNLOAD"
 */

public abstract class BaseDownload  implements Serializable {

	private static final long serialVersionUID = -5509087840467267474L;
	public static String REF = "Download";
	public static String PROP_ADMIN_DISABLE = "adminDisable";
	public static String PROP_CHECK = "check";
	public static String PROP_DEF_STR9 = "defStr9";
	public static String PROP_HOMEPAGE = "homepage";
	public static String PROP_DEF_MONEY2 = "defMoney2";
	public static String PROP_DOWN_COUNT = "downCount";
	public static String PROP_VISIT_WEEK = "visitWeek";
	public static String PROP_DISABLED = "disabled";
	public static String PROP_TAGS = "tags";
	public static String PROP_TITLE_COLOR = "titleColor";
	public static String PROP_CONTENT_RES_PATH = "contentResPath";
	public static String PROP_VISIT_TOTAL = "visitTotal";
	public static String PROP_GROUP = "group";
	public static String PROP_DEF_LONG4 = "defLong4";
	public static String PROP_DOWN_TYPE = "downType";
	public static String PROP_CONTENT_CTG = "contentCtg";
	public static String PROP_RELEASE_SYS_DATE = "releaseSysDate";
	public static String PROP_CHANNEL = "channel";
	public static String PROP_CONTENT = "content";
	public static String PROP_HAS_TITLEIMG = "hasTitleimg";
	public static String PROP_PARAM1 = "param1";
	public static String PROP_DEF_STR5 = "defStr5";
	public static String PROP_DEF_STR2 = "defStr2";
	public static String PROP_VISIT_YEAR = "visitYear";
	public static String PROP_DEF_BOOL1 = "defBool1";
	public static String PROP_VISIT_MONTH = "visitMonth";
	public static String PROP_CHECK_OPINION = "checkOpinion";
	public static String PROP_SHORT_TITLE = "shortTitle";
	public static String PROP_TOP_LEVEL = "topLevel";
	public static String PROP_CONTACT = "contact";
	public static String PROP_DEF_DATE2 = "defDate2";
	public static String PROP_RELEASE_DATE = "releaseDate";
	public static String PROP_EVALUATION = "evaluation";
	public static String PROP_TITLE = "title";
	public static String PROP_DEF_STR6 = "defStr6";
	public static String PROP_PARAM2 = "param2";
	public static String PROP_DEF_DATE3 = "defDate3";
	public static String PROP_DEF_STR1 = "defStr1";
	public static String PROP_DEF_STR4 = "defStr4";
	public static String PROP_DISABLE_TIME = "disableTime";
	public static String PROP_ADMIN_CHECK = "adminCheck";
	public static String PROP_FILE_TYPE = "fileType";
	public static String PROP_AUTHOR = "author";
	public static String PROP_ATTACHMENT = "attachment";
	public static String PROP_VISIT_QUARTER = "visitQuarter";
	public static String PROP_DRAFT = "draft";
	public static String PROP_DEF_MONEY3 = "defMoney3";
	public static String PROP_STAT_DATE = "statDate";
	public static String PROP_VIEW_TOTAL = "viewTotal";
	public static String PROP_DESCRIPTION = "description";
	public static String PROP_PARAM3 = "param3";
	public static String PROP_DEF_BOOL3 = "defBool3";
	public static String PROP_DEF_STR3 = "defStr3";
	public static String PROP_CHECK_TIME = "checkTime";
	public static String PROP_FILE_SIZE = "fileSize";
	public static String PROP_DEF_LONG5 = "defLong5";
	public static String PROP_RECOMMEND = "recommend";
	public static String PROP_DEF_BOOL2 = "defBool2";
	public static String PROP_COMMENT_COUNT = "commentCount";
	public static String PROP_DEF_LONG2 = "defLong2";
	public static String PROP_WEBSITE = "website";
	public static String PROP_VISIT_TODAY = "visitToday";
	public static String PROP_ADMIN_INPUT = "adminInput";
	public static String PROP_DEF_DATE1 = "defDate1";
	public static String PROP_DEF_STR8 = "defStr8";
	public static String PROP_DEF_MONEY1 = "defMoney1";
	public static String PROP_TPL_CONTENT = "tplContent";
	public static String PROP_DEMO_URL = "demoUrl";
	public static String PROP_OUTER_URL = "outerUrl";
	public static String PROP_DEF_LONG1 = "defLong1";
	public static String PROP_DEF_STR7 = "defStr7";
	public static String PROP_TITLE_IMG = "titleImg";
	public static String PROP_BOLD = "bold";
	public static String PROP_CHECK_STEP = "checkStep";
	public static String PROP_MEMBER = "member";
	public static String PROP_DEF_LONG3 = "defLong3";
	public static String PROP_ENVIRONMENT = "environment";
	public static String PROP_ID = "id";
	public static String PROP_REJECT = "reject";


	// constructors
	public BaseDownload () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseDownload (java.lang.Long id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseDownload (
		java.lang.Long id,
		com.jeecms.core.entity.Website website,
		com.jeecms.cms.entity.CmsChannel channel,
		java.lang.Long viewTotal,
		java.lang.Long visitTotal,
		java.lang.Long visitToday,
		java.lang.Long visitWeek,
		java.lang.Long visitMonth,
		java.lang.Long visitQuarter,
		java.lang.Long visitYear,
		java.lang.Integer commentCount,
		java.lang.Boolean hasTitleimg,
		java.lang.Boolean bold,
		java.lang.Boolean draft,
		java.lang.Boolean recommend,
		java.lang.Boolean check,
		java.lang.Boolean reject,
		java.lang.Boolean disabled) {

		this.setId(id);
		this.setWebsite(website);
		this.setChannel(channel);
		this.setViewTotal(viewTotal);
		this.setVisitTotal(visitTotal);
		this.setVisitToday(visitToday);
		this.setVisitWeek(visitWeek);
		this.setVisitMonth(visitMonth);
		this.setVisitQuarter(visitQuarter);
		this.setVisitYear(visitYear);
		this.setCommentCount(commentCount);
		this.setHasTitleimg(hasTitleimg);
		this.setBold(bold);
		this.setDraft(draft);
		this.setRecommend(recommend);
		this.setCheck(check);
		this.setReject(reject);
		this.setDisabled(disabled);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Long id;

	// fields
	private java.lang.String title;
	private java.lang.String shortTitle;
	private java.lang.String titleColor;
	private java.lang.String titleImg;
	private java.lang.String description;
	private java.lang.String tags;
	private java.lang.String author;
	private java.util.Date releaseDate;
	private java.util.Date releaseSysDate;
	private java.util.Date checkTime;
	private java.util.Date disableTime;
	private java.lang.Long viewTotal;
	private java.lang.Long visitTotal;
	private java.lang.Long visitToday;
	private java.lang.Long visitWeek;
	private java.lang.Long visitMonth;
	private java.lang.Long visitQuarter;
	private java.lang.Long visitYear;
	private java.util.Date statDate;
	private java.lang.String outerUrl;
	private java.lang.String contentResPath;
	private java.lang.String tplContent;
	private java.lang.Integer checkStep;
	private java.lang.Integer topLevel;
	private java.lang.String checkOpinion;
	private java.lang.String homepage;
	private java.lang.String demoUrl;
	private java.lang.String contact;
	private java.lang.String environment;
	private java.lang.Integer evaluation;
	private java.lang.String fileType;
	private java.lang.Long fileSize;
	private java.lang.Long downCount;
	private java.lang.Integer commentCount;
	private java.lang.String content;
	private java.lang.Boolean hasTitleimg;
	private java.lang.Boolean bold;
	private java.lang.Boolean draft;
	private java.lang.Boolean recommend;
	private java.lang.Boolean check;
	private java.lang.Boolean reject;
	private java.lang.Boolean disabled;
	private java.lang.String param1;
	private java.lang.String param2;
	private java.lang.String param3;
	private java.lang.String defStr1;
	private java.lang.String defStr2;
	private java.lang.String defStr3;
	private java.lang.String defStr4;
	private java.lang.String defStr5;
	private java.lang.String defStr6;
	private java.lang.String defStr7;
	private java.lang.String defStr8;
	private java.lang.String defStr9;
	private java.lang.Long defLong1;
	private java.lang.Long defLong2;
	private java.lang.Long defLong3;
	private java.lang.Long defLong4;
	private java.lang.Long defLong5;
	private java.math.BigDecimal defMoney1;
	private java.math.BigDecimal defMoney2;
	private java.math.BigDecimal defMoney3;
	private java.util.Date defDate1;
	private java.util.Date defDate2;
	private java.util.Date defDate3;
	private java.lang.Boolean defBool1;
	private java.lang.Boolean defBool2;
	private java.lang.Boolean defBool3;

	// many to one
	private com.jeecms.core.entity.Attachment attachment;
	private com.jeecms.core.entity.Website website;
	private com.jeecms.cms.entity.CmsMember member;
	private com.jeecms.cms.entity.CmsMemberGroup group;
	private com.jeecms.cms.entity.CmsChannel channel;
	private com.jeecms.cms.entity.ContentCtg contentCtg;
	private com.jeecms.download.entity.DownType downType;
	private com.jeecms.core.entity.Admin adminInput;
	private com.jeecms.core.entity.Admin adminCheck;
	private com.jeecms.core.entity.Admin adminDisable;

	// collections
	private java.util.Set<com.jeecms.core.entity.Attachment> coreAttachments;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="DOWNLOAD_ID"
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
	 * Return the value associated with the column: SHORT_TITLE
	 */
	public java.lang.String getShortTitle () {
		return shortTitle;
	}

	/**
	 * Set the value related to the column: SHORT_TITLE
	 * @param shortTitle the SHORT_TITLE value
	 */
	public void setShortTitle (java.lang.String shortTitle) {
		this.shortTitle = shortTitle;
	}


	/**
	 * Return the value associated with the column: TITLE_COLOR
	 */
	public java.lang.String getTitleColor () {
		return titleColor;
	}

	/**
	 * Set the value related to the column: TITLE_COLOR
	 * @param titleColor the TITLE_COLOR value
	 */
	public void setTitleColor (java.lang.String titleColor) {
		this.titleColor = titleColor;
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
	 * Return the value associated with the column: TAGS
	 */
	public java.lang.String getTags () {
		return tags;
	}

	/**
	 * Set the value related to the column: TAGS
	 * @param tags the TAGS value
	 */
	public void setTags (java.lang.String tags) {
		this.tags = tags;
	}


	/**
	 * Return the value associated with the column: AUTHOR
	 */
	public java.lang.String getAuthor () {
		return author;
	}

	/**
	 * Set the value related to the column: AUTHOR
	 * @param author the AUTHOR value
	 */
	public void setAuthor (java.lang.String author) {
		this.author = author;
	}


	/**
	 * Return the value associated with the column: RELEASE_DATE
	 */
	public java.util.Date getReleaseDate () {
		return releaseDate;
	}

	/**
	 * Set the value related to the column: RELEASE_DATE
	 * @param releaseDate the RELEASE_DATE value
	 */
	public void setReleaseDate (java.util.Date releaseDate) {
		this.releaseDate = releaseDate;
	}


	/**
	 * Return the value associated with the column: RELEASE_SYS_DATE
	 */
	public java.util.Date getReleaseSysDate () {
		return releaseSysDate;
	}

	/**
	 * Set the value related to the column: RELEASE_SYS_DATE
	 * @param releaseSysDate the RELEASE_SYS_DATE value
	 */
	public void setReleaseSysDate (java.util.Date releaseSysDate) {
		this.releaseSysDate = releaseSysDate;
	}


	/**
	 * Return the value associated with the column: CHECK_TIME
	 */
	public java.util.Date getCheckTime () {
		return checkTime;
	}

	/**
	 * Set the value related to the column: CHECK_TIME
	 * @param checkTime the CHECK_TIME value
	 */
	public void setCheckTime (java.util.Date checkTime) {
		this.checkTime = checkTime;
	}


	/**
	 * Return the value associated with the column: DISABLE_TIME
	 */
	public java.util.Date getDisableTime () {
		return disableTime;
	}

	/**
	 * Set the value related to the column: DISABLE_TIME
	 * @param disableTime the DISABLE_TIME value
	 */
	public void setDisableTime (java.util.Date disableTime) {
		this.disableTime = disableTime;
	}


	/**
	 * Return the value associated with the column: VIEW_TOTAL
	 */
	public java.lang.Long getViewTotal () {
		return viewTotal;
	}

	/**
	 * Set the value related to the column: VIEW_TOTAL
	 * @param viewTotal the VIEW_TOTAL value
	 */
	public void setViewTotal (java.lang.Long viewTotal) {
		this.viewTotal = viewTotal;
	}


	/**
	 * Return the value associated with the column: VISIT_TOTAL
	 */
	public java.lang.Long getVisitTotal () {
		return visitTotal;
	}

	/**
	 * Set the value related to the column: VISIT_TOTAL
	 * @param visitTotal the VISIT_TOTAL value
	 */
	public void setVisitTotal (java.lang.Long visitTotal) {
		this.visitTotal = visitTotal;
	}


	/**
	 * Return the value associated with the column: VISIT_TODAY
	 */
	public java.lang.Long getVisitToday () {
		return visitToday;
	}

	/**
	 * Set the value related to the column: VISIT_TODAY
	 * @param visitToday the VISIT_TODAY value
	 */
	public void setVisitToday (java.lang.Long visitToday) {
		this.visitToday = visitToday;
	}


	/**
	 * Return the value associated with the column: VISIT_WEEK
	 */
	public java.lang.Long getVisitWeek () {
		return visitWeek;
	}

	/**
	 * Set the value related to the column: VISIT_WEEK
	 * @param visitWeek the VISIT_WEEK value
	 */
	public void setVisitWeek (java.lang.Long visitWeek) {
		this.visitWeek = visitWeek;
	}


	/**
	 * Return the value associated with the column: VISIT_MONTH
	 */
	public java.lang.Long getVisitMonth () {
		return visitMonth;
	}

	/**
	 * Set the value related to the column: VISIT_MONTH
	 * @param visitMonth the VISIT_MONTH value
	 */
	public void setVisitMonth (java.lang.Long visitMonth) {
		this.visitMonth = visitMonth;
	}


	/**
	 * Return the value associated with the column: VISIT_QUARTER
	 */
	public java.lang.Long getVisitQuarter () {
		return visitQuarter;
	}

	/**
	 * Set the value related to the column: VISIT_QUARTER
	 * @param visitQuarter the VISIT_QUARTER value
	 */
	public void setVisitQuarter (java.lang.Long visitQuarter) {
		this.visitQuarter = visitQuarter;
	}


	/**
	 * Return the value associated with the column: VISIT_YEAR
	 */
	public java.lang.Long getVisitYear () {
		return visitYear;
	}

	/**
	 * Set the value related to the column: VISIT_YEAR
	 * @param visitYear the VISIT_YEAR value
	 */
	public void setVisitYear (java.lang.Long visitYear) {
		this.visitYear = visitYear;
	}


	/**
	 * Return the value associated with the column: STAT_DATE
	 */
	public java.util.Date getStatDate () {
		return statDate;
	}

	/**
	 * Set the value related to the column: STAT_DATE
	 * @param statDate the STAT_DATE value
	 */
	public void setStatDate (java.util.Date statDate) {
		this.statDate = statDate;
	}


	/**
	 * Return the value associated with the column: OUTER_URL
	 */
	public java.lang.String getOuterUrl () {
		return outerUrl;
	}

	/**
	 * Set the value related to the column: OUTER_URL
	 * @param outerUrl the OUTER_URL value
	 */
	public void setOuterUrl (java.lang.String outerUrl) {
		this.outerUrl = outerUrl;
	}


	/**
	 * Return the value associated with the column: CONTENT_RES_PATH
	 */
	public java.lang.String getContentResPath () {
		return contentResPath;
	}

	/**
	 * Set the value related to the column: CONTENT_RES_PATH
	 * @param contentResPath the CONTENT_RES_PATH value
	 */
	public void setContentResPath (java.lang.String contentResPath) {
		this.contentResPath = contentResPath;
	}


	/**
	 * Return the value associated with the column: TPL_CONTENT
	 */
	public java.lang.String getTplContent () {
		return tplContent;
	}

	/**
	 * Set the value related to the column: TPL_CONTENT
	 * @param tplContent the TPL_CONTENT value
	 */
	public void setTplContent (java.lang.String tplContent) {
		this.tplContent = tplContent;
	}


	/**
	 * Return the value associated with the column: CHECK_STEP
	 */
	public java.lang.Integer getCheckStep () {
		return checkStep;
	}

	/**
	 * Set the value related to the column: CHECK_STEP
	 * @param checkStep the CHECK_STEP value
	 */
	public void setCheckStep (java.lang.Integer checkStep) {
		this.checkStep = checkStep;
	}


	/**
	 * Return the value associated with the column: TOP_LEVEL
	 */
	public java.lang.Integer getTopLevel () {
		return topLevel;
	}

	/**
	 * Set the value related to the column: TOP_LEVEL
	 * @param topLevel the TOP_LEVEL value
	 */
	public void setTopLevel (java.lang.Integer topLevel) {
		this.topLevel = topLevel;
	}


	/**
	 * Return the value associated with the column: CHECK_OPINION
	 */
	public java.lang.String getCheckOpinion () {
		return checkOpinion;
	}

	/**
	 * Set the value related to the column: CHECK_OPINION
	 * @param checkOpinion the CHECK_OPINION value
	 */
	public void setCheckOpinion (java.lang.String checkOpinion) {
		this.checkOpinion = checkOpinion;
	}


	/**
	 * Return the value associated with the column: HOMEPAGE
	 */
	public java.lang.String getHomepage () {
		return homepage;
	}

	/**
	 * Set the value related to the column: HOMEPAGE
	 * @param homepage the HOMEPAGE value
	 */
	public void setHomepage (java.lang.String homepage) {
		this.homepage = homepage;
	}


	/**
	 * Return the value associated with the column: DEMO_URL
	 */
	public java.lang.String getDemoUrl () {
		return demoUrl;
	}

	/**
	 * Set the value related to the column: DEMO_URL
	 * @param demoUrl the DEMO_URL value
	 */
	public void setDemoUrl (java.lang.String demoUrl) {
		this.demoUrl = demoUrl;
	}


	/**
	 * Return the value associated with the column: CONTACT
	 */
	public java.lang.String getContact () {
		return contact;
	}

	/**
	 * Set the value related to the column: CONTACT
	 * @param contact the CONTACT value
	 */
	public void setContact (java.lang.String contact) {
		this.contact = contact;
	}


	/**
	 * Return the value associated with the column: ENVIRONMENT
	 */
	public java.lang.String getEnvironment () {
		return environment;
	}

	/**
	 * Set the value related to the column: ENVIRONMENT
	 * @param environment the ENVIRONMENT value
	 */
	public void setEnvironment (java.lang.String environment) {
		this.environment = environment;
	}


	/**
	 * Return the value associated with the column: EVALUATION
	 */
	public java.lang.Integer getEvaluation () {
		return evaluation;
	}

	/**
	 * Set the value related to the column: EVALUATION
	 * @param evaluation the EVALUATION value
	 */
	public void setEvaluation (java.lang.Integer evaluation) {
		this.evaluation = evaluation;
	}


	/**
	 * Return the value associated with the column: FILE_TYPE
	 */
	public java.lang.String getFileType () {
		return fileType;
	}

	/**
	 * Set the value related to the column: FILE_TYPE
	 * @param fileType the FILE_TYPE value
	 */
	public void setFileType (java.lang.String fileType) {
		this.fileType = fileType;
	}


	/**
	 * Return the value associated with the column: FILE_SIZE
	 */
	public java.lang.Long getFileSize () {
		return fileSize;
	}

	/**
	 * Set the value related to the column: FILE_SIZE
	 * @param fileSize the FILE_SIZE value
	 */
	public void setFileSize (java.lang.Long fileSize) {
		this.fileSize = fileSize;
	}


	/**
	 * Return the value associated with the column: DOWN_COUNT
	 */
	public java.lang.Long getDownCount () {
		return downCount;
	}

	/**
	 * Set the value related to the column: DOWN_COUNT
	 * @param downCount the DOWN_COUNT value
	 */
	public void setDownCount (java.lang.Long downCount) {
		this.downCount = downCount;
	}


	/**
	 * Return the value associated with the column: COMMENT_COUNT
	 */
	public java.lang.Integer getCommentCount () {
		return commentCount;
	}

	/**
	 * Set the value related to the column: COMMENT_COUNT
	 * @param commentCount the COMMENT_COUNT value
	 */
	public void setCommentCount (java.lang.Integer commentCount) {
		this.commentCount = commentCount;
	}


	/**
	 * Return the value associated with the column: CONTENT
	 */
	public java.lang.String getContent () {
		return content;
	}

	/**
	 * Set the value related to the column: CONTENT
	 * @param content the CONTENT value
	 */
	public void setContent (java.lang.String content) {
		this.content = content;
	}


	/**
	 * Return the value associated with the column: HAS_TITLEIMG
	 */
	public java.lang.Boolean getHasTitleimg () {
		return hasTitleimg;
	}

	/**
	 * Set the value related to the column: HAS_TITLEIMG
	 * @param hasTitleimg the HAS_TITLEIMG value
	 */
	public void setHasTitleimg (java.lang.Boolean hasTitleimg) {
		this.hasTitleimg = hasTitleimg;
	}


	/**
	 * Return the value associated with the column: IS_BOLD
	 */
	public java.lang.Boolean getBold () {
		return bold;
	}

	/**
	 * Set the value related to the column: IS_BOLD
	 * @param bold the IS_BOLD value
	 */
	public void setBold (java.lang.Boolean bold) {
		this.bold = bold;
	}


	/**
	 * Return the value associated with the column: IS_DRAFT
	 */
	public java.lang.Boolean getDraft () {
		return draft;
	}

	/**
	 * Set the value related to the column: IS_DRAFT
	 * @param draft the IS_DRAFT value
	 */
	public void setDraft (java.lang.Boolean draft) {
		this.draft = draft;
	}


	/**
	 * Return the value associated with the column: IS_RECOMMEND
	 */
	public java.lang.Boolean getRecommend () {
		return recommend;
	}

	/**
	 * Set the value related to the column: IS_RECOMMEND
	 * @param recommend the IS_RECOMMEND value
	 */
	public void setRecommend (java.lang.Boolean recommend) {
		this.recommend = recommend;
	}


	/**
	 * Return the value associated with the column: IS_CHECK
	 */
	public java.lang.Boolean getCheck () {
		return check;
	}

	/**
	 * Set the value related to the column: IS_CHECK
	 * @param check the IS_CHECK value
	 */
	public void setCheck (java.lang.Boolean check) {
		this.check = check;
	}


	/**
	 * Return the value associated with the column: IS_REJECT
	 */
	public java.lang.Boolean getReject () {
		return reject;
	}

	/**
	 * Set the value related to the column: IS_REJECT
	 * @param reject the IS_REJECT value
	 */
	public void setReject (java.lang.Boolean reject) {
		this.reject = reject;
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
	 * Return the value associated with the column: PARAM1
	 */
	public java.lang.String getParam1 () {
		return param1;
	}

	/**
	 * Set the value related to the column: PARAM1
	 * @param param1 the PARAM1 value
	 */
	public void setParam1 (java.lang.String param1) {
		this.param1 = param1;
	}


	/**
	 * Return the value associated with the column: PARAM2
	 */
	public java.lang.String getParam2 () {
		return param2;
	}

	/**
	 * Set the value related to the column: PARAM2
	 * @param param2 the PARAM2 value
	 */
	public void setParam2 (java.lang.String param2) {
		this.param2 = param2;
	}


	/**
	 * Return the value associated with the column: PARAM3
	 */
	public java.lang.String getParam3 () {
		return param3;
	}

	/**
	 * Set the value related to the column: PARAM3
	 * @param param3 the PARAM3 value
	 */
	public void setParam3 (java.lang.String param3) {
		this.param3 = param3;
	}


	/**
	 * Return the value associated with the column: DEF_STRING_1
	 */
	public java.lang.String getDefStr1 () {
		return defStr1;
	}

	/**
	 * Set the value related to the column: DEF_STRING_1
	 * @param defStr1 the DEF_STRING_1 value
	 */
	public void setDefStr1 (java.lang.String defStr1) {
		this.defStr1 = defStr1;
	}


	/**
	 * Return the value associated with the column: DEF_STRING_2
	 */
	public java.lang.String getDefStr2 () {
		return defStr2;
	}

	/**
	 * Set the value related to the column: DEF_STRING_2
	 * @param defStr2 the DEF_STRING_2 value
	 */
	public void setDefStr2 (java.lang.String defStr2) {
		this.defStr2 = defStr2;
	}


	/**
	 * Return the value associated with the column: DEF_STRING_3
	 */
	public java.lang.String getDefStr3 () {
		return defStr3;
	}

	/**
	 * Set the value related to the column: DEF_STRING_3
	 * @param defStr3 the DEF_STRING_3 value
	 */
	public void setDefStr3 (java.lang.String defStr3) {
		this.defStr3 = defStr3;
	}


	/**
	 * Return the value associated with the column: DEF_STRING_4
	 */
	public java.lang.String getDefStr4 () {
		return defStr4;
	}

	/**
	 * Set the value related to the column: DEF_STRING_4
	 * @param defStr4 the DEF_STRING_4 value
	 */
	public void setDefStr4 (java.lang.String defStr4) {
		this.defStr4 = defStr4;
	}


	/**
	 * Return the value associated with the column: DEF_STRING_5
	 */
	public java.lang.String getDefStr5 () {
		return defStr5;
	}

	/**
	 * Set the value related to the column: DEF_STRING_5
	 * @param defStr5 the DEF_STRING_5 value
	 */
	public void setDefStr5 (java.lang.String defStr5) {
		this.defStr5 = defStr5;
	}


	/**
	 * Return the value associated with the column: DEF_STRING_6
	 */
	public java.lang.String getDefStr6 () {
		return defStr6;
	}

	/**
	 * Set the value related to the column: DEF_STRING_6
	 * @param defStr6 the DEF_STRING_6 value
	 */
	public void setDefStr6 (java.lang.String defStr6) {
		this.defStr6 = defStr6;
	}


	/**
	 * Return the value associated with the column: DEF_STRING_7
	 */
	public java.lang.String getDefStr7 () {
		return defStr7;
	}

	/**
	 * Set the value related to the column: DEF_STRING_7
	 * @param defStr7 the DEF_STRING_7 value
	 */
	public void setDefStr7 (java.lang.String defStr7) {
		this.defStr7 = defStr7;
	}


	/**
	 * Return the value associated with the column: DEF_STRING_8
	 */
	public java.lang.String getDefStr8 () {
		return defStr8;
	}

	/**
	 * Set the value related to the column: DEF_STRING_8
	 * @param defStr8 the DEF_STRING_8 value
	 */
	public void setDefStr8 (java.lang.String defStr8) {
		this.defStr8 = defStr8;
	}


	/**
	 * Return the value associated with the column: DEF_STRING_9
	 */
	public java.lang.String getDefStr9 () {
		return defStr9;
	}

	/**
	 * Set the value related to the column: DEF_STRING_9
	 * @param defStr9 the DEF_STRING_9 value
	 */
	public void setDefStr9 (java.lang.String defStr9) {
		this.defStr9 = defStr9;
	}


	/**
	 * Return the value associated with the column: DEF_LONG_1
	 */
	public java.lang.Long getDefLong1 () {
		return defLong1;
	}

	/**
	 * Set the value related to the column: DEF_LONG_1
	 * @param defLong1 the DEF_LONG_1 value
	 */
	public void setDefLong1 (java.lang.Long defLong1) {
		this.defLong1 = defLong1;
	}


	/**
	 * Return the value associated with the column: DEF_LONG_2
	 */
	public java.lang.Long getDefLong2 () {
		return defLong2;
	}

	/**
	 * Set the value related to the column: DEF_LONG_2
	 * @param defLong2 the DEF_LONG_2 value
	 */
	public void setDefLong2 (java.lang.Long defLong2) {
		this.defLong2 = defLong2;
	}


	/**
	 * Return the value associated with the column: DEF_LONG_3
	 */
	public java.lang.Long getDefLong3 () {
		return defLong3;
	}

	/**
	 * Set the value related to the column: DEF_LONG_3
	 * @param defLong3 the DEF_LONG_3 value
	 */
	public void setDefLong3 (java.lang.Long defLong3) {
		this.defLong3 = defLong3;
	}


	/**
	 * Return the value associated with the column: DEF_LONG_4
	 */
	public java.lang.Long getDefLong4 () {
		return defLong4;
	}

	/**
	 * Set the value related to the column: DEF_LONG_4
	 * @param defLong4 the DEF_LONG_4 value
	 */
	public void setDefLong4 (java.lang.Long defLong4) {
		this.defLong4 = defLong4;
	}


	/**
	 * Return the value associated with the column: DEF_LONG_5
	 */
	public java.lang.Long getDefLong5 () {
		return defLong5;
	}

	/**
	 * Set the value related to the column: DEF_LONG_5
	 * @param defLong5 the DEF_LONG_5 value
	 */
	public void setDefLong5 (java.lang.Long defLong5) {
		this.defLong5 = defLong5;
	}


	/**
	 * Return the value associated with the column: DEF_MONEY1
	 */
	public java.math.BigDecimal getDefMoney1 () {
		return defMoney1;
	}

	/**
	 * Set the value related to the column: DEF_MONEY1
	 * @param defMoney1 the DEF_MONEY1 value
	 */
	public void setDefMoney1 (java.math.BigDecimal defMoney1) {
		this.defMoney1 = defMoney1;
	}


	/**
	 * Return the value associated with the column: DEF_MONEY2
	 */
	public java.math.BigDecimal getDefMoney2 () {
		return defMoney2;
	}

	/**
	 * Set the value related to the column: DEF_MONEY2
	 * @param defMoney2 the DEF_MONEY2 value
	 */
	public void setDefMoney2 (java.math.BigDecimal defMoney2) {
		this.defMoney2 = defMoney2;
	}


	/**
	 * Return the value associated with the column: DEF_MONEY3
	 */
	public java.math.BigDecimal getDefMoney3 () {
		return defMoney3;
	}

	/**
	 * Set the value related to the column: DEF_MONEY3
	 * @param defMoney3 the DEF_MONEY3 value
	 */
	public void setDefMoney3 (java.math.BigDecimal defMoney3) {
		this.defMoney3 = defMoney3;
	}


	/**
	 * Return the value associated with the column: DEF_DATE1
	 */
	public java.util.Date getDefDate1 () {
		return defDate1;
	}

	/**
	 * Set the value related to the column: DEF_DATE1
	 * @param defDate1 the DEF_DATE1 value
	 */
	public void setDefDate1 (java.util.Date defDate1) {
		this.defDate1 = defDate1;
	}


	/**
	 * Return the value associated with the column: DEF_DATE2
	 */
	public java.util.Date getDefDate2 () {
		return defDate2;
	}

	/**
	 * Set the value related to the column: DEF_DATE2
	 * @param defDate2 the DEF_DATE2 value
	 */
	public void setDefDate2 (java.util.Date defDate2) {
		this.defDate2 = defDate2;
	}


	/**
	 * Return the value associated with the column: DEF_DATE3
	 */
	public java.util.Date getDefDate3 () {
		return defDate3;
	}

	/**
	 * Set the value related to the column: DEF_DATE3
	 * @param defDate3 the DEF_DATE3 value
	 */
	public void setDefDate3 (java.util.Date defDate3) {
		this.defDate3 = defDate3;
	}


	/**
	 * Return the value associated with the column: DEF_BOOL1
	 */
	public java.lang.Boolean getDefBool1 () {
		return defBool1;
	}

	/**
	 * Set the value related to the column: DEF_BOOL1
	 * @param defBool1 the DEF_BOOL1 value
	 */
	public void setDefBool1 (java.lang.Boolean defBool1) {
		this.defBool1 = defBool1;
	}


	/**
	 * Return the value associated with the column: DEF_BOOL2
	 */
	public java.lang.Boolean getDefBool2 () {
		return defBool2;
	}

	/**
	 * Set the value related to the column: DEF_BOOL2
	 * @param defBool2 the DEF_BOOL2 value
	 */
	public void setDefBool2 (java.lang.Boolean defBool2) {
		this.defBool2 = defBool2;
	}


	/**
	 * Return the value associated with the column: DEF_BOOL3
	 */
	public java.lang.Boolean getDefBool3 () {
		return defBool3;
	}

	/**
	 * Set the value related to the column: DEF_BOOL3
	 * @param defBool3 the DEF_BOOL3 value
	 */
	public void setDefBool3 (java.lang.Boolean defBool3) {
		this.defBool3 = defBool3;
	}


	/**
	 * Return the value associated with the column: ATTACHMENT_ID
	 */
	public com.jeecms.core.entity.Attachment getAttachment () {
		return attachment;
	}

	/**
	 * Set the value related to the column: ATTACHMENT_ID
	 * @param attachment the ATTACHMENT_ID value
	 */
	public void setAttachment (com.jeecms.core.entity.Attachment attachment) {
		this.attachment = attachment;
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
	 * Return the value associated with the column: MEMEBE_ID
	 */
	public com.jeecms.cms.entity.CmsMember getMember () {
		return member;
	}

	/**
	 * Set the value related to the column: MEMEBE_ID
	 * @param member the MEMEBE_ID value
	 */
	public void setMember (com.jeecms.cms.entity.CmsMember member) {
		this.member = member;
	}


	/**
	 * Return the value associated with the column: GROUP_ID
	 */
	public com.jeecms.cms.entity.CmsMemberGroup getGroup () {
		return group;
	}

	/**
	 * Set the value related to the column: GROUP_ID
	 * @param group the GROUP_ID value
	 */
	public void setGroup (com.jeecms.cms.entity.CmsMemberGroup group) {
		this.group = group;
	}


	/**
	 * Return the value associated with the column: CHANNEL_ID
	 */
	public com.jeecms.cms.entity.CmsChannel getChannel () {
		return channel;
	}

	/**
	 * Set the value related to the column: CHANNEL_ID
	 * @param channel the CHANNEL_ID value
	 */
	public void setChannel (com.jeecms.cms.entity.CmsChannel channel) {
		this.channel = channel;
	}


	/**
	 * Return the value associated with the column: CTTCTG_ID
	 */
	public com.jeecms.cms.entity.ContentCtg getContentCtg () {
		return contentCtg;
	}

	/**
	 * Set the value related to the column: CTTCTG_ID
	 * @param contentCtg the CTTCTG_ID value
	 */
	public void setContentCtg (com.jeecms.cms.entity.ContentCtg contentCtg) {
		this.contentCtg = contentCtg;
	}


	/**
	 * Return the value associated with the column: DOWNTYPE_ID
	 */
	public com.jeecms.download.entity.DownType getDownType () {
		return downType;
	}

	/**
	 * Set the value related to the column: DOWNTYPE_ID
	 * @param downType the DOWNTYPE_ID value
	 */
	public void setDownType (com.jeecms.download.entity.DownType downType) {
		this.downType = downType;
	}


	/**
	 * Return the value associated with the column: ADMIN_INPUT
	 */
	public com.jeecms.core.entity.Admin getAdminInput () {
		return adminInput;
	}

	/**
	 * Set the value related to the column: ADMIN_INPUT
	 * @param adminInput the ADMIN_INPUT value
	 */
	public void setAdminInput (com.jeecms.core.entity.Admin adminInput) {
		this.adminInput = adminInput;
	}


	/**
	 * Return the value associated with the column: ADMIN_CHECK
	 */
	public com.jeecms.core.entity.Admin getAdminCheck () {
		return adminCheck;
	}

	/**
	 * Set the value related to the column: ADMIN_CHECK
	 * @param adminCheck the ADMIN_CHECK value
	 */
	public void setAdminCheck (com.jeecms.core.entity.Admin adminCheck) {
		this.adminCheck = adminCheck;
	}


	/**
	 * Return the value associated with the column: ADMIN_DISABLE
	 */
	public com.jeecms.core.entity.Admin getAdminDisable () {
		return adminDisable;
	}

	/**
	 * Set the value related to the column: ADMIN_DISABLE
	 * @param adminDisable the ADMIN_DISABLE value
	 */
	public void setAdminDisable (com.jeecms.core.entity.Admin adminDisable) {
		this.adminDisable = adminDisable;
	}


	/**
	 * Return the value associated with the column: coreAttachments
	 */
	public java.util.Set<com.jeecms.core.entity.Attachment> getCoreAttachments () {
		return coreAttachments;
	}

	/**
	 * Set the value related to the column: coreAttachments
	 * @param coreAttachments the coreAttachments value
	 */
	public void setCoreAttachments (java.util.Set<com.jeecms.core.entity.Attachment> coreAttachments) {
		this.coreAttachments = coreAttachments;
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.jeecms.download.entity.Download)) return false;
		else {
			com.jeecms.download.entity.Download download = (com.jeecms.download.entity.Download) obj;
			if (null == this.getId() || null == download.getId()) return false;
			else return (this.getId().equals(download.getId()));
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