package com.jeecms.core.exception;

@SuppressWarnings("serial")
public class NoLogonException extends RuntimeException {
	public NoLogonException() {
		super();
	}

	public NoLogonException(String msg) {
		super(msg);
	}
}
