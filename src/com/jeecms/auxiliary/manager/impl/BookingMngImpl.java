package com.jeecms.auxiliary.manager.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeecms.auxiliary.dao.BookingDao;
import com.jeecms.auxiliary.entity.Booking;
import com.jeecms.auxiliary.manager.BookingMng;
import com.jeecms.common.page.Pagination;
import com.jeecms.core.JeeCoreManagerImpl;

@Service
@Transactional
public class BookingMngImpl extends JeeCoreManagerImpl<Booking> implements BookingMng {
	@Autowired
	public void setDao(BookingDao dao) {
		super.setDao(dao);
	}

	public BookingDao getDao() {
		return (BookingDao) super.getDao();
	}

	@Override
	public Pagination getPage(Long webId, int pageNo, int pageSize) {
		return getDao().getPage(webId, pageNo, pageSize);
	}
}
