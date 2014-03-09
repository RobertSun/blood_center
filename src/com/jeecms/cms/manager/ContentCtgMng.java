package com.jeecms.cms.manager;

import java.util.List;

import com.jeecms.cms.entity.ContentCtg;
import com.jeecms.core.JeeCoreManager;

public interface ContentCtgMng extends JeeCoreManager<ContentCtg> {
	/**
	 * 获得站点内容属性列表
	 * 
	 * @param webId
	 * @param disabled
	 *            是否停止使用，为null则查询所有。
	 * @return
	 */
	public List<ContentCtg> getList(Long webId, Boolean disabled);

	/**
	 * 获得第一个内容属性
	 * 
	 * @param webId
	 * @return
	 */
	public ContentCtg getFirstCtg(Long webId);

	/**
	 * 根据label获得id
	 * 
	 * @param webId
	 * @param label
	 * @return
	 */
	public ContentCtg getContentCtg(Long webId, String label);

	/**
	 * 检查内容属性label是否重复
	 * 
	 * @param webId
	 * @param label
	 * @return
	 */
	public boolean checkLabel(Long webId, String label);
}