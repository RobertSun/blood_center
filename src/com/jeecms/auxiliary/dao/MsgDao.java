package com.jeecms.auxiliary.dao;

import com.jeecms.auxiliary.entity.Msg;
import com.jeecms.common.page.Pagination;
import com.jeecms.core.JeeCoreDao;

public interface MsgDao extends JeeCoreDao<Msg> {
	public Pagination getPage(Long webId, int pageNo, int pageSize);
	
	public Pagination getPageByMemId(Long webId,Long memId, int pageNo, int pageSize);
}