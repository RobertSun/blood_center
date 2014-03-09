package com.jeecms.download.dao.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import com.jeecms.download.entity.Download;
import com.jeecms.download.dao.DownloadDao;
import com.jeecms.common.hibernate3.Finder;
import com.jeecms.common.page.Pagination;
import com.jeecms.core.JeeCoreDaoImpl;

@Repository
public class DownloadDaoImpl extends JeeCoreDaoImpl<Download> implements
		DownloadDao {

	public Pagination getForTag(Long webId, Long chnlId, Long ctgId,
			String searchKey, Boolean hasTitleImg, boolean recommend,
			int topLevel, int orderBy, boolean isPage, int firstResult,
			int pageNo, int pageSize) {
		Finder f = Finder.create("select bean from Download bean");
		if (chnlId != null) {
			f.append(" inner join bean.channel node,CmsChannel parent");
			f.append(" where node.lft between parent.lft and parent.rgt");
			f.append(" and parent.id=:chnlId").setParam("chnlId", chnlId);
		} else {
			f.append(" where 1=1");
			f.append(" and bean.website.id=:webId").setParam("webId", webId);
		}
		f.append(" and bean.check=true and bean.disabled=false");
		if (ctgId != null) {
			f.append(" and bean.contentCtg.id=:ctgId").setParam("ctgId", ctgId);
		}
		if (recommend) {
			f.append(" and bean.recommend=true");
		}
		if (hasTitleImg != null) {
			f.append(" and bean.hasTitleImg=:hasTitleImg");
			f.setParam("hasTitleImg", hasTitleImg);
		}
		switch (topLevel) {
		case 1:
			f.append(" and bean.topLevel=0");
		case 2:
			f.append(" and bean.topLevel>=1");
		}
		if (!StringUtils.isBlank(searchKey)) {
			searchKey = "%" + searchKey + "%";
			f.append(" and (bean.title like :searchKey");
			f.append(" or tags like :searchKey");
			f.append(" or description like :searchKey)");
			f.setParam("searchKey", searchKey);
		}
		switch (orderBy) {
		// ����ʱ������
		case 1:
			f.append(" order by bean.releaseDate asc");
			break;
		// �̶�����
		case 2:
			f.append(" order by bean.topLevel desc, bean.sortDate desc");
			break;
		// �ö�����
		case 3:
			f.append(" order by bean.sortDate desc");
			break;
		// �յ������
		case 4:
			f.append(" order by bean.visitToday desc");
			break;
		// �ܵ������
		case 5:
			f.append(" order by bean.visitWeek desc");
			break;
		// �µ������
		case 6:
			f.append(" order by bean.visitMonth desc");
			break;
		// ���������
		case 7:
			f.append(" order by bean.visitQuarter desc");
			break;
		// ��������
		case 8:
			f.append(" order by bean.visitYear desc");
			break;
		// �ܵ������
		case 9:
			f.append(" order by bean.visitTotal desc");
			break;
		// Ĭ�Ϸ���ʱ�併��
		default:
			f.append(" order by bean.releaseDate desc");
			break;
		}
		if (isPage) {
			return find(f, pageNo, pageSize);
		} else {
			f.setFirstResult(firstResult);
			f.setMaxResults(pageSize);
			@SuppressWarnings("rawtypes")
			List list = find(f);
			return new Pagination(pageNo, list.size(), pageSize, list);
		}
	}

	public Pagination getRightDownload(Long webId, Long chnlId, Long adminId,
			boolean isMy, int status, String title, int order, int pageNo,
			int pageSize) {
		String hql = "select bean from Download bean inner join bean.channel node inner join node.admins admin,CmsChannel parent"
				+ " where node.lft between parent.lft and parent.rgt and parent.id=:chnlId and bean.website.id=:webId and admin.id=:adminId";
		Finder f = Finder.create(hql).setParam("webId", webId).setParam(
				"chnlId", chnlId).setParam("adminId", adminId);
		if (isMy) {
			f.append(" and bean.adminInput.id=:adminId");
		}
		switch (status) {
		case 4:
			// �˸�
			f.append(" and bean.reject=true");
			break;
		case 3:
			// �����
			f.append(" and bean.check=true");
			break;
		case 2:
			// �����
			f.append(" and bean.check=false");
			break;
		case 1:
			// �ݸ�
			f.append(" and bean.draft=true");
			break;
		default:
			break;
		}
		if (!StringUtils.isBlank(title)) {
			f.append(" and bean.title like :title").setParam("title",
					"%" + title + "%");
		}
		switch (order) {
		case 13:
			f.append(" order by bean.visitTotal asc");
			break;
		case 12:
			f.append(" order by bean.visitTotal desc");
			break;
		case 11:
			f.append(" order by bean.visitYear asc");
			break;
		case 10:
			f.append(" order by bean.visitYear desc");
			break;
		case 9:
			f.append(" order by bean.visitQuarter asc");
			break;
		case 8:
			f.append(" order by bean.visitQuarter desc");
			break;
		case 7:
			f.append(" order by bean.visitMonth asc");
			break;
		case 6:
			f.append(" order by bean.visitMonth desc");
			break;
		case 5:
			f.append(" order by bean.visitWeek asc");
			break;
		case 4:
			f.append(" order by bean.visitWeek desc");
			break;
		case 3:
			f.append(" order by bean.visitToday asc");
			break;
		case 2:
			f.append(" order by bean.visitTotal desc");
			break;
		case 1:
			f.append(" order by bean.id asc");
			break;
		default:
			f.append(" order by bean.id desc");
			break;
		}
		return find(f, pageNo, pageSize);
	}

	public Pagination getDownloadBySort(Long webId, Long chnlId, Long typeId,
			int status, String title, int order, int pageNo, int pageSize) {
		String hql = "select bean from Download bean";
		Finder f = Finder.create(hql).setParam("webId", webId);
		if (chnlId != null) {
			f.append(" inner join bean.channel node,CmsChannel parent");
			f.append(" where node.lft between parent.lft and parent.rgt");
			f.append(" and parent.id=:chnlId").setParam("chnlId", chnlId);
		} else {
			f.append(" where 1=1");
		}
		f.append(" and bean.website.id=:webId").setParam("webId", webId);
		if (typeId != null) {
			switch (status) {
			case 3:
				// ������Ͳ�ѯ
				f.append(" and bean.downType.id=:typeId");
				f.setParam("typeId", typeId);
				break;
			case 2:
				// ��ݰ汾��ѯ
				f.append(" and bean.downEdtion.id=:typeId");
				f.setParam("typeId", typeId);
				break;
			case 1:
				// �������ѯ
				f.append(" and bean.downSort.id=:typeId");
				f.setParam("typeId", typeId);
				break;
			default:
				break;
			}
		}
		f.append(" order by bean.id desc");
		return find(f, pageNo, pageSize);
	}
}