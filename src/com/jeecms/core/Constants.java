package com.jeecms.core;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;

public class Constants {
	public static final String ENCODING = "GBK";
	public static final String JEECMS = "jeecms";
	public static final String JEESHOP = "jeeshop";
	public static final String JEEBBS = "jeebbs";

	/**
	 * ϵͳ����
	 */
	public static final Map<String, String> SYSTEM_TYPES = new LinkedHashMap<String, String>();
	static {
		SYSTEM_TYPES.put(JEECMS, "JEECMSϵͳ");
		SYSTEM_TYPES.put(JEESHOP, "JEESHOPϵͳ");
		SYSTEM_TYPES.put(JEEBBS, "JEEBBSϵͳ");
	}

	public static String getSysName(String sysType) {
		return SYSTEM_TYPES.get(sysType);
	}

	/**
	 * ��Դ·��
	 */
	public static final String RES_BASE = "res_base";
	/**
	 * �û�·��
	 */
	public static final String USER_BASE = "user_base";
	/**
	 * ģ��·��
	 */
	public static final String TEMPLATE = "template";
	/**
	 * WEB-INF
	 */
	public static final String WEBINF = "WEB-INF";
	/**
	 * ϵͳ��ԴĿ¼
	 */
	public static final String RES_SYS = "front_res";
	/**
	 * �ϴ���·����
	 */
	public static final String UPLOAD_PATH = "upload";
	public static final String UPLOAD_FILE = "/file";
	public static final String UPLOAD_FLASH = "/flash";
	public static final String UPLOAD_IMAGE = "/image";
	public static final String UPLOAD_MEDIA = "/media";
	/**
	 * Ĭ��ģ�巽��
	 */
	public static final String TPL_DEF_SOLUTION = "default";
	/**
	 * ģ���׺
	 */
	public static final String TPL_SUFFIX = ".html";
	/**
	 * ·���ָ���
	 */
	public static final char SPT = '/';
	/**
	 * ϵͳ·���ָ���
	 */
	public static final char FILE_SPT = File.separatorChar;
	/**
	 * �ض���result
	 */
	public static final String REDIRECT = "redirect";
	/**
	 * û���ҵ���������ƥ���վ��
	 */
	public static final String WEBSITE_NOT_FOUND = "websiteNotFound";

	/**
	 * ÿ�պ�����
	 */
	public static final long DAY_MILLIS = 24 * 60 * 60 * 1000;
}
