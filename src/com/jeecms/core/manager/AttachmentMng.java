package com.jeecms.core.manager;

import com.jeecms.common.page.Pagination;
import com.jeecms.core.JeeCoreManager;
import com.jeecms.core.entity.Attachment;

public interface AttachmentMng extends JeeCoreManager<Attachment> {

	public Pagination getPage(Long webId, int pageNo, int pageSize);
}