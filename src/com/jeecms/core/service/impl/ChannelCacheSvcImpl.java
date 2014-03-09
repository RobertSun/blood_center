package com.jeecms.core.service.impl;

import java.io.Serializable;

import net.sf.ehcache.Cache;
import net.sf.ehcache.Element;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.jeecms.core.service.ChannelCacheSvc;

@Service
public class ChannelCacheSvcImpl implements ChannelCacheSvc {
	public void put(Serializable key, byte[] bytes) {
		channelCache.put(new Element(key, bytes));
	}

	public byte[] get(Serializable key) {
		Element e = channelCache.get(key);
		if (e != null) {
			return (byte[]) e.getValue();
		} else {
			return null;
		}
	}

	public String getKey(Long webId, String chnlPath, int pageNo) {
		return new StringBuilder(String.valueOf(webId)).append(SPLIT).append(
				chnlPath).append(SPLIT).append(pageNo).append(SPLIT).toString();
	}

	public void put(Long webId, String chnlPath, int pageNo, byte[] bytes) {
		channelCache.put(new Element(getKey(webId, chnlPath, pageNo), bytes));
	}

	public byte[] get(Long webId, String chnlPath, int pageNo) {
		return get(getKey(webId, chnlPath, pageNo));
	}

	public int remove(Long webId) {
		String begin = String.valueOf(webId) + SPLIT;
		return remove(begin);
	}

	public int remove(Long webId, String chnlPath) {
		String begin = String.valueOf(webId) + SPLIT + chnlPath + SPLIT;
		return remove(begin);
	}

	public boolean remove(Long webId, String chnlPath, int pageNo) {
		return channelCache.remove(getKey(webId, chnlPath, pageNo));
	}

	private int remove(String begin) {
		int count = 0;
		for (Object key : channelCache.getKeys()) {
			String k = (String) key;
			if (k.startsWith(begin)) {
				count++;
				channelCache.remove(k);
			}
		}
		return count;
	}

	@Autowired
	public void setChannelCache(@Qualifier("channel") Cache channelCache) {
		this.channelCache = channelCache;
	}

	private Cache channelCache;
}
