package com.jeecms.auxiliary.manager.impl;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeecms.auxiliary.dao.VoteTopicDao;
import com.jeecms.auxiliary.entity.VoteItem;
import com.jeecms.auxiliary.entity.VoteRecord;
import com.jeecms.auxiliary.entity.VoteTopic;
import com.jeecms.auxiliary.exception.VoteException;
import com.jeecms.auxiliary.manager.VoteRecordMng;
import com.jeecms.auxiliary.manager.VoteTopicMng;
import com.jeecms.common.hibernate3.Updater;
import com.jeecms.common.page.Pagination;
import com.jeecms.common.util.ComUtils;
import com.jeecms.core.JeeCoreManagerImpl;
import com.jeecms.core.entity.Member;

@Service
@Transactional
public class VoteTopicMngImpl extends JeeCoreManagerImpl<VoteTopic> implements
		VoteTopicMng {

	public Pagination getPage(Long webId, int pageNo, int pageSize) {
		return getDao().getPage(webId, pageNo, pageSize);
	}

	public VoteTopic updateTopic(VoteTopic bean, Set<VoteItem> items) {
		VoteTopic topic = findById(bean.getId());
		Set<VoteItem> oItems = topic.getItems();
		Set<VoteItem> rmItems = new HashSet<VoteItem>();
		// 删除
		boolean isContain = false;
		for (VoteItem oit : oItems) {
			for (VoteItem it : items) {
				if (oit.getId().equals(it.getId())) {
					isContain = true;
					break;
				}
			}
			if (!isContain) {
				rmItems.add(oit);
			}
			isContain = false;
		}
		oItems.removeAll(rmItems);
		// 更新或添加
		for (VoteItem it : items) {
			if (it.getId() == null) {
				oItems.add(it);
			} else {
				for (VoteItem oit : oItems) {
					if (it.getId().equals(oit.getId())) {
						merge(it);
					}
				}
			}
		}
		Updater updater = Updater.create(bean);
		updater.include("startTime");
		updater.include("endTime");
		return (VoteTopic) updateByUpdater(updater);
	}

	public VoteTopic getCurrentTopic(Long webId) {
		return getDao().getCurrentTopic(webId);
	}

	public VoteTopic vote(Long topicId, Long[] voteItems, Long memberId,
			String ip, String cookie) throws VoteException {
		VoteTopic topic = findById(topicId);
		if (topic.getDisabled()) {
			throw new VoteException("这个投票主题已经被关闭！");
		}
		if (voteItems == null || voteItems.length <= 0) {
			return topic;
		}
		if (voteItems.length > topic.getMultiSelect()) {
			throw new VoteException("您投票的选项个数大于允许的个数！");
		}
		long now = System.currentTimeMillis();
		Date start = topic.getStartTime();
		if (start != null && now < start.getTime()) {
			throw new VoteException("投票还没有开始！开始时间是："
					+ ComUtils.dataFormatWhole(start));
		}
		Date end = topic.getEndTime();
		if (end != null && now > end.getTime()) {
			throw new VoteException("投票已经结束！结束时间是："
					+ ComUtils.dataFormatWhole(end));
		}
		long repeat = topic.getRepeateHour() * 60 * 60 * 1000;
		long vtime = 0;
		if (topic.getRestrictMember()) {
			if (memberId == null) {
				throw new VoteException("这个主题需要登录才能投票，请您先登录！");
			}
			vtime = voteRecordMng.getTimeByMemberId(memberId, topicId);
			if (vtime + repeat > now) {
				throw new VoteException("该主题不能在" + topic.getRepeateHour()
						+ "小时内重复投票。您上次的投票时间是："
						+ ComUtils.dataFormatWhole(new Date(vtime)));
			}
		}
		if (topic.getRestrictIp() || cookie == null) {
			vtime = voteRecordMng.getTimeByIp(ip, topicId);
			if (vtime + repeat > now) {
				throw new VoteException("该主题不能在" + topic.getRepeateHour()
						+ "小时内重复投票。您上次的投票时间是："
						+ ComUtils.dataFormatWhole(new Date(vtime)));
			}
		}
		if (topic.getRestrictCookie() && cookie != null) {
			vtime = voteRecordMng.getTimeByCookie(cookie, topicId);
			if (vtime + repeat > now) {
				throw new VoteException("该主题不能在" + topic.getRepeateHour()
						+ "小时内重复投票。您上次的投票时间是："
						+ ComUtils.dataFormatWhole(new Date(vtime)));
			}
		}
		topic.setTotalCount(topic.getTotalCount() + voteItems.length);
		for (VoteItem vi : topic.getItems()) {
			for (Long itemId : voteItems) {
				if (vi.getId().equals(itemId)) {
					vi.setVoteCount(vi.getVoteCount() + 1);
				}
			}
		}
		VoteRecord record = voteRecordMng.getVoteRecord(ip, cookie, memberId,
				topicId);
		if (record == null) {
			record = new VoteRecord();
			record.setTopic(topic);
		}
		record.setVoteCookie(cookie);
		record.setVoteIp(ip);
		if (memberId != null) {
			record.setMember(new Member(memberId));
		}
		record.setVoteTime(ComUtils.now());
		saveOrUpdate(record);
		return topic;
	}

	@Override
	public Object updateByUpdater(Updater updater) {
		VoteTopic topic = (VoteTopic) super.updateByUpdater(updater);
		return topic;
	}

	@Override
	public VoteTopic save(VoteTopic topic) {
		topic.setTotalCount(0L);
		super.save(topic);
		return topic;
	}

	@Override
	public VoteTopic findById(Serializable id) {
		VoteTopic topic = super.findById(id);
		return topic;
	}

	@Override
	public VoteTopic deleteById(Serializable id) {
		VoteTopic topic = super.deleteById(id);
		return topic;
	}

	@Autowired
	private VoteRecordMng voteRecordMng;

	@Autowired
	public void setDao(VoteTopicDao dao) {
		super.setDao(dao);
	}

	public VoteTopicDao getDao() {
		return (VoteTopicDao) super.getDao();
	}
}