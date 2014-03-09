package com.jeecms.download.manager;

import com.jeecms.cms.entity.CmsAdmin;
import com.jeecms.cms.entity.CmsMember;
import com.jeecms.common.page.Pagination;
import com.jeecms.core.JeeCoreManager;
import com.jeecms.core.util.UploadRule;
import com.jeecms.download.entity.Download;

public interface DownloadMng extends JeeCoreManager<Download> {
	public Pagination getForTag(Long webId, Long chnlId, Long ctgId,
			String searchKey, Boolean hasTitleImg, boolean recommend,
			int topLevel, int orderBy, boolean isPage, int firstResult,
			int pageNo, int pageSize);

	public Pagination getPage(Long chnlId, int pageNo, int pageSize);

	public Pagination getRightDownload(Long webId, Long chnlId, Long adminId,
			boolean isMy, int status, String title, int order, int pageNo,
			int pageSize);

	public Download saveDownload(Download bean, CmsAdmin admin,
			CmsMember member, UploadRule rule, String resUrl,
			String downloadAttch, long topTime);

	public Download updateDownload(Download bean, CmsAdmin admin,
			CmsMember member, UploadRule rule, String resUrl,
			String downloadAttch, long topTime);

	public Pagination getDownloadBySort(Long webId, Long chnlId, Long typeId,
			int status, String title, int order, int pageNo, int pageSize);
}