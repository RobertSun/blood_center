package com.jeecms.core.manager.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeecms.core.JeeCoreManagerImpl;
import com.jeecms.core.dao.GlobalDao;
import com.jeecms.core.entity.Global;
import com.jeecms.core.manager.GlobalMng;

@Service
@Transactional
public class GlobalMngImpl extends JeeCoreManagerImpl<Global> implements
		GlobalMng {
	@Autowired
	public void setDao(GlobalDao dao) {
		super.setDao(dao);
	}

	public GlobalDao getDao() {
		return (GlobalDao) super.getDao();
	}

}
