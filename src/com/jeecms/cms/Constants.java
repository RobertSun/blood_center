package com.jeecms.cms;

import java.util.LinkedHashMap;
import java.util.Map;

public class Constants {
	/**
	 * 文章系统代号
	 */
	public static final String ARTICLE_SYS = "article";
	/**
	 * 论坛系统代号
	 */
	public static final String BBS_SYS = "bbs";
	/**
	 * 图片系统代号
	 */
	public static final String PICTURE_SYS = "picture";
	/**
	 * 下载系统代号
	 */
	public static final String DOWNLOAD_SYS = "download";
	/**
	 * 会员系统代号
	 */
	public static final String MEMBER_SYS = "cms_member";
	/**
	 * 共用系统代号
	 */
	public static final String COMMON_SYS = "cms_common";
	/**
	 * 文章全文检索索引
	 */
	public static final String LUCENE_ARTICLE_PATH = "/WEB-INF/lucene/article";

	/**
	 * CMS系统集合
	 */
	public static final Map<String, String> CMSSYS_TYPES = new LinkedHashMap<String, String>();
	static {
		CMSSYS_TYPES.put(ARTICLE_SYS, "文章系统");
		CMSSYS_TYPES.put(DOWNLOAD_SYS, "下载系统");
		CMSSYS_TYPES.put(PICTURE_SYS, "图片系统");
	}
	/**
	 * cms会员登录重定向
	 */
	public static String CMS_MEMBER_LOGIN = "cmsMemberLogin";

	public static String getSysName(String sysType) {
		return CMSSYS_TYPES.get(sysType);
	}
}
