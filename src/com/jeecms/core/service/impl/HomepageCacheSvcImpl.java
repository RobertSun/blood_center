package com.jeecms.core.service.impl;

import java.io.Serializable;

import net.sf.ehcache.Cache;
import net.sf.ehcache.Element;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.jeecms.core.service.HomepageCacheSvc;

@Service
public class HomepageCacheSvcImpl implements HomepageCacheSvc {
	public void put(Serializable key, byte[] bytes) {
		homepageCache.put(new Element(key, bytes));
	}

	public byte[] get(Serializable key) {
		Element e = homepageCache.get(key);
		if (e != null) {
			return (byte[]) e.getValue();
		} else {
			return null;
		}
	}

	public boolean remove(Long webId) {
		return homepageCache.remove(webId);
	}

	@Autowired
	public void setHomepageCache(@Qualifier("homepage") Cache homepageCache) {
		this.homepageCache = homepageCache;
	}

	private Cache homepageCache;
}
