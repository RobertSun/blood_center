package com.jeecms.auxiliary.dao.impl;

import java.util.Date;

import org.springframework.stereotype.Repository;

import com.jeecms.auxiliary.dao.VoteRecordDao;
import com.jeecms.auxiliary.entity.VoteRecord;
import com.jeecms.core.JeeCoreDaoImpl;

@Repository
public class VoteRecordDaoImpl extends JeeCoreDaoImpl<VoteRecord> implements
		VoteRecordDao {
	public Date getTimeByMemberId(Long memberId, Long topicId) {
		String hql = "select max(vr.voteTime) as mt from VoteRecord vr where vr.member.id=? and vr.topic.id=?";
		return (Date) findUnique(hql, memberId, topicId);
	}

	public Date getTimeByIp(String voteIp, Long topicId) {
		String hql = "select max(vr.voteTime) as mt from VoteRecord vr where vr.voteIp=? and vr.topic.id=?";
		return (Date) findUnique(hql, voteIp, topicId);
	}

	public Date getTimeByCookie(String voteCookie, Long topicId) {
		String hql = "select max(vr.voteTime) as mt from VoteRecord vr where vr.voteCookie=? and vr.topic.id=?";
		return (Date) findUnique(hql, voteCookie, topicId);
	}

	public VoteRecord getVoteRecord(String voteIp, String voteCookie,
			Long memberId, Long topicId) {
		String hql = "select vr from VoteRecord vr where vr.topic.id = ? and (vr.voteIp=? or vr.voteCookie=?";
		Object[] param;
		if (memberId != null) {
			hql += " or vr.member.id=?)";
			param = new Object[] { topicId, voteIp, voteCookie, memberId };
		} else {
			hql += ")";
			param = new Object[] { topicId, voteIp, voteCookie };
		}
		return (VoteRecord) findUnique(hql, param);
	}
}