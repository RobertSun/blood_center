package com.jeecms.auxiliary.manager;

import com.jeecms.auxiliary.entity.VoteRecord;
import com.jeecms.core.JeeCoreManager;

/**
 * ͶƱ����manager
 * 
 * @author liufang
 * 
 */
public interface VoteRecordMng extends JeeCoreManager<VoteRecord> {
	/**
	 * ���һ�Ա�������������һ��ͶƱʱ��
	 * 
	 * @param memberId
	 * @param topicId
	 * @return
	 */
	public long getTimeByMemberId(Long memberId, Long topicId);

	/**
	 * ����IP�������������һ��ͶƱʱ��
	 * 
	 * @param voteIp
	 * @param topicId
	 * @return
	 */
	public long getTimeByIp(String voteIp, Long topicId);

	/**
	 * ����COOKIE�������������һ��ͶƱʱ��
	 * 
	 * @param voteCookie
	 * @param topicId
	 * @return
	 */
	public long getTimeByCookie(String voteCookie, Long topicId);

	/**
	 * ����������IP��cookie��guestId��ͶƱ��¼
	 * 
	 * @param voteIp
	 * @param voteCookie
	 * @param memberId
	 * @param topicId
	 * @return
	 */
	public VoteRecord getVoteRecord(String voteIp, String voteCookie,
			Long memberId, Long topicId);
}