package com.jeecms.cms.manager.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeecms.cms.dao.ContentCtgDao;
import com.jeecms.cms.entity.ContentCtg;
import com.jeecms.cms.manager.ContentCtgMng;
import com.jeecms.common.hibernate3.Condition;
import com.jeecms.common.hibernate3.OrderBy;
import com.jeecms.common.hibernate3.Updater;
import com.jeecms.core.JeeCoreManagerImpl;
import com.jeecms.core.entity.Website;
import com.jeecms.core.service.IdCacheSvc;

@Service
@Transactional
public class ContentCtgMngImpl extends JeeCoreManagerImpl<ContentCtg> implements
		ContentCtgMng {
	public ContentCtg getContentCtg(Long webId, String label) {
		Long id = idCacheSvc.get(ContentCtg.REF, String.valueOf(webId), label);
		// ’“≤ªµΩª∫¥Ê
		if (id == null) {
			ContentCtg ctg = getDao().getContentCtg(webId, label);
			// –¥»Îª∫¥Ê
			if (ctg != null) {
				idCacheSvc.put(ctg.getId(), ContentCtg.REF, String
						.valueOf(webId), label);
			}
			return ctg;
		} else {
			return findById(id);
		}
	}

	public List<ContentCtg> getList(Long webId, Boolean disabled) {
		ContentCtg eg = new ContentCtg();
		eg.setWebsite(new Website(webId));
		eg.setDisabled(disabled);
		return findByEgList(eg, new Condition[] { OrderBy
				.asc(ContentCtg.PROP_LABEL) });
	}

	public ContentCtg getFirstCtg(Long webId) {
		List<ContentCtg> list = getList(webId, null);
		if (list.size() > 0) {
			return list.get(0);
		} else {
			return null;
		}
	}

	@Override
	public Object updateByUpdater(Updater updater) {
		ContentCtg orig = findById(((ContentCtg) updater.getBean()).getId());
		String origLabel = orig.getLabel();
		ContentCtg ctg = (ContentCtg) super.updateByUpdater(updater);
		// ¥¶¿Ìª∫¥Ê
		if (!origLabel.equals(ctg.getLabel())) {
			idCacheSvc.remove(ContentCtg.REF, String.valueOf(ctg.getWebsite()
					.getId()), origLabel);
			idCacheSvc.put(ctg.getId(), ContentCtg.REF, String.valueOf(ctg
					.getWebsite().getId()), ctg.getLabel());
		}
		return ctg;
	}

	@Override
	public ContentCtg save(ContentCtg ctg) {
		super.save(ctg);
		return ctg;
	}

	@Override
	public ContentCtg findById(Serializable id) {
		ContentCtg ctg = super.findById(id);
		return ctg;
	}

	@Override
	public ContentCtg deleteById(Serializable id) {
		ContentCtg ctg = super.deleteById(id);
		// …æ≥˝ª∫¥Ê
		idCacheSvc.remove(ContentCtg.REF, String.valueOf(ctg.getWebsite()
				.getId()), ctg.getLabel());
		return ctg;
	}

	public boolean checkLabel(Long webId, String label) {
		return getDao().getContentCtg(webId, label) == null;
	}

	@Autowired
	public void setDao(ContentCtgDao dao) {
		super.setDao(dao);
	}

	@Autowired
	public void setIdCacheSvc(IdCacheSvc idCacheSvc) {
		this.idCacheSvc = idCacheSvc;
	}

	private IdCacheSvc idCacheSvc;

	public ContentCtgDao getDao() {
		return (ContentCtgDao) super.getDao();
	}

}
