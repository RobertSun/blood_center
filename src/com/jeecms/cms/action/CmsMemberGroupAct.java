package com.jeecms.cms.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;

import com.jeecms.cms.entity.CmsMemberGroup;
import com.jeecms.cms.manager.CmsMemberGroupMng;

@SuppressWarnings({ "serial", "unchecked" })
@Scope("prototype")
@Controller("cms.cmsMemberGroupAct")
public class CmsMemberGroupAct extends com.jeecms.cms.CmsSysAction {
	private static final Logger log = LoggerFactory
			.getLogger(CmsMemberGroup.class);

	public String list() {
		this.list = cmsMemberGroupMng.getList(getWebId(), Integer.MIN_VALUE,
				true);
		return LIST;
	}

	public String add() {
		return ADD;
	}

	public String save() {
		cmsMemberGroupMng.save(bean);
		log.info("��ӻ�Ա�� �ɹ���{}" + bean.getName());
		return list();
	}

	public String edit() {
		this.bean = cmsMemberGroupMng.findById(id);
		return EDIT;
	}

	public String update() {
		cmsMemberGroupMng.updateDefault(bean);
		log.info("�޸� ��Ա�� �ɹ�:{}", bean.getName());
		return list();
	}

	public String delete() {
		try {
			for (CmsMemberGroup o : cmsMemberGroupMng.deleteById(ids)) {
				log.info("ɾ�� ��Ա�� �ɹ�:{}", o.getName());
			}
		} catch (DataIntegrityViolationException e) {
			addActionError("��¼�ѱ����ã�����ɾ��!");
			return SHOW_ERROR;
		}
		return list();
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

	private boolean vldWebsite(Long id, CmsMemberGroup bean) {
		CmsMemberGroup entity = cmsMemberGroupMng.findById(id);
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
		CmsMemberGroup entity = cmsMemberGroupMng.findById(id);
		if (entity == null) {
			addActionError("��ݲ����ڣ�" + id);
			return true;
		}
		return false;
	}

	@Autowired
	private CmsMemberGroupMng cmsMemberGroupMng;
	private CmsMemberGroup bean;

	public CmsMemberGroup getBean() {
		return bean;
	}

	public void setBean(CmsMemberGroup bean) {
		this.bean = bean;
	}
}