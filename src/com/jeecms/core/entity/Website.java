package com.jeecms.core.entity;

import static com.jeecms.core.Constants.RES_BASE;
import static com.jeecms.core.Constants.RES_SYS;
import static com.jeecms.core.Constants.SPT;
import static com.jeecms.core.Constants.TEMPLATE;
import static com.jeecms.core.Constants.UPLOAD_PATH;
import static com.jeecms.core.Constants.USER_BASE;
import static com.jeecms.core.Constants.WEBINF;

import java.util.Set;

import org.apache.commons.lang.StringUtils;

import com.jeecms.common.hibernate3.HibernateTree;
import com.jeecms.common.util.SelectTree;
import com.jeecms.core.entity.base.BaseWebsite;

public class Website extends BaseWebsite implements SelectTree, HibernateTree {
	/**
	 * �û���Ը�·����/WEB-INF/user_base/
	 */
	public static final String USER_ROOT = SPT + WEBINF + SPT + USER_BASE + SPT;
	/**
	 * ҳ�����Ĭ�ϵĺ�׺
	 */
	public static final String DEF_SUFFIX = "htm";

	/**
	 * ���վ���URL���磺http://www.nc138.com �� http://www.nc138.com:8080/CmsSys
	 *
	 * @return
	 */
	public StringBuilder getWebUrlBuf() {
		StringBuilder sb = new StringBuilder();
//		sb.append("http://").append(getDomain());
        sb.append("http://").append(getCurrentAccessDomain());
		if (getPort() != null && !getPort().equals(80)) {
			sb.append(":").append(getPort());
		}
		if (getContextPath() != null) {
			sb.append(getContextPath());
		}
		return sb;
	}

	/**
	 * ���վ���URL���磺http://www.nc138.com �� http://www.nc138.com:8080/CmsSys
	 *
	 * @return
	 */
	public String getWebUrl() {
		return getWebUrlBuf().toString();
	}

	/**
	 * �����Դվ���URL���磺http://res.nc138.com �� http://res.nc138.com:8080/CmsSys
	 *
	 * ��û��ָ����Դ���������վ���ʵ�ַһ��ΪԶ�̸�����׼����
	 *
	 * @return
	 */
	public StringBuilder getResUrlBuf() {
		if (StringUtils.isBlank(getResDomain())) {
			return getWebUrlBuf();
		} else {
			return new StringBuilder(getResDomain());
		}
	}

	/**
	 * �����Դվ���URL���磺http://res.nc138.com �� http://res.nc138.com:8080/CmsSys
	 *
	 * ��û��ָ����Դ���������վ���ʵ�ַһ��ΪԶ�̸�����׼����
	 *
	 * @return
	 */
	public String getResUrl() {
		return getResUrlBuf().toString();
	}

	/**
	 * ���վ�����ԴURL���磺http://www.sina.com/res_base/sina_com_www
	 *
	 * @return
	 */
	public StringBuilder getUserResUrlBuf() {
		return getResUrlBuf().append(SPT).append(RES_BASE).append(SPT).append(
				getResPath());
	}

	/**
	 * ���վ�����ԴURL���磺http://www.sina.com/res_base/sina_com_www
	 *
	 * @return
	 */
	public String getUserResUrl() {
		return getUserResUrlBuf().toString();
	}

	/**
	 * ���ϵͳ��ԴURL���磺http://www.sian.com/front_res
	 *
	 * ��Ҫ��ǰ̨ģ��ʹ�õ�һЩ��ʽ�?ͼƬ��
	 *
	 * @return
	 */
	public String getSysResUrl() {
		return getResUrlBuf().append(SPT).append(RES_SYS).toString();
	}

	/**
	 * ����ϴ���·�����磺http://www.sina.com/res_base/sina_com_www/upload
	 *
	 * @return
	 */
	public StringBuilder getUploadUrlBuf() {
		return getUserResUrlBuf().append(SPT).append(UPLOAD_PATH);
	}

	/**
	 * ����ϴ���·�����磺http://www.sina.com/res_base/sina_com_www/upload
	 *
	 * @return
	 */
	public String getUploadUrl() {
		return getUploadUrlBuf().toString();
	}

	/**
	 * ����û���Ը�·�����磺/WEB-INF/user_base/ponyjava_com_www
	 *
	 * @return
	 */
	public StringBuilder getUserRoot() {
		StringBuilder sb = new StringBuilder(USER_ROOT);
		sb.append(getResPath());
		return sb;
	}

	/**
	 * ���ģ�����·�����磺/WEB-INF/user_base/ponyjava_com_www/template
	 *
	 * @return
	 */
	public StringBuilder getTplRoot() {
		return getUserRoot().append(SPT).append(TEMPLATE);
	}

	/**
	 * ���ģ����·�����磺f:/wangzhan/sina/WEB-INF/user_base/ponyjava_com_www/template
	 *
	 * @param realRoot
	 * @return
	 */
	public StringBuilder getTplRootReal(String realRoot) {
		StringBuilder sb = new StringBuilder(realRoot);
		sb.append(getTplRoot());
		return sb;
	}

	/**
	 * �����Դ��·�����磺/res_base/sina_com_www
	 *
	 * @return
	 */
	public StringBuilder getResRootBuf() {
		StringBuilder sb = new StringBuilder();
		sb.append(SPT).append(RES_BASE).append(SPT).append(getResPath());
		return sb;
	}

	/**
	 * �����Դ��·�����磺/res_base/sina_com_www
	 *
	 * @return
	 */
	public String getResRoot() {
		return getResRootBuf().toString();
	}

	/**
	 * ����ϴ���·�����磺/res_base/sina_com_www/upload
	 *
	 * @return
	 */
	public StringBuilder getUploadRoot() {
		return getResRootBuf().append(SPT).append(UPLOAD_PATH);
	}

	/**
	 * ��ø�վ�㡣����վȺ����
	 *
	 * @return
	 */
	public Website getRootWeb() {
		Website parentWeb = getParent();
		if (parentWeb == null) {
			return this;
		} else {
			return parentWeb.getRootWeb();
		}
	}

	/**
	 * ��ø�վ��ID
	 *
	 * @return
	 */
	public Long getRootWebId() {
		Website root = getRootWeb();
		if (root != null) {
			return root.getId();
		} else {
			return null;
		}
	}

	/**
	 * ��ȡ�����������ڵ����¼���磺.jeecms.com
	 *
	 * @param withPoint
	 *            �Ƿ���� �ǣ�.jeecms.com����jeecms.com
	 * @return
	 */
	public String getTopDomain(boolean withPoint) {
		String topDomain = getBaseDomain();
		if (StringUtils.isBlank(topDomain)) {
			return getDomain();
		}
		if (withPoint) {
			return "." + topDomain;
		} else {
			return topDomain;
		}
	}

	/**
	 * ���վ���������
	 *
	 * @return
	 */
	public String[] getAlias() {
		return StringUtils.split(getDomainAlias(), ',');
	}

    public String[] getDomains(){
        return StringUtils.split(getDomain(), ',');
    }

	public String getTreeName() {
		return getName();
	}

	public String getSelectTree() {
		return selectTree;
	}

	public void setSelectTree(String selectTree) {
		this.selectTree = selectTree;
	}

	public Set<? extends SelectTree> getTreeChild() {
		if (treeChild != null) {
			return treeChild;
		} else {
			return getChild();
		}
	}

	public Set<? extends SelectTree> getTreeChildRaw() {
		return treeChild;
	}

	public SelectTree getTreeParent() {
		return getParent();
	}

	public Long getParentId() {
		Website parent = getParent();
		if (parent == null) {
			return null;
		} else {
			return parent.getId();
		}
	}

	public String getTreeCondition() {
		return null;
	}

	@SuppressWarnings("unchecked")
	public void setTreeChild(@SuppressWarnings("rawtypes") Set treeChild) {
		this.treeChild = treeChild;
	}

	/**
	 * ��վ��ơ�
	 */
	public String getShortName() {
		String s = super.getShortName();
		if (StringUtils.isBlank(s)) {
			return getName();
		} else {
			return s;
		}
	}

	public Integer getPort() {
		return getGlobal().getPort();
	}

	public String getContextPath() {
		return getGlobal().getContextPath();
	}

	/**
	 * �����б���
	 */
	private String selectTree;
	/**
	 * ���ӽڵ�
	 */
	private Set<Website> treeChild;
	private static final long serialVersionUID = 1L;

    /**
     * for second domain
     *
     */
    private String currentAccessDomain;

	/* [CONSTRUCTOR MARKER BEGIN] */
	public Website () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public Website (java.lang.Long id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public Website (
		java.lang.Long id,
		com.jeecms.core.entity.Global global,
		java.lang.String domain,
		java.lang.String resPath,
		java.lang.Integer lft,
		java.lang.Integer rgt,
		java.lang.String name,
		java.util.Date createTime,
		java.lang.Boolean close) {

		super (
			id,
			global,
			domain,
			resPath,
			lft,
			rgt,
			name,
			createTime,
			close);
	}

    public String getCurrentAccessDomain() {
        return currentAccessDomain;
    }

    public void setCurrentAccessDomain(String currentAccessDomain) {
        this.currentAccessDomain = currentAccessDomain;
    }

    /* [CONSTRUCTOR MARKER END] */
}