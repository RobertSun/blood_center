package com.jeecms.cms.action;

import java.io.IOException;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;

import com.jeecms.cms.manager.CmsConfigMng;
import com.jeecms.common.util.SelectTreeUtils;
import com.jeecms.core.JeeCoreAction;
import com.jeecms.core.entity.EmailSender;
import com.jeecms.core.entity.Global;
import com.jeecms.core.entity.Website;
import com.jeecms.core.manager.GlobalMng;

@SuppressWarnings("serial")
@Scope("prototype")
@Controller("core.websiteAct")
public class WebsiteAct extends JeeCoreAction {
	private static final Logger log = LoggerFactory.getLogger(WebsiteAct.class);

	@SuppressWarnings("unchecked")
	public String list() {
		this.list = SelectTreeUtils.webTree(SelectTreeUtils
				.handleTreeChild(websiteMng.getAllWebsite()));
		return LIST;
	}

	@SuppressWarnings("unchecked")
	public String add() {
		this.parentList = SelectTreeUtils.webTree(SelectTreeUtils
				.handleTreeChild(websiteMng.getAllWebsite()));
		return ADD;
	}

	@SuppressWarnings("unchecked")
	public String edit() {
		this.bean = websiteMng.getWebsite(id);
		this.parentList = SelectTreeUtils.webTree(SelectTreeUtils
				.handleTreeChild(websiteMng.getListForUpdate(id)));
		return EDIT;
	}

	public String save() throws IOException {
		if (bean.getParent() != null && bean.getParent().getId() == null) {
			bean.setParent(null);
		}
		cmsConfigMng.saveWebsite(getWeb(), bean, getUser());
		log.info("添加  站点 成功:{}", bean.getName());
		ServletActionContext.getResponse().sendRedirect("Com_list.do");
		return null;
	}

	public String update() {
		websiteMng.updateWebsite(bean);
		log.info("更新  站点 成功:{}", bean.getName());
		return list();
	}

	public String emailEdit() {
		this.email = getWeb().getEmailSender();
		return "emailEdit";
	}

	public String emailUpdate() {
		Website updater = new Website();
		if (email.getUserPwd() != null && email.getUserPwd().trim().equals("")) {
			email.setUserPwd(null);
		}
		updater.setEmailSender(email);
		updater.setId(getWebId());
		websiteMng.updateWebsite(updater);
		addActionMessage("修改成功");
		return emailEdit();
	}

	public String siteEdit() {
		this.bean = getWeb();
		return "siteEdit";
	}

	public String siteUpdate() {
		String origDomain = getWeb().getDomain();
		String updatedDomain = bean.getDomain();
		bean.setId(getWebId());
		bean = websiteMng.updateWebsite(bean);
		addActionMessage("修改成功");
		if (StringUtils.equals(origDomain, updatedDomain)) {
			return siteEdit();
		} else {
			return "domainChanged";
		}
	}

	public String globalEdit() {
		this.global = getWeb().getGlobal();
		return "globalEdit";
	}

	public String globalUpdate() {
		globalMng.updateDefault(global);
		addActionMessage("修改成功");
		return globalEdit();
	}

	public String delete() {
		try {
			for (Long webId : ids) {
				bean = websiteMng.removeWebsite(webId);
				log.info("删除  站点 成功:{}", bean.getName());
			}
		} catch (DataIntegrityViolationException e) {
			addActionError("记录已被引用，不能删除!");
			log.info("删除  站点 失败，记录被引用");
			return SHOW_ERROR;
		}
		return list();
	}

	public boolean validateSave() {
		if (hasErrors()) {
			return true;
		}
		if (vldDomain(bean.getDomain(), null)) {
			return true;
		}
		if (vldResPath(bean.getResPath(), null)) {
			return true;
		}
		return false;
	}

	public boolean validateEdit() {
		if (hasErrors()) {
			return true;
		}
		if (vldExist(id)) {
			return true;
		}
		return false;
	}

	public boolean validateUpdate() {
		if (hasErrors()) {
			return true;
		}
		if (bean.getId().equals(bean.getParentId())) {
			addActionError("不能将自身设置成父站点");
			return true;
		}
		if (vldExist(bean.getId())) {
			return true;
		}
		if (vldDomain(bean.getDomain(), bean.getId())) {
			return true;
		}
		if (vldResPath(bean.getResPath(), bean.getId())) {
			return true;
		}
		return false;
	}

	public boolean validateDelete() {
		if (hasErrors()) {
			return true;
		}
		if (vldBatch()) {
			return true;
		}
		for (Long id : ids) {
			if (vldExist(id)) {
				return true;
			}
		}
		return false;
	}

	private boolean vldExist(Long id) {
		Website entity = websiteMng.getWebsite(id);
		if (entity == null) {
			addActionError("记录不存在：" + id);
			return true;
		}
		return false;
	}

	private boolean vldDomain(String domain, Long id) {
		if (id != null) {
			Website w = websiteMng.getWebsite(id);
			if (w.getDomain().equals(domain)) {
				return false;
			}
		}
		if (!websiteMng.checkDomain(domain)) {
			addActionError("域名已经存在：" + domain);
			return true;
		}
		return false;
	}

	private boolean vldResPath(String resPath, Long id) {
		if (id != null) {
			Website w = websiteMng.getWebsite(id);
			if (w.getResPath().equals(resPath)) {
				return false;
			}
		}
		if (!websiteMng.checkResPath(resPath)) {
			addActionError("资源路径已经存在：" + resPath);
			return true;
		}
		return false;
	}

	public String checkDomain() {
		if (StringUtils.isBlank(domain)) {
			return renderText("false");
		}
		return renderText(websiteMng.checkDomain(domain) ? "true" : "false");
	}

	public String checkResPath() {
		if (StringUtils.isBlank(resPath)) {
			return renderText("false");
		}
		return renderText(websiteMng.checkResPath(resPath) ? "true" : "false");
	}

	@Autowired
	private GlobalMng globalMng;
	@Autowired
	private CmsConfigMng cmsConfigMng;

	private Website bean;
	private EmailSender email;
	private Global global;
	private List<Website> parentList;
	private String domain;
	private String origDomain;
	private String resPath;
	private String origResPath;

	public Website getBean() {
		return bean;
	}

	public void setBean(Website bean) {
		this.bean = bean;
	}

	public List<Website> getParentList() {
		return parentList;
	}

	public void setParentList(List<Website> parentList) {
		this.parentList = parentList;
	}

	public EmailSender getEmail() {
		return email;
	}

	public void setEmail(EmailSender email) {
		this.email = email;
	}

	public Global getGlobal() {
		return global;
	}

	public void setGlobal(Global global) {
		this.global = global;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getOrigDomain() {
		return origDomain;
	}

	public void setOrigDomain(String origDomain) {
		this.origDomain = origDomain;
	}

	public String getResPath() {
		return resPath;
	}

	public void setResPath(String resPath) {
		this.resPath = resPath;
	}

	public String getOrigResPath() {
		return origResPath;
	}

	public void setOrigResPath(String origResPath) {
		this.origResPath = origResPath;
	}

}
