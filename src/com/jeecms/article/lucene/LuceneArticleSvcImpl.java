package com.jeecms.article.lucene;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.DateTools;
import org.apache.lucene.document.DateTools.Resolution;
import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.Searcher;
import org.apache.lucene.search.TermRangeQuery;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.LockObtainFailedException;
import org.apache.lucene.store.SimpleFSDirectory;
import org.apache.lucene.util.Version;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeecms.article.dao.ArticleDao;
import com.jeecms.article.entity.Article;
import com.jeecms.article.manager.ArticleMng;
import com.jeecms.common.page.Pagination;
import com.jeecms.common.struts2.ContextPvd;

@Service
public class LuceneArticleSvcImpl implements LuceneArticleSvc {
	public int index(String path, Date startDate) throws CorruptIndexException,
			LockObtainFailedException, IOException {
		boolean create = startDate == null;
		IndexWriter writer = new IndexWriter(new SimpleFSDirectory(new File(
				path)), new StandardAnalyzer(Version.LUCENE_30), create,
				IndexWriter.MaxFieldLength.LIMITED);
		try {
			if (!create) {
				writer.deleteDocuments(new TermRangeQuery(
						LuceneArticle.RELEASE_DATE, DateTools.dateToString(
								startDate, Resolution.DAY), null, true, true));
			}
			int count = articleDao.luceneWriteIndex(writer, startDate,
					contextPvd.getAppRealPath(""));
			writer.optimize();
			return count;
		} finally {
			writer.close();
		}

	}

	public Pagination search(String path, String queryString, Long websiteId,
			Long channelId, int pageNo, int pageSize)
			throws CorruptIndexException, IOException, ParseException {

		Searcher searcher = new IndexSearcher(new SimpleFSDirectory(new File(
				path)));
		try {
			Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_30);
			Query query = LuceneArticle.createQuery(queryString, websiteId,
					channelId, null, analyzer);
			TopDocs docs = searcher.search(query, pageNo * pageSize);
			Pagination p = LuceneArticle.getResult(searcher, docs, pageNo,
					pageSize);
			List<?> list = p.getList();
			List<Article> mlist = new ArrayList<Article>(list.size());
			for (Object id : list) {
				mlist.add(articleMng.findById((Long) id));
			}
			p.setList(mlist);
			return p;
		} finally {
			searcher.close();
		}
	}

	private ArticleMng articleMng;
	private ArticleDao articleDao;
	private ContextPvd contextPvd;

	@Autowired
	public void setArticleDao(ArticleDao articleDao) {
		this.articleDao = articleDao;
	}

	@Autowired
	public void setArticleMng(ArticleMng articleMng) {
		this.articleMng = articleMng;
	}

	@Autowired
	public void setContextPvd(ContextPvd contextPvd) {
		this.contextPvd = contextPvd;
	}

}
