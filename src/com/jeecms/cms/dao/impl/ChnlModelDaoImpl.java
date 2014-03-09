package com.jeecms.cms.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jeecms.cms.dao.ChnlModelDao;
import com.jeecms.cms.entity.ChnlModel;
import com.jeecms.core.JeeCoreDaoImpl;

@Repository
public class ChnlModelDaoImpl extends JeeCoreDaoImpl<ChnlModel> implements
		ChnlModelDao {
	@SuppressWarnings("unchecked")
	public List<ChnlModel> getHasChild(Long webId) {
		String hql = "from ChnlModel cm where cm.hasChild=true and cm.website.id=?";
		return find(hql, webId);
	}

}