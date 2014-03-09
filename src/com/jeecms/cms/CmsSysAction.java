package com.jeecms.cms;

import org.springframework.beans.factory.annotation.Autowired;

import com.jeecms.cms.entity.CmsAdmin;
import com.jeecms.cms.entity.CmsConfig;
import com.jeecms.cms.entity.CmsMember;
import com.jeecms.cms.manager.CmsAdminMng;
import com.jeecms.cms.manager.CmsConfigMng;
import com.jeecms.cms.manager.CmsMemberMng;
import com.jeecms.core.JeeCoreAction;
import com.jeecms.core.entity.Admin;
import com.jeecms.core.exception.AdminNotFoundException;

/**
 * jeecms��action���ȡ�
 * <p>
 * ����cms����Ա
 * </p>
 *
 * @author liufang
 *
 */
@SuppressWarnings({ "serial", "unchecked" })
public abstract class CmsSysAction extends JeeCoreAction {
	/**
	 * ���JEECMS����ԱID
	 * <p>
	 * ���������׳��쳣
	 * </p>
	 *
	 * @return
	 */
	public Long getCmsAdminId() throws AdminNotFoundException {
		// ������ʿ��ƣ�adminId������ȷ��
		Long adminId = (Long) contextPvd.getSessionAttr(Admin.ADMIN_KEY);
		if (adminId == null) {
			throw new AdminNotFoundException("����JEECMSϵͳ�Ĺ���Ա��");
		} else {
			return adminId;
		}
	}

	/**
	 * ���JEECMS����Ա����
	 *
	 * @return
	 */
	public CmsAdmin getCmsAdmin() throws AdminNotFoundException {
		return cmsAdminMng.findById(getCmsAdminId());
	}

	/**
	 * ���JEECMS��Ա����
	 *
	 * @return
	 */
	public CmsMember getCmsMember() {
		Long memberId = getMemberId();
		if (memberId == null) {
			return null;
		} else {
			return cmsMemberMng.findById(memberId);
		}
	}

	/**
	 * ���JEECMS��Ա����ID
	 *
	 * @return
	 */
	public Long getCmsMemberId() {
		CmsMember cmsMember = getCmsMember();
		if (cmsMember == null) {
			return null;
		} else {
			return cmsMember.getId();
		}
	}

	/**
	 * ���JEECMS���ö���
	 *
	 * @return
	 */
	public CmsConfig getConfig() {
		return cmsConfigMng.findById(getWebId());
	}

	@Autowired
	protected CmsAdminMng cmsAdminMng;
	@Autowired
	protected CmsConfigMng cmsConfigMng;
	@Autowired
	protected CmsMemberMng cmsMemberMng;
}
