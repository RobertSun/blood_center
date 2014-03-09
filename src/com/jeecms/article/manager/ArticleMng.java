package com.jeecms.article.manager;

import java.io.Serializable;
import java.util.List;

import com.jeecms.article.entity.Article;
import com.jeecms.cms.entity.CmsAdmin;
import com.jeecms.cms.entity.CmsMember;
import com.jeecms.common.page.Pagination;
import com.jeecms.core.JeeCoreManager;
import com.jeecms.core.util.UploadRule;

public interface ArticleMng extends JeeCoreManager<Article> {
	/**
	 * Ϊǰ̨��ǩ��������б�
	 * 
	 * @param webId
	 * @param chnlId
	 * @param ctgId
	 * @param searchKey
	 * @param hasTitleImg
	 * @param recommend
	 * @param topLevel
	 * @param orderBy
	 * @param isPage
	 * @param firstResult
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public Pagination getForTag(Long webId, Long chnlId, Long topicId,
			Long ctgId, String searchKey, Boolean hasTitleImg,
			boolean recommend, int topLevel, int orderBy, boolean isPage,
			int firstResult, int pageNo, int pageSize);

	/**
	 * ��ԱͶ��
	 * 
	 * @param bean
	 * @param member
	 * @param rule
	 * @return
	 */
	public Article memberSave(Article bean, CmsMember member, UploadRule rule);

	/**
	 * ��Ա�޸ĸ��
	 * 
	 * @param bean
	 * @param cmsMember
	 * @param rule
	 * @return
	 */
	public Article memberUpdate(Article bean, CmsMember cmsMember,
			UploadRule rule);

	/**
	 * ����Ա��������
	 * 
	 * @param arti
	 * @param admin
	 * @param rule
	 *            �ϴ�����
	 * @param resUrl
	 *            ��ԴURL
	 * @param topTime
	 * @return
	 */
	public Article saveArticle(Article arti, CmsAdmin admin, UploadRule rule,
			String resUrl, int checkCount, long topTime);

	/**
	 * ����Ա��������
	 * 
	 * @param arti
	 * @param admin
	 * @param rule
	 * @param topTime
	 * @return
	 */
	public Article updateArticle(Article arti, CmsAdmin admin, UploadRule rule,
			long topTime);

	public Article disableArticle(Long id, CmsAdmin admin, boolean disable);

	public List<Article> disableArticle(Long[] ids, CmsAdmin admin,
			boolean disable);

	public Article checkArticle(Long id, CmsAdmin admin);

	public List<Article> checkArticle(Long[] ids, CmsAdmin admin);

	public Article rejectArticle(Long id, CmsAdmin admin, String opinion);

	public List<Article> rejectArticle(Long[] ids, CmsAdmin admin,
			String opinion);

	/**
	 * ���δ��˵�����
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

	public Article signinArticle(Long id, CmsAdmin admin);

	public List<Article> signinArticle(Long[] ids, CmsAdmin admin);

	/**
	 * ������²������Դ·��
	 * 
	 * @param id
	 * @return
	 */
	public Article findAndCheckResPath(Serializable id);
}