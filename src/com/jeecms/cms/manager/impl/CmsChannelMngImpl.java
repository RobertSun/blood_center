package com.jeecms.cms.manager.impl;

import java.io.File;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeecms.article.entity.Article;
import com.jeecms.cms.dao.CmsChannelDao;
import com.jeecms.cms.entity.CmsAdmin;
import com.jeecms.cms.entity.CmsChannel;
import com.jeecms.cms.manager.CmsAdminMng;
import com.jeecms.cms.manager.CmsChannelMng;
import com.jeecms.common.hibernate3.Condition;
import com.jeecms.common.hibernate3.OrderBy;
import com.jeecms.common.hibernate3.Updater;
import com.jeecms.common.struts2.ContextPvd;
import com.jeecms.common.util.ComUtils;
import com.jeecms.core.JeeCoreManagerImpl;
import com.jeecms.core.entity.Attachment;
import com.jeecms.core.entity.Website;
import com.jeecms.core.service.IdCacheSvc;
import com.jeecms.core.util.UploadRule;
import com.jeecms.core.util.UploadRule.UploadFile;

@Service
@Transactional
public class CmsChannelMngImpl extends JeeCoreManagerImpl<CmsChannel> implements
		CmsChannelMng {
	public CmsChannel getByPath(Long webId, String path) {
		Long id = idCacheSvc.get(CmsChannel.REF, String.valueOf(webId), path);
		// 找不到缓存
		if (id == null) {
			CmsChannel entity = getDao().getByPath(webId, path);
			// 写入缓存
			if (entity != null) {
				idCacheSvc.put(entity.getId(), CmsChannel.REF, webId, path);
			}
			return entity;
		} else {
			return findById(id);
		}
	}

	public CmsChannel getRoot(Long webId, String sysType) {
		Long id = idCacheSvc.get(CmsChannel.REF, webId, "", sysType);
		// 找不到缓存
		if (id == null) {
			CmsChannel entity = getDao().getRoot(webId, sysType);
			// 写入缓存
			if (entity != null) {
				idCacheSvc.put(entity.getId(), CmsChannel.REF, webId, "",
						sysType);
			}
			return entity;
		} else {
			return findById(id);
		}
	}

	public CmsChannel getRoot(Long webId, String sysType, boolean hasChild) {
		if (hasChild) {
			return getDao().getRootWithFilter(webId, sysType);
		} else {
			return getRoot(webId, sysType);
		}
	}

	public List<CmsChannel> getChild(Long webId, String sysType, Long pid,
			int orderBy, boolean isDisplay, boolean hasChild, int start,
			int count) {
		CmsChannel example = new CmsChannel();
		if (pid == null) {
			pid = getRoot(webId, sysType).getId();
		}
		example.setParent(new CmsChannel(pid));
		if (isDisplay) {
			example.setDisplay(isDisplay);
		}
		if (hasChild) {
			example.setHasChild(hasChild);
		}
		Condition[] conds = null;
		switch (orderBy) {
		case 0:
			conds = new Condition[] { OrderBy.asc("priority") };
			break;
		case 1:
			conds = new Condition[] { OrderBy.desc("priority") };
			break;
		case 2:
			conds = new Condition[] { OrderBy.asc("visitTotal") };
			break;
		case 3:
			conds = new Condition[] { OrderBy.desc("visitTotal") };
			break;
		default:
			conds = new Condition[] { OrderBy.asc("priority") };
		}
		if (start == 0 && count == 0) {
			return findByEgList(example, conds);
		} else {
			return findByEgList(example, conds, start, count);
		}
	}

	public boolean isChild(Long pid, Long cid) {
		return getDao().isChild(pid, cid);
	}

	public List<CmsChannel> getRightChnl(Long webId, String sysType,
			Long adminId, Boolean hasChild) {
		return getDao().getRightChnl(webId, sysType, adminId, hasChild);
	}

	public List<CmsChannel> getRightChnl(Long webId, String sysType,
			Long chnlId, Long adminId, Long modelId, Boolean hasChild) {
		return getDao().getRightChnl(webId, sysType, chnlId, adminId, modelId,
				hasChild);
	}

	public List<CmsChannel> getChnlsAndExclude(Long webId, String sysType,
			Long excludeNode) {
		return getDao().getChnlsAndExclude(webId, sysType, excludeNode);
	}

	public List<CmsChannel> getChnlsForMember(Long webId, Integer groupLevel) {
		return getDao().getChnlsForMember(webId, groupLevel);
	}

	public CmsChannel updateChannel(CmsChannel chnl, CmsAdmin admin,
			Collection<CmsAdmin> admins, UploadRule rule) {
		CmsChannel entity = findById(chnl.getId());
		String origPath = entity.getPath();
		handleTitleImg(chnl);

		// 处理父子节点
		CmsChannel oparent = entity.getParent();
		CmsChannel cparent = chnl.getParent();
		if (oparent != null && cparent != null) {
			if (!oparent.getId().equals(cparent.getId())) {
				oparent.getChild().remove(entity);
				cparent.addToChild(entity);
				entity.setParent(cparent);
			}
		}
		chnl.setParent(null);

		// 处理栏目权限
		if (admins != null && admins.size() > 0) {
			Set<CmsAdmin> oadmins = entity.getAdmins();
			// 清除管理员
			for (CmsAdmin a : oadmins) {
				if (!admins.contains(a)) {
					a.getChannels().remove(entity);
				}
			}
			// 添加管理员
			for (CmsAdmin a : admins) {
				a.addTochannels(entity);
			}
			// 重置
			oadmins.clear();
			oadmins.addAll(admins);
		}

		updateByUpdater(createUpdate(chnl));

		entity.setHasChild(entity.getModel().getHasChild());
		removeAttachment(entity, false);
		if (!origPath.equals(entity.getPath())) {
			String sid = String.valueOf(entity.getWebsite().getId());
			idCacheSvc.remove(CmsChannel.REF, sid, origPath);
			idCacheSvc.put(entity.getId(), CmsChannel.REF, sid, entity
					.getPath());
		}
		return entity;
	}

	public CmsChannel saveChannel(CmsChannel chnl, CmsAdmin admin,
			Collection<CmsAdmin> admins, UploadRule rule) {
		initDefValue(chnl);
		handleTitleImg(chnl);
		chnl.setHasChild(chnl.getModel().getHasChild());
		CmsChannel parent = chnl.getParent();
		if (parent != null) {
			// 父节点关联子节点
			parent.addToChild(chnl);
			// 是否指定栏目权限
			if (admins == null || admins.size() <= 0) {
				admins = parent.getAdmins();
			}
		} else {
			if (admins == null || admins.size() <= 0) {
				admins = cmsAdminMng.getList(chnl.getWebsite().getId());
			}
		}
		// 栏目权限
		for (CmsAdmin a : admins) {
			a.addTochannels(chnl);
		}
		save(chnl);
		addAttachment(chnl, rule, chnl.getWebsite(), admin);
		return chnl;
	}

	private void initDefValue(CmsChannel bean) {
		if (bean.getDisplay() == null) {
			bean.setDisplay(true);
		}
		if (bean.getPriority() == null) {
			bean.setPriority(10);
		}
		bean.setVisitToday(0L);
		bean.setVisitTotal(0L);
		bean.setStatDate(new Date());
		bean.setDocCount(0);
	}

	private void handleTitleImg(CmsChannel bean) {
		// 如果标题图为空，则设置没有标题图片。
		if (StringUtils.isBlank(bean.getTitleImg())) {
			bean.setTitleImg("");
			bean.setHasTitleImg(false);
		} else {
			bean.setHasTitleImg(true);
		}
	}

	private Updater createUpdate(CmsChannel bean) {
		Updater updater = Updater.create(bean);
		updater.exclude(CmsChannel.PROP_WEBSITE);
		updater.exclude(CmsChannel.PROP_CONFIG);
		updater.exclude(CmsChannel.PROP_PARENT);
		updater.exclude(CmsChannel.PROP_DOC_COUNT);
		return updater;
	}

	/**
	 * 新增附件
	 * 
	 * @param chnl
	 * @param rule
	 * @param web
	 * @param admin
	 */
	private void addAttachment(CmsChannel chnl, UploadRule rule, Website web,
			CmsAdmin admin) {
		Map<String, UploadFile> uploadFiles = rule.getUploadFiles();
		if (uploadFiles != null) {
			String content = chnl.getContent();
			String titleImg = chnl.getTitleImg();
			String contentImg = chnl.getContentImg();
			Set<String> rmFile = new HashSet<String>();
			Attachment attach;
			UploadFile uf;
			String rootPath = contextPvd.getAppRealPath(web.getUploadRoot()
					.toString());
			for (String name : uploadFiles.keySet()) {
				if (StringUtils.contains(content, name)
						|| StringUtils.contains(titleImg, name)
						|| StringUtils.contains(contentImg, name)) {
					rmFile.add(name);
					attach = new Attachment();
					uf = uploadFiles.get(name);
					attach.setWebsite(web);
					attach.setUser(admin.getAdmin().getUser());
					attach.setName(uf.getOrigName());
					attach.setFileName(uf.getFileName());
					attach.setFilePath(uf.getRelPath(rootPath));
					attach.setFileSize((int) (uf.getSize() / 1024) + 1);
					attach.setOwnerCtg(Article.ATTACHMENT_CTG);
					attach.setOwnerId(chnl.getId());
					attach.setOwnerName(chnl.getName());
					attach.setOwnerUrl(chnl.getUrl().replace(
							chnl.getWebsite().getWebUrl(), ""));
					attach.setDownCount(0L);
					attach.setCreateTime(ComUtils.now());
					if (chnl.getGroupVisit() == null) {
						attach.setFree(true);
					} else {
						attach.setFree(false);
					}
					attach.setLost(false);
					chnl.addToAttachments(attach);
				}
			}
			for (String name : rmFile) {
				rule.removeUploadFile(name);
			}
		}
	}

	private void removeAttachment(CmsChannel entity, boolean removeAll) {
		Set<Attachment> attachs = entity.getAttachments();

		String content = entity.getContent();
		String titleImg = entity.getTitleImg();
		String contentImg = entity.getContentImg();

		Set<Attachment> rmAttachs = new HashSet<Attachment>();
		String filename;
		for (Attachment attach : attachs) {
			filename = attach.getFileName();
			if (removeAll
					|| (!StringUtils.contains(content, filename)
							&& !StringUtils.contains(titleImg, filename) && !StringUtils
							.contains(contentImg, filename))) {
				String realPath = contextPvd
						.getAppRealPath(attach.getRelPath());
				if (new File(realPath).delete()) {
					log.info("删除附件：{}", realPath);
				} else {
					log.warn("删除附件失败：{}", realPath);
				}
				rmAttachs.add(attach);
			}
		}
		attachs.removeAll(rmAttachs);
	}

	@Override
	public CmsChannel findById(Serializable id) {
		CmsChannel entity = super.findById(id);
		return entity;
	}

	@Override
	public CmsChannel deleteById(Serializable id) {
		CmsChannel entity = findById(id);
		for (CmsAdmin admin : entity.getAdmins()) {
			admin.getChannels().remove(entity);
		}
		CmsChannel parent = entity.getParent();
		super.delete(entity);
		if (parent != null) {
			parent.getChild().remove(entity);
		}
		removeAttachment(entity, true);
		// 删除缓存
		String sid = String.valueOf(entity.getWebsite().getId());
		idCacheSvc.remove(CmsChannel.REF, sid, entity.getPath());
		if (parent == null) {
			idCacheSvc.remove(CmsChannel.REF, sid, "", entity.getSysType());
		}
		return entity;
	}

	@Autowired
	private CmsAdminMng cmsAdminMng;

	@Autowired
	private ContextPvd contextPvd;

	@Autowired
	public void setCmsChannelDao(CmsChannelDao dao) {
		super.setDao(dao);
	}

	@Autowired
	public void setIdCacheSvc(IdCacheSvc idCacheSvc) {
		this.idCacheSvc = idCacheSvc;
	}

	private IdCacheSvc idCacheSvc;

	public CmsChannelDao getDao() {
		return (CmsChannelDao) super.getDao();
	}
}