package com.jeecms.auxiliary.manager;

import com.jeecms.auxiliary.entity.Msg;
import com.jeecms.common.page.Pagination;
import com.jeecms.core.JeeCoreManager;

public interface MsgMng extends JeeCoreManager<Msg> {
	public Pagination getPage(Long webId, int pageNo, int pageSize);
	
	public Pagination getPageByMemId(Long webId,Long memId, int pageNo, int pageSize);

	public Pagination getForTag(Long webId, Long ctgId, boolean isRecommand,
			boolean isCheck, int orderBy, boolean isPage, int firstResult,
			int pageNo, int pageSize);
	
	/**
	 * <p>Title: isDuplicated</p>
	 * <p>Description: 检查是否有完全重复的问题 .</p>
	 * @param ip
	 * @param title
	 * @param content
	 * @return boolean
	 */
	boolean isDuplicated(String ip, String title, String content);
}