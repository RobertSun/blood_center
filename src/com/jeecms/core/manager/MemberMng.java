package com.jeecms.core.manager;

import java.util.List;

import com.jeecms.common.page.Pagination;
import com.jeecms.core.JeeCoreManager;
import com.jeecms.core.entity.Member;
import com.jeecms.core.entity.User;
import com.jeecms.core.exception.UserRegisterException;

public interface MemberMng extends JeeCoreManager<Member> {
	public Pagination getAll(Long webId, int page, int countPerPage);

	public List<Member> getAll(Long webId);

	/**
	 * 通过登录名获取Member
	 * 
	 * @param webId
	 *            站点ID
	 * @param loginName
	 *            登录名
	 * @return
	 */
	public Member getByLoginName(Long webId, String loginName);

	/**
	 * 通过用户ID获取Member
	 * 
	 * @param webId
	 *            站点ID
	 * @param userId
	 *            用户ID
	 * @return
	 */
	public Member getByUserId(Long webId, Long userId);

	/**
	 * 注册用户
	 * 
	 * @param webId
	 * @param user
	 * @param member
	 * @param isExist
	 * @return
	 * @throws UserRegisterException
	 */
	public Member register(Long webId, User user, Member member, boolean isExist)
			throws UserRegisterException;

	/**
	 * 注册用户
	 * 
	 * @param webId
	 * @param user
	 * @param isExist
	 * @throws UserRegisteredException
	 *             用户注册异常
	 */
	public Member register(Long webId, User user, boolean isExist)
			throws UserRegisterException;

	/**
	 * 获得登录的会员
	 * <p>
	 * 如果管理员登录了，可从通过userId获得会员
	 * </p>
	 * 
	 * @param webId
	 * @param userId
	 * @return
	 */
	public Member getLoginMember(Long webId, Long userId, Long memberId);
}