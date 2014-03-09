package com.jeecms.cms.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;

import com.jeecms.core.entity.Attachment;
import com.jeecms.core.manager.AttachmentMng;

@SuppressWarnings("serial")
@Scope("prototype")
@Controller("core.attachmentAct")
public class AttachmentAct extends com.jeecms.core.JeeCoreAction {
	private static final Logger log = LoggerFactory
			.getLogger(AttachmentAct.class);

	public String list() {
		this.pagination = attachmentMng.getPage(getWebId(), pageNo,
				getCookieCount());
		return LIST;
	}

	public String add() {
		return ADD;
	}

	public String save() {
		attachmentMng.save(bean);
		log.info("添加  附件 成功:{}", bean.getName());
		return list();
	}

	public String edit() {
		this.bean = attachmentMng.findById(id);
		return EDIT;
	}

	public String update() {
		attachmentMng.updateDefault(bean);
		log.info("修改  附件 成功:{}", bean.getName());
		return list();
	}

	public String delete() {
		try {
			if (id != null) {
				attachmentMng.deleteById(id);
			} else {
				attachmentMng.deleteById(ids);
			}
		} catch (DataIntegrityViolationException e) {
			addActionError("记录已被引用，不能删除!");
		}
		return list();
	}

	@Autowired
	private AttachmentMng attachmentMng;
	private Attachment bean;

	public Attachment getBean() {
		return bean;
	}

	public void setBean(Attachment bean) {
		this.bean = bean;
	}
}