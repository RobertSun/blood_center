package com.jeecms.core.exception;

/**
 * 缺少注册的必要信息。
 * 
 * @author liufang
 * 
 */
@SuppressWarnings("serial")
public class LackOfInfomationException extends UserRegisterException {
	public LackOfInfomationException() {
		super();
	}

	public LackOfInfomationException(String msg) {
		super(msg);
	}
}
