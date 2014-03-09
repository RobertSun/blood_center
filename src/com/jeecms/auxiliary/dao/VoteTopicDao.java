package com.jeecms.auxiliary.dao;

import com.jeecms.auxiliary.entity.VoteTopic;
import com.jeecms.common.page.Pagination;
import com.jeecms.core.JeeCoreDao;

public interface VoteTopicDao extends JeeCoreDao<VoteTopic> {
	/**
	 * ��õ�ǰ���µ�ͶƱ
	 * 
	 * @param webId
	 * @return
	 */
	public VoteTopic getCurrentTopic(Long webId);

	/**
	 * ���ͶƱ�б�
	 * 
	 * @param webId
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public Pagination getPage(Long webId, int pageNo, int pageSize);
}