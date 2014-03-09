package com.jeecms.cms.action;

import org.springframework.context.annotation.Scope;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;

import com.jeecms.core.entity.Member;

@SuppressWarnings("serial")
@Scope("prototype")
@Controller("core.memberAct")
public class MemberAct extends com.jeecms.core.JeeCoreAction {
	public String list() {
		this.pagination = memberMng.findAll(pageNo, getCookieCount());
		return LIST;
	}

	public String add() {
		return ADD;
	}

	public String save() {
		memberMng.save(bean);
		return add();
	}

	public String edit() {
		this.bean = memberMng.findById(id);
		return EDIT;
	}

	public String update() {
		memberMng.updateDefault(bean);
		addActionMessage("修改成功");
		return list();
	}

	public String delete() {
		try {
			memberMng.deleteById(id);
			memberMng.deleteById(ids);
		} catch (DataIntegrityViolationException e) {
			addActionError("记录已被引用，不能删除!");
		}
		return list();
	}

	private Member bean;

	public Member getBean() {
		return bean;
	}

	public void setBean(Member bean) {
		this.bean = bean;
	}
}
