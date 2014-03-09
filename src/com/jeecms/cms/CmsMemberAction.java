package com.jeecms.cms;

import com.jeecms.cms.entity.CmsMember;
import com.jeecms.core.entity.Member;
import com.jeecms.core.entity.User;

/**
 * JEECMS��Աaction�Ļ��ࡣ
 * <p>
 * �ṩ��¼��֤������ϵͳ����
 * </p>
 *
 * @author liufang
 *
 */
@SuppressWarnings("unchecked")
public class CmsMemberAction extends CmsIndeAction {
	/**
	 * ����Ƿ��¼�ʹ�����Ϣ����������ʾ��Ϣ
	 *
	 * @return ����¼����null�����򷵻ص�¼��ת����Ϣ��ʾ��
	 */
	protected String checkLoginAndError() {
		if (hasErrors()) {
			return showError();
		}
		User user = getUser();
		// û�е�¼
		if (user == null) {
			if (contextPvd.isMethodPost()) {
				addActionError("�Բ�����û�е�¼���޷����д˲���");
				return showMessage();
			} else {
				return redirectLogin();
			}
		}
		Member member = getMember();
		// ���Ǳ�վ��Ա
		if (member == null) {
			addActionError("���Ǳ�վ��Ա");
			return showMessage();
		}
		CmsMember cmsMember = getCmsMember();
		// ���Ǳ�ϵͳ��Ա
		if (cmsMember == null) {
			addActionError("���Ǳ�ϵͳ��Ա");
			return showMessage();
		}
		return null;
	}

	@Override
	protected String getSysType() {
		return Constants.MEMBER_SYS;
	}
}
