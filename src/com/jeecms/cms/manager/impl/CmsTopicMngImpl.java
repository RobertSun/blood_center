package com.jeecms.cms.manager.impl;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeecms.article.entity.Article;
import com.jeecms.article.manager.ArticleMng;
import com.jeecms.cms.dao.CmsTopicDao;
import com.jeecms.cms.entity.CmsTopic;
import com.jeecms.cms.manager.CmsTopicMng;
import com.jeecms.common.page.Pagination;
import com.jeecms.core.JeeCoreManagerImpl;

@Service
@Transactional
public class CmsTopicMngImpl extends JeeCoreManagerImpl<CmsTopic> implements
		CmsTopicMng {
	public Pagination getForTag(boolean isPage, int firstResult, int pageNo,
			int pageSize) {
		return getDao().getForTag(isPage, firstResult, pageNo, pageSize);
	}

	public Object updateTopic(CmsTopic topic, String articleIds) {
		topic = (CmsTopic) super.updateDefault(topic);
		Set<Article> set = toArticles(articleIds);
		topic.setArticles(set);
		return topic;
	}

	public CmsTopic saveTopic(CmsTopic topic, String articleIds) {
		Set<Article> set = toArticles(articleIds);
		topic.setArticles(set);
		super.save(topic);
		return topic;
	}

	@Override
	public CmsTopic findById(Serializable id) {
		CmsTopic topic = super.findById(id);
		return topic;
	}

	@Override
	public CmsTopic deleteById(Serializable id) {
		CmsTopic topic = super.deleteById(id);
		return topic;
	}

	private Set<Article> toArticles(String articleIds) {
		Set<Article> set = new HashSet<Article>();
		if (!StringUtils.isBlank(articleIds)) {
			articleIds = StringUtils.replace(articleIds, "£¬", ",");
			String[] arr = StringUtils.split(articleIds, ',');
			Long id;
			Article article;
			for (String s : arr) {
				try {
					id = Long.parseLong(s);
					article = articleMng.findById(id);
					if (article != null) {
						set.add(article);
					}
				} catch (Exception e) {
				}
			}
		}
		return set;
	}

	public ArticleMng articleMng;

	@Autowired
	public void setDao(CmsTopicDao dao) {
		super.setDao(dao);
	}

	public CmsTopicDao getDao() {
		return (CmsTopicDao) super.getDao();
	}

	@Autowired
	public void setArticleMng(ArticleMng articleMng) {
		this.articleMng = articleMng;
	}

}
