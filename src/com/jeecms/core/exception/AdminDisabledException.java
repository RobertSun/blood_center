package com.jeecms.core.exception;

/**
 * 管理员禁用异常
 * 
 * @author liufang
 * 
 */
@SuppressWarnings("serial")
public class AdminDisabledException extends RuntimeException {
	public AdminDisabledException() {
		super();
	}

	public AdminDisabledException(String msg) {
		super(msg);
	}
}
