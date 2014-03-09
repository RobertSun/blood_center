package com.jeecms.cms.manager;

import java.util.List;

import com.jeecms.common.page.Pagination;
import com.jeecms.core.JeeCoreManager;
import com.jeecms.cms.entity.CmsComment;

public interface CmsCommentMng extends JeeCoreManager<CmsComment> {
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

	/**
	 * 审核评论
	 * 
	 * @param ids
	 * @return
	 */
	public List<CmsComment> check(Long[] ids);
}