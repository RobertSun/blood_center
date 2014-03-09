package com.jeecms.core.manager;

import javax.naming.AuthenticationException;

import com.jeecms.core.JeeCoreManager;
import com.jeecms.core.entity.User;
import com.jeecms.core.exception.UserRegisterException;

public interface UserMng extends JeeCoreManager<User> {
	/**
	 * 通过登录名查找用户，并使用缓存。
	 * 
	 * @param loginName
	 * @return 返回用户。用户不存在返回null。
	 */
	public User getByLoginName(String loginName);

	/**
	 * 检查登录名是否已经被注册
	 * 
	 * @param loginName
	 * @return true：没有被注册；false：已经被注册
	 */
	public boolean checkLoginName(String loginName);

	/**
	 * 通过email查找用户。
	 * 
	 * @param email
	 * @return
	 */
	public User getUserByEmail(String email);

	/**
	 * 检查email是否已经被使用
	 * 
	 * @param email
	 * @return true：没有被使用；false：已经被使用
	 */
	public boolean checkEmail(String email);

	/**
	 * 认证。并返回用户对象。认证失败抛出异常。
	 * 
	 * @param loginName
	 * @param password
	 * @return
	 */
	public User authenticate(String loginName, String password);

	/**
	 * 登录。登录成功后保存至session。
	 * 
	 * @param loginName
	 * @param password
	 * @return
	 * @throws AuthenticationException
	 */
	public User login(String loginName, String password);

	/**
	 * 更新密码和邮箱
	 * 
	 * @param oldPwd
	 *            原密码
	 * @param newPwd
	 *            新密码，为null则不修改
	 * @param email
	 *            邮箱，为null则不修改
	 * @return 是否更新成功
	 */
	public boolean updatePwdEmail(User user, String oldPwd, String newPwd,
			String email);

	/**
	 * 更新密码
	 * 
	 * @param id
	 * @param newPwd
	 */
	public void updatePassword(Long id, String newPwd);

	/**
	 * 更新登录信息
	 * 
	 * @param user
	 */
	public void updateLoginInfo(User user);

	/**
	 * 注册用户
	 * 
	 * 已存在用户需提供loginName，可获得该用户对象。 新用户必须提供loginname、email、password。
	 * 
	 * @param user
	 * @param isExist
	 *            用户是否存在
	 * @return
	 * @throws UserRegisterException
	 */
	public User register(User user, boolean isExist)
			throws UserRegisterException;
}