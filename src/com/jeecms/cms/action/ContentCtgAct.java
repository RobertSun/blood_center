package com.jeecms.cms.action;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;

import com.jeecms.cms.entity.ContentCtg;
import com.jeecms.cms.manager.ContentCtgMng;

@SuppressWarnings({ "serial", "unchecked" })
@Scope("prototype")
@Controller("cms.contentCtgAct")
public class ContentCtgAct extends com.jeecms.cms.CmsSysAction {
	private static final Logger log = LoggerFactory
			.getLogger(ContentCtgAct.class);

	public String list() {
		this.list = contentCtgMng.getList(getRootWebId(), null);
		return LIST;
	}

	public String add() {
		return ADD;
	}

	public String save() {
		contentCtgMng.save(bean);
		log.info("��� �������� �ɹ�:{}", bean.getName());
		return list();
	}

	public String edit() {
		this.bean = contentCtgMng.findById(id);
		return EDIT;
	}

	public String update() {
		contentCtgMng.updateDefault(bean);
		log.info("�޸� �������� �ɹ�:{}", bean.getName());
		return list();
	}

	public String delete() {
		try {
			for (ContentCtg o : contentCtgMng.deleteById(ids)) {
				log.info("ɾ�� �������� �ɹ�:{}", o.getName());
			}
		} catch (DataIntegrityViolationException e) {
			addActionError("��¼�ѱ����ã�����ɾ��!");
			return SHOW_ERROR;
		}
		return list();
	}

	public String checkLabel() {
		if (StringUtils.isBlank(label)) {
			return "false";
		}
		return renderText(contentCtgMng.checkLabel(getRootWebId(), label) ? "true"
				: "false");
	}

	public boolean validateSave() {
		if (hasErrors()) {
			return true;
		}
		bean.setWebsite(getRootWeb());
		return false;
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
		if (vldWebsite(bean.getId(), bean)) {
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
			if (vldWebsite(id, null)) {
				return true;
			}
		}
		return false;
	}

	private boolean vldWebsite(Long id, ContentCtg bean) {
		ContentCtg entity = contentCtgMng.findById(id);
		if (!entity.getWebsite().equals(getRootWeb())) {
			addActionError("ֻ�ܹ��?վ����ݣ�" + id);
			return true;
		}
		if (bean != null) {
			bean.setWebsite(getRootWeb());
		}
		return false;
	}

	private boolean vldExist(Long id) {
		ContentCtg entity = contentCtgMng.findById(id);
		if (entity == null) {
			addActionError("��ݲ����ڣ�" + id);
			return true;
		}
		return false;
	}

	@Autowired
	private ContentCtgMng contentCtgMng;
	private ContentCtg bean;

	private String label;

	public ContentCtg getBean() {
		return bean;
	}

	public void setBean(ContentCtg bean) {
		this.bean = bean;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
}