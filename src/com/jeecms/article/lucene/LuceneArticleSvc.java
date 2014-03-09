package com.jeecms.article.lucene;

import java.io.IOException;
import java.util.Date;

import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.store.LockObtainFailedException;

import com.jeecms.common.page.Pagination;

public interface LuceneArticleSvc {
	public int index(String path, Date startDate) throws CorruptIndexException,
			LockObtainFailedException, IOException;

	public Pagination search(String path, String queryString, Long websiteId,
			Long channelId, int pageNo, int pageSize)
			throws CorruptIndexException, IOException, ParseException;
}
