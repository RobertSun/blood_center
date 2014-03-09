package com.jeecms.cms.action;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;

import com.jeecms.cms.Constants;
import com.jeecms.cms.entity.CmsAdmin;
import com.jeecms.cms.entity.CmsChannel;
import com.jeecms.cms.entity.CmsMemberGroup;
import com.jeecms.cms.manager.CmsChannelMng;
import com.jeecms.cms.manager.CmsMemberGroupMng;
import com.jeecms.core.entity.Admin;
import com.jeecms.core.entity.Role;
import com.jeecms.core.exception.UserRegisterException;
import com.jeecms.core.manager.RoleMng;

@SuppressWarnings({ "serial", "unchecked" })
@Scope("prototype")
@Controller("cms.cmsAdminAct")
public class CmsAdminAct extends com.jeecms.cms.CmsSysAction {
	private static final Logger log = LoggerFactory
			.getLogger(CmsAdminAct.class);

	public String list() {
		this.list = cmsAdminMng.getList(getWebId());
		return LIST;
	}

	public String add() {
		this.roleList = roleMng.findAll();
		this.groupList = cmsMemberGroupMng.getList(getWeb().getRootWebId(),
				Integer.MIN_VALUE, true);
		this.artiChnlRoot = cmsChannelMng.getRoot(getWebId(),
				Constants.ARTICLE_SYS, true);
		this.downChnlRoot = cmsChannelMng.getRoot(getWebId(),
				Constants.DOWNLOAD_SYS, true);
		return ADD;
	}

	public String save() {
		Set<Role> roleSet = null;
		if (roles != null && roles.size() > 0) {
			roleSet = new HashSet<Role>(roles);
		}
		Set<CmsChannel> channelSet = null;
		if (channels != null && channels.size() > 0) {
			channelSet = new HashSet<CmsChannel>(channels);
		}
		try {
			cmsAdminMng.saveAdmin(bean, roleSet, channelSet, getWeb()
					.getRootWebId(), groupId, !createUser);
		} catch (UserRegisterException e) {
			log.error("��ӹ���Աʧ��", e);
			addActionError(e.getMessage());
			return add();
		}
		log.info("��� CMS����Ա �ɹ�:{}", bean.getLoginName());
		return list();
	}

	public String edit() {
		this.bean = cmsAdminMng.findById(id);
		this.roleList = roleMng.findAll();
		this.groupList = cmsMemberGroupMng.getList(getWeb().getRootWebId(),
				Integer.MIN_VALUE, true);
		this.artiChnlRoot = cmsChannelMng.getRoot(getWebId(),
				Constants.ARTICLE_SYS, true);
		this.downChnlRoot = cmsChannelMng.getRoot(getWebId(),
				Constants.DOWNLOAD_SYS, true);
		return EDIT;
	}

	public String update() {
		Set<Role> roleSet = null;
		if (roles != null) {
			roleSet = new HashSet<Role>(roles);
		} else {
			roleSet = new HashSet<Role>();
		}
		Set<CmsChannel> channelSet = null;
		if (channels != null) {
			channelSet = new HashSet<CmsChannel>(channels);
		} else {
			channelSet = new HashSet<CmsChannel>();
		}
		Boolean disabled = null;
		Admin admin = bean.getAdmin();
		if (admin != null) {
			disabled = admin.getDisabled();
		}
		cmsAdminMng.updateAdmin(bean, roleSet, channelSet, disabled);
		log.info("�޸� CMS����Ա �ɹ�:{}", bean.getLoginName());
		return list();
	}

	public String delete() {
		try {
			if (id != null) {
				bean = cmsAdminMng.deleteById(id);
				log.info("ɾ�� CMS����Ա �ɹ�:{}", bean.getLoginName());
			} else {
				for (CmsAdmin o : cmsAdminMng.deleteById(ids)) {
					log.info("ɾ�� CMS����Ա �ɹ�:{}", o.getLoginName());
				}
			}
		} catch (DataIntegrityViolationException e) {
			addActionError("��¼�ѱ����ã�����ɾ��!");
		}
		return list();
	}

	public boolean validateSave() {
		if (hasErrors()) {
			return true;
		}
		bean.setWebsite(getWeb());
		String username = bean.getLoginName();
		String email = bean.getAdmin().getUser().getEmail();
		String password = bean.getAdmin().getUser().getPassword();
		if (createUser) {
			if (StringUtils.isBlank(email)) {
				addActionError("���䲻��Ϊ��");
				return true;
			}
			if (StringUtils.isBlank(password)) {
				addActionError("���벻��Ϊ��");
				return true;
			}
			if (!userMng.checkLoginName(username)) {
				addActionError("�û����Ѿ����ڣ�" + username);
				return true;
			}
			if (!userMng.checkEmail(email)) {
				addActionError("�����Ѿ���ʹ�ã�" + email);
				return true;
			}
		} else {
			if (userMng.checkLoginName(username)) {
				addActionError("�û�����ڣ�" + username);
				return true;
			}
			if (cmsAdminMng.getAdminByLoginName(getWebId(), username) != null) {
				addActionError("���û��Ѿ��ǹ���Ա��" + username);
				return true;
			}
		}
		return false;
	}

	@Autowired
	private RoleMng roleMng;
	@Autowired
	private CmsMemberGroupMng cmsMemberGroupMng;
	@Autowired
	private CmsChannelMng cmsChannelMng;
	private CmsChannel artiChnlRoot;
	private CmsChannel downChnlRoot;
	private List<Role> roleList;
	private List<Role> roles;
	private List<CmsChannel> channels;
	private List<CmsMemberGroup> groupList;
	private Long groupId;
	private CmsAdmin bean;
	private boolean createUser;

	public CmsAdmin getBean() {
		return bean;
	}

	public void setBean(CmsAdmin bean) {
		this.bean = bean;
	}

	public List<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public List<CmsMemberGroup> getGroupList() {
		return groupList;
	}

	public void setGroupList(List<CmsMemberGroup> groupList) {
		this.groupList = groupList;
	}

	public Long getGroupId() {
		return groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

	public boolean isCreateUser() {
		return createUser;
	}

	public void setCreateUser(boolean createUser) {
		this.createUser = createUser;
	}

	public List<CmsChannel> getChannels() {
		return channels;
	}

	public void setChannels(List<CmsChannel> channels) {
		this.channels = channels;
	}

	public CmsChannel getArtiChnlRoot() {
		return artiChnlRoot;
	}

	public void setArtiChnlRoot(CmsChannel artiChnlRoot) {
		this.artiChnlRoot = artiChnlRoot;
	}

	public CmsChannel getDownChnlRoot() {
		return downChnlRoot;
	}

	public void setDownChnlRoot(CmsChannel downChnlRoot) {
		this.downChnlRoot = downChnlRoot;
	}
}
