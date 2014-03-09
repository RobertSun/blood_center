package com.jeecms.core.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jeecms.core.JeeCoreDaoImpl;
import com.jeecms.core.dao.FunctionDao;
import com.jeecms.core.entity.Function;

@Repository
public class FunctionDaoImpl extends JeeCoreDaoImpl<Function> implements
		FunctionDao {
	@SuppressWarnings("unchecked")
	public List<Function> getFunctions(Long adminId) {
		String hql = "select func from Function func where func.id in"
				+ " (select f1.id from Admin admin join admin.roles role join role.functions f1 where admin.id = ?) or func.id in "
				+ " (select f2.id from Admin admin join admin.functions f2 where admin.id = ?)"
				+ " order by func.priority asc";
		return find(hql, adminId, adminId);
	}

	@SuppressWarnings("unchecked")
	public List<Function> getRoots() {
		String hql = "select func from Function func where func.parent.id is null order by func.priority asc";
		return find(hql);
	}

	@SuppressWarnings("unchecked")
	public List<Function> getChild(Long pid) {
		String hql = "select func from Function func where func.parent.id = ? order by func.priority asc";
		return find(hql, pid);
	}
}