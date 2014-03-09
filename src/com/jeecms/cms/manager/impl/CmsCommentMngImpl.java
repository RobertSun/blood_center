package com.jeecms.cms.manager.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeecms.article.entity.Article;
import com.jeecms.cms.dao.CmsCommentDao;
import com.jeecms.cms.entity.CmsComment;
import com.jeecms.cms.manager.CmsCommentMng;
import com.jeecms.common.hibernate3.Updater;
import com.jeecms.common.page.Pagination;
import com.jeecms.common.struts2.ContextPvd;
import com.jeecms.common.util.ComUtils;
import com.jeecms.core.JeeCoreManagerImpl;

@Service
@Transactional
public class CmsCommentMngImpl extends JeeCoreManagerImpl<CmsComment> implements
		CmsCommentMng {
	public int deleteComment(Long docId, String docType) {
		return getDao().deleteComment(docId, docType);
	}

	public Pagination getCommentForTag(Long docId, String docType,
			Boolean check, Boolean recommend, Boolean disabled,
			boolean rcmFirst, int orderBy, boolean isPage, int firstResult,
			int pageNo, int pageSize) {
		return getDao().getCommentForTag(docId, docType, check, recommend,
				disabled, rcmFirst, orderBy, isPage, firstResult, pageNo,
				pageSize);
	}

	public List<CmsComment> check(Long[] ids) {
		List<CmsComment> list = new ArrayList<CmsComment>(ids.length);
		CmsComment entity;
		for (Long id : ids) {
			entity = findById(id);
			entity.setCheck(true);
			list.add(entity);
		}
		return list;
	}

	@Override
	public Object updateByUpdater(Updater updater) {
		CmsComment comment = (CmsComment) super.updateByUpdater(updater);
		return comment;
	}

	@Override
	public CmsComment save(CmsComment comment) {
		initDefValue(comment);
		super.save(comment);
		Article article = (Article) comment.getDoc();
		int commentCount = article.getCommentCount();
		article.setCommentCount(commentCount + 1);
		return comment;
	}

	@Override
	public CmsComment findById(Serializable id) {
		CmsComment comment = super.findById(id);
		return comment;
	}

	@Override
	public CmsComment deleteById(Serializable id) {
		CmsComment comment = super.deleteById(id);
		return comment;
	}

	private void initDefValue(CmsComment bean) {
		bean.setCreateTime(ComUtils.now());
		bean.setIp(contenxtPvd.getRemoteIp());
		bean.setCheck(false);
		bean.setRecommend(false);
		bean.setDisabled(false);
	}

	@Autowired
	private ContextPvd contenxtPvd;

	@Autowired
	public void setDao(CmsCommentDao dao) {
		super.setDao(dao);
	}

	public CmsCommentDao getDao() {
		return (CmsCommentDao) super.getDao();
	}

}
