package com.jeecms.core.service;

/**
 * ��ҳ����
 * 
 * @author liufang
 * 
 */
public interface HomepageCacheSvc extends PageCacheSvc {
	public boolean remove(Long webId);
}