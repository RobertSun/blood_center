package com.jeecms.core.exception;

/**
 * ����Աû���ڱ�ϵͳ�ҵ�
 * <p>
 * һ��ֻ�ڸ���վ��ϵͳʱ�Ż���֣�����ϵͳ�ǲ��Ƽ�ʹ�õĲ�����
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
