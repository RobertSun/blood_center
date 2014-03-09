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
	 * ͨ����¼����ȡMember
	 * 
	 * @param webId
	 *            վ��ID
	 * @param loginName
	 *            ��¼��
	 * @return
	 */
	public Member getByLoginName(Long webId, String loginName);

	/**
	 * ͨ���û�ID��ȡMember
	 * 
	 * @param webId
	 *            վ��ID
	 * @param userId
	 *            �û�ID
	 * @return
	 */
	public Member getByUserId(Long webId, Long userId);

	/**
	 * ע���û�
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
	 * ע���û�
	 * 
	 * @param webId
	 * @param user
	 * @param isExist
	 * @throws UserRegisteredException
	 *             �û�ע���쳣
	 */
	public Member register(Long webId, User user, boolean isExist)
			throws UserRegisterException;

	/**
	 * ��õ�¼�Ļ�Ա
	 * <p>
	 * �������Ա��¼�ˣ��ɴ�ͨ��userId��û�Ա
	 * </p>
	 * 
	 * @param webId
	 * @param userId
	 * @return
	 */
	public Member getLoginMember(Long webId, Long userId, Long memberId);
}