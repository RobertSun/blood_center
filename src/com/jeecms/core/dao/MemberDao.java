package com.jeecms.core.dao;

import com.jeecms.core.JeeCoreDao;
import com.jeecms.core.entity.Member;

public interface MemberDao extends JeeCoreDao<Member> {
	/**
	 * 获得会员
	 * 
	 * @param webId
	 *            站点ID
	 * @param userId
	 *            用户ID
	 * @return
	 */
	public Member getByUserId(Long webId, Long userId);
}