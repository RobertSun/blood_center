package com.jeecms.auxiliary.manager;

import java.util.Set;

import com.jeecms.auxiliary.entity.VoteItem;
import com.jeecms.auxiliary.entity.VoteTopic;
import com.jeecms.auxiliary.exception.VoteException;
import com.jeecms.common.page.Pagination;
import com.jeecms.core.JeeCoreManager;

/**
 * ͶƱ����manager
 * 
 * @author liufang
 * 
 */
public interface VoteTopicMng extends JeeCoreManager<VoteTopic> {
	/**
	 * ���ͶƱ�б�
	 * 
	 * @param webId
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public Pagination getPage(Long webId, int pageNo, int pageSize);

	/**
	 * ����ͶƱ����
	 * 
	 * @param bean
	 *            ����������
	 * @param items
	 *            ������ͶƱ��
	 * @return
	 */
	public VoteTopic updateTopic(VoteTopic bean, Set<VoteItem> items);

	/**
	 * ������µ�ͶƱ
	 * 
	 * @param webId
	 * @return
	 */
	public VoteTopic getCurrentTopic(Long webId);

	/**
	 * ͶƱ
	 * 
	 * @param topicId
	 *            ͶƱ����ID
	 * @param voteItems
	 *            ͶƱѡ��ID
	 * @param member
	 *            ͶƱ��Ա
	 * @param ip
	 *            ͶƱIP
	 * @param cookie
	 *            ͶƱcookie
	 * @return result of VotoTopic
	 * 
	 * @throws VoteException
	 */
	public VoteTopic vote(Long topicId, Long[] voteItems, Long memberId,
			String ip, String cookie) throws VoteException;
}