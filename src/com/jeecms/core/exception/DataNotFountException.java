package com.jeecms.core.exception;

/**
 * 数据没有找到异常。
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
