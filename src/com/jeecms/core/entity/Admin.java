package com.jeecms.core.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.jeecms.core.entity.base.BaseAdmin;

public class Admin extends BaseAdmin {
	private static final long serialVersionUID = 1L;
	/**
	 * ��session�ı����key��
	 */
	public static final String ADMIN_KEY = "_admin_key";
	public static final String RIGHTS_KEY = "_rights_key";
	/**
	 * �����б�ʧЧʱ��
	 */
	private static long FUNCTION_EXPIRED = 0;

	private long functionExpired = 0;

	/**
	 * �����б��Ƿ����
	 * 
	 * @return
	 */
	public boolean isFuncExpired() {
		if (FUNCTION_EXPIRED > this.functionExpired) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * ���¹���ʱ��
	 */
	public void updateFuncExpired() {
		this.functionExpired = System.currentTimeMillis();
	}

	public static void funcChange() {
		FUNCTION_EXPIRED = System.currentTimeMillis();
	}

	/**
	 * Ȩ��URL����
	 */
	private Set<String> rights;

	public void setRights(List<Function> funcList) {
		if (rights != null) {
			rights.clear();
		} else {
			rights = new HashSet<String>();
		}
		for (Function f : funcList) {
			String url = f.getUrl();
			if (url != null && !url.trim().equals("")) {
				rights.add(url);
			}
			String urls = f.getFuncs();
			if (urls != null && !urls.trim().equals("")) {
				String[] urlArr = urls.split("@");
				for (String s : urlArr) {
					rights.add(s);
				}
			}
		}
	}

	/**
	 * ���ܲ˵�
	 */
	private List<Function> menuFunctions;

	/**
	 * �Ƿ�ͨ��Ȩ����֤
	 * 
	 * @param url
	 *            ����֤��URL
	 * @return
	 */
	public boolean isPass(String url) {
		if (rights != null && url != null) {
			for (String s : rights) {
				if (s.equals(url)) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean isPass(String url, boolean openSuper) {
		// ��������Ա
		if (openSuper && getUser().getId().equals(1L)) {
			return true;
		}
		if (rights != null && url != null) {
			for (String s : rights) {
				if (s.equals(url)) {
					return true;
				}
			}
		}
		return false;
	}

	public void setMenuFunctions(List<Function> allFuncsList) {
		if (this.menuFunctions == null) {
			this.menuFunctions = new ArrayList<Function>();
		} else {
			this.menuFunctions.clear();
		}
		for (Function f : allFuncsList) {
			if (f.getMenu() && !this.menuFunctions.contains(f)) {
				this.menuFunctions.add(f);
			}
		}
	}

	/**
	 * ��õ�¼��
	 * 
	 * @return
	 */
	public String getLoginName() {
		if (getUser() != null) {
			return getUser().getLoginName();
		} else {
			return null;
		}
	}

	/**
	 * �Ƿ񱻽���
	 * 
	 * @return
	 */
	public Boolean getAdminDisabled() {
		Boolean b = getDisabled();
		if (b == null || b == true) {
			return b;
		} else {
			return getUser().getDisabled();
		}
	}

	/* [CONSTRUCTOR MARKER BEGIN] */
	public Admin () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public Admin (java.lang.Long id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public Admin (
		java.lang.Long id,
		com.jeecms.core.entity.Website website,
		com.jeecms.core.entity.User user,
		java.util.Date createTime,
		java.lang.Boolean disabled) {

		super (
			id,
			website,
			user,
			createTime,
			disabled);
	}

	/* [CONSTRUCTOR MARKER END] */
	public List<Function> getMenuFunctions() {
		return menuFunctions;
	}

	public Set<String> getRights() {
		return this.rights;
	}

	private List<Function> allFunctions;

	public List<Function> getAllFunctions() {
		return allFunctions;
	}

	public void setAllFunctions(List<Function> allFunctions) {
		this.allFunctions = allFunctions;
	}
}