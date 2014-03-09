package com.jeecms.cms.entity.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the CMS_CHANNEL table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="CMS_CHANNEL"
 */

public abstract class BaseCmsChannel  implements Serializable {

	private static final long serialVersionUID = -1480753821037195906L;
	public static String REF = "CmsChannel";
	public static String PROP_DEF_STR9 = "defStr9";
	public static String PROP_DEF_MONEY2 = "defMoney2";
	public static String PROP_KEYWORDS = "keywords";
	public static String PROP_SYS_TYPE = "sysType";
	public static String PROP_VISIT_TOTAL = "visitTotal";
	public static String PROP_CONFIG = "config";
	public static String PROP_DEF_LONG4 = "defLong4";
	public static String PROP_GROUP_CONTRIBUTE = "groupContribute";
	public static String PROP_CONTENT = "content";
	public static String PROP_PARAM1 = "param1";
	public static String PROP_DEF_STR5 = "defStr5";
	public static String PROP_DEF_STR2 = "defStr2";
	public static String PROP_DEF_BOOL1 = "defBool1";
	public static String PROP_TPL_INDEX = "tplIndex";
	public static String PROP_MODEL = "model";
	public static String PROP_DEF_DATE2 = "defDate2";
	public static String PROP_GROUP_VISIT = "groupVisit";
	public static String PROP_PATH = "path";
	public static String PROP_DISPLAY = "display";
	public static String PROP_TITLE = "title";
	public static String PROP_PARAM2 = "param2";
	public static String PROP_DEF_STR6 = "defStr6";
	public static String PROP_DEF_STR1 = "defStr1";
	public static String PROP_DEF_DATE3 = "defDate3";
	public static String PROP_DEF_STR4 = "defStr4";
	public static String PROP_RGT = "rgt";
	public static String PROP_PRIORITY = "priority";
	public static String PROP_HAS_CHILD = "hasChild";
	public static String PROP_STAT_DATE = "statDate";
	public static String PROP_DEF_MONEY3 = "defMoney3";
	public static String PROP_DESCRIPTION = "description";
	public static String PROP_PARAM3 = "param3";
	public static String PROP_DEF_STR3 = "defStr3";
	public static String PROP_DEF_BOOL3 = "defBool3";
	public static String PROP_NAME = "name";
	public static String PROP_DOC_COUNT = "docCount";
	public static String PROP_DEF_LONG5 = "defLong5";
	public static String PROP_DEF_BOOL2 = "defBool2";
	public static String PROP_DEF_LONG2 = "defLong2";
	public static String PROP_WEBSITE = "website";
	public static String PROP_VISIT_TODAY = "visitToday";
	public static String PROP_DEF_DATE1 = "defDate1";
	public static String PROP_DEF_STR8 = "defStr8";
	public static String PROP_DEF_MONEY1 = "defMoney1";
	public static String PROP_HAS_TITLE_IMG = "hasTitleImg";
	public static String PROP_TPL_CONTENT = "tplContent";
	public static String PROP_OUTER_URL = "outerUrl";
	public static String PROP_DEF_LONG1 = "defLong1";
	public static String PROP_DEF_STR7 = "defStr7";
	public static String PROP_LFT = "lft";
	public static String PROP_TITLE_IMG = "titleImg";
	public static String PROP_PARENT = "parent";
	public static String PROP_DEF_LONG3 = "defLong3";
	public static String PROP_ID = "id";
	public static String PROP_CONTENT_IMG = "contentImg";


	// constructors
	public BaseCmsChannel () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseCmsChannel (java.lang.Long id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseCmsChannel (
		java.lang.Long id,
		com.jeecms.cms.entity.ChnlModel model,
		com.jeecms.cms.entity.CmsConfig config,
		com.jeecms.core.entity.Website website,
		java.lang.String sysType,
		java.lang.Integer lft,
		java.lang.Integer rgt,
		java.lang.Integer docCount,
		java.lang.Integer priority,
		java.lang.Boolean hasTitleImg,
		java.lang.Boolean hasChild,
		java.lang.Boolean display) {

		this.setId(id);
		this.setModel(model);
		this.setConfig(config);
		this.setWebsite(website);
		this.setSysType(sysType);
		this.setLft(lft);
		this.setRgt(rgt);
		this.setDocCount(docCount);
		this.setPriority(priority);
		this.setHasTitleImg(hasTitleImg);
		this.setHasChild(hasChild);
		this.setDisplay(display);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Long id;

	// fields
	private java.lang.String sysType;
	private java.lang.String path;
	private java.lang.Integer lft;
	private java.lang.Integer rgt;
	private java.lang.String name;
	private java.lang.String content;
	private java.lang.String titleImg;
	private java.lang.String contentImg;
	private java.lang.String tplIndex;
	private java.lang.String tplContent;
	private java.lang.String title;
	private java.lang.String keywords;
	private java.lang.String description;
	private java.lang.Integer docCount;
	private java.lang.Long visitTotal;
	private java.lang.Long visitToday;
	private java.util.Date statDate;
	private java.lang.String outerUrl;
	private java.lang.Integer priority;
	private java.lang.Boolean hasTitleImg;
	private java.lang.Boolean hasChild;
	private java.lang.Boolean display;
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
	private com.jeecms.cms.entity.CmsMemberGroup groupContribute;
	private com.jeecms.cms.entity.CmsMemberGroup groupVisit;
	private com.jeecms.cms.entity.CmsChannel parent;
	private com.jeecms.cms.entity.ChnlModel model;
	private com.jeecms.cms.entity.CmsConfig config;
	private com.jeecms.core.entity.Website website;

	// collections
	private java.util.Set<com.jeecms.cms.entity.CmsChannel> child;
	private java.util.Set<com.jeecms.core.entity.Attachment> attachments;
	private java.util.Set<com.jeecms.cms.entity.CmsAdmin> admins;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="CHANNEL_ID"
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
	 * Return the value associated with the column: SYS_TYPE
	 */
	public java.lang.String getSysType () {
		return sysType;
	}

	/**
	 * Set the value related to the column: SYS_TYPE
	 * @param sysType the SYS_TYPE value
	 */
	public void setSysType (java.lang.String sysType) {
		this.sysType = sysType;
	}



	/**
	 * Return the value associated with the column: PATH
	 */
	public java.lang.String getPath () {
		return path;
	}

	/**
	 * Set the value related to the column: PATH
	 * @param path the PATH value
	 */
	public void setPath (java.lang.String path) {
		this.path = path;
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
	 * Return the value associated with the column: CONTENT_IMG
	 */
	public java.lang.String getContentImg () {
		return contentImg;
	}

	/**
	 * Set the value related to the column: CONTENT_IMG
	 * @param contentImg the CONTENT_IMG value
	 */
	public void setContentImg (java.lang.String contentImg) {
		this.contentImg = contentImg;
	}



	/**
	 * Return the value associated with the column: TPL_INDEX
	 */
	public java.lang.String getTplIndex () {
		return tplIndex;
	}

	/**
	 * Set the value related to the column: TPL_INDEX
	 * @param tplIndex the TPL_INDEX value
	 */
	public void setTplIndex (java.lang.String tplIndex) {
		this.tplIndex = tplIndex;
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
	 * Return the value associated with the column: DOC_COUNT
	 */
	public java.lang.Integer getDocCount () {
		return docCount;
	}

	/**
	 * Set the value related to the column: DOC_COUNT
	 * @param docCount the DOC_COUNT value
	 */
	public void setDocCount (java.lang.Integer docCount) {
		this.docCount = docCount;
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
	 * Return the value associated with the column: HAS_TITLEIMG
	 */
	public java.lang.Boolean getHasTitleImg () {
		return hasTitleImg;
	}

	/**
	 * Set the value related to the column: HAS_TITLEIMG
	 * @param hasTitleImg the HAS_TITLEIMG value
	 */
	public void setHasTitleImg (java.lang.Boolean hasTitleImg) {
		this.hasTitleImg = hasTitleImg;
	}



	/**
	 * Return the value associated with the column: HAS_CHILD
	 */
	public java.lang.Boolean getHasChild () {
		return hasChild;
	}

	/**
	 * Set the value related to the column: HAS_CHILD
	 * @param hasChild the HAS_CHILD value
	 */
	public void setHasChild (java.lang.Boolean hasChild) {
		this.hasChild = hasChild;
	}



	/**
	 * Return the value associated with the column: IS_DISPLAY
	 */
	public java.lang.Boolean getDisplay () {
		return display;
	}

	/**
	 * Set the value related to the column: IS_DISPLAY
	 * @param display the IS_DISPLAY value
	 */
	public void setDisplay (java.lang.Boolean display) {
		this.display = display;
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
	 * Return the value associated with the column: GROUP_CONTRI_ID
	 */
	public com.jeecms.cms.entity.CmsMemberGroup getGroupContribute () {
		return groupContribute;
	}

	/**
	 * Set the value related to the column: GROUP_CONTRI_ID
	 * @param groupContribute the GROUP_CONTRI_ID value
	 */
	public void setGroupContribute (com.jeecms.cms.entity.CmsMemberGroup groupContribute) {
		this.groupContribute = groupContribute;
	}



	/**
	 * Return the value associated with the column: GROUP_VISIT_ID
	 */
	public com.jeecms.cms.entity.CmsMemberGroup getGroupVisit () {
		return groupVisit;
	}

	/**
	 * Set the value related to the column: GROUP_VISIT_ID
	 * @param groupVisit the GROUP_VISIT_ID value
	 */
	public void setGroupVisit (com.jeecms.cms.entity.CmsMemberGroup groupVisit) {
		this.groupVisit = groupVisit;
	}



	/**
	 * Return the value associated with the column: PARENT
	 */
	public com.jeecms.cms.entity.CmsChannel getParent () {
		return parent;
	}

	/**
	 * Set the value related to the column: PARENT
	 * @param parent the PARENT value
	 */
	public void setParent (com.jeecms.cms.entity.CmsChannel parent) {
		this.parent = parent;
	}



	/**
	 * Return the value associated with the column: MODEL_ID
	 */
	public com.jeecms.cms.entity.ChnlModel getModel () {
		return model;
	}

	/**
	 * Set the value related to the column: MODEL_ID
	 * @param model the MODEL_ID value
	 */
	public void setModel (com.jeecms.cms.entity.ChnlModel model) {
		this.model = model;
	}



	/**
	 * Return the value associated with the column: CONFIG_ID
	 */
	public com.jeecms.cms.entity.CmsConfig getConfig () {
		return config;
	}

	/**
	 * Set the value related to the column: CONFIG_ID
	 * @param config the CONFIG_ID value
	 */
	public void setConfig (com.jeecms.cms.entity.CmsConfig config) {
		this.config = config;
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
	 * Return the value associated with the column: child
	 */
	public java.util.Set<com.jeecms.cms.entity.CmsChannel> getChild () {
		return child;
	}

	/**
	 * Set the value related to the column: child
	 * @param child the child value
	 */
	public void setChild (java.util.Set<com.jeecms.cms.entity.CmsChannel> child) {
		this.child = child;
	}

	public void addTochild (com.jeecms.cms.entity.CmsChannel cmsChannel) {
		if (null == getChild()) setChild(new java.util.TreeSet<com.jeecms.cms.entity.CmsChannel>());
		getChild().add(cmsChannel);
	}



	/**
	 * Return the value associated with the column: attachments
	 */
	public java.util.Set<com.jeecms.core.entity.Attachment> getAttachments () {
		return attachments;
	}

	/**
	 * Set the value related to the column: attachments
	 * @param attachments the attachments value
	 */
	public void setAttachments (java.util.Set<com.jeecms.core.entity.Attachment> attachments) {
		this.attachments = attachments;
	}



	/**
	 * Return the value associated with the column: admins
	 */
	public java.util.Set<com.jeecms.cms.entity.CmsAdmin> getAdmins () {
		return admins;
	}

	/**
	 * Set the value related to the column: admins
	 * @param admins the admins value
	 */
	public void setAdmins (java.util.Set<com.jeecms.cms.entity.CmsAdmin> admins) {
		this.admins = admins;
	}

	public void addToadmins (com.jeecms.cms.entity.CmsAdmin cmsAdmin) {
		if (null == getAdmins()) setAdmins(new java.util.TreeSet<com.jeecms.cms.entity.CmsAdmin>());
		getAdmins().add(cmsAdmin);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.jeecms.cms.entity.CmsChannel)) return false;
		else {
			com.jeecms.cms.entity.CmsChannel cmsChannel = (com.jeecms.cms.entity.CmsChannel) obj;
			if (null == this.getId() || null == cmsChannel.getId()) return false;
			else return (this.getId().equals(cmsChannel.getId()));
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