package com.jeecms.cms.dao;

import java.util.List;

import com.jeecms.cms.entity.CmsChannel;
import com.jeecms.core.JeeCoreDao;

public interface CmsChannelDao extends JeeCoreDao<CmsChannel> {
	/**
	 * ����·��������Ŀ
	 * 
	 * @param webId
	 * @param path
	 *            ��Ŀ·��
	 * @return
	 */
	public CmsChannel getByPath(Long webId, String path);

	/**
	 * ���Ҹ���Ŀ
	 * 
	 * @param webId
	 * @param sysType
	 *            ϵͳ����
	 * @return
	 */
	public CmsChannel getRoot(Long webId, String sysType);

	/**
	 * ���Ҹ���Ŀ�����������������˲������ӽڵ����Ŀ��
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