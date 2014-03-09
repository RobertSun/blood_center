package com.jeecms.core.manager.impl;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.jeecms.common.hibernate3.Updater;
import com.jeecms.common.page.Pagination;
import com.jeecms.common.struts2.ContextPvd;
import com.jeecms.core.JeeCoreManagerImpl;
import com.jeecms.core.dao.MemberDao;
import com.jeecms.core.entity.Member;
import com.jeecms.core.entity.User;
import com.jeecms.core.entity.Website;
import com.jeecms.core.exception.UserRegisterException;
import com.jeecms.core.manager.MemberMng;
import com.jeecms.core.manager.UserMng;
import com.jeecms.core.manager.WebsiteMng;

@Service
@Transactional
public class MemberMngImpl extends JeeCoreManagerImpl<Member> implements
		MemberMng {

	public Pagination getAll(Long webId, int page, int countPerPage) {
		Member example = new Member();
		example.setWebsite(new Website(webId));
		return findByEg(example, page, countPerPage);
	}

	public List<Member> getAll(Long webId) {
		Member example = new Member();
		example.setWebsite(new Website(webId));
		return findByEgList(example);
	}

	public Member getByLoginName(Long webId, String loginName) {
		User user = userMng.getByLoginName(loginName);
		if (user != null) {
			return getByUserId(webId, user.getId());
		} else {
			return null;
		}

	}

	public Member register(Long webId, User user, Member member, boolean isExist)
			throws UserRegisterException {
		Assert.notNull(webId);
		Assert.notNull(user);
		Assert.notNull(member);
		user = userMng.register(user, isExist);
		// 原会员
		Member omember = getByUserId(webId, user.getId());
		if (omember != null) {
			return omember;
		} else {
			member.setWebsite(websiteMng.getWebsite(webId));
			member.setUser(user);
			return save(member);
		}
	}

	public Member register(Long webId, User user, boolean isExist)
			throws UserRegisterException {
		Assert.notNull(webId);
		Assert.notNull(user);
		Member member = new Member();
		return register(webId, user, member, isExist);
	}

	public Member getByUserId(Long webId, Long userId) {
		return getDao().getByUserId(webId, userId);
	}

	public Member getLoginMember(Long webId, Long userId, Long memberId) {
		// 用户未登录
		if (userId == null) {
			return null;
		}
		// 会员已登录
		if (memberId != null) {
			Member member = findById(memberId);
			// 会员与当前站点一致
			if (member.getWebsite().getId().equals(webId)) {
				return member;
			}
		}
		// 用户登录，会员未登录
		Member m = getByUserId(webId, userId);
		if (m != null) {
			// 保存登录信息
			contextPvd.setSessionAttr(Member.MEMBER_KEY, m.getId());
		}
		return m;
	}

	@Override
	public Object updateByUpdater(Updater updater) {
		Member member = (Member) super.updateByUpdater(updater);
		return member;
	}

	@Override
	public Member save(Member member) {
		initMember(member);
		return super.save(member);
	}

	private void initMember(Member member) {
		member.setDisabled(false);
		member.setCreateTime(new Timestamp(System.currentTimeMillis()));
	}

	@Override
	public Member findById(Serializable id) {
		Member member = super.findById(id);
		return member;
	}

	@Override
	public Member deleteById(Serializable id) {
		Member member = super.deleteById(id);
		return member;
	}

	@Autowired
	private ContextPvd contextPvd;
	@Autowired
	private UserMng userMng;
	@Autowired
	private WebsiteMng websiteMng;

	@Autowired
	public void setDao(MemberDao dao) {
		super.setDao(dao);
	}

	protected MemberDao getDao() {
		return (MemberDao) super.getDao();
	}

}
