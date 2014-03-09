package com.jeecms.auxiliary.action;

import org.apache.commons.lang.StringEscapeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;

import com.jeecms.auxiliary.entity.Msg;
import com.jeecms.auxiliary.manager.MsgMng;
import com.jeecms.common.util.ComUtils;
import com.jeecms.common.util.StrUtils;

@SuppressWarnings({ "serial", "unchecked" })
@Scope("prototype")
@Controller("auxiliary.msgAct")
public class MsgAct extends com.jeecms.auxiliary.AuxiSysAction {
	private static final Logger log = LoggerFactory.getLogger(MsgAct.class);

	public String list() {
		this.pagination = msgMng.getPage(getWebId(), pageNo, getCookieCount());
		return LIST;
	}

	public String save() {
		msgMng.save(bean);
		log.info("��� ���� �ɹ���{}", bean.getContentMember());
		return list();
	}

	public String edit() {
		bean = msgMng.findById(id);
		return EDIT;
	}

	public String update() {
		bean.setAdmin(getAdmin());
		bean.setReplyTime(ComUtils.now());
		handleString(bean);
		msgMng.updateDefault(bean);
		log.info("�޸� ���� �ɹ���{}", bean.getContentMember());
		return list();
	}

	public String delete() {
		try {
			for (Msg o : msgMng.deleteById(ids)) {
				log.info("ɾ�� ���� �ɹ�:{}", o.getContentMember());
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
		bean.setWebsite(getWeb());
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

	private boolean vldExist(Long id) {
		Msg entity = msgMng.findById(id);
		if (entity == null) {
			addActionError("��ݲ����ڣ�" + id);
			return true;
		}
		return false;
	}

	private boolean vldWebsite(Long id, Msg bean) {
		Msg entity = msgMng.findById(id);
		if (!entity.getWebsite().equals(getWeb())) {
			addActionError("ֻ�ܹ��?վ����ݣ�" + id);
			return true;
		}
		if (bean != null) {
			bean.setWebsite(getWeb());
		}
		return false;
	}

	private void handleString(Msg m) {
		String title = m.getTitle();
		m.setTitle(StringEscapeUtils.escapeHtml(title));
		String cm = m.getContentMember();
		String ca = m.getContentAdmin();
		cm = StrUtils.getCn(cm, getConfig().getMsgMaxSize());
		ca = StrUtils.getCn(ca, getConfig().getMsgMaxSize());
		m.setContentMember(StrUtils.txt2htm(cm));
		m.setContentAdmin(StrUtils.txt2htm(ca));
	}

	@Autowired
	private MsgMng msgMng;
	private Msg bean;

	public Msg getBean() {
		return bean;
	}

	public void setBean(Msg bean) {
		this.bean = bean;
	}
}
