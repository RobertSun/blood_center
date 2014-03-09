package com.jeecms.cms.action.front;

import static com.jeecms.cms.Constants.MEMBER_SYS;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.jeecms.article.entity.Article;
import com.jeecms.article.manager.ArticleMng;
import com.jeecms.cms.Constants;
import com.jeecms.cms.entity.CmsChannel;
import com.jeecms.cms.entity.CmsConfig;
import com.jeecms.cms.entity.CmsMember;
import com.jeecms.cms.entity.CmsMemberGroup;
import com.jeecms.cms.manager.CmsChannelMng;
import com.jeecms.cms.manager.CmsConfigMng;
import com.jeecms.cms.manager.CmsMemberMng;
import com.jeecms.common.page.Paginable;
import com.jeecms.common.page.SimplePage;
import com.jeecms.core.PageBaseAction;
import com.jeecms.core.service.PageCacheSvc;
import com.jeecms.download.entity.Download;
import com.jeecms.download.manager.DownloadMng;

@SuppressWarnings("unchecked")
@Scope("prototype")
@Controller("cms.cmsPageAct")
public class CmsPageAct extends PageBaseAction {
	private static final Logger log = LoggerFactory.getLogger(CmsPageAct.class);

	@Override
	protected String sysIndex() throws IOException {
		String result = SUCCESS;
		if (getConfig().getCacheHomepage()) {
			log.debug("��ҳ���濪��");
			result = PAGE_CACHE_RESULT;
			if (useHomepageCache()) {
				return null;
			}
		}
		sysType = getConfig().getDefaultSystem();
		chnl = cmsChannelMng.getRoot(getWebId(), sysType);
		if (chnl == null) {
			addActionError("վ����ҳ�����ڣ����ں�̨�����ҳ��");
			return showMessage();
		}
		// chnl.setVisitTotal(chnl.getVisitTotal() + 1);

		tplPath = chnl.chooseTplChannel();
		return result;
	}

	@Override
	protected String chnlIndex(String chnlName) throws IOException {
		String result = SUCCESS;
		if (getConfig().getCacheChannel()) {
			log.debug("��Ŀ���濪��");
			result = PAGE_CACHE_RESULT;
			if (useChannelCache(chnlName)) {
				return null;
			}
		}
		chnl = cmsChannelMng.getByPath(getWebId(), chnlName);
		if (chnl == null) {
			return pageNotFound();
		}
		// chnl.setVisitTotal(chnl.getVisitTotal() + 1);

		tplPath = chnl.chooseTplChannel();
		sysType = chnl.getSysType();
		return result;
	}

	@Override
	protected String content(String chnlName, Long id) {
		CmsChannel cmschnl = cmsChannelMng.getByPath(getWebId(), chnlName);
		if (cmschnl != null) {
			if (cmschnl.getSysType().equals(Constants.ARTICLE_SYS)) {
				arti = articleMng.findAndCheckResPath(id);
				String err = checkArticle(arti, chnlName);
				if (err != null) {
					return err;
				}
				chnl = arti.getChannel();
				sysType = chnl.getSysType();
				pagination = new SimplePage(pageNo, 1, arti.getPageCount());

				arti.updateVisit(1);

				tplPath = arti.chooseTpl();
			} else {
				//============ **add 2011.11 start=========
				download = downloadMng.findById(id);
				String err = checkDownload(download, chnlName);
				if (err != null) {
					return err;
				}
				chnl = download.getChannel();
				download.setVisitTotal(download.getVisitTotal() + 1);
				sysType = chnl.getSysType();
				tplPath = download.chooseTpl();
				//============ **add delete 2011.11 end=========
				// ============ **add delete 2011.11 start=========
//				downcontent(chnlName, id);
				// ============ **add delete 2011.11 and=========
			}
		} else {
			return pageNotFound();
		}
		return SUCCESS;
	}

	// ============ **add delete 2011.11 start=========
//	private void downcontent(String chnlName, Long id) {
//		download = downloadMng.findById(id);
//		chnl = download.getChannel();
//		download.setVisitTotal(download.getVisitTotal() + 1);
//
//		sysType = chnl.getSysType();
//		tplPath = download.chooseTpl();
//	}
	// ============ **add delete 2011.11 and=========

	@Override
	protected String alone(String chnlName) {
		chnl = cmsChannelMng.getByPath(getWebId(), chnlName);
		if (chnl == null) {
			return pageNotFound();
		}
		sysType = chnl.getSysType();
		tplPath = chnl.chooseTplChannel();
		return SUCCESS;
	}

	@Override
	protected String pageNotFound() {
		return handleResult(PAGE_NOT_FOUND, MEMBER_SYS, getConfig()
				.getSolution(MEMBER_SYS));
	}

	@Override
	protected String getSolution() {
		return getConfig().getSolution(getSysType());
	}

	private String checkArticle(Article entity, String chnlName) {
		if (entity == null || !entity.getChannel().getPath().equals(chnlName)) {
			return pageNotFound();
		}
		// ����Ķ�Ȩ��
		CmsMemberGroup group = entity.getGroup();
		if (group == null) {
			group = entity.getChannel().getGroupVisit();
		}
		if (group != null) {
			CmsMember cmsMember = getCmsMember();
			if (cmsMember == null) {
				return redirectLogin();
			}
			int artiLevel = group.getLevel();
			CmsMemberGroup memberGroup = cmsMember.getGroup();
			int memberLevel = memberGroup.getLevel();
			if (artiLevel > memberLevel) {
				addActionError("��Ļ�Ա�鼶���ǡ�" + memberGroup.getName() + "������ҳ����Ҫ��"
						+ group.getName() + "�������ϼ�����ܷ���");
				return showMessage();
			}
		}
		if (entity.getDisabled()) {
			addActionError("������ʵ������Ѿ����ر�");
			return showMessage();
		}
		return null;
	}

	// ==================== **add 2011.11 start ===================
	/**
	 * ����Ȩ�޼��
	 * @param entity
	 * @param chnlName
	 * @return
	 */
	private String checkDownload(Download entity, String chnlName) {
		if (entity == null || !entity.getChannel().getPath().equals(chnlName)) {
			return pageNotFound();
		}
		// �������Ȩ��
		CmsMemberGroup group = entity.getGroup();
		if (group == null) {
			group = entity.getChannel().getGroupVisit();
		}
		if (group != null) {
			CmsMember cmsMember = getCmsMember();
			if (cmsMember == null) {
				return redirectLogin();
			}
			int dlLevel = group.getLevel();
			CmsMemberGroup memberGroup = cmsMember.getGroup();
			int memberLevel = memberGroup.getLevel();
			if (dlLevel > memberLevel) {
				addActionError("��Ļ�Ա�鼶���ǡ�" + memberGroup.getName() + "������ҳ����Ҫ��"
						+ group.getName() + "�������ϼ�����ܷ���");
				return showMessage();
			}
		}
		if (entity.getDisabled()) {
			addActionError("������ʵ����������Ѿ���ɾ���رա�");
			return showMessage();
		}
		return null;
	}
	// ==================== **add 2011.11 end ===================

	public CmsChannel getChnl() {
		return chnl;
	}

	public Article getArti() {
		return arti;
	}

	public String getSysType() {
		return sysType;
	}

	public CmsConfig getConfig() {
		return cmsConfigMng.findById(getWebId());
	}

	/**
	 * ���cms��Ա����
	 *
	 * @return
	 */
	public CmsMember getCmsMember() {
		Long memberId = getMemberId();
		if (memberId == null) {
			return null;
		} else {
			return cmsMemberMng.findById(memberId);
		}
	}

	/**
	 * ���cms��ԱID
	 *
	 * @return
	 */
	public Long getCmsMemberId() {
		CmsMember cmsMember = getCmsMember();
		if (cmsMember == null) {
			return null;
		} else {
			return cmsMember.getId();
		}
	}

	private String showMessage() {
		return handleResult(SHOW_MESSAGE, Constants.MEMBER_SYS, getConfig()
				.getSolution(MEMBER_SYS));
	}

	protected String redirectLogin() {
		rootWebUrl = getWeb().getRootWeb().getWebUrl();
		return Constants.CMS_MEMBER_LOGIN;
	}

	private boolean useCache(Serializable key, PageCacheSvc cache)
			throws IOException {
		byte[] bytes = cache.get(key);
		if (bytes != null) {
			int i = 0;
			while (i < MAX_WAIT_TIME && bytes.length == 0) {
				try {
					i += SLEEP_FOR_WAIT;
					Thread.sleep(SLEEP_FOR_WAIT);
					bytes = cache.get(key);
					log.debug("�ȴ��sleep{}ms" + SLEEP_FOR_WAIT);
				} catch (InterruptedException e1) {
					log.warn("sleep interrupted");
				}
			}
			int len = bytes.length;
			if (i < MAX_WAIT_TIME && len > 0) {
				HttpServletResponse resp = ServletActionContext.getResponse();
				resp.setContentLength(len);
				resp.setCharacterEncoding("GBK");
				resp.setContentType("text/html;charset=GBK");
				OutputStream out = resp.getOutputStream();
				out.write(bytes, 0, len);
				out.flush();
				log.debug("��������");
				return true;
			} else {
				log.warn("�ȴ��Ѿ�����{}ms��û�еȵ�����", i);
			}
		} else {
			// ׼����ɻ���
			cache.put(key, new byte[0]);
			log.debug("׼����ɻ���");
		}
		return false;
	}

	private boolean useHomepageCache() throws IOException {
		ckHomepage = getWebId();
		cacheType = HOMEPAGE_CACHE;
		return useCache(ckHomepage, homepageCacheSvc);
	}

	private boolean useChannelCache(String chnlName) throws IOException {
		ckChannel = channelCacheSvc.getKey(getWebId(), chnlName, getPageNo());
		cacheType = CHANNEL_CACHE;
		return useCache(ckChannel, channelCacheSvc);
	}

	private static final int SLEEP_FOR_WAIT = 1000;
	private static final int MAX_WAIT_TIME = 15000;
	@Autowired
	private CmsConfigMng cmsConfigMng;
	@Autowired
	private CmsChannelMng cmsChannelMng;
	@Autowired
	private CmsMemberMng cmsMemberMng;
	@Autowired
	private ArticleMng articleMng;
	@Autowired
	private DownloadMng downloadMng;
	private CmsChannel chnl;
	private Article arti;
	private Download download;
	private String sysType;
	private Paginable pagination;

	public void setChnl(CmsChannel chnl) {
		this.chnl = chnl;
	}

	public Paginable getPagination() {
		return pagination;
	}

	public Download getDownload() {
		return download;
	}

	public void setDownload(Download download) {
		this.download = download;
	}

}
