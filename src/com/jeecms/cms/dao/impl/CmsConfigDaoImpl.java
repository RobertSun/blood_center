package com.jeecms.cms.dao.impl;

import org.springframework.stereotype.Repository;

import com.jeecms.cms.dao.CmsConfigDao;
import com.jeecms.cms.entity.CmsConfig;
import com.jeecms.core.JeeCoreDaoImpl;

@Repository
public class CmsConfigDaoImpl extends JeeCoreDaoImpl<CmsConfig> implements
		CmsConfigDao {

}