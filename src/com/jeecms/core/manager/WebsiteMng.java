package com.jeecms.core.manager;

import java.util.List;

import com.jeecms.common.page.Pagination;
import com.jeecms.core.entity.Website;

/**
 * 站点管理。
 * 
 * <p>
 * 站点管理是整个jeesys的核心，由于访问频繁，必须使用缓存。
 * </P>
 * <p>
 * 这个接口设计的很一般，基本能用。
 * </p>
 * 
 * @author liufang
 */
public interface WebsiteMng {
	/**
	 * 将所有站点读入缓存
	 */
	public void loadAllWebsiteToCache();

	public Website save(Website website);

	/**
	 * 根据域名从缓存查找站点。
	 * 
	 * @param domainName
	 *            站点域名
	 * @return
	 */
	public Website getWebsite(String domainName);

	/**
	 * 根据ID从缓存查找站点
	 * 
	 * @param id
	 *            站点ID
	 * @return
	 */
	public Website getWebsite(Long id);

	/**
	 * 通过域名别名查找站点
	 * 
	 * @param domainName
	 *            网站别名
	 * @return 如果站点不存在则返回null
	 */
	public Website getByAlias(String domainName);

	/**
	 * 从缓存中获得所有站点列表
	 * 
	 * @return
	 */
	public List<Website> getAllWebsite();

	/**
	 * 从数据库获得分页列表
	 * 
	 * @param page
	 *            第几页
	 * @param countPerPage
	 *            每页几条
	 * @return
	 */
	public Pagination getAllWebsite(int page, int countPerPage);

	/**
	 * 获得列表。去除自身及自身的子站点
	 * 
	 * @param webId
	 * @return
	 */
	public List<Website> getListForUpdate(Long webId);

	/**
	 * 从缓存和数据库中删除站点和缓存
	 * 
	 * @param website
	 * @return
	 */
	public Website removeWebsite(Long id);

	/**
	 * 更新缓存和数据库的站点，对象中null字段不更新。
	 * 
	 * @param website
	 * @return
	 */
	public Website updateWebsite(Website website);

	/**
	 * 获得管理员的所有站点
	 * 
	 * @param userId
	 * @return
	 */
	public List<Website> getListByUserId(Long userId);

	/**
	 * 检查域名是否存在
	 * 
	 * @param domain
	 * @return
	 */
	public boolean checkDomain(String domain);

	/**
	 * 检查资源路径是否存在
	 * 
	 * @param resPath
	 * @return
	 */
	public boolean checkResPath(String resPath);
}
