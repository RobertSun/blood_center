package com.jeecms.core.util;

/**
 * 内容接口
 * 
 * 定义统一的内容显示接口，便于所有内容可以采用统一的显示方式。
 * 
 * @author liufang
 * 
 */
public interface ContentInterface {
	/**
	 * 标题
	 * 
	 * @param len
	 *            截取个数
	 * @return
	 */
	public String tit(int len);

	/**
	 * 简短标题
	 * 
	 * @param len
	 * @return
	 */
	public String stit(int len);

	/**
	 * 描述
	 * 
	 * @param len
	 * @return
	 */
	public String desc(int len);

	/**
	 * 图片地址
	 * 
	 * @return
	 */
	public String getImgUrl();

	/**
	 * 内容链接
	 * 
	 * @return
	 */
	public String getUrl();

	/**
	 * 标题颜色。红、蓝、黑等
	 * 
	 * @return
	 */
	public String getTitCol();

	/**
	 * 标题是否加粗
	 * 
	 * @return
	 */
	public boolean isTitBold();

	/**
	 * 类别名称。如栏目、留言类别、论坛板块等。
	 * 
	 * @return
	 */
	public String getCtgName();

	/**
	 * 类别URL地址。
	 * 
	 * @return
	 */
	public String getCtgUrl();

	/**
	 * 站点名称
	 * 
	 * @return
	 */
	public String getWebName();

	/**
	 * 站点URL
	 * 
	 * @return
	 */
	public String getWebUrl();

	/**
	 * 获得日期
	 * 
	 * @param style
	 *            1:yyyy-MM-dd HH:mm:ss 2:yyyy-MM-dd 3:MM-dd HH:mm 4:MM-dd
	 * @return
	 */
	public String getDate(int style);
}