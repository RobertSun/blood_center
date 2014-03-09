package com.jeecms.cms.manager;

import java.util.List;

import com.jeecms.cms.entity.ContentCtg;
import com.jeecms.core.JeeCoreManager;

public interface ContentCtgMng extends JeeCoreManager<ContentCtg> {
	/**
	 * ���վ�����������б�
	 * 
	 * @param webId
	 * @param disabled
	 *            �Ƿ�ֹͣʹ�ã�Ϊnull���ѯ���С�
	 * @return
	 */
	public List<ContentCtg> getList(Long webId, Boolean disabled);

	/**
	 * ��õ�һ����������
	 * 
	 * @param webId
	 * @return
	 */
	public ContentCtg getFirstCtg(Long webId);

	/**
	 * ����label���id
	 * 
	 * @param webId
	 * @param label
	 * @return
	 */
	public ContentCtg getContentCtg(Long webId, String label);

	/**
	 * �����������label�Ƿ��ظ�
	 * 
	 * @param webId
	 * @param label
	 * @return
	 */
	public boolean checkLabel(Long webId, String label);
}