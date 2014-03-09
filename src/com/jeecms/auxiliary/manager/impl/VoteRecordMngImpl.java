package com.jeecms.auxiliary.manager.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeecms.auxiliary.dao.VoteRecordDao;
import com.jeecms.auxiliary.entity.VoteRecord;
import com.jeecms.auxiliary.manager.VoteRecordMng;
import com.jeecms.core.JeeCoreManagerImpl;

@Service
@Transactional
public class VoteRecordMngImpl extends JeeCoreManagerImpl<VoteRecord> implements
		VoteRecordMng {
	public long getTimeByMemberId(Long memberId, Long topicId) {
		Date d = getDao().getTimeByMemberId(memberId, topicId);
		if (d != null) {
			return d.getTime();
		} else {
			return 0;
		}
	}

	public long getTimeByIp(String voteIp, Long topicId) {
		Date d = getDao().getTimeByIp(voteIp, topicId);
		if (d != null) {
			return d.getTime();
		} else {
			return 0;
		}
	}

	public long getTimeByCookie(String voteCookie, Long topicId) {
		Date d = getDao().getTimeByCookie(voteCookie, topicId);
		if (d != null) {
			return d.getTime();
		} else {
			return 0;
		}

	}

	public VoteRecord getVoteRecord(String voteIp, String voteCookie,
			Long memberId, Long topicId) {
		return getDao().getVoteRecord(voteIp, voteCookie, memberId, topicId);
	}

	@Autowired
	public void setVoteRecordDao(VoteRecordDao dao) {
		super.setDao(dao);
	}

	public VoteRecordDao getDao() {
		return (VoteRecordDao) super.getDao();
	}
}