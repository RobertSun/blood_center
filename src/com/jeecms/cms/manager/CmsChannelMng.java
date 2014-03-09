package com.jeecms.cms.manager;

import java.util.Collection;
import java.util.List;

import com.jeecms.core.JeeCoreManager;
import com.jeecms.core.util.UploadRule;
import com.jeecms.cms.entity.CmsAdmin;
import com.jeecms.cms.entity.CmsChannel;

public interface CmsChannelMng extends JeeCoreManager<CmsChannel> {
	/**
	 * �����Ŀ�ӽڵ㡣
	 * <p>
	 * start��count��Ϊ0ʱ�������ƽ��������
	 * </p>
	 * 
	 * @param webId
	 * @param pid
	 *            ���ڵ�ID
	 * @param orderBy
	 *            ����ʽ��0�����ȼ�����1�����ȼ�����2�������������3�������������
	 * @param isDisplay
	 *            �Ƿ�ֻ��ȡ��ʾ����Ŀ
	 * @param hasChild
	 *            �Ƿ�ֻ��ȡ���������ݵ���Ŀ
	 * @param start
	 * @param count
	 * @return
	 */
	public List<CmsChannel> getChild(Long webId, String sysType, Long pid,
			int orderBy, boolean isDisplay, boolean hasChild, int start,
			int count);

	/**
	 * ͨ����Ŀ·�������Ŀ����
	 * 
	 * @param webId
	 * @param path
	 * @return
	 */
	public CmsChannel getByPath(Long webId, String path);

	/**
	 * ��ø���Ŀ�б�
	 * 
	 * @param webId
	 * @param sysType
	 *            ϵͳ����
	 * @return
	 */
	public CmsChannel getRoot(Long webId, String sysType);

	/**
	 * ��ø���Ŀ�����������������˲������ӽڵ����Ŀ
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