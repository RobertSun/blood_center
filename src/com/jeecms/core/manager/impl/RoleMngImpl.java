package com.jeecms.core.manager.impl;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeecms.common.hibernate3.Updater;
import com.jeecms.core.JeeCoreManagerImpl;
import com.jeecms.core.dao.RoleDao;
import com.jeecms.core.entity.Role;
import com.jeecms.core.entity.Admin;
import com.jeecms.core.manager.RoleMng;

@Service
@Transactional
public class RoleMngImpl extends JeeCoreManagerImpl<Role> implements RoleMng {
	@Override
	public Object updateByUpdater(Updater updater) {
		Role role = (Role) super.updateByUpdater(updater);
		Admin.funcChange();
		return role;
	}

	@Override
	public Role save(Role role) {
		super.save(role);
		return role;
	}

	@Override
	public Role findById(Serializable id) {
		Role role = super.findById(id);
		return role;
	}

	@Override
	public Role deleteById(Serializable id) {
		Role role = super.deleteById(id);
		return role;
	}

	@Autowired
	public void setRoleDao(RoleDao dao) {
		super.setDao(dao);
	}

	protected RoleDao getRoleDao() {
		return (RoleDao) super.getDao();
	}

}
