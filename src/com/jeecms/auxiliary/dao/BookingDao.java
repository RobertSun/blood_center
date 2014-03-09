package com.jeecms.auxiliary.dao;

import com.jeecms.auxiliary.entity.Booking;
import com.jeecms.common.page.Pagination;
import com.jeecms.core.JeeCoreDao;

public interface BookingDao extends JeeCoreDao<Booking> {
	public Pagination getPage(Long webId, int pageNo, int pageSize);
}
