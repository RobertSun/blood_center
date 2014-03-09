package com.jeecms.auxiliary.dao.impl;

import org.springframework.stereotype.Repository;

import com.jeecms.auxiliary.dao.VoteTopicDao;
import com.jeecms.auxiliary.entity.VoteTopic;
import com.jeecms.common.hibernate3.Finder;
import com.jeecms.common.page.Pagination;
import com.jeecms.core.JeeCoreDaoImpl;

@Repository
public class VoteTopicDaoImpl extends JeeCoreDaoImpl<VoteTopic> implements
		VoteTopicDao {
	public VoteTopic getCurrentTopic(Long webId) {
		String hql = "select v from VoteTopic v where v.website.id=? and v.current=true and v.disabled=false order by v.id desc";
		return (VoteTopic) findUnique(hql, webId);
	}

	public Pagination getPage(Long webId, int pageNo, int pageSize) {
		String hql = "select bean from VoteTopic bean where bean.website.id=:webId order by bean.id desc";
		Finder f = Finder.create(hql).setParam("webId", webId);
		return find(f, pageNo, pageSize);
	}
}