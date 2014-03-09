package com.jeecms.core.manager;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.jeecms.common.page.Pagination;
import com.jeecms.core.JeeCoreManager;
import com.jeecms.core.entity.Admin;
import com.jeecms.core.entity.User;
import com.jeecms.core.exception.UserRegisterException;

/**
 * ����Աmanager�ӿ�
 * 
 * @author liufang
 * 
 */
public interface AdminMng extends JeeCoreManager<Admin> {
	/**
	 * ͨ��ͳһ�û�ID��ù���Ա
	 * 
	 * @param webId
	 * @param userId
	 * @return
	 */
	public Admin getByUserId(Long webId, Long userId);

	/**
	 * ͨ����¼�����ҹ���Ա
	 * 
	 * @param webId
	 * @param loginName
	 * @return
	 */
	public Admin getByLoginName(Long webId, String loginName);

	/**
	 * ���ĳվ�����Ա
	 * 
	 * @param webId
	 * @return
	 */
	public Pagination getAll(Long webId, int page, int countPerPage);

	/**
	 * ����ͳһ�û�ID��ù���Ա�б�
	 * 
	 * @param unitedId
	 * @return
	 */
	public List<Admin> getListByUserId(Long userId);

	/**
	 * ��õ�¼״̬�Ĺ���Ա
	 * 
	 * @param webId
	 * @param adminId
	 * @param userId
	 * @return
	 */
	public Admin getLoginAdmin(Long webId, Long adminId, Long userId);

	/**
	 * ��õ�¼״̬�Ĺ���Ա
	 * 
	 * @param webId
	 * @param adminId
	 * @param userId
	 * @return
	 */
	public Admin getLoginAdmin(String domain, Long adminId, Long userId,
			HttpSession session);

	/**
	 * ע�����Ա
	 * 
	 * @param webId
	 * @param user
	 * @param admin
	 * @param isExist
	 * @return
	 * @throws UserRegisterException
	 */
	public Admin register(Long webId, User user, Admin admin, boolean isExist)
			throws UserRegisterException;
}