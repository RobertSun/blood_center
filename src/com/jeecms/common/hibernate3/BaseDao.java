package com.jeecms.common.hibernate3;

import java.io.Serializable;
import java.util.List;

import com.jeecms.common.page.Pagination;

public interface BaseDao<T extends Serializable> {
	/**
	 * ͨ��ID���Ҷ���
	 * 
	 * @param id
	 *            ��¼��ID
	 * @param lock
	 *            �Ƿ���������
	 * @return ʵ�����
	 */
	public T load(Serializable id, boolean lock);

	public T get(Serializable id);

	/**
	 * ͨ��ID���Ҷ���,����������
	 * 
	 * @param id
	 *            ��¼��ID
	 * @return ʵ�����
	 */
	public T load(Serializable id);

	/**
	 * �������ж���
	 * 
	 * @return �����б�
	 */
	public List<T> findAll();

	public List<T> findAll(OrderBy... orders);

	public Pagination findAll(int pageNo, int pageSize, OrderBy... orders);

	/**
	 * ͨ��ʾ��������Ҷ����б�
	 * 
	 * @param eg
	 *            ʾ������
	 * @param anyWhere
	 *            �Ƿ�ģ����ѯ��Ĭ��false��
	 * @param conds
	 *            �����is null���ֶΡ��ֱ�ΪOrderBy��String��
	 * @param exclude
	 *            ��Ҫ�ų�������
	 * @return �����б�
	 */
	public List<T> findByEgList(T eg, boolean anyWhere, Condition[] conds,
			String... exclude);

	public List<T> findByEgList(T eg, boolean anyWhere, Condition[] conds,
			int firstResult, int maxResult, String... exclude);

	public Pagination findByEg(T exampleInstance, boolean anyWhere,
			Condition[] conds, int pageNo, int pageSize, String... exclude);

	/**
	 * �����Բ��Ҷ����б�.
	 */
	public List<T> findByProperty(String property, Object value);

	/**
	 * �����Բ���Ψһ����.
	 */
	public T findUniqueByProperty(String property, Object value);

	/**
	 * �����Բ��Ҷ��������
	 * 
	 * @param property
	 * @param value
	 * @return
	 */
	public int countByProperty(String property, Object value);

	/**
	 * ����Updater���¶���
	 * 
	 * @param updater
	 * @return �־û�����
	 */
	public Object updateByUpdater(Updater updater);

	public Object updateDefault(Object entity);

	/**
	 * �������
	 * 
	 * @param entity
	 *            ʵ�����
	 * @return ʵ�����
	 */
	public T save(T entity);

	/**
	 * ���¶���
	 * 
	 * @param entity
	 *            ʵ�����
	 * @return ʵ�����
	 */
	public Object update(Object entity);

	/**
	 * �������¶���
	 * 
	 * @param entity
	 *            ʵ�����
	 * @return ʵ�����
	 */
	public Object saveOrUpdate(Object entity);

	/**
	 * �������¶��󿽱�
	 * 
	 * @param entity
	 * @return �Ѹ��µĳ־û�����
	 */
	public Object merge(Object entity);

	/**
	 * ɾ������
	 * 
	 * @param entity
	 *            ʵ�����
	 */
	public void delete(Object entity);

	/**
	 * ����IDɾ����¼
	 * 
	 * @param id
	 *            ��¼ID
	 */
	public T deleteById(Serializable id);

	/**
	 * ˢ�¶���
	 * 
	 * @param entity
	 */
	public void refresh(Object entity);

	/**
	 * ���ʵ��Class
	 * 
	 * @return
	 */
	public Class<T> getPersistentClass();

	/**
	 * ����ʵ����Ķ���
	 * 
	 * @return
	 */
	public T createNewEntiey();
}
