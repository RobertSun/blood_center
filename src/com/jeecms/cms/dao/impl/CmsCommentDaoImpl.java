package com.jeecms.cms.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jeecms.cms.dao.CmsCommentDao;
import com.jeecms.cms.entity.CmsComment;
import com.jeecms.common.hibernate3.Finder;
import com.jeecms.common.page.Pagination;
import com.jeecms.core.JeeCoreDaoImpl;

@Repository
public class CmsCommentDaoImpl extends JeeCoreDaoImpl<CmsComment> implements
		CmsCommentDao {
	public int deleteComment(Long docId, String docType) {
		String hql = "delete CmsComment bean where bean.doc.id=:docId and bean.doc.class='"
				+ docType + "'";
		return getSession().createQuery(hql).setLong("docId", docId)
				.executeUpdate();
	}

	public Pagination getCommentForTag(Long docId, String docType,
			Boolean check, Boolean recommend, Boolean disabled,
			boolean rcmFirst, int orderBy, boolean isPage, int firstResult,
			int pageNo, int pageSize) {
		Finder f = Finder.create("from CmsComment bean").append(
				" where bean.doc.id=:docId").setParam("docId", docId);
		f.append(" and bean.doc.class='" + docType + "'");
		if (check != null) {
			f.append(" and bean.check=:check");
			f.setParam("check", check);
		}
		if (recommend != null) {
			f.append(" and bean.recommend=:recommend");
			f.setParam("recommend", recommend);
		}
		if (disabled != null) {
			f.append(" and bean.disabled=:disabled");
			f.setParam("disabled", disabled);
		}
		if (rcmFirst) {
			f.append(" order by bean.recommend desc,");
		} else {
			f.append(" order by");
		}
		switch (orderBy) {
		case 1:
			f.append(" bean.id desc");
			break;
		default:
			f.append(" bean.id asc");
			break;
		}
		if (isPage) {
			return find(f, pageNo, pageSize);
		} else {
			f.setFirstResult(firstResult);
			f.setMaxResults(pageSize);
			@SuppressWarnings("rawtypes")
			List list = find(f);
			return new Pagination(1, pageSize, list.size(), list);
		}
	}
}