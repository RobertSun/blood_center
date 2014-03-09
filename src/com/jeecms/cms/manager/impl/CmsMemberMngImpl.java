package com.jeecms.cms.manager.impl;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.jeecms.cms.dao.CmsMemberDao;
import com.jeecms.cms.entity.CmsConfig;
import com.jeecms.cms.entity.CmsMember;
import com.jeecms.cms.manager.CmsConfigMng;
import com.jeecms.cms.manager.CmsMemberGroupMng;
import com.jeecms.cms.manager.CmsMemberMng;
import com.jeecms.common.hibernate3.Updater;
import com.jeecms.common.util.ComUtils;
import com.jeecms.core.JeeCoreManagerImpl;
import com.jeecms.core.entity.Member;
import com.jeecms.core.entity.User;
import com.jeecms.core.exception.UserRegisterException;
import com.jeecms.core.manager.MemberMng;

@Service
@Transactional
public class CmsMemberMngImpl extends JeeCoreManagerImpl<CmsMember> implements
		CmsMemberMng {
	public CmsMember register(Long webId, User user, Member member,
			CmsMember cmsMember, boolean isExist) throws UserRegisterException {
		Assert.notNull(webId);
		Assert.notNull(user);
		Assert.notNull(member);
		Assert.notNull(cmsMember);
		member = memberMng.register(webId, user, member, isExist);
		// 如果CMS会员已经存在，则返回CMS会员对象。
		CmsMember ocmember = findById(member.getId());
		if (ocmember != null) {
			return ocmember;
		} else {
			cmsMember.setWebsite(member.getWebsite());
			cmsMember.setScore(0);
			cmsMember.setUploadSize(0);
			cmsMember.setUploadTotalSize(0L);
			cmsMember.setDisabled(false);
			cmsMember.setCoupon(0);
			cmsMember.setWebsite(member.getWebsite());
			cmsMember.setMember(member);
			return save(cmsMember);
		}
	}

	public CmsMember register(Long webId, Long groupId, User user,
			boolean isExist) throws UserRegisterException {
		Assert.notNull(webId);
		Assert.notNull(groupId);
		Assert.notNull(user);
		CmsMember cmsMember = new CmsMember();
		cmsMember.setGroup(cmsMemberGroupMng.findById(groupId));
		Member member = new Member();
		return register(webId, user, member, cmsMember, isExist);
	}

	public boolean autoRegist(Long webId, Long memberId) {
		if (memberId == null) {
			return true;
		}
		Member member = memberMng.findById(memberId);
		Member m = memberMng.getByUserId(webId, member.getUser().getId());
		if (m == null) {
			CmsConfig config = cmsconfigMng.findById(webId);
			if (!config.isOpenRegister()) {
				return true;
			}
			if (config.getAutoRegister() == null) {
				return true;
			}
			if (config.getAutoRegister()) {
				if (config.getMemberGroup() == null) {
					return true;
				}
				register(webId, config.getMemberGroup().getId(), member
						.getUser(), true);
			}
		}
		return false;
	}

	@Override
	public Object updateByUpdater(Updater updater) {
		CmsMember member = (CmsMember) super.updateByUpdater(updater);
		return member;
	}

	@Override
	public CmsMember save(CmsMember member) {
		initCmsMember(member);
		super.save(member);
		return member;
	}

	private void initCmsMember(CmsMember member) {
		if (member.getCoupon() != null) {
			member.setCoupon(0);
		}
		if (member.getScore() != null) {
			member.setScore(0);
		}
		member.setUploadSize(0);
		member.setUploadStatDate(ComUtils.now());
		member.setUploadTotalSize(0L);
		member.setDisabled(false);
	}

	@Override
	public CmsMember findById(Serializable id) {
		CmsMember member = super.findById(id);
		return member;
	}

	@Override
	public CmsMember deleteById(Serializable id) {
		CmsMember member = super.deleteById(id);
		return member;
	}

	@Autowired
	private MemberMng memberMng;
	@Autowired
	private CmsConfigMng cmsconfigMng;
	@Autowired
	private CmsMemberGroupMng cmsMemberGroupMng;

	@Autowired
	public void setCmsMemberDao(CmsMemberDao dao) {
		super.setDao(dao);
	}

	public CmsMemberDao getCmsMemberDao() {
		return (CmsMemberDao) super.getDao();
	}

}
