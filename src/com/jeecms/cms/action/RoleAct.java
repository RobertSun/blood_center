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
		// 寻找根节点
		List<Function> roots = functionMng.getRoots();
		if (roots != null && roots.size() > 0) {
			this.funcRoot = roots.get(0);
		} else {
			addActionError("请先添加功能菜单！");
			return SHOW_ERROR;
		}
		return ADD;
	}

	public String save() {
		bean.setFunctions(new HashSet<Function>(functions));
		roleMng.save(bean);
		log.info("增加  角色 成功:{}", bean.getName());
		return list();
	}

	public String edit() {
		this.bean = roleMng.findById(id);
		// 寻找根节点
		List<Function> roots = functionMng.getRoots();
		if (roots != null && roots.size() > 0) {
			this.funcRoot = roots.get(0);
		} else {
			addActionError("请先添加功能菜单！");
			return SHOW_ERROR;
		}
		return EDIT;
	}

	public String update() {
		bean.setFunctions(new HashSet<Function>(functions));
		roleMng.updateDefault(bean);
		log.info("修改  角色 成功:{}", bean.getName());
		return list();
	}

	public String delete() {
		try {
			for (Role o : roleMng.deleteById(ids)) {
				log.info("删除  角色 成功:{}", o.getName());
			}
		} catch (DataIntegrityViolationException e) {
			addActionError("记录已被引用，不能删除!");
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
			addActionError("记录不存在：" + id);
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
