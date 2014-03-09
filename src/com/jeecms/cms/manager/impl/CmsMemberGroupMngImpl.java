package com.jeecms.cms.manager.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeecms.cms.dao.CmsMemberGroupDao;
import com.jeecms.cms.entity.CmsMemberGroup;
import com.jeecms.cms.manager.CmsMemberGroupMng;
import com.jeecms.common.hibernate3.Updater;
import com.jeecms.core.JeeCoreManagerImpl;

@Service
@Transactional
public class CmsMemberGroupMngImpl extends JeeCoreManagerImpl<CmsMemberGroup>
		implements CmsMemberGroupMng {
	public List<CmsMemberGroup> getList(Long webId, int fromLevel, boolean asc) {
		return getDao().getList(webId, fromLevel, asc);
	}

	@Override
	public Object updateByUpdater(Updater updater) {
		CmsMemberGroup group = (CmsMemberGroup) super.updateByUpdater(updater);
		return group;
	}

	@Override
	public CmsMemberGroup save(CmsMemberGroup group) {
		super.save(group);
		return group;
	}

	@Override
	public CmsMemberGroup findById(Serializable id) {
		CmsMemberGroup group = super.findById(id);
		return group;
	}

	@Override
	public CmsMemberGroup deleteById(Serializable id) {
		CmsMemberGroup group = super.deleteById(id);
		return group;
	}

	@Autowired
	public void setDao(CmsMemberGroupDao dao) {
		super.setDao(dao);
	}

	public CmsMemberGroupDao getDao() {
		return (CmsMemberGroupDao) super.getDao();
	}

}
