package com.jeecms.auxiliary.manager;

import com.jeecms.auxiliary.entity.Booking;
import com.jeecms.common.page.Pagination;
import com.jeecms.core.JeeCoreManager;

public interface BookingMng extends JeeCoreManager<Booking> {
	public Pagination getPage(Long webId, int pageNo, int pageSize);
}
