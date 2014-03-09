package com.jeecms.cms.entity;

import com.jeecms.cms.entity.base.BaseCmsConfig;

public class CmsConfig extends BaseCmsConfig {
	private static final long serialVersionUID = 1L;
	public static final int CLOSE_REGISTER = 0;
	public static final int OPEN_REGISTER = 1;
	public static final int INVITATION_REGISTER = 2;

	/**
	 * 获得评论排序方式。
	 * 
	 * @return 1：id降序；0：id升序
	 */
	public int getCommentOderBy() {
		if (getCommentSort()) {
			return 0;
		} else {
			return 1;
		}
	}

	/**
	 * 获得模板方案
	 * 
	 * @param sysType
	 * @return
	 */
	public String getSolution(String sysType) {
		String solution = getWebsite().getSolutions().get(sysType);
		if (solution == null) {
			throw new RuntimeException("不存在该系统的模板方案：" + sysType);
		}
		return solution;
	}

	/**
	 * 是否允许注册
	 * 
	 * @return
	 */
	public boolean isOpenRegister() {
		Integer status = getRegisterStatus();
		if (status == null) {
			return false;
		}
		if (status.equals(OPEN_REGISTER)) {
			return true;
		} else {
			return false;
		}
	}

	/* [CONSTRUCTOR MARKER BEGIN] */
	public CmsConfig() {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public CmsConfig(java.lang.Long id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public CmsConfig(java.lang.Long id, java.lang.Integer checkCount,
			java.lang.String defaultSystem, java.lang.Boolean commentNeedCheck,
			java.lang.Boolean commentNeedLogin, java.lang.Boolean commentSort,
			java.lang.Integer commentMaxLength,
			java.lang.Boolean cacheHomepage, java.lang.Boolean cacheChannel) {

		super(id, checkCount, defaultSystem, commentNeedCheck,
				commentNeedLogin, commentSort, commentMaxLength, cacheHomepage,
				cacheChannel);
	}

	/* [CONSTRUCTOR MARKER END] */

}