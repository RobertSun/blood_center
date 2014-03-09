package com.jeecms.cms;

import org.springframework.beans.factory.annotation.Autowired;

import com.jeecms.cms.entity.CmsConfig;
import com.jeecms.cms.entity.CmsMember;
import com.jeecms.cms.manager.CmsConfigMng;
import com.jeecms.cms.manager.CmsMemberMng;
import com.jeecms.core.IndeBaseAction;

/**
 * JEECMS����ҳ���action���ȡ�
 * <p>
 * ����CmsConfig���ú͵�ǰϵͳģ�巽��
 * </p>
 *
 * @author liufang
 *
 */
@SuppressWarnings("unchecked")
public abstract class CmsIndeAction extends IndeBaseAction {
	@Override
	protected String getSolution() {
		return getConfig().getSolution(getSysType());
	}

	@Override
	protected String getSysType() {
		return Constants.COMMON_SYS;
	}

	/**
	 * ���CMS���ö���
	 *
	 * @return
	 */
	public CmsConfig getConfig() {
		return cmsConfigMng.findById(getWebId());
	}

	/**
	 * ���CMS��Ա
	 *
	 * @return
	 */
	public CmsMember getCmsMember() {
		Long memberId = getMemberId();
		if (memberId == null) {
			return null;
		} else {
			CmsMember cmsMember = cmsMemberMng.findById(memberId);
			if (cmsMember != null && cmsMember.getMemberDisabled()) {
				throw new RuntimeException("����ʺ��Ѿ������ã�");
			}
			return cmsMemberMng.findById(memberId);
		}
	}

	/**
	 * ������Ϣ��ʾҳ�棬�޷��ذ�ť�������Ѿ���¼����û��Ȩ�޵���ʾ��
	 *
	 * @return
	 */
	protected String showMessage() {
		return handleResult(SHOW_MESSAGE, Constants.MEMBER_SYS);
	}

	/**
	 * ��ʾ������Ϣ���з��ذ�ť�������Զ���ת������֤��������ʾ��
	 *
	 * @return
	 */
	protected String showError() {
		return handleResult(SHOW_ERROR, Constants.MEMBER_SYS);
	}

	/**
	 * ��ʾ���ɹ���Ϣ���з��ذ�ť��2����Զ���ת�����޸�����ɹ�����Ҫ�ṩ�������ӵ�ַ��
	 *
	 * @return
	 */
	protected String showSuccess() {
		return handleResult(SHOW_SUCCESS, Constants.MEMBER_SYS);
	}

	/**
	 * �ض��򵽵�¼ҳ��
	 *
	 * @return
	 */
	protected String redirectLogin() {
		rootWebUrl = getWeb().getRootWeb().getWebUrl();
		return Constants.CMS_MEMBER_LOGIN;
	}

	@Autowired
	protected CmsConfigMng cmsConfigMng;

	@Autowired
	protected CmsMemberMng cmsMemberMng;
}
