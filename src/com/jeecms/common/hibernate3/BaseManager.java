package com.jeecms.common.hibernate3;

import java.io.Serializable;
import java.util.List;

import com.jeecms.common.page.Pagination;

public interface BaseManager<T extends Serializable> {
	/**
	 * ͨ��ID���Ҷ���
	 * 
	 * @param id
	 *            ��¼��ID
	 * @return ʵ�����
	 */
	public T findById(Serializable id);

	public T load(Serializable id);

	/**
	 * �������ж���
	 * 
	 * @return �����б�
	 */
	public List<T> findAll();

	public Pagination findAll(int pageNo, int pageSize, OrderBy... orderBys);

	/**
	 * ͨ��ʾ��������Ҷ����б�
	 * 
	 * @param eg
	 *            ʾ������
	 * @param anyWhere
	 *            �Ƿ�ģ����ѯ��Ĭ��false��
	 * @param conds
	 *            ����is null���ֱ�ΪOrderBy��String��
	 * @param exclude
	 *            �ų�����
	 * @return
	 */
	public List<T> findByEgList(T eg, boolean anyWhere, Condition[] conds,
			String... exclude);

	public List<T> findByEgList(T eg, boolean anyWhere, String... exclude);

	public List<T> findByEgList(T eg, Condition[] conds, String... exclude);

	public List<T> findByEgList(T eg, boolean anyWhere, Condition[] conds,
			int firstResult, int maxResult, String... exclude);

	public List<T> findByEgList(T eg, boolean anyWhere, int firstResult,
			int maxResult, String... exclude);

	public List<T> findByEgList(T eg, Condition[] conds, int firstResult,
			int maxResult, String... exclude);

	public List<T> findByEgList(T eg, String... exclude);

	public Pagination findByEg(T eg, boolean anyWhere, Condition[] conds,
			int pageNo, int pageSize, String... exclude);

	public Pagination findByEg(T eg, boolean anyWhere, int pageNo,
			int pageSize, String... exclude);

	public Pagination findByEg(T eg, Condition[] conds, int pageNo,
			int pageSize, String... exclude);

	public Pagination findByEg(T eg, int pageNo, int pageSize,
			String... exclude);

	/**
	 * ����Updater���¶���
	 * 
	 * @param updater
	 */
	public Object updateByUpdater(Updater updater);

	public Object updateDefault(Object entity);

	/**
	 * �������
	 * 
	 * @param entity
	 *            ʵ�����
	 * @return ������Ϣ
	 */
	public T save(T entity);

	public Object update(Object o);

	public Object saveOrUpdate(Object o);

	public void delete(Object o);

	/**
	 * ����IDɾ����¼
	 * 
	 * @param id
	 *            ��¼ID
	 */
	public T deleteById(Serializable id);

	/**
	 * ����ID����ɾ����¼���������쳣ʱ��������ֹ���ع�
	 * 
	 * @param ids
	 *            ��¼ID����
	 * @return ɾ���Ķ���
	 */
	public List<T> deleteById(Serializable[] ids);

	/**
	 * ���沢ˢ�¶��󣬱���many-to-one���Բ�����
	 * 
	 * @param entity
	 */
	public T saveAndRefresh(T entity);
}
