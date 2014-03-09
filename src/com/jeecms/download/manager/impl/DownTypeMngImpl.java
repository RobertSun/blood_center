package com.jeecms.download.manager.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeecms.common.hibernate3.Updater;
import com.jeecms.core.JeeCoreManagerImpl;
import com.jeecms.download.dao.DownTypeDao;
import com.jeecms.download.entity.DownType;
import com.jeecms.download.manager.DownTypeMng;

@Service
@Transactional
public class DownTypeMngImpl extends JeeCoreManagerImpl<DownType> implements
		DownTypeMng {
	public List<DownType> getList(Long webId, boolean all) {
		return getDao().getList(webId, all);
	}

	public void updatePriority(Long[] wids, int[] prioritys) {
		for (int i = 0; i < wids.length; i++) {
			DownType entity = findById(wids[i]);
			entity.setPriority(prioritys[i]);
		}
	}

	@Override
	public Object updateByUpdater(Updater updater) {
		DownType down_type = (DownType) super.updateByUpdater(updater);
		return down_type;
	}

	@Override
	public DownType save(DownType down_type) {
		super.save(down_type);
		return down_type;
	}

	@Override
	public DownType findById(Serializable id) {
		DownType down_type = super.findById(id);
		return down_type;
	}

	@Override
	public DownType deleteById(Serializable id) {
		DownType down_type = super.deleteById(id);
		return down_type;
	}

	@Autowired
	public void setDao(DownTypeDao dao) {
		super.setDao(dao);
	}

	public DownTypeDao getDao() {
		return (DownTypeDao) super.getDao();
	}

}
