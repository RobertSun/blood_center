package com.jeecms.core.manager;

import java.util.List;

import com.jeecms.common.page.Pagination;
import com.jeecms.core.entity.Website;

/**
 * վ�����
 * 
 * <p>
 * վ�����������jeesys�ĺ��ģ����ڷ���Ƶ��������ʹ�û��档
 * </P>
 * <p>
 * ����ӿ���Ƶĺ�һ�㣬�������á�
 * </p>
 * 
 * @author liufang
 */
public interface WebsiteMng {
	/**
	 * ������վ����뻺��
	 */
	public void loadAllWebsiteToCache();

	public Website save(Website website);

	/**
	 * ���������ӻ������վ�㡣
	 * 
	 * @param domainName
	 *            վ������
	 * @return
	 */
	public Website getWebsite(String domainName);

	/**
	 * ����ID�ӻ������վ��
	 * 
	 * @param id
	 *            վ��ID
	 * @return
	 */
	public Website getWebsite(Long id);

	/**
	 * ͨ��������������վ��
	 * 
	 * @param domainName
	 *            ��վ����
	 * @return ���վ�㲻�����򷵻�null
	 */
	public Website getByAlias(String domainName);

	/**
	 * �ӻ����л������վ���б�
	 * 
	 * @return
	 */
	public List<Website> getAllWebsite();

	/**
	 * �����ݿ��÷�ҳ�б�
	 * 
	 * @param page
	 *            �ڼ�ҳ
	 * @param countPerPage
	 *            ÿҳ����
	 * @return
	 */
	public Pagination getAllWebsite(int page, int countPerPage);

	/**
	 * ����б�ȥ�������������վ��
	 * 
	 * @param webId
	 * @return
	 */
	public List<Website> getListForUpdate(Long webId);

	/**
	 * �ӻ�������ݿ���ɾ��վ��ͻ���
	 * 
	 * @param website
	 * @return
	 */
	public Website removeWebsite(Long id);

	/**
	 * ���»�������ݿ��վ�㣬������null�ֶβ����¡�
	 * 
	 * @param website
	 * @return
	 */
	public Website updateWebsite(Website website);

	/**
	 * ��ù���Ա������վ��
	 * 
	 * @param userId
	 * @return
	 */
	public List<Website> getListByUserId(Long userId);

	/**
	 * ��������Ƿ����
	 * 
	 * @param domain
	 * @return
	 */
	public boolean checkDomain(String domain);

	/**
	 * �����Դ·���Ƿ����
	 * 
	 * @param resPath
	 * @return
	 */
	public boolean checkResPath(String resPath);
}
