package com.jeecms.cms.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import com.jeecms.cms.dao.CmsChannelDao;
import com.jeecms.cms.entity.CmsChannel;
import com.jeecms.common.hibernate3.Finder;
import com.jeecms.core.JeeCoreDaoImpl;

@Repository
public class CmsChannelDaoImpl extends JeeCoreDaoImpl<CmsChannel> implements
		CmsChannelDao {
	public CmsChannel getByPath(Long webId, String path) {
		String hql = "select c from CmsChannel c where c.website.id=? and c.path=?";
		return (CmsChannel) findUnique(hql, webId, path);
	}

	public CmsChannel getRoot(Long webId, String sysType) {
		String hql = "from CmsChannel chnl where chnl.website.id=? and chnl.sysType=? and chnl.lft=1";
		return (CmsChannel) findUnique(hql, webId, sysType);
	}

	public CmsChannel getRootWithFilter(Long webId, String sysType) {
		getSession().enableFilter("channelFilter");
		return getRoot(webId, sysType);
	}

	public boolean isChild(Long pid, Long cid) {
		String hql = "select count(*) from CmsChannel c,CmsChannel p where c.lft between p.lft and p.rgt and c.id=? and p.id=?";
		int count = ((Number) findUnique(hql, cid, pid)).intValue();
		if (count > 0) {
			return true;
		} else {
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	public List<CmsChannel> getRightChnl(Long webId, String sysType,
			Long adminId, Boolean hasChild) {
		Criteria crit = getSession().createCriteria(CmsChannel.class);
		crit.add(Restrictions.eq("website.id", webId)).add(
				Restrictions.eq("sysType", sysType));
		if (hasChild != null) {
			crit.add(Restrictions.eq("hasChild", hasChild));
		}
		crit.createCriteria("admins").add(Restrictions.eq("id", adminId));
		crit.addOrder(Order.asc(CmsChannel.PROP_PRIORITY));
		List<CmsChannel> list = crit.list();
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<CmsChannel> getRightChnl(Long webId, String sysType,
			Long chnlId, Long adminId, Long modelId, Boolean hasChild) {
		Finder f = Finder.create("select node from CmsChannel node");
		f.append(" inner join node.admins admin, CmsChannel parent");
		f.append(" where node.lft between parent.lft and parent.rgt");
		f.append(" and parent.id=:chnlId and node.website.id=:webId").setParam(
				"chnlId", chnlId).setParam("webId", webId);
		f.append(" and node.sysType=:sysType and admin.id=:adminId").setParam(
				"sysType", sysType).setParam("adminId", adminId);
		if (modelId != null) {
			f.append(" and node.model.id=:modelId")
					.setParam("modelId", modelId);
		}
		if (hasChild != null) {
			f.append(" and node.hasChild=:hasChild").setParam("hasChild",
					hasChild);
		}
		f.append(" order by node.priority asc");
		return find(f);
	}

	@SuppressWarnings("unchecked")
	public List<CmsChannel> getChnlsAndExclude(Long webId, String sysType,
			Long excludeNode) {
		String hql = "select node from CmsChannel node,CmsChannel enode where (node.lft>enode.rgt or node.lft<enode.lft)"
				+ " and enode.id=? and node.website.id=? and node.sysType=? order by node.priority asc";
		return find(hql, excludeNode, webId, sysType);
	}

	@SuppressWarnings("unchecked")
	public List<CmsChannel> getChnlsForMember(Long webId, Integer groupLevel) {
		Assert.notNull(groupLevel);
		String hql = "select chnl from CmsChannel chnl inner join chnl.groupContribute mgroup";
		if (webId != null) {
			hql += " where chnl.website.id=? and mgroup.level<=? order by chnl.priority asc";
			return find(hql, webId, groupLevel);
		} else {
			hql += " where mgroup.level<=? order by chnl.priority asc";
			return find(hql, groupLevel);
		}
	}
}