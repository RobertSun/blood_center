package com.jeecms.cms.dao.impl;

import org.springframework.stereotype.Repository;

import com.jeecms.cms.dao.CmsAdminDao;
import com.jeecms.cms.entity.CmsAdmin;
import com.jeecms.core.JeeCoreDaoImpl;

@Repository
public class CmsAdminDaoImpl extends JeeCoreDaoImpl<CmsAdmin> implements
		CmsAdminDao {

}