package com.jeecms.auxiliary.dao.impl;

import org.springframework.stereotype.Repository;

import com.jeecms.auxiliary.dao.AuxiConfigDao;
import com.jeecms.auxiliary.entity.AuxiConfig;
import com.jeecms.core.JeeCoreDaoImpl;

@Repository
public class AuxiConfigDaoImpl extends JeeCoreDaoImpl<AuxiConfig> implements
		AuxiConfigDao {

}