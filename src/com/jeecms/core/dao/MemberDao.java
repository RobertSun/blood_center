package com.jeecms.core.dao;

import com.jeecms.core.JeeCoreDao;
import com.jeecms.core.entity.Member;

public interface MemberDao extends JeeCoreDao<Member> {
	/**
	 * ��û�Ա
	 * 
	 * @param webId
	 *            վ��ID
	 * @param userId
	 *            �û�ID
	 * @return
	 */
	public Member getByUserId(Long webId, Long userId);
}