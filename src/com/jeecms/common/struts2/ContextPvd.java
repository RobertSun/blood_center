package com.jeecms.common.struts2;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public interface ContextPvd {
	/**
	 * ���ϵͳ����·�� �磺F:\webapps\CmsSys
	 * 
	 * @param path
	 *            ���Դ���մ�
	 * @return
	 */
	public String getAppRealPath(String path);

	/**
	 * ���Ӧ�þ��Ը�·��
	 * 
	 * @return
	 */
	public String getAppRoot();

	/**
	 * ���ϵͳ��·�� �磺/CmsSys
	 * 
	 * @return
	 */
	public String getAppCxtPath();

	/**
	 * ���Ӧ�ö˿ں�
	 * 
	 * @return
	 */
	public int getServerPort();

	/**
	 * ע��
	 * 
	 * @return
	 */
	public void logout();

	/**
	 * ���response
	 * 
	 * @return
	 */
	public HttpServletResponse getResponse();

	/**
	 * ��Request��Attribute�л�ȡֵ
	 * 
	 * @param key
	 * @return
	 */
	public Object getRequestAttr(String key);

	/**
	 * ��Request��Attribute�и�ֵ
	 * 
	 * @param key
	 * @param value
	 */
	public void setRequestAttr(String key, Object value);

	/**
	 * ��SESSION�л��ֵ
	 * 
	 * @param key
	 * @return
	 */
	public Object getSessionAttr(String key);

	/**
	 * ��session��ֵ
	 * 
	 * @param key
	 * @param value
	 */
	public void setSessionAttr(String key, Object value);

	/**
	 * �Ƴ�session�е�����
	 * 
	 * @param key
	 */
	public void removeAttribute(String key);

	public Object getApplicationAttr(String key);

	public void setApplicationAttr(String key, Object value);

	/**
	 * ���sessionId
	 * 
	 * @param isCreate
	 *            ���session�������Ƿ񴴽�
	 * @return
	 */
	public String getSessionId(boolean isCreate);

	/**
	 * ��÷�����IP
	 * 
	 * @return
	 */
	public String getRemoteIp();

	/**
	 * ��÷�����PORT
	 * 
	 * @return
	 */
	public int getRemotePort();

	/**
	 * ��÷�����URL
	 * 
	 * @return
	 */
	public String getRequestURL();

	/**
	 * ��÷����������
	 * 
	 * @return
	 */
	public String getRequestBrowser();

	/**
	 * ��÷����߲���ϵͳ
	 * 
	 * @return
	 */
	public String getRequestOs();

	/**
	 * ��÷����ߵĴ���ȫ����Ϣ
	 * 
	 * @return
	 */
	public String getRequestUserAgent();

	/**
	 * ���cookie
	 * 
	 * @param cookie
	 */
	public void addCookie(Cookie cookie);

	/**
	 * ��ȡcookie
	 * 
	 * @param name
	 * @return
	 */
	public Cookie getCookie(String name);

	/**
	 * �Ƿ���post����
	 * 
	 * @return
	 */
	public boolean isMethodPost();
}
