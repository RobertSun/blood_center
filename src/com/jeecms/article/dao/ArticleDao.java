package com.jeecms.article.dao;

import java.io.IOException;
import java.util.Date;

import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.index.IndexWriter;

import com.jeecms.article.entity.Article;
import com.jeecms.common.page.Pagination;
import com.jeecms.core.JeeCoreDao;

public interface ArticleDao extends JeeCoreDao<Article> {
	public Pagination getForTag(Long webId, Long chnlId, Long topicId,
			Long ctgId, String searchKey, Boolean hasTitleImg,
			boolean recommend, int topLevel, int orderBy, boolean isPage,
			int firstResult, int pageNo, int pageSize);

	/**
	 * �����һƪ����һƪ����
	 * 
	 * @param webId
	 * @param chnlId
	 * @param artiId
	 * @param next
	 *            true����һƪ��false����һƪ
	 * @return
	 */
	public Article getSideArticle(Long webId, Long chnlId, Long artiId,
			boolean next);

	/**
	 * �����Ȩ��δ��˵�����
	 * 
	 * @param adminId
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public Pagination getUncheckArticle(Long adminId, int pageNo, int pageSize);

	/**
	 * �����Ȩ��δǩ�յ�����
	 * 
	 * @param adminId
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public Pagination getUnsigninArticle(Long adminId, int pageNo, int pageSize);

	/**
	 * �����Ȩ�޵�����
	 * 
	 * @param webId
	 * @param chnlId
	 * @param adminId
	 * @param inputAdminId
	 * @param contentCtgId
	 * @param disabled
	 * @param topTime
	 * @param topLevel
	 * @param status
	 * @param title
	 * @param order
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public Pagination getRightArticle(Long webId, Long chnlId, Long adminId,
			Long inputAdminId, Long contentCtgId, boolean disabled,
			boolean topTime, int topLevel, int status, String title, int order,
			int pageNo, int pageSize);

	public Pagination getArticleForMember(Long memberId, Long webId,
			Boolean draft, Boolean check, Boolean reject, int pageNo,
			int pageSize);

	public int luceneWriteIndex(IndexWriter writer, Date startDate, String root)
			throws CorruptIndexException, IOException;
}