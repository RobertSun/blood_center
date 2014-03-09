package com.jeecms.core.manager.impl;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeecms.common.hibernate3.Updater;
import com.jeecms.core.JeeCoreManagerImpl;
import com.jeecms.core.dao.FunctionDao;
import com.jeecms.core.entity.Function;
import com.jeecms.core.manager.FunctionMng;

@Service
@Transactional
public class FunctionMngImpl extends JeeCoreManagerImpl<Function> implements
		FunctionMng {

	public List<Function> getFunctions(Long adminId) {
		return getFunctionDao().getFunctions(adminId);
	}

	public Set<String> getFunctionItems(Long adminId) {
		List<Function> funcList = getFunctions(adminId);
		Set<String> funcItemSet = new HashSet<String>();
		String f = null;
		String fs = null;
		String[] fa = null;
		for (Function function : funcList) {
			f = function.getUrl();
			if (!StringUtils.isBlank(f)) {
				funcItemSet.add(f);
			}
			fs = function.getFuncs();
			if (!StringUtils.isBlank(fs)) {
				fa = fs.split(Function.FUNC_SPLIT);
				for (String fas : fa) {
					funcItemSet.add(fas);
				}
			}
		}
		return funcItemSet;
	}

	public List<Function> getRoots() {
		return getFunctionDao().getRoots();
	}

	public List<Function> getChild(Long pid) {
		return getFunctionDao().getChild(pid);
	}

	@Override
	public Object updateByUpdater(Updater updater) {
		Function bean = (Function) updater.getBean();
		Function f = findById(bean.getId());
		Function pf = f.getParent();
		Function pbean = bean.getParent();
		// pbean!=null代表需要更新父节点。父节点不能等于自身。
		if (pbean != null && !f.getId().equals(pbean.getId())) {
			// pf!=null原父节点存在，处理原父节点的child
			if (pf != null && !pf.getId().equals(pbean.getId())) {
				pf.getChild().remove(f);
			}
			// pbean.getId()!=null新父节点存在，处理新父节点child
			if (pbean.getId() != null && !pbean.getId().equals(pf.getId())) {
				Function np = findById(pbean.getId());
				np.addTochild(f);
			}
		}
		Function func = (Function) super.updateByUpdater(updater);
		return func;
	}

	@Override
	public Function save(Function func) {
		Function p = func.getParent();
		if (p != null) {
			Long pid = p.getId();
			// 如果父节点ID为null则将父节点对象设置为null，以免hibernate发生错误。并直接保存对象。
			if (pid == null) {
				func.setParent(null);
				super.save(func);
			} else {
				func.setParent(p);
				findById(pid).addTochild(func);
			}
		}
		return func;
	}

	@Override
	public Function findById(Serializable id) {
		Function func = super.findById(id);
		return func;
	}

	@Override
	public Function deleteById(Serializable id) {
		Function entity = findById(id);
		Function parent = entity.getParent();
		super.delete(entity);
		if (parent != null) {
			parent.getChild().remove(entity);
		}
		return entity;
	}

	@Autowired
	public void setFunctionDao(FunctionDao dao) {
		super.setDao(dao);
	}

	protected FunctionDao getFunctionDao() {
		return (FunctionDao) super.getDao();
	}

}
