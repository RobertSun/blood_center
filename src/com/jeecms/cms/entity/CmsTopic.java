package com.jeecms.cms.entity;

import java.util.Set;

import org.apache.commons.lang.StringUtils;

import com.jeecms.article.entity.Article;
import com.jeecms.cms.entity.base.BaseCmsTopic;

public class CmsTopic extends BaseCmsTopic {
	private static final long serialVersionUID = 1L;

	public String getTitleImgUrl() {
		String img = getTitleImg();
		if (!StringUtils.isBlank(img)) {
			return getWebsite().getUploadUrlBuf().append(img).toString();
		} else {
			return "";
		}
	}

	public String getArticleIds() {
		Set<Article> set = getArticles();
		if (set != null && set.size() > 0) {
			StringBuilder sb = new StringBuilder();
			for (Article a : set) {
				sb.append(a.getId()).append(",");
			}
			if (sb.length() > 0) {
				sb.setLength(sb.length() - 1);
			}
			return sb.toString();
		} else {
			return "";
		}
	}

	/* [CONSTRUCTOR MARKER BEGIN] */
	public CmsTopic () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public CmsTopic (java.lang.Long id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public CmsTopic (
		java.lang.Long id,
		com.jeecms.core.entity.Website website,
		java.lang.String name,
		java.lang.Integer priority) {

		super (
			id,
			website,
			name,
			priority);
	}

	/* [CONSTRUCTOR MARKER END] */

}