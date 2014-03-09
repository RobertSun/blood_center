package com.jeecms.article.lucene;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.DateTools;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.DateTools.Resolution;
import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryParser.MultiFieldQueryParser;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.search.BooleanClause;
import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.Searcher;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.TermRangeQuery;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.util.Version;

import com.jeecms.article.entity.Article;
import com.jeecms.common.page.Pagination;

public class LuceneArticle {

	/**
	 * 获得Lucene格式的Document
	 * 
	 * @param a
	 *            文章对象
	 * @return
	 */
	public static Document createDocument(Article a) {
		Document doc = new Document();
		doc.add(new Field(ID, a.getId().toString(), Field.Store.YES,
				Field.Index.NO));
		doc.add(new Field(WEBSITE_ID, a.getWebsite().getId().toString(),
				Field.Store.NO, Field.Index.NOT_ANALYZED));
		doc.add(new Field(RELEASE_DATE, DateTools.dateToString(a
				.getReleaseDate(), Resolution.DAY), Field.Store.NO,
				Field.Index.NOT_ANALYZED));

		for (Long id : a.getChannelIds()) {
			doc.add(new Field(CHANNEL_ID_ARRAY, id.toString(), Field.Store.NO,
					Field.Index.NOT_ANALYZED));
		}

		doc.add(new Field(TITLE, a.getTitle(), Field.Store.NO,
				Field.Index.ANALYZED));
		doc.add(new Field(CONTENT, a.getContentFromFile(), Field.Store.NO,
				Field.Index.ANALYZED));
		return doc;
	}

	public static Query createQuery(String queryString, Long websiteId,
			Long channelId, Date startDate, Analyzer analyzer)
			throws ParseException {
		BooleanQuery bq = new BooleanQuery();
		Query q;
		if (!StringUtils.isBlank(queryString)) {
			q = MultiFieldQueryParser.parse(Version.LUCENE_30, queryString,
					QUERY_FIELD, QUERY_FLAGS, analyzer);
			bq.add(q, BooleanClause.Occur.MUST);
		}
		if (websiteId != null) {
			q = new TermQuery(new Term(WEBSITE_ID, websiteId.toString()));
			bq.add(q, BooleanClause.Occur.MUST);
		}
		if (channelId != null) {
			q = new TermQuery(new Term(CHANNEL_ID_ARRAY, channelId.toString()));
			bq.add(q, BooleanClause.Occur.MUST);
		}
		if (startDate != null) {
			q = new TermRangeQuery(RELEASE_DATE, DateTools.dateToString(
					startDate, Resolution.DAY), null, true, true);
			bq.add(q, BooleanClause.Occur.MUST);
		}
		return bq;
	}

	public static void delete(Date startDate, IndexWriter writer)
			throws CorruptIndexException, IOException {
		writer.deleteDocuments(new TermRangeQuery(RELEASE_DATE, DateTools
				.dateToString(startDate, Resolution.DAY), null, true, true));
	}

	public static Pagination getResult(Searcher searcher, TopDocs docs,
			int pageNo, int pageSize) throws CorruptIndexException, IOException {
		List<Long> list = new ArrayList<Long>(pageSize);
		ScoreDoc[] hits = docs.scoreDocs;
		int endIndex = pageNo * pageSize;
		int len = hits.length;
		if (endIndex > len) {
			endIndex = len;
		}
		for (int i = (pageNo - 1) * pageSize; i < endIndex; i++) {
			Document d = searcher.doc(hits[i].doc);
			list.add(Long.valueOf(d.getField(ID).stringValue()));
		}
		return new Pagination(pageNo, pageSize, docs.totalHits, list);
	}

	public static final String ID = "id";
	public static final String WEBSITE_ID = "websiteId";
	public static final String CHANNEL_ID_ARRAY = "channelIdAttry";
	public static final String RELEASE_DATE = "releaseDate";
	public static final String TITLE = "title";
	public static final String CONTENT = "content";
	public static final String[] QUERY_FIELD = { TITLE, CONTENT };
	public static final BooleanClause.Occur[] QUERY_FLAGS = {
			BooleanClause.Occur.SHOULD, BooleanClause.Occur.SHOULD };
}
