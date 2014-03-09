package com.jeecms.core.entity;

import com.jeecms.core.entity.base.BaseAttachment;

public class Attachment extends BaseAttachment {
	private static final long serialVersionUID = 1L;

	/**
	 * ��ø��������·����
	 * �磺/res_base/sina_com_www/upload/article/image/2008_2/5_20/fdfe2swetv.jpg
	 * 
	 * @return
	 */
	public String getRelPath() {
		Website web = getWebsite();
		if (web != null) {
			return web.getUploadRoot().append(getFilePath()).toString();
		} else {
			return null;
		}
	}

	/**
	 * ���ӵ�����ĵ���URL
	 * 
	 * @return
	 */
	public String getDocUrl() {
		return getWebsite().getWebUrlBuf().append(getOwnerUrl()).toString();
	}

	/* [CONSTRUCTOR MARKER BEGIN] */
	public Attachment() {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public Attachment(java.lang.Long id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public Attachment(java.lang.Long id,
			com.jeecms.core.entity.Website website, java.lang.Boolean free,
			java.lang.Boolean lost) {

		super(id, website, free, lost);
	}
	/* [CONSTRUCTOR MARKER END] */
}