package com.jeecms.auxiliary.dao.impl;

import org.springframework.stereotype.Repository;

import com.jeecms.auxiliary.dao.MsgDao;
import com.jeecms.auxiliary.entity.Msg;
import com.jeecms.common.hibernate3.Finder;
import com.jeecms.common.page.Pagination;
import com.jeecms.core.JeeCoreDaoImpl;

@Repository
public class MsgDaoImpl extends JeeCoreDaoImpl<Msg> implements MsgDao {
	public Pagination getPage(Long webId, int pageNo, int pageSize) {
		String hql = "from Msg bean where bean.website.id=:webId order by bean.id desc";
		Finder f = Finder.create(hql).setParam("webId", webId);
		return find(f, pageNo, pageSize);
	}
	
	public Pagination getPageByMemId(Long webId,Long memId, int pageNo, int pageSize) {
		String hql = "from Msg bean where bean.website.id=:webId and bean.member.id=:memId order by bean.id desc";
		Finder f = Finder.create(hql).setParam("webId", webId).setParam("memId", memId);
		return find(f, pageNo, pageSize);
	}
}