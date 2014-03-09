package com.jeecms.cms.action;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;

import com.jeecms.common.util.SelectTreeUtils;
import com.jeecms.core.entity.Function;
import com.jeecms.core.manager.FunctionMng;

@SuppressWarnings("serial")
@Scope("prototype")
@Controller("core.functionAct")
public class FunctionAct extends com.jeecms.core.JeeCoreAction {
	public String list() {
		if (pid == null) {
			this.list = functionMng.getRoots();
		} else {
			this.list = new ArrayList<Function>(functionMng.findById(pid)
					.getChild());
		}
		return LIST;
	}

	public String left() {
		// 根
		funcRoot = new Function();
		funcRoot.setName("根目录");
		// 内容。取所有列表，找出父菜单。
		List<Function> all = functionMng.getRoots();
		funcRoot.setChild(new LinkedHashSet<Function>(all));
		return LEFT;
	}

	public String add() {
		if (pid != null) {
			parent = functionMng.findById(pid);
		}
		// 功能菜单
		return ADD;
	}

	public String save() {
		functionMng.save(bean);
		addActionMessage("添加成功");
		return add();
	}

	public String edit() {
		this.bean = functionMng.findById(id);
		this.list = SelectTreeUtils.webTree(functionMng.getRoots());
		return EDIT;
	}

	public String update() {
		functionMng.updateDefault(bean);
		addActionMessage("修改成功");
		return list();
	}

	public String priorityUpdate() {
		for (int i = 0; i < wids.length; i++) {
			Function f = functionMng.findById(wids[i]);
			f.setPriority(prioritys[i]);
			functionMng.update(f);
		}
		return list();
	}

	public String delete() {
		try {
			if (id != null) {
				functionMng.deleteById(id);
			} else {
				functionMng.deleteById(ids);
			}
		} catch (DataIntegrityViolationException e) {
			addActionError("记录已被引用，不能删除!");
		}
		return list();
	}

	@Autowired
	private FunctionMng functionMng;
	private Function bean;
	private Function parent;

	private Function funcRoot;
	private List<Function> funcList;
	private Long pid;
	private Long[] wids;
	private int[] prioritys;

	public Function getBean() {
		return bean;
	}

	public void setBean(Function bean) {
		this.bean = bean;
	}

	public Function getFuncRoot() {
		return funcRoot;
	}

	public void setFuncRoot(Function funcRoot) {
		this.funcRoot = funcRoot;
	}

	public List<Function> getFuncList() {
		return funcList;
	}

	public void setFuncList(List<Function> funcList) {
		this.funcList = funcList;
	}

	public Long getPid() {
		return pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}

	public Long[] getWids() {
		return wids;
	}

	public void setWids(Long[] wids) {
		this.wids = wids;
	}

	public int[] getPrioritys() {
		return prioritys;
	}

	public void setPrioritys(int[] prioritys) {
		this.prioritys = prioritys;
	}

	public Function getParent() {
		return parent;
	}

	public void setParent(Function parent) {
		this.parent = parent;
	}
}
