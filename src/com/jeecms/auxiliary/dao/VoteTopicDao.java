package com.jeecms.auxiliary.dao;

import com.jeecms.auxiliary.entity.VoteTopic;
import com.jeecms.common.page.Pagination;
import com.jeecms.core.JeeCoreDao;

public interface VoteTopicDao extends JeeCoreDao<VoteTopic> {
	/**
	 * 获得当前最新的投票
	 * 
	 * @param webId
	 * @return
	 */
	public VoteTopic getCurrentTopic(Long webId);

	/**
	 * 获得投票列表
	 * 
	 * @param webId
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public Pagination getPage(Long webId, int pageNo, int pageSize);
}