package com.jeecms.auxiliary.dao.impl;

import org.springframework.stereotype.Repository;

import com.jeecms.auxiliary.dao.BookingDao;
import com.jeecms.auxiliary.entity.Booking;
import com.jeecms.common.hibernate3.Finder;
import com.jeecms.common.page.Pagination;
import com.jeecms.core.JeeCoreDaoImpl;

@Repository
public class BookingDaoImpl extends JeeCoreDaoImpl<Booking> implements BookingDao {

	@Override
	public Pagination getPage(Long webId, int pageNo, int pageSize) {
		String hql = "from Booking bean where bean.website.id=:webId order by bean.id desc";
		Finder f = Finder.create(hql).setParam("webId", webId);
		return find(f, pageNo, pageSize);
	}
}
