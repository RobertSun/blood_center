package com.jeecms.cms.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;

import com.jeecms.cms.entity.CmsComment;
import com.jeecms.cms.manager.CmsCommentMng;
import com.jeecms.common.hibernate3.OrderBy;

@SuppressWarnings({ "serial", "unchecked" })
@Scope("prototype")
@Controller("cms.cmsCommentAct")
public class CmsCommentAct extends com.jeecms.cms.CmsSysAction {
	private static final Logger log = LoggerFactory.getLogger(CmsComment.class);

	public String list() {
		this.pagination = cmsCommentMng.findAll(pageNo, getCookieCount(),
				OrderBy.desc("id"));
		return LIST;
	}

	public String edit() {
		this.bean = cmsCommentMng.findById(id);
		return EDIT;
	}

	public String update() {
		cmsCommentMng.updateDefault(bean);
		log.info("�޸�  ���� �ɹ�:{}", bean.getContentMember());
		return list();
	}

	public String delete() {
		try {
			for (CmsComment o : cmsCommentMng.deleteById(ids)) {
				log.info("ɾ��  ���� �ɹ�:{}", o.getContentMember());
			}
		} catch (DataIntegrityViolationException e) {
			addActionError("��¼�ѱ����ã�����ɾ��!");
			return SHOW_ERROR;
		}
		return list();
	}

	public String check() {
		for (CmsComment o : cmsCommentMng.check(ids)) {
			log.info("���  ���� �ɹ�:{}", o.getContentMember());
		}
		return list();
	}

	public boolean validateEdit() {
		if (hasErrors()) {
			return true;
		}
		if (vldExist(id)) {
			return true;
		}
		if (vldWebsite(id, null)) {
			return true;
		}
		return false;
	}

	public boolean validateUpdate() {
		if (hasErrors()) {
			return true;
		}
		if (vldExist(bean.getId())) {
			return true;
		}
		if (vldWebsite(bean.getId(), null)) {
			return true;
		}
		bean.setWebsite(getWeb());
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
			if (vldWebsite(id, null)) {
				return true;
			}
		}
		return false;
	}

	public boolean validateCheck() {
		return validateDelete();
	}

	private boolean vldExist(Long id) {
		CmsComment entity = cmsCommentMng.findById(id);
		if (entity == null) {
			addActionError("��ݲ����ڣ�" + id);
			return true;
		}
		return false;
	}

	private boolean vldWebsite(Long id, CmsComment bean) {
		CmsComment entity = cmsCommentMng.findById(id);
		if (!entity.getWebsite().equals(getWeb())) {
			addActionError("ֻ�ܹ��?վ����ݣ�" + id);
			return true;
		}
		if (bean != null) {
			bean.setWebsite(getWeb());
		}
		return false;
	}

	@Autowired
	private CmsCommentMng cmsCommentMng;
	private CmsComment bean;

	public CmsComment getBean() {
		return bean;
	}

	public void setBean(CmsComment bean) {
		this.bean = bean;
	}
}