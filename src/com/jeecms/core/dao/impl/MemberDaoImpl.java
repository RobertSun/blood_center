package com.jeecms.core.dao.impl;

import org.springframework.stereotype.Repository;

import com.jeecms.core.JeeCoreDaoImpl;
import com.jeecms.core.dao.MemberDao;
import com.jeecms.core.entity.Member;

@Repository
public class MemberDaoImpl extends JeeCoreDaoImpl<Member> implements MemberDao {
	public Member getByUserId(Long webId, Long userId) {
		String hql = "from Member bean where bean.website.id=? and bean.user.id=?";
		return (Member) findUnique(hql, webId, userId);
	}
}