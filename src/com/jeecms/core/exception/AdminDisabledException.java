package com.jeecms.core.exception;

/**
 * ����Ա�����쳣
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
