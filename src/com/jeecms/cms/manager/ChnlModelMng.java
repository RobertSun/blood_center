package com.jeecms.cms.manager;

import java.util.List;

import com.jeecms.cms.entity.ChnlModel;
import com.jeecms.cms.entity.ChnlModelItem;
import com.jeecms.core.JeeCoreManager;

public interface ChnlModelMng extends JeeCoreManager<ChnlModel> {
	/**
	 * 获得栏目模型
	 * 
	 * @param webId
	 * @param all
	 *            是否显示所有。为false时不显示display为false的模型
	 * @return
	 */
	public List<ChnlModel> getModels(Long webId, boolean all);

	/**
	 * 获得栏目模型
	 * 
	 * @param webId
	 * @param sysType
	 *            系统类型
	 * @param all
	 *            是否显示所有。为false时不显示display为false的模型
	 * @return
	 */
	public List<ChnlModel> getModels(Long webId, String sysType, boolean all);

	/**
	 * 获得可以有子节点的模型id数组
	 * 
	 * @param webId
	 * @return
	 */
	public Long[] getHasChildIds(Long webId);

	/**
	 * 更新模型。不属于模型的模型项将不被更新
	 * 
	 * @param model
	 *            模型
	 * @param modelItems
	 *            模型项
	 * @return
	 */
	public ChnlModel updateModel(ChnlModel model, List<ChnlModelItem> modelItems);

}