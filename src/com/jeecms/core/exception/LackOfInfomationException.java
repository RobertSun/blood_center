package com.jeecms.core.exception;

/**
 * ȱ��ע��ı�Ҫ��Ϣ��
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
