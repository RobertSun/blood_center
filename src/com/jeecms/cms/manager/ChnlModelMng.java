package com.jeecms.cms.manager;

import java.util.List;

import com.jeecms.cms.entity.ChnlModel;
import com.jeecms.cms.entity.ChnlModelItem;
import com.jeecms.core.JeeCoreManager;

public interface ChnlModelMng extends JeeCoreManager<ChnlModel> {
	/**
	 * �����Ŀģ��
	 * 
	 * @param webId
	 * @param all
	 *            �Ƿ���ʾ���С�Ϊfalseʱ����ʾdisplayΪfalse��ģ��
	 * @return
	 */
	public List<ChnlModel> getModels(Long webId, boolean all);

	/**
	 * �����Ŀģ��
	 * 
	 * @param webId
	 * @param sysType
	 *            ϵͳ����
	 * @param all
	 *            �Ƿ���ʾ���С�Ϊfalseʱ����ʾdisplayΪfalse��ģ��
	 * @return
	 */
	public List<ChnlModel> getModels(Long webId, String sysType, boolean all);

	/**
	 * ��ÿ������ӽڵ��ģ��id����
	 * 
	 * @param webId
	 * @return
	 */
	public Long[] getHasChildIds(Long webId);

	/**
	 * ����ģ�͡�������ģ�͵�ģ�����������
	 * 
	 * @param model
	 *            ģ��
	 * @param modelItems
	 *            ģ����
	 * @return
	 */
	public ChnlModel updateModel(ChnlModel model, List<ChnlModelItem> modelItems);

}