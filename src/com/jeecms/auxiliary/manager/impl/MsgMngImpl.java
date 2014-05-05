package com.jeecms.auxiliary.manager.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeecms.auxiliary.dao.MsgDao;
import com.jeecms.auxiliary.entity.AuxiConfig;
import com.jeecms.auxiliary.entity.Msg;
import com.jeecms.auxiliary.entity.MsgCtg;
import com.jeecms.auxiliary.manager.MsgMng;
import com.jeecms.common.hibernate3.Condition;
import com.jeecms.common.hibernate3.OrderBy;
import com.jeecms.common.hibernate3.Updater;
import com.jeecms.common.page.Pagination;
import com.jeecms.core.JeeCoreManagerImpl;
import com.jeecms.core.entity.Website;

@Service
@Transactional
public class MsgMngImpl extends JeeCoreManagerImpl<Msg> implements MsgMng {
	public Pagination getPage(Long webId, int pageNo, int pageSize) {
		return getDao().getPage(webId, pageNo, pageSize);
	}
	
	public Pagination getPageByMemId(Long webId,Long memId, int pageNo, int pageSize){
		return getDao().getPageByMemId(webId, memId, pageNo, pageSize);
	}

	public Pagination getForTag(Long webId, Long ctgId, boolean isRecommand,
			boolean isCheck, int orderBy, boolean isPage, int firstResult,
			int pageNo, int pageSize) {
		Msg example = new Msg();
		example.setWebsite(new Website(webId));
		if (ctgId != null) {
			example.setCtg(new MsgCtg(ctgId));
		}
		if (isRecommand) {
			example.setRecommend(isRecommand);
		}
		if (isCheck) {
			example.setCheck(isCheck);
		}
		Condition[] conds = null;
		switch (orderBy) {
		case 0:
			conds = new Condition[] { OrderBy.desc("id") };
			break;
		case 1:
			conds = new Condition[] { OrderBy.asc("id") };
			break;
		}
		if (isPage) {
			return findByEg(example, conds, pageNo, pageSize);
		} else {
			List<Msg> list = findByEgList(example, conds, firstResult, pageSize);
			return new Pagination(pageNo, Pagination.DEF_COUNT, list.size(),
					list);
		}
	}

	@Override
	public Object updateByUpdater(Updater updater) {
		Msg msg = (Msg) super.updateByUpdater(updater);
		return msg;
	}

	@Override
	public Msg save(Msg msg) {
		msg.setConfig(new AuxiConfig(msg.getWebsite().getId()));
		super.save(msg);
		return msg;
	}

	@Override
	public Msg findById(Serializable id) {
		Msg msg = super.findById(id);
		return msg;
	}

	@Override
	public Msg deleteById(Serializable id) {
		Msg msg = super.deleteById(id);
		return msg;
	}

	@Autowired
	public void setDao(MsgDao dao) {
		super.setDao(dao);
	}

	public MsgDao getDao() {
		return (MsgDao) super.getDao();
	}

	/**
	 * @see com.jeecms.auxiliary.manager.MsgMng#isDuplicated(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public boolean isDuplicated(String ip, String title, String content) {
		Msg eg = new Msg();
		eg.setIp(ip);
		eg.setTitle(title);
		eg.setContentMember(content);
		List<Msg> msgs =  findByEgList(eg, new Condition[] { OrderBy
				.asc(Msg.PROP_ID) });
		if (msgs != null && !msgs.isEmpty()) {
			return true;
		}
		return false;
	}

}
