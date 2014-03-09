package com.jeecms.article.dao.impl;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.index.IndexWriter;
import org.hibernate.CacheMode;
import org.hibernate.ScrollMode;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.jeecms.article.dao.ArticleDao;
import com.jeecms.article.entity.Article;
import com.jeecms.article.lucene.LuceneArticle;
import com.jeecms.common.hibernate3.Finder;
import com.jeecms.common.page.Pagination;
import com.jeecms.core.JeeCoreDaoImpl;

@Repository
public class ArticleDaoImpl extends JeeCoreDaoImpl<Article> implements
		ArticleDao {
	public Pagination getForTag(Long webId, Long chnlId, Long topicId,
			Long ctgId, String searchKey, Boolean hasTitleImg,
			boolean recommend, int topLevel, int orderBy, boolean isPage,
			int firstResult, int pageNo, int pageSize) {
		Finder f = Finder.create("select bean from Article bean");
		boolean whereHas = false;
		if (chnlId != null) {
			f.append(" inner join bean.channel node,CmsChannel parent");
			f.append(" where node.lft between parent.lft and parent.rgt");
			f.append(" and parent.id=:chnlId").setParam("chnlId", chnlId);
			whereHas = true;
		} else if (topicId != null) {
			f.append(" inner join bean.topics topic where topic.id=:topicId");
			f.setParam("topicId", topicId);
		}
		//��������webid,����webid���ж�
		if(webId!=null){
			if(whereHas)
				f.append(" and bean.website.id=:webId").setParam("webId", webId);
			else
				f.append(" where bean.website.id=:webId").setParam("webId", webId);
		}
		f.append(" and bean.check=true and bean.disabled=false");
		if (ctgId != null) {
			f.append(" and bean.contentCtg.id=:ctgId").setParam("ctgId", ctgId);
		}
		if (recommend) {
			f.append(" and bean.recommend=true");
		}
		if (hasTitleImg != null) {
			f.append(" and bean.hasTitleImg=:hasTitleImg");
			f.setParam("hasTitleImg", hasTitleImg);
		}
		switch (topLevel) {
		case 1:
			f.append(" and bean.topLevel=0");
			break;
		case 2:
			f.append(" and bean.topLevel>=1");
			break;
		}
		if (!StringUtils.isBlank(searchKey)) {
			searchKey = "%" + searchKey + "%";
			f.append(" and (bean.title like :searchKey");
			f.append(" or bean.tags like :searchKey");
			f.append(" or bean.description like :searchKey)");
			f.setParam("searchKey", searchKey);
		}
		switch (orderBy) {
		// ����ʱ������
		case 1:
			f.append(" order by bean.releaseDate asc");
			break;
		// �̶�����
		case 2:
			f.append(" order by bean.topLevel desc, bean.sortDate desc");
			break;
		// �ö�����
		case 3:
			f.append(" order by bean.sortDate desc");
			break;
		// �յ������
		case 4:
			f.append(" order by bean.visitToday desc");
			break;
		// �ܵ������
		case 5:
			f.append(" order by bean.visitWeek desc");
			break;
		// �µ������
		case 6:
			f.append(" order by bean.visitMonth desc");
			break;
		// ���������
		case 7:
			f.append(" order by bean.visitQuarter desc");
			break;
		// ��������
		case 8:
			f.append(" order by bean.visitYear desc");
			break;
		// �ܵ������
		case 9:
			f.append(" order by bean.visitTotal desc");
			break;
		// Ĭ�Ϸ���ʱ�併��
		default:
			f.append(" order by bean.releaseDate desc");
			break;
		}
		if (isPage) {
			return find(f, pageNo, pageSize);
		} else {
			f.setFirstResult(firstResult);
			f.setMaxResults(pageSize);
			@SuppressWarnings("rawtypes")
			List list = find(f);
			return new Pagination(pageNo, list.size(), pageSize, list);
		}
	}

    public Article getSideArticle(Long webId, Long chnlId, Long artiId,
			boolean next) {
		Finder f = Finder
				.create("from Article a where a.website.id=:webId and a.disabled=false");
//        Finder f = Finder
//                .create("from Article a where a.website.id=:webId and a.disabled=false and a.check=true");

		f.setParam("webId", webId);
		if (chnlId != null) {
			f.append(" and a.channel.id=:chnlId");
			f.setParam("chnlId", chnlId);
		}
		if (next) {
			f.append(" and a.id>:artiId order by a.id asc");
		} else {
			f.append(" and a.id<:artiId order by a.id desc");
		}
		f.setParam("artiId", artiId);
		Article entity = (Article) f.createQuery(getSession()).setMaxResults(1)
				.uniqueResult();
		return entity;
	}

	public Pagination getUncheckArticle(Long adminId, int pageNo, int pageSize) {
		// ��Ȩ�޵����з�����Ҫ�������
		Finder f = Finder.create("select bean from Article bean");
		f.append(" inner join bean.channel chnl");
		f.append(" inner join chnl.admins admin");
		f.append(" where admin.id=:adminId").setParam("adminId", adminId);
		f.append(" and bean.disabled=false and bean.reject=false");
		f.append(" and bean.draft=false and bean.check=false");
		f.append(" and bean.checkStep>=0");
		f.append(" and admin.checkRight=bean.checkStep+1");
		return find(f, pageNo, pageSize);
	}

	public Pagination getUnsigninArticle(Long adminId, int pageNo, int pageSize) {
		Finder f = Finder.create("select bean from Article bean");
		f.append(" inner join bean.channel chnl");
		f.append(" inner join chnl.admins admin");
		f.append(" where admin.id=:adminId").setParam("adminId", adminId);
		f.append(" and bean.checkStep=-1 and bean.draft=false");
		f.append(" and bean.disabled=false and bean.reject=false");
		return find(f, pageNo, pageSize);

	}

	public Pagination getRightArticle(Long webId, Long chnlId, Long adminId,
			Long inputAdminId, Long contentCtgId, boolean disabled,
			boolean topTime, int topLevel, int status, String title, int order,
			int pageNo, int pageSize) {
		String hql = "select bean from Article bean inner join bean.channel node inner join node.admins admin,CmsChannel parent"
				+ " where node.lft between parent.lft and parent.rgt and parent.id=:chnlId and bean.website.id=:webId and admin.id=:adminId";
		Finder f = Finder.create(hql).setParam("webId", webId).setParam(
				"chnlId", chnlId).setParam("adminId", adminId);
		if (contentCtgId != null) {
			f.append(" and bean.contentCtg.id=:contentCtgId").setParam(
					"contentCtgId", contentCtgId);
		}
		switch (topLevel) {
		case 1:
			f.append(" and bean.topLevel=0");
		case 2:
			f.append(" and bean.topLevel>=1");
		}
		if (inputAdminId != null) {
			f.append(" and bean.adminInput.id=:inputAdminId");
			f.setParam("inputAdminId", inputAdminId);
		}
		if (disabled) {
			f.append(" and bean.disabled=true");
		}
		if (topTime) {
			f.append(" and bean.sortDate>current_timestamp()");
		}
		switch (status) {
		case 4:
			// �˸�
			f.append(" and bean.reject=true");
			break;
		case 3:
			// �����
			f.append(" and bean.check=true");
			break;
		case 2:
			// �����
			f.append(" and bean.check=false and bean.draft=false");
			break;
		case 1:
			// �ݸ�
			f.append(" and bean.draft=true");
			break;
		default:
			break;
		}
		if (!StringUtils.isBlank(title)) {
			f.append(" and bean.title like :title").setParam("title",
					"%" + title + "%");
		}
		switch (order) {
		case 13:
			f.append(" order by bean.visitTotal asc");
			break;
		case 12:
			f.append(" order by bean.visitTotal desc");
			break;
		case 11:
			f.append(" order by bean.visitYear asc");
			break;
		case 10:
			f.append(" order by bean.visitYear desc");
			break;
		case 9:
			f.append(" order by bean.visitQuarter asc");
			break;
		case 8:
			f.append(" order by bean.visitQuarter desc");
			break;
		case 7:
			f.append(" order by bean.visitMonth asc");
			break;
		case 6:
			f.append(" order by bean.visitMonth desc");
			break;
		case 5:
			f.append(" order by bean.visitWeek asc");
			break;
		case 4:
			f.append(" order by bean.visitWeek desc");
			break;
		case 3:
			f.append(" order by bean.visitToday asc");
			break;
		case 2:
			f.append(" order by bean.visitTotal desc");
			break;
		case 1:
			f.append(" order by bean.id asc");
			break;
		default:
			f.append(" order by bean.id desc");
			break;
		}
		return find(f, pageNo, pageSize);
	}

	public Pagination getArticleForMember(Long memberId, Long webId,
			Boolean draft, Boolean check, Boolean reject, int pageNo,
			int pageSize) {
		Finder f = Finder
				.create("from Article bean where bean.member.id=:memberId");
		f.setParam("memberId", memberId);
		if (webId != null) {
			f.append(" and bean.website.id=:webId").setParam("webId", webId);
		}
		if (draft != null) {
			f.append(" and bean.draft=:draft").setParam("draft", draft);
		}
		if (check != null) {
			f.append(" and bean.check=:check").setParam("check", check);
		}
		if (reject != null) {
			f.append(" and bean.reject=:reject").setParam("reject", reject);
			if (reject) {
				f.append(" and bean.checkStep=-1");
			}
		}
		f.append(" order by bean.id desc");
		return find(f, pageNo, pageSize);
	}

	public int luceneWriteIndex(IndexWriter writer, Date startDate, String root)
			throws CorruptIndexException, IOException {
		Finder f = Finder.create("from Article bean where bean.check=true");
		if (startDate != null) {
			f.append(" and bean.releaseDate >= :startDate");
			f.setParam("startDate", startDate);
		}
		Session session = getSession();
		ScrollableResults articles = f.createQuery(session).setCacheMode(
				CacheMode.IGNORE).scroll(ScrollMode.FORWARD_ONLY);
		int count = 0;
		Article article;
		while (articles.next()) {
			article = (Article) articles.get(0);
			article.setRootReal(root);
			writer.addDocument(LuceneArticle.createDocument(article));
			if (++count % 20 == 0) {
				session.clear();
			}
		}
		return count;
	}
}