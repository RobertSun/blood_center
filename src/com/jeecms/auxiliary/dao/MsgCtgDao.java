package com.jeecms.auxiliary.dao;

import java.util.List;

import com.jeecms.auxiliary.entity.MsgCtg;
import com.jeecms.core.JeeCoreDao;

public interface MsgCtgDao extends JeeCoreDao<MsgCtg> {
	public List<MsgCtg> getList(Long webId);
}