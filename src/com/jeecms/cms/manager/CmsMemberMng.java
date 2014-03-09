package com.jeecms.cms.manager;

import com.jeecms.core.JeeCoreManager;
import com.jeecms.core.entity.Member;
import com.jeecms.core.entity.User;
import com.jeecms.core.exception.UserRegisterException;
import com.jeecms.cms.entity.CmsMember;

public interface CmsMemberMng extends JeeCoreManager<CmsMember> {
	/**
	 * 注册会员
	 * 
	 * @param webId
	 * @param user
	 * @param member
	 * @param cmsMember
	 * @param isExist
	 * @return
	 * @throws UserRegisterException
	 */
	public CmsMember register(Long webId, User user, Member member,
			CmsMember cmsMember, boolean isExist) throws UserRegisterException;

	/**
	 * 注册会员
	 * 
	 * @param webId
	 * @param groupId
	 * @param user
	 * @param isExist
	 * @return
	 * @throws UserRegisterException
	 */
	public CmsMember register(Long webId, Long groupId, User user,
			boolean isExist) throws UserRegisterException;
	
	/**
	 * 自动注册会员
	 * @param webId
	 * @return
	 */
	public boolean autoRegist(Long webId,Long memberId);
}