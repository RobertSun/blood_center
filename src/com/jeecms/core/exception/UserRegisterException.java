package com.jeecms.core.exception;

/**
 * �û�ע���쳣��
 * 
 * @author liufang
 * 
 */
@SuppressWarnings("serial")
public class UserRegisterException extends RuntimeException {
	public UserRegisterException() {
		super();
	}

	public UserRegisterException(String msg) {
		super(msg);
	}
}
