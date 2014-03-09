package com.jeecms.auxiliary.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jeecms.auxiliary.dao.MsgCtgDao;
import com.jeecms.auxiliary.entity.MsgCtg;
import com.jeecms.core.JeeCoreDaoImpl;

@Repository
public class MsgCtgDaoImpl extends JeeCoreDaoImpl<MsgCtg> implements MsgCtgDao {

	@SuppressWarnings("unchecked")
	public List<MsgCtg> getList(Long webId) {
		String hql = "from MsgCtg bean where bean.website.id=?";
		return find(hql, webId);
	}
}