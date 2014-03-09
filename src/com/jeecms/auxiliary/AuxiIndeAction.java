package com.jeecms.auxiliary;

import static com.jeecms.cms.Constants.CMS_MEMBER_LOGIN;
import static com.jeecms.cms.Constants.MEMBER_SYS;

import org.springframework.beans.factory.annotation.Autowired;

import com.jeecms.auxiliary.entity.AuxiConfig;
import com.jeecms.auxiliary.manager.AuxiConfigMng;
import com.jeecms.core.IndeBaseAction;

/**
 * ����ϵͳ����ҳ���action���ȡ�
 * <p>
 * ����AuxiConfig����
 * </p>
 *
 * @author liufang
 *
 */
@SuppressWarnings("unchecked")
public class AuxiIndeAction extends IndeBaseAction {
	@Override
	protected String getSolution() {
		return getWeb().getSolutions().get(Constants.AUXILIARY_SYS);
	}

	@Override
	protected String getSysType() {
		return Constants.AUXILIARY_SYS;
	}

	public AuxiConfig getConfig() {
		return auxiConfigMng.findById(getWebId());
	}

	/**
	 * ������Ϣ��ʾҳ�棬�޷��ذ�ť�������Ѿ���¼����û��Ȩ�޵���ʾ��
	 *
	 * @return
	 */
	protected String showMessage() {
		return handleResult(SHOW_MESSAGE, MEMBER_SYS);
	}

	/**
	 * ��ʾ������Ϣ���з��ذ�ť�������Զ���ת������֤��������ʾ��
	 *
	 * @return
	 */
	protected String showError() {
		return handleResult(SHOW_ERROR, MEMBER_SYS);
	}

	/**
	 * ��ʾ���ɹ���Ϣ���з��ذ�ť��2����Զ���ת�����޸�����ɹ�����Ҫ�ṩ�������ӵ�ַ��
	 *
	 * @return
	 */
	protected String showSuccess() {
		return handleResult(SHOW_SUCCESS, MEMBER_SYS);
	}

	/**
	 * �ض��򵽵�¼ҳ��
	 *
	 * @return
	 */
	protected String redirectLogin() {
		rootWebUrl = getWeb().getRootWeb().getWebUrl();
		return CMS_MEMBER_LOGIN;
	}

	@Autowired
	protected AuxiConfigMng auxiConfigMng;
}
