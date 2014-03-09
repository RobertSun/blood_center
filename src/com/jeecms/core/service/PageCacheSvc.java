package com.jeecms.core.service;

import java.io.Serializable;

import com.jeecms.core.service.CacheSvc;

/**
 * 整页缓存通用接口
 * 
 * @author liufang
 * 
 */
public interface PageCacheSvc extends CacheSvc {
	public void put(Serializable key, byte[] bytes);

	public byte[] get(Serializable key);
}
