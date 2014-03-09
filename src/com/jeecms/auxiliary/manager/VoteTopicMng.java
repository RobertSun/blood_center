package com.jeecms.auxiliary.manager;

import java.util.Set;

import com.jeecms.auxiliary.entity.VoteItem;
import com.jeecms.auxiliary.entity.VoteTopic;
import com.jeecms.auxiliary.exception.VoteException;
import com.jeecms.common.page.Pagination;
import com.jeecms.core.JeeCoreManager;

/**
 * 投票主题manager
 * 
 * @author liufang
 * 
 */
public interface VoteTopicMng extends JeeCoreManager<VoteTopic> {
	/**
	 * 获得投票列表
	 * 
	 * @param webId
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public Pagination getPage(Long webId, int pageNo, int pageSize);

	/**
	 * 更新投票主题
	 * 
	 * @param bean
	 *            待更新主题
	 * @param items
	 *            待更新投票项
	 * @return
	 */
	public VoteTopic updateTopic(VoteTopic bean, Set<VoteItem> items);

	/**
	 * 获得最新的投票
	 * 
	 * @param webId
	 * @return
	 */
	public VoteTopic getCurrentTopic(Long webId);

	/**
	 * 投票
	 * 
	 * @param topicId
	 *            投票主题ID
	 * @param voteItems
	 *            投票选项ID
	 * @param member
	 *            投票会员
	 * @param ip
	 *            投票IP
	 * @param cookie
	 *            投票cookie
	 * @return result of VotoTopic
	 * 
	 * @throws VoteException
	 */
	public VoteTopic vote(Long topicId, Long[] voteItems, Long memberId,
			String ip, String cookie) throws VoteException;
}