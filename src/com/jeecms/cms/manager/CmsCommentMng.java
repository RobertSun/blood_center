package com.jeecms.cms.manager;

import java.util.List;

import com.jeecms.common.page.Pagination;
import com.jeecms.core.JeeCoreManager;
import com.jeecms.cms.entity.CmsComment;

public interface CmsCommentMng extends JeeCoreManager<CmsComment> {
	/**
	 * ɾ������
	 * 
	 * @param docId
	 * @param docType
	 * @return
	 */
	public int deleteComment(Long docId, String docType);

	/**
	 * �������
	 * 
	 * @param docId
	 * @param docType
	 * @param check
	 * @param recommend
	 * @param disabled
	 * @param rcmFirst
	 *            �Ƽ���������ʾ��ǰ��
	 * @param orderBy
	 *            0��id����1��id����
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
	 * �������
	 * 
	 * @param ids
	 * @return
	 */
	public List<CmsComment> check(Long[] ids);
}