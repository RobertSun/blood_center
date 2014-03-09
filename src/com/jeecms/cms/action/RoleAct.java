package com.jeecms.cms.action;

import java.util.HashSet;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;

import com.jeecms.core.entity.Function;
import com.jeecms.core.entity.Role;
import com.jeecms.core.manager.FunctionMng;
import com.jeecms.core.manager.RoleMng;

@SuppressWarnings("serial")
@Scope("prototype")
@Controller("core.roleAct")
public class RoleAct extends com.jeecms.core.JeeCoreAction {
	private static final Logger log = LoggerFactory.getLogger(RoleAct.class);

	public String list() {
		this.pagination = roleMng.findAll(pageNo, getCookieCount());
		return LIST;
	}

	public String add() {
		// Ѱ�Ҹ��ڵ�
		List<Function> roots = functionMng.getRoots();
		if (roots != null && roots.size() > 0) {
			this.funcRoot = roots.get(0);
		} else {
			addActionError("������ӹ��ܲ˵���");
			return SHOW_ERROR;
		}
		return ADD;
	}

	public String save() {
		bean.setFunctions(new HashSet<Function>(functions));
		roleMng.save(bean);
		log.info("����  ��ɫ �ɹ�:{}", bean.getName());
		return list();
	}

	public String edit() {
		this.bean = roleMng.findById(id);
		// Ѱ�Ҹ��ڵ�
		List<Function> roots = functionMng.getRoots();
		if (roots != null && roots.size() > 0) {
			this.funcRoot = roots.get(0);
		} else {
			addActionError("������ӹ��ܲ˵���");
			return SHOW_ERROR;
		}
		return EDIT;
	}

	public String update() {
		bean.setFunctions(new HashSet<Function>(functions));
		roleMng.updateDefault(bean);
		log.info("�޸�  ��ɫ �ɹ�:{}", bean.getName());
		return list();
	}

	public String delete() {
		try {
			for (Role o : roleMng.deleteById(ids)) {
				log.info("ɾ��  ��ɫ �ɹ�:{}", o.getName());
			}
		} catch (DataIntegrityViolationException e) {
			addActionError("��¼�ѱ����ã�����ɾ��!");
			return SHOW_ERROR;
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
		return false;
	}

	public boolean validateUpdate() {
		if (hasErrors()) {
			return true;
		}
		if (vldExist(bean.getId())) {
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
		Role entity = roleMng.findById(id);
		if (entity == null) {
			addActionError("��¼�����ڣ�" + id);
			return true;
		}
		return false;
	}

	@Autowired
	private RoleMng roleMng;
	private Role bean;
	@Autowired
	private FunctionMng functionMng;
	private List<Function> funcList;
	private Function funcRoot;
	private List<Function> functions;

	public Role getBean() {
		return bean;
	}

	public void setBean(Role bean) {
		this.bean = bean;
	}

	public List<Function> getFuncList() {
		return funcList;
	}

	public void setFuncList(List<Function> funcList) {
		this.funcList = funcList;
	}

	public Function getFuncRoot() {
		return funcRoot;
	}

	public void setFuncRoot(Function funcRoot) {
		this.funcRoot = funcRoot;
	}

	public List<Function> getFunctions() {
		return functions;
	}

	public void setFunctions(List<Function> functions) {
		this.functions = functions;
	}

}
