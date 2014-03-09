package com.jeecms.auxiliary.manager.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeecms.auxiliary.dao.MsgCtgDao;
import com.jeecms.auxiliary.entity.MsgCtg;
import com.jeecms.auxiliary.manager.MsgCtgMng;
import com.jeecms.common.hibernate3.Updater;
import com.jeecms.core.JeeCoreManagerImpl;

@Service
@Transactional
public class MsgCtgMngImpl extends JeeCoreManagerImpl<MsgCtg> implements
		MsgCtgMng {
	public List<MsgCtg> getList(Long webId) {
		return getDao().getList(webId);
	}

	@Override
	public Object updateByUpdater(Updater updater) {
		MsgCtg ctg = (MsgCtg) super.updateByUpdater(updater);
		return ctg;
	}

	@Override
	public MsgCtg save(MsgCtg ctg) {
		super.save(ctg);
		return ctg;
	}

	@Override
	public MsgCtg findById(Serializable id) {
		MsgCtg ctg = super.findById(id);
		return ctg;
	}

	@Override
	public MsgCtg deleteById(Serializable id) {
		MsgCtg ctg = super.deleteById(id);
		return ctg;
	}

	@Autowired
	public void setDao(MsgCtgDao dao) {
		super.setDao(dao);
	}

	public MsgCtgDao getDao() {
		return (MsgCtgDao) super.getDao();
	}
}
