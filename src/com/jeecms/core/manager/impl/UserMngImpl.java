package com.jeecms.core.manager.impl;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.jeecms.common.hibernate3.Updater;
import com.jeecms.common.struts2.ContextPvd;
import com.jeecms.common.util.PwdEncoder;
import com.jeecms.core.JeeCoreManagerImpl;
import com.jeecms.core.dao.UserDao;
import com.jeecms.core.entity.User;
import com.jeecms.core.exception.UserRegisterException;
import com.jeecms.core.manager.UserMng;

@Service
@Transactional
public class UserMngImpl extends JeeCoreManagerImpl<User> implements UserMng {

	public User authenticate(String loginName, String password) {
		User user = getByLoginName(loginName);
		if (user != null) {
			String md5Pwd = pwdEncoder.encodePassword(password);
			if (md5Pwd.equals(user.getPassword())) {
				return user;
			}
		}
		return null;
	}

	public User login(String loginName, String password) {
		User united = authenticate(loginName, password);
		updateLoginInfo(united);
		contextPvd.setSessionAttr(User.USER_KEY, united);
		return united;
	}

	public boolean updatePwdEmail(User user, String oldPwd, String newPwd,
			String email) {
		if (!pwdEncoder.isPasswordValid(user.getPassword(), oldPwd)) {
			return false;
		}
		if (!StringUtils.isBlank(newPwd)) {
			user.setPassword(pwdEncoder.encodePassword(newPwd));
		}
		if (!StringUtils.isBlank(email)) {
			user.setEmail(email);
		}
		update(user);
		return true;
	}

	public void updatePassword(Long id, String newPwd) {
		User user = findById(id);
		user.setPassword(pwdEncoder.encodePassword(newPwd));
		update(user);
	}

	public void updateLoginInfo(User admin) {
		admin.setLastLoginTime(admin.getCurrentLoginTime());
		admin.setLastLoginIp(admin.getCurrentLoginIp());
		admin.setCurrentLoginTime(new java.sql.Timestamp(System
				.currentTimeMillis()));
		admin.setCurrentLoginIp(contextPvd.getRemoteIp());
		if (admin.getLoginCount() == null || admin.getLoginCount() < 0) {
			admin.setLoginCount(0L);
		}
		admin.setLoginCount(admin.getLoginCount() + 1);
	}

	public User getByLoginName(String loginName) {
		return getDao().getUserByLoginName(loginName);
	}

	public boolean checkLoginName(String loginName) {
		return getDao().countByProperty(User.PROP_LOGIN_NAME, loginName) <= 0 ? true
				: false;
	}

	public User getUserByEmail(String email) {
		return getDao().findUniqueByProperty("email", email);
	}

	public boolean checkEmail(String email) {
		User u = getUserByEmail(email);
		return u == null ? true : false;
	}

	public User register(User user, boolean isExist)
			throws UserRegisterException {
		Assert.notNull(user);
		String loginName = user.getLoginName();
		Assert.hasText(loginName);
		User origUser = getByLoginName(loginName);
		if (isExist) {
			if (origUser == null) {
				throw new UserRegisterException("用户不存在！");
			}
			return origUser;
		} else {
			if (origUser != null) {
				throw new UserRegisterException("该用户名已注册！");
			}
			return save(user);
		}
	}

	@Override
	public Object updateByUpdater(Updater updater) {
		User udt = (User) updater.getBean();
		// 密码加密
		String p = udt.getPassword();
		if (!StringUtils.isBlank(p)) {
			udt.setPassword(pwdEncoder.encodePassword(p));
		} else {
			udt.setPassword(null);
		}
		User after = (User) super.updateByUpdater(updater);
		return after;
	}

	@Override
	public User save(User user) {
		Assert.notNull(user);
		Assert.hasText(user.getLoginName());
		Assert.hasText(user.getPassword());
		Assert.hasText(user.getEmail());
		initUser(user);
		super.save(user);
		return user;
	}

	/**
	 * 初始化用户信息
	 */
	private void initUser(User user) {
		// 默认值处理
		user.setUnreadMsg(0);
		user.setDisabled(false);
		// 密码加密
		String p = pwdEncoder.encodePassword(user.getPassword());
		user.setPassword(p);
		// 即时信息
		String ip = contextPvd.getRemoteIp();
		Date now = new Timestamp(System.currentTimeMillis());
		user.setCreateTime(now);
		user.setCurrentLoginIp(ip);
		user.setCurrentLoginTime(now);
		user.setLastLoginIp(ip);
		user.setLastLoginTime(now);
		user.setLoginCount(0L);
	}

	@Override
	public User findById(Serializable id) {
		User user = super.findById(id);
		return user;
	}

	@Override
	public User deleteById(Serializable id) {
		User user = super.deleteById(id);
		return user;
	}

	@Autowired
	private PwdEncoder pwdEncoder;
	@Autowired
	private ContextPvd contextPvd;

	@Autowired
	public void setDao(UserDao dao) {
		super.setDao(dao);
	}

	public UserDao getDao() {
		return (UserDao) super.getDao();
	}
}
