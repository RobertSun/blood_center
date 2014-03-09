package com.jeecms.cms.dao.impl;

import org.springframework.stereotype.Repository;

import com.jeecms.cms.dao.CmsMemberDao;
import com.jeecms.cms.entity.CmsMember;
import com.jeecms.core.JeeCoreDaoImpl;

@Repository
public class CmsMemberDaoImpl extends JeeCoreDaoImpl<CmsMember> implements
		CmsMemberDao {

}