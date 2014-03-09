package com.jeecms.core.service;

import java.io.Serializable;

import com.jeecms.core.service.CacheSvc;

/**
 * ��ҳ����ͨ�ýӿ�
 * 
 * @author liufang
 * 
 */
public interface PageCacheSvc extends CacheSvc {
	public void put(Serializable key, byte[] bytes);

	public byte[] get(Serializable key);
}
