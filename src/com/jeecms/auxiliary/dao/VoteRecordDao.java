package com.jeecms.auxiliary.dao;

import java.util.Date;

import com.jeecms.auxiliary.entity.VoteRecord;
import com.jeecms.core.JeeCoreDao;

public interface VoteRecordDao extends JeeCoreDao<VoteRecord> {

	public Date getTimeByMemberId(Long memberId, Long topicId);

	public Date getTimeByIp(String voteIp, Long topicId);

	public Date getTimeByCookie(String voteCookie, Long topicId);

	public VoteRecord getVoteRecord(String voteIp, String voteCookie,
			Long memberId, Long topicId);
}