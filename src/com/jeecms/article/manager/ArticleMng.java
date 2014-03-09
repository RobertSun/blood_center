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
	 * 为前台标签获得文章列表
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
	 * 会员投稿
	 * 
	 * @param bean
	 * @param member
	 * @param rule
	 * @return
	 */
	public Article memberSave(Article bean, CmsMember member, UploadRule rule);

	/**
	 * 会员修改稿件
	 * 
	 * @param bean
	 * @param cmsMember
	 * @param rule
	 * @return
	 */
	public Article memberUpdate(Article bean, CmsMember cmsMember,
			UploadRule rule);

	/**
	 * 管理员保存文章
	 * 
	 * @param arti
	 * @param admin
	 * @param rule
	 *            上传规则
	 * @param resUrl
	 *            资源URL
	 * @param topTime
	 * @return
	 */
	public Article saveArticle(Article arti, CmsAdmin admin, UploadRule rule,
			String resUrl, int checkCount, long topTime);

	/**
	 * 管理员更新文章
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
	 * 获得未审核的文章
	 * 
	 * @param adminId
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public Pagination getUncheckArticle(Long adminId, int pageNo, int pageSize);

	/**
	 * 获得有权限未签收的文章
	 * 
	 * @param adminId
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public Pagination getUnsigninArticle(Long adminId, int pageNo, int pageSize);

	/**
	 * 获得有权限的文章
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
	 * 获得文章并检查资源路径
	 * 
	 * @param id
	 * @return
	 */
	public Article findAndCheckResPath(Serializable id);
}