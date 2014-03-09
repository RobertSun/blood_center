package com.jeecms.cms.dao;

import com.jeecms.cms.entity.CmsComment;
import com.jeecms.common.page.Pagination;
import com.jeecms.core.JeeCoreDao;

public interface CmsCommentDao extends JeeCoreDao<CmsComment> {
	/**
	 * 删除评论
	 * 
	 * @param docId
	 * @param docType
	 * @return
	 */
	public int deleteComment(Long docId, String docType);

	/**
	 * 获得评论
	 * 
	 * @param docId
	 * @param docType
	 * @param check
	 * @param recommend
	 * @param disabled
	 * @param rcmFirst
	 *            推荐的评论显示在前面
	 * @param orderBy
	 *            0：id降序；1：id升序
	 * @param isPage
	 * @param firstResult
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public Pagination getCommentForTag(Long docId, String docType,
			Boolean check, Boolean recommend, Boolean disabled,
			boolean rcmFirst, int orderBy, boolean isPage, int firstResult,
			int pageNo, int pageSize);
}