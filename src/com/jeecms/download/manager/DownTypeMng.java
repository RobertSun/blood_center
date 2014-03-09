package com.jeecms.download.manager;

import java.util.List;

import com.jeecms.core.JeeCoreManager;
import com.jeecms.download.entity.DownType;

public interface DownTypeMng extends JeeCoreManager<DownType> {

	/**
	 * ����վ�������������б���priority����
	 * 
	 * @param webId
	 *            վ��ID
	 * @param all
	 *            true������������ԣ�false��δ�����������
	 * @return
	 */
	public List<DownType> getList(Long webId, boolean all);

	public void updatePriority(Long[] wids, int[] prioritys);
}