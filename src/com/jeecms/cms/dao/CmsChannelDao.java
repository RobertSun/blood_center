package com.jeecms.cms.dao;

import java.util.List;

import com.jeecms.cms.entity.CmsChannel;
import com.jeecms.core.JeeCoreDao;

public interface CmsChannelDao extends JeeCoreDao<CmsChannel> {
	/**
	 * 根据路径查找栏目
	 * 
	 * @param webId
	 * @param path
	 *            栏目路径
	 * @return
	 */
	public CmsChannel getByPath(Long webId, String path);

	/**
	 * 查找根栏目
	 * 
	 * @param webId
	 * @param sysType
	 *            系统类型
	 * @return
	 */
	public CmsChannel getRoot(Long webId, String sysType);

	/**
	 * 查找根栏目，启动过滤器，过滤不能有子节点的栏目。
	 * 
	 * @param webId
	 * @param sysType
	 * @return
	 */
	public CmsChannel getRootWithFilter(Long webId, String sysType);

	public boolean isChild(Long pid, Long cid);

	public List<CmsChannel> getRightChnl(Long webId, String sysType,
			Long adminId, Boolean hasChild);

	public List<CmsChannel> getRightChnl(Long webId, String sysType,
			Long chnlId, Long adminId, Long modelId, Boolean hasChild);

	public List<CmsChannel> getChnlsAndExclude(Long webId, String sysType,
			Long excludeNode);

	public List<CmsChannel> getChnlsForMember(Long webId, Integer groupLevel);
}