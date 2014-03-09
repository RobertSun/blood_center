package com.jeecms.cms.manager;

import java.util.Collection;
import java.util.List;

import com.jeecms.core.JeeCoreManager;
import com.jeecms.core.util.UploadRule;
import com.jeecms.cms.entity.CmsAdmin;
import com.jeecms.cms.entity.CmsChannel;

public interface CmsChannelMng extends JeeCoreManager<CmsChannel> {
	/**
	 * 获得栏目子节点。
	 * <p>
	 * start和count都为0时，不限制结果数量。
	 * </p>
	 * 
	 * @param webId
	 * @param pid
	 *            父节点ID
	 * @param orderBy
	 *            排序方式。0：优先级升序；1：优先级降序；2：点击次数升序；3：点击次数降序
	 * @param isDisplay
	 *            是否只获取显示的栏目
	 * @param hasChild
	 *            是否只获取可以有内容的栏目
	 * @param start
	 * @param count
	 * @return
	 */
	public List<CmsChannel> getChild(Long webId, String sysType, Long pid,
			int orderBy, boolean isDisplay, boolean hasChild, int start,
			int count);

	/**
	 * 通过栏目路径获得栏目对象
	 * 
	 * @param webId
	 * @param path
	 * @return
	 */
	public CmsChannel getByPath(Long webId, String path);

	/**
	 * 获得根栏目列表
	 * 
	 * @param webId
	 * @param sysType
	 *            系统类型
	 * @return
	 */
	public CmsChannel getRoot(Long webId, String sysType);

	/**
	 * 获得根栏目，启动过滤器，过滤不能有子节点的栏目
	 * 
	 * @param webId
	 * @param sysType
	 * @param hasChild
	 * @return
	 */
	public CmsChannel getRoot(Long webId, String sysType, boolean hasChild);

	public boolean isChild(Long pid, Long cid);

	public List<CmsChannel> getRightChnl(Long webId, String sysType,
			Long adminId, Boolean hasChild);

	public List<CmsChannel> getRightChnl(Long webId, String sysType,
			Long chnlId, Long adminId, Long modelId, Boolean hasChild);

	public List<CmsChannel> getChnlsAndExclude(Long webId, String sysType,
			Long excludeNode);

	public CmsChannel saveChannel(CmsChannel chnl, CmsAdmin admin,
			Collection<CmsAdmin> admins, UploadRule rule);

	public CmsChannel updateChannel(CmsChannel chnl, CmsAdmin admin,
			Collection<CmsAdmin> admins, UploadRule rule);

	public List<CmsChannel> getChnlsForMember(Long webId, Integer groupLevel);
}