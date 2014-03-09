package com.jeecms.cms.manager.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.jeecms.cms.dao.CmsAdminDao;
import com.jeecms.cms.entity.CmsAdmin;
import com.jeecms.cms.entity.CmsChannel;
import com.jeecms.cms.manager.CmsAdminMng;
import com.jeecms.cms.manager.CmsMemberMng;
import com.jeecms.core.JeeCoreManagerImpl;
import com.jeecms.core.entity.Admin;
import com.jeecms.core.entity.Role;
import com.jeecms.core.entity.User;
import com.jeecms.core.entity.Website;
import com.jeecms.core.exception.UserRegisterException;
import com.jeecms.core.manager.AdminMng;
import com.jeecms.core.manager.UserMng;

@Service
@Transactional
public class CmsAdminMngImpl extends JeeCoreManagerImpl<CmsAdmin> implements
		CmsAdminMng {
	public List<CmsAdmin> getList(Long webId) {
		CmsAdmin eg = new CmsAdmin();
		eg.setWebsite(new Website(webId));
		return findByEgList(eg);
	}

	public CmsAdmin register(Long webId, User user, Admin admin,
			CmsAdmin cmsAdmin, boolean isExist) throws UserRegisterException {
		Assert.notNull(webId);
		Assert.notNull(user);
		Assert.notNull(admin);
		Assert.notNull(cmsAdmin);
		Admin oadmin = adminMng.register(webId, user, admin, isExist);
		// 如果该管理员已经存在，则返回管理员对象。
		CmsAdmin ocadmin = findById(oadmin.getId());
		if (ocadmin != null) {
			return ocadmin;
		} else {
			cmsAdmin.setAdmin(oadmin);
			cmsAdmin.setWebsite(oadmin.getWebsite());
			cmsAdmin.setCheckRight(0);
			cmsAdmin.setSelfOnly(false);
			return save(cmsAdmin);
		}
	}

	public CmsAdmin getAdminByLoginName(Long webId, String loginName) {
		Assert.notNull(webId);
		Assert.hasText(loginName);
		User user = userMng.getByLoginName(loginName);
		if (user == null) {
			return null;
		}
		Admin admin = adminMng.getByUserId(webId, user.getId());
		if (admin == null) {
			return null;
		}
		return findById(admin.getId());
	}

	public CmsAdmin getAdminByUserId(Long webId, Long userId) {
		Admin admin = adminMng.getByUserId(webId, userId);
		if (admin != null) {
			return findById(admin.getId());
		} else {
			return null;
		}
	}

	public CmsAdmin saveAdmin(CmsAdmin cmsAdmin, Set<Role> roles,
			Set<CmsChannel> channels, Long rootWebId, Long groupId,
			boolean createUser) throws UserRegisterException {
		Assert.notNull(cmsAdmin);
		Admin admin = cmsAdmin.getAdmin();
		Long webId = cmsAdmin.getWebsite().getId();
		User user = admin.getUser();
		CmsAdmin entity = register(webId, user, admin, cmsAdmin, createUser);
		if (roles != null) {
			entity.getAdmin().setRoles(roles);
		}
		if (channels != null) {
			entity.setChannels(channels);
		}
		if (groupId != null) {
			Assert.notNull(rootWebId);
			cmsMemberMng.register(rootWebId, groupId, entity.getAdmin()
					.getUser(), true);
		}
		return entity;
	}

	public CmsAdmin updateAdmin(CmsAdmin cmsAdmin, Set<Role> roles,
			Set<CmsChannel> channels, Boolean disabled) {
		Assert.notNull(cmsAdmin);
		CmsAdmin padmin = findById(cmsAdmin.getId());
		if (roles != null) {
			padmin.getAdmin().setRoles(roles);
		}
		if (channels != null) {
			padmin.setChannels(channels);
		}
		cmsAdmin.setAdmin(null);
		cmsAdmin = (CmsAdmin) super.updateDefault(cmsAdmin);
		if (disabled != null) {
			cmsAdmin.getAdmin().setDisabled(disabled);
		}
		return cmsAdmin;
	}

	public CmsAdmin save(CmsAdmin admin) {
		initCmsAdmin(admin);
		super.save(admin);
		return admin;
	}

	private void initCmsAdmin(CmsAdmin admin) {
		if (admin.getCheckRight() == null) {
			admin.setCheckRight(0);
		}
		if (admin.getSelfOnly() == null) {
			admin.setSelfOnly(true);
		}
	}

	public CmsAdmin findById(Serializable id) {
		CmsAdmin admin = super.findById(id);
		return admin;
	}

	public CmsAdmin deleteById(Serializable id) {
		CmsAdmin admin = super.deleteById(id);
		return admin;
	}

	@Autowired
	private AdminMng adminMng;
	@Autowired
	private UserMng userMng;
	@Autowired
	private CmsMemberMng cmsMemberMng;

	@Autowired
	public void setCmsAdminDao(CmsAdminDao dao) {
		super.setDao(dao);
	}

	public CmsAdminDao getDao() {
		return (CmsAdminDao) super.getDao();
	}
}
