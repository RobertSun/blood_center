package com.jeecms.core.service;

public interface ChannelCacheSvc extends PageCacheSvc {
	/**
	 * »ñµÃkey
	 * 
	 * @param webId
	 * @param chnlPath
	 * @param pageNo
	 * @return
	 */
	public String getKey(Long webId, String chnlPath, int pageNo);

	public void put(Long webId, String chnlPath, int pageNo, byte[] bytes);

	public byte[] get(Long webId, String chnlPath, int pageNo);

	public int remove(Long webId);

	public int remove(Long webId, String chnlPath);

	public boolean remove(Long webId, String chnlPath, int pageNo);

}
