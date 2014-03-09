package com.jeecms.common.struts2.interceptor;

/**
 * ��URL���д����û�����ǰ̨��ҳ��·�������͡�-���ָ�Ĳ���
 * 
 * @author liufang
 * 
 */
public interface UrlAware {
	/**
	 * ·���������磺http://www.sina.com/news/32_5-2-3.htm��ȡ{"news","32"}��
	 * 
	 * @param pathParams
	 */
	public void setPathParams(String[] pathParams);

	/**
	 * ���Ӳ������磺http://www.sina.com/news/32_5-2---.htm��ȡ{"5","2","",""}��
	 * 
	 * @param otherParams
	 */
	public void setOtherParams(String[] otherParams);

	/**
	 * �ڼ�ҳ
	 * 
	 * @param pageNo
	 */
	public void setPageNo(int pageNo);

	/**
	 * ���ڷ�ҳ������·��ǰ�沿�֡�
	 * 
	 * �磺http://www.sina.com/news/32_2.htm��ȡ "http://www.sina.com/news/32"
	 */
	public void setPageLink(String pageLink);

	/**
	 * ���ڷ�ҳ������·�����沿�֡�
	 * 
	 * �磺http://www.sina.com/news/32_2-5-9.htm��ȡ"-5-9.htm"
	 */
	public void setPageSuffix(String pageSuffix);

	/**
	 * ��������·�����磺http://www.sina.com/news/32_2-5-9.htm
	 */
	public void setWholeUrl(String wholeUrl);
}
