package com.jeecms.core.exception;

/**
 * ����û���ҵ��쳣��
 * 
 * @author liufang
 * 
 */
public class DataNotFountException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public DataNotFountException() {
		super();
	}

	public DataNotFountException(String msg) {
		super(msg);
	}
}
