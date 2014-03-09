package com.jeecms.common.util;

import java.util.Set;

/**
 * �����б����
 *
 * @author liufang
 *
 */
public interface SelectTree {
	/**
	 * �����ID
	 *
	 * @return
	 */
	public Long getId();

	/**
	 * ��ø��ڵ�
	 *
	 * @return
	 */
	public SelectTree getTreeParent();

	/**
	 * ���ԭ�ڵ����
	 *
	 * @return
	 */
	public String getTreeName();

	/**
	 * ��������б������
	 *
	 * @return
	 */
	public String getSelectTree();

	/**
	 * ���������б������
	 *
	 * @param selectTree
	 */
	public void setSelectTree(String selectTree);

	/**
	 * ��������ӽڵ㡣���Ա����?����Ϊnullʱ������ֱ�ӵ���getChild()
	 *
	 * @return
	 */
	public Set<? extends SelectTree> getTreeChild();

	/**
	 * δ������ӽڵ㡣���û�е���setTreeChild����÷�������null��
	 *
	 * @return
	 */
	public Set<? extends SelectTree> getTreeChildRaw();

	/**
	 * ���������ӽڵ�
	 *
	 * @param treeChild
	 */
	public void setTreeChild(@SuppressWarnings("rawtypes") Set treeChild);
}
