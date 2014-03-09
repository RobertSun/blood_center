package com.jeecms.core.util;

/**
 * ���ݽӿ�
 * 
 * ����ͳһ��������ʾ�ӿڣ������������ݿ��Բ���ͳһ����ʾ��ʽ��
 * 
 * @author liufang
 * 
 */
public interface ContentInterface {
	/**
	 * ����
	 * 
	 * @param len
	 *            ��ȡ����
	 * @return
	 */
	public String tit(int len);

	/**
	 * ��̱���
	 * 
	 * @param len
	 * @return
	 */
	public String stit(int len);

	/**
	 * ����
	 * 
	 * @param len
	 * @return
	 */
	public String desc(int len);

	/**
	 * ͼƬ��ַ
	 * 
	 * @return
	 */
	public String getImgUrl();

	/**
	 * ��������
	 * 
	 * @return
	 */
	public String getUrl();

	/**
	 * ������ɫ���졢�����ڵ�
	 * 
	 * @return
	 */
	public String getTitCol();

	/**
	 * �����Ƿ�Ӵ�
	 * 
	 * @return
	 */
	public boolean isTitBold();

	/**
	 * ������ơ�����Ŀ�����������̳���ȡ�
	 * 
	 * @return
	 */
	public String getCtgName();

	/**
	 * ���URL��ַ��
	 * 
	 * @return
	 */
	public String getCtgUrl();

	/**
	 * վ������
	 * 
	 * @return
	 */
	public String getWebName();

	/**
	 * վ��URL
	 * 
	 * @return
	 */
	public String getWebUrl();

	/**
	 * �������
	 * 
	 * @param style
	 *            1:yyyy-MM-dd HH:mm:ss 2:yyyy-MM-dd 3:MM-dd HH:mm 4:MM-dd
	 * @return
	 */
	public String getDate(int style);
}