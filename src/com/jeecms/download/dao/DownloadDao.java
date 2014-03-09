package com.jeecms.download.dao;

import com.jeecms.download.entity.Download;
import com.jeecms.common.page.Pagination;
import com.jeecms.core.JeeCoreDao;

public interface DownloadDao extends JeeCoreDao<Download> {

	public Pagination getForTag(Long webId, Long chnlId, Long ctgId,
			String searchKey, Boolean hasTitleImg, boolean recommend,
			int topLevel, int orderBy, boolean isPage, int firstResult,
			int pageNo, int pageSize);

	public Pagination getRightDownload(Long webId, Long chnlId, Long adminId,
			boolean isMy, int status, String title, int order, int pageNo,
			int pageSize);

	public Pagination getDownloadBySort(Long webId, Long chnlId, Long typeId,
			int status, String title, int order, int pageNo, int pageSize);
}