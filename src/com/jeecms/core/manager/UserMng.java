package com.jeecms.core.manager;

import javax.naming.AuthenticationException;

import com.jeecms.core.JeeCoreManager;
import com.jeecms.core.entity.User;
import com.jeecms.core.exception.UserRegisterException;

public interface UserMng extends JeeCoreManager<User> {
	/**
	 * ͨ����¼�������û�����ʹ�û��档
	 * 
	 * @param loginName
	 * @return �����û����û������ڷ���null��
	 */
	public User getByLoginName(String loginName);

	/**
	 * ����¼���Ƿ��Ѿ���ע��
	 * 
	 * @param loginName
	 * @return true��û�б�ע�᣻false���Ѿ���ע��
	 */
	public boolean checkLoginName(String loginName);

	/**
	 * ͨ��email�����û���
	 * 
	 * @param email
	 * @return
	 */
	public User getUserByEmail(String email);

	/**
	 * ���email�Ƿ��Ѿ���ʹ��
	 * 
	 * @param email
	 * @return true��û�б�ʹ�ã�false���Ѿ���ʹ��
	 */
	public boolean checkEmail(String email);

	/**
	 * ��֤���������û�������֤ʧ���׳��쳣��
	 * 
	 * @param loginName
	 * @param password
	 * @return
	 */
	public User authenticate(String loginName, String password);

	/**
	 * ��¼����¼�ɹ��󱣴���session��
	 * 
	 * @param loginName
	 * @param password
	 * @return
	 * @throws AuthenticationException
	 */
	public User login(String loginName, String password);

	/**
	 * �������������
	 * 
	 * @param oldPwd
	 *            ԭ����
	 * @param newPwd
	 *            �����룬Ϊnull���޸�
	 * @param email
	 *            ���䣬Ϊnull���޸�
	 * @return �Ƿ���³ɹ�
	 */
	public boolean updatePwdEmail(User user, String oldPwd, String newPwd,
			String email);

	/**
	 * ��������
	 * 
	 * @param id
	 * @param newPwd
	 */
	public void updatePassword(Long id, String newPwd);

	/**
	 * ���µ�¼��Ϣ
	 * 
	 * @param user
	 */
	public void updateLoginInfo(User user);

	/**
	 * ע���û�
	 * 
	 * �Ѵ����û����ṩloginName���ɻ�ø��û����� ���û������ṩloginname��email��password��
	 * 
	 * @param user
	 * @param isExist
	 *            �û��Ƿ����
	 * @return
	 * @throws UserRegisterException
	 */
	public User register(User user, boolean isExist)
			throws UserRegisterException;
}