package com.jeecms.auxiliary.manager;

import java.util.List;

import com.jeecms.auxiliary.entity.MsgCtg;
import com.jeecms.core.JeeCoreManager;

public interface MsgCtgMng extends JeeCoreManager<MsgCtg> {
	public List<MsgCtg> getList(Long webId);

}