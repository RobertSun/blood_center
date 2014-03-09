package com.jeecms.download.manager.impl;

import java.io.File;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.jeecms.cms.entity.CmsAdmin;
import com.jeecms.cms.entity.CmsChannel;
import com.jeecms.cms.entity.CmsMember;
import com.jeecms.common.hibernate3.Updater;
import com.jeecms.common.page.Pagination;
import com.jeecms.common.struts2.ContextPvd;
import com.jeecms.common.util.ComUtils;
import com.jeecms.core.JeeCoreManagerImpl;
import com.jeecms.core.entity.Attachment;
import com.jeecms.core.entity.Website;
import com.jeecms.core.manager.AttachmentMng;
import com.jeecms.core.util.UploadRule;
import com.jeecms.core.util.UploadRule.UploadFile;
import com.jeecms.download.dao.DownloadDao;
import com.jeecms.download.entity.Download;
import com.jeecms.download.manager.DownloadMng;

@Service
@Transactional
public class DownloadMngImpl extends JeeCoreManagerImpl<Download> implements
		DownloadMng {
	public Pagination getPage(Long chnlId, int pageNo, int pageSize) {
		return null;
	}

	public Pagination getRightDownload(Long webId, Long chnlId, Long adminId,
			boolean isMy, int status, String title, int order, int pageNo,
			int pageSize) {
		return getDao().getRightDownload(webId, chnlId, adminId, isMy, status,
				title, order, pageNo, pageSize);
	}

	public Download saveDownload(Download bean, CmsAdmin admin,
			CmsMember member, UploadRule rule, String resUrl,
			String downloadAttch, long topTime) {
		Assert.notNull(bean);
		Assert.notNull(rule);
		Assert.notNull(resUrl);

		bean.setContentResPath(resUrl);

		initDefValue(bean);
		handleDate(bean);

		bean = save(bean);

		// 栏目文档数量
		CmsChannel chnl = bean.getChannel();
		chnl.setDocCount(chnl.getDocCount() + 1);

		addAttachment(bean, rule, admin, downloadAttch, member);
		return bean;
	}

	public Download updateDownload(Download bean, CmsAdmin admin,
			CmsMember member, UploadRule rule, String resUrl,
			String downloadAttch, long topTime) {
		Assert.notNull(bean);
		Assert.notNull(rule);
		Assert.notNull(resUrl);

		CmsChannel origChnl = bean.getChannel();
		Download d = findById(bean.getId());
		updateByUpdater(createUpdater(bean));
		// 栏目文档数量
		CmsChannel currChnl = d.getChannel();
		if (!currChnl.equals(origChnl)) {
			// 栏目文档数量
			currChnl.setDocCount(currChnl.getDocCount() + 1);
			origChnl.setDocCount(origChnl.getDocCount() - 1);
		}

		removeAttachment(d, false);

		addAttachment(d, rule, admin, downloadAttch, member);

		return bean;
	}

	/**
	 * 新增附件
	 * 
	 * @param entity
	 * @param rule
	 * @param web
	 * @param user
	 */
	private void addAttachment(Download entity, UploadRule rule,
			CmsAdmin admin, String downloadAttch, CmsMember member) {
		Website web = entity.getWebsite();
		Map<String, UploadFile> uploadFiles = rule.getUploadFiles();
		if (uploadFiles != null) {
			String content = entity.getContent();
			String titleImg = entity.getTitleImg();
			Set<String> rmFile = new HashSet<String>();
			Attachment attach;
			UploadFile uf;
			String rootPath = contextPvd.getAppRealPath(web.getUploadRoot()
					.toString());
			for (String name : uploadFiles.keySet()) {
				if (StringUtils.contains(content, name)
						|| StringUtils.contains(titleImg, name)
						|| StringUtils.contains(downloadAttch, name)) {
					rmFile.add(name);
					attach = new Attachment();
					uf = uploadFiles.get(name);
					attach.setWebsite(web);
					if (admin != null) {
						attach.setUser(admin.getAdmin().getUser());
					}
					attach.setName(uf.getOrigName());
					attach.setFileName(uf.getFileName());
					attach.setFilePath(uf.getRelPath(rootPath));
					attach.setFileSize((int) (uf.getSize() / 1024) + 1);
					attach.setOwnerCtg(Download.ATTACHMENT_CTG);
					attach.setOwnerId(entity.getId());
					attach.setOwnerName(entity.getTitle());
					// attach.setPicture(true);
					// 清除域名相关内容
					attach.setOwnerUrl(entity.getUrl().replace(
							entity.getWebUrl(), ""));
					attach.setDownCount(0L);
					attach.setCreateTime(ComUtils.now());
					if (entity.getGroup() == null) {
						attach.setFree(true);
					} else {
						attach.setFree(false);
					}
					attach.setLost(false);
					if (StringUtils.contains(downloadAttch, name)) {
						attachmentMng.save(attach);
						entity.setAttachment(attach);
						entity.setFileType(attach.getFileName().substring(
								attach.getFileName().lastIndexOf(".") + 1));
						entity.setFileSize(attach.getFileSize().longValue());
					} else {
						entity.addToAttachments(attach);
					}
					if (member != null) {
						attach.setUser(member.getMember().getUser());
						member.addUploadSize((int) uf.getSize());
					}
				}
			}
			for (String name : rmFile) {
				rule.removeUploadFile(name);
			}
		}
	}

	private void initDefValue(Download download) {
		download.setDisabled(false);
		download.setReject(false);
		download.setHasTitleimg(false);
		download.setDownCount(0L);
		download.setCheck(true);
		download.setCheckStep(-1);
		download.setCheckOpinion("");
		if (download.getContent() == null) {
			download.setContent("");
		}
		if (download.getBold() == null) {
			download.setBold(false);
		}
		if (download.getDraft() == null) {
			download.setDraft(false);
		}
		if (download.getRecommend() == null) {
			download.setRecommend(false);
		}
		download.setCommentCount(0);
		download.setViewTotal(0L);
		download.setVisitTotal(0L);
		download.setStatDate(ComUtils.now());
		download.setVisitToday(0L);
		download.setVisitWeek(0L);
		download.setVisitMonth(0L);
		download.setVisitQuarter(0L);
		download.setVisitYear(0L);
	}

	private void handleDate(Download download) {
		Date now = ComUtils.now();
		download.setReleaseSysDate(now);
		// 如果没有输入发布时间，则取系统时间；
		Date relDate = download.getReleaseDate();
		if (relDate == null) {
			relDate = now;
			download.setReleaseDate(relDate);
		}
	}

	private void removeAttachment(Download entity, boolean removeAll) {
		Set<Attachment> attachs = entity.getCoreAttachments();

		String titleImg = entity.getTitleImg();

		Set<Attachment> rmAttachs = new HashSet<Attachment>();
		String filename;
		if (attachs != null) {
			for (Attachment attach : attachs) {
				filename = attach.getFileName();
				if (removeAll || !StringUtils.contains(titleImg, filename)) {
					String realPath = contextPvd.getAppRealPath(attach
							.getRelPath());
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
	}

	private Updater createUpdater(Download bean) {
		Updater updater = Updater.create(bean);
		// 控制不能更新的字段
		updater.exclude(Download.PROP_WEBSITE);
		updater.exclude(Download.PROP_CONTENT_RES_PATH);
		updater.exclude(Download.PROP_ADMIN_CHECK);
		updater.exclude(Download.PROP_ADMIN_DISABLE);
		updater.exclude(Download.PROP_ADMIN_INPUT);
		updater.exclude(Download.PROP_CHECK);
		updater.exclude(Download.PROP_CHECK_OPINION);
		updater.exclude(Download.PROP_CHECK_STEP);
		updater.exclude(Download.PROP_CHECK_TIME);
		updater.exclude(Download.PROP_CONTENT_RES_PATH);
		updater.exclude(Download.PROP_DISABLE_TIME);
		updater.exclude(Download.PROP_REJECT);
		return updater;
	}

	public Pagination getForTag(Long webId, Long chnlId, Long ctgId,
			String searchKey, Boolean hasTitleImg, boolean recommend,
			int topLevel, int orderBy, boolean isPage, int firstResult,
			int pageNo, int pageSize) {
		return getDao().getForTag(webId, chnlId, ctgId, searchKey, hasTitleImg,
				recommend, topLevel, orderBy, isPage, firstResult, pageNo,
				pageSize);
	}

	public Pagination getDownloadBySort(Long webId, Long chnlId, Long typeId,
			int status, String title, int order, int pageNo, int pageSize) {
		return getDao().getDownloadBySort(webId, chnlId, typeId, status, title,
				order, pageNo, pageSize);
	}

	@Override
	public Object updateByUpdater(Updater updater) {
		Download download = (Download) super.updateByUpdater(updater);
		return download;
	}

	@Override
	public Download save(Download download) {
		super.save(download);
		return download;
	}

	@Override
	public Download findById(Serializable id) {
		Download download = super.findById(id);
		return download;
	}

	@Override
	public Download deleteById(Serializable id) {
		Download download = super.deleteById(id);
		Attachment entity = download.getAttachment();
		if (entity != null) {
			attachmentMng.delete(entity);
		}
		return download;
	}

	@Autowired
	public void setDao(DownloadDao dao) {
		super.setDao(dao);
	}

	public DownloadDao getDao() {
		return (DownloadDao) super.getDao();
	}

	@Autowired
	private ContextPvd contextPvd;
	@Autowired
	private AttachmentMng attachmentMng;

}
