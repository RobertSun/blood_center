package com.jeecms.core.exception;

/**
 * 管理员没有在本系统找到
 * <p>
 * 一般只在更改站点系统时才会出现，更改系统是不推荐使用的操作。
 * </p>
 * 
 * @author liufang
 * 
 */
@SuppressWarnings("serial")
public class AdminNotFoundException extends RuntimeException {
	public AdminNotFoundException() {
		super();
	}

	public AdminNotFoundException(String msg) {
		super(msg);
	}
}
