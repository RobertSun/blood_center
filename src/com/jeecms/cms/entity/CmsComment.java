package com.jeecms.cms.entity;

import com.jeecms.cms.entity.base.BaseCmsComment;
import com.jeecms.common.util.StrUtils;
import com.jeecms.core.util.ContentInterface;

public class CmsComment extends BaseCmsComment {
	private static final long serialVersionUID = 1L;
	public static final String DOC_ARTICLE = "ARTI";
	public static final String DOC_DOWNLOAD = "DOWN";

	/**
	 * 获得文档类型
	 * 
	 * @param sign
	 * @return
	 */
	public static String getDocType(String sign) {
		if ("1".equals(sign)) {
			return DOC_ARTICLE;
		} else if ("2".equals(sign)) {
			return DOC_DOWNLOAD;
		} else {
			throw new RuntimeException();
		}
	}

	public String getHtmlMember() {
		return StrUtils.txt2htm(getContentMember());

	}

	public String getHtmlAdmin() {
		return StrUtils.txt2htm(getContentAdmin());
	}

	/**
	 * 文档（Article,Download）
	 */
	private ContentInterface doc;

	/* [CONSTRUCTOR MARKER BEGIN] */
	public CmsComment () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public CmsComment (java.lang.Long id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public CmsComment (
		java.lang.Long id,
		com.jeecms.core.entity.Website website,
		java.lang.Boolean check,
		java.lang.Boolean recommend,
		java.lang.Boolean disabled) {

		super (
			id,
			website,
			check,
			recommend,
			disabled);
	}

	/* [CONSTRUCTOR MARKER END] */

	public ContentInterface getDoc() {
		return doc;
	}

	public void setDoc(ContentInterface doc) {
		this.doc = doc;
	}
}