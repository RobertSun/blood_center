package com.jeecms.auxiliary.manager;

import com.jeecms.auxiliary.entity.VoteRecord;
import com.jeecms.core.JeeCoreManager;

/**
 * 投票主题manager
 * 
 * @author liufang
 * 
 */
public interface VoteRecordMng extends JeeCoreManager<VoteRecord> {
	/**
	 * 查找会员在主题中最近的一次投票时间
	 * 
	 * @param memberId
	 * @param topicId
	 * @return
	 */
	public long getTimeByMemberId(Long memberId, Long topicId);

	/**
	 * 查找IP在主题中最近的一次投票时间
	 * 
	 * @param voteIp
	 * @param topicId
	 * @return
	 */
	public long getTimeByIp(String voteIp, Long topicId);

	/**
	 * 查找COOKIE在主题中最近的一次投票时间
	 * 
	 * @param voteCookie
	 * @param topicId
	 * @return
	 */
	public long getTimeByCookie(String voteCookie, Long topicId);

	/**
	 * 查找主题在IP、cookie、guestId的投票记录
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