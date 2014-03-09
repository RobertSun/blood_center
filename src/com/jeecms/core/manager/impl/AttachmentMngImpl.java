package com.jeecms.core.manager.impl;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeecms.common.hibernate3.Condition;
import com.jeecms.common.hibernate3.OrderBy;
import com.jeecms.common.hibernate3.Updater;
import com.jeecms.common.page.Pagination;
import com.jeecms.core.JeeCoreManagerImpl;
import com.jeecms.core.dao.AttachmentDao;
import com.jeecms.core.entity.Attachment;
import com.jeecms.core.entity.Website;
import com.jeecms.core.manager.AttachmentMng;

@Service
@Transactional
public class AttachmentMngImpl extends JeeCoreManagerImpl<Attachment> implements
		AttachmentMng {
	public Pagination getPage(Long webId, int pageNo, int pageSize) {
		Attachment eg = new Attachment();
		eg.setWebsite(new Website(webId));
		return findByEg(eg, new Condition[] { OrderBy.desc("id") }, pageNo,
				pageSize);
	}

	@Override
	public Object updateByUpdater(Updater updater) {
		Attachment attachment = (Attachment) super.updateByUpdater(updater);
		return attachment;
	}

	@Override
	public Attachment save(Attachment attachment) {
		super.save(attachment);
		return attachment;
	}

	@Override
	public Attachment findById(Serializable id) {
		Attachment attachment = super.findById(id);
		return attachment;
	}

	@Override
	public Attachment deleteById(Serializable id) {
		Attachment attachment = super.deleteById(id);
		return attachment;
	}

	@Autowired
	public void setDao(AttachmentDao dao) {
		super.setDao(dao);
	}

	public AttachmentDao getDao() {
		return (AttachmentDao) super.getDao();
	}

}
