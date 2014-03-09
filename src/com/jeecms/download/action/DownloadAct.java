package com.jeecms.download.action;

import static com.jeecms.cms.Constants.DOWNLOAD_SYS;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;

import com.jeecms.cms.entity.CmsChannel;
import com.jeecms.cms.entity.CmsMemberGroup;
import com.jeecms.cms.entity.ContentCtg;
import com.jeecms.cms.manager.CmsChannelMng;
import com.jeecms.cms.manager.CmsMemberGroupMng;
import com.jeecms.cms.manager.ContentCtgMng;
import com.jeecms.common.page.Pagination;
import com.jeecms.common.util.BCConvert;
import com.jeecms.common.util.SelectTreeUtils;
import com.jeecms.core.util.UploadRule;
import com.jeecms.download.entity.DownType;
import com.jeecms.download.entity.Download;
import com.jeecms.download.manager.DownTypeMng;
import com.jeecms.download.manager.DownloadMng;

@SuppressWarnings({ "serial", "unchecked" })
@Scope("prototype")
@Controller("download.downloadAct")
public class DownloadAct extends com.jeecms.cms.CmsSysAction {
	private static final Logger log = LoggerFactory
			.getLogger(DownloadAct.class);

	public String left() {
		List<CmsChannel> chnlList = cmsChannelMng.getRightChnl(getWebId(),
				DOWNLOAD_SYS, getCmsAdminId(), true);
		chnlList = SelectTreeUtils.handleTreeChild(chnlList);
		if (chnlList.size() > 0) {
			treeRoot = chnlList.get(0);
		}
		return LEFT;
	}

	public String list() {
		if (chnlId == null) {
			chnl = cmsChannelMng.getRoot(getWebId(), DOWNLOAD_SYS, true);
			if (chnl != null) {
				chnlId = chnl.getId();
			}
		} else {
			chnl = cmsChannelMng.findById(chnlId);
		}
		selfOnly = getCmsAdmin().getSelfOnly();
		if (selfOnly) {
			queryMy = selfOnly;
		}
		if (chnlId != null) {
			pagination = downloadMng.getRightDownload(getWebId(), chnlId,
					getCmsAdminId(), queryMy, queryStatus, queryTitle,
					queryOrder, pageNo, getCookieCount());
		} else {
			pagination = new Pagination(1, getCookieCount(), 0, null);
		}
		return LIST;
	}

	public String add() {
		contentCtgList = contentCtgMng.getList(getRootWebId(), false); //ȡ��վ����������
		CmsChannel channel = cmsChannelMng.findById(chnlId);
		tplContentList = channel.getModel().tplContentList(getConfig(),
				DOWNLOAD_SYS, contextPvd.getAppRoot());
		downTypeList = downTypeMng.getList(getRootWebId(), false); //ȡ��վ����������
		// ֻ��ѡ��ͬһģ�͵���Ŀ
		Long modelId;
		if (channel.getParent() == null
				&& getConfig().getDefDownloadModel() != null) {
			modelId = getConfig().getDefDownloadModel().getId();
		} else {
			modelId = channel.getModel().getId();
		}
		chnlList = cmsChannelMng.getRightChnl(getWebId(), DOWNLOAD_SYS, chnlId,
				getCmsAdminId(), modelId, true);
		chnlList = SelectTreeUtils.handleTreeChild(chnlList);
		chnlList = SelectTreeUtils.webTree(chnlList);
		// �����ϴ�����
		addUploadRule();
		return ADD;
	}

	public String save() {
		downloadMng.saveDownload(bean, getCmsAdmin(), getCmsMember(),
				uploadRule, getWeb().getResUrl(), downloadAttch, topTime);

		// ����ϴ�����
		removeUploadRule();

		log.info("��� ���� �ɹ�:{}", bean.getTitle());
		addActionMessage("��ӳɹ�");
		return list();
	}

	public String edit() {
		this.bean = downloadMng.findById(id);
		contentCtgList = contentCtgMng.getList(getRootWebId(), false); //ȡ��վ����������
		tplContentList = bean.getChannel().getModel().tplContentList(
				getConfig(), DOWNLOAD_SYS, contextPvd.getAppRoot());
		downTypeList = downTypeMng.getList(getRootWeb().getId(), false); //ȡ��վ����������
		List<CmsChannel> chnlList = cmsChannelMng.getRightChnl(bean
				.getWebsite().getId(), DOWNLOAD_SYS, getCmsAdminId(), true);
		chnlList = SelectTreeUtils.handleTreeChild(chnlList);
		this.list = SelectTreeUtils.webTree(chnlList);

		// �����ϴ�����
		addUploadRule();
		return EDIT;
	}

	public String check() {
		this.bean = downloadMng.findById(id);
		if (bean.getCheck()) {
			bean.setAdminDisable(getAdmin());
			bean.setCheck(false);
		} else {
			bean.setAdminCheck(getAdmin());
			bean.setCheck(true);
		}
		log.info("��˲��� ���� �ɹ�:{}", bean.getTitle());
		addActionMessage("�����ɹ�");
		return list();
	}

	public String update() {
		downloadMng.updateDownload(bean, getCmsAdmin(), getCmsMember(),
				uploadRule, getWeb().getResUrl(), downloadAttch, topTime);

		// ����ϴ�����
		removeUploadRule();

		log.info("�޸� ���� �ɹ�:{}", bean.getTitle());
		return list();
	}

	public String delete() {
		try {
			if (id != null) {
				bean = downloadMng.deleteById(id);
				log.info("ɾ�� ���� �ɹ�:{}", bean.getTitle());
			} else {
				for (Download o : downloadMng.deleteById(ids)) {
					log.info("ɾ�� ���� �ɹ�:{}", o.getTitle());
				}
			}
		} catch (DataIntegrityViolationException e) {
			addActionError("��¼�ѱ����ã�����ɾ��!");
			return SHOW_ERROR;
		}
		return list();
	}

	public boolean validateAdd() {
		if (hasErrors()) {
			return true;
		}
		if (vldChannel(chnlId, true, null)) {
			return true;
		}
		return false;
	}

	public boolean validateSave() {
		if (hasErrors()) {
			return true;
		}
		// ��֤�ϴ�����
		if (vldUploadRule()) {
			return true;
		}
		// ����bean
		if (vldBean()) {
			return true;
		}
		bean.setWebsite(getWeb());
		// ��֤��Ŀ
		if (vldChannel(bean.getChannel().getId(), false, bean)) {
			return true;
		}
		// ��֤��������
		if (vldContentCtg(bean.getContentCtg().getId(), bean)) {
			return true;
		}
		// ��֤��Ա��
		if (vldMemberGroup(bean.getGroup(), bean, true)) {
			return true;
		}
		return false;
	}

	public boolean validateEdit() {
		if (hasErrors()) {
			return true;
		}
		if (vldDownloadRight(id)) {
			return true;
		}
		if (vldWebsite(id, null)) {
			return true;
		}
		return false;
	}

	public boolean validateUpdate() {
		if (hasErrors()) {
			return true;
		}
		// ��֤�ϴ�����
		if (vldUploadRule()) {
			return true;
		}
		// ����bean
		if (vldBean()) {
			return true;
		}
		// ��֤����Ȩ��
		if (vldDownloadRight(bean.getId())) {
			return true;
		}
		// ��֤��Ŀ
		if (vldChannel(bean.getChannel().getId(), false, null)) {
			return true;
		}
		if (vldWebsite(bean.getId(), bean)) {
			return true;
		}
		// ��֤��������
		if (vldContentCtg(bean.getContentCtg().getId(), null)) {
			return true;
		}
		return false;
	}

	public boolean validateDelete() {
		if (hasErrors()) {
			return true;
		}
		Download entity;
		if (id == null && (ids == null || ids.length <= 0)) {
			addActionError("ID����Ϊ��");
			return true;
		} else {
			if (id != null) {
				ids = new Long[] { id };
			}
			for (Long id : ids) {
				entity = downloadMng.findById(id);
				if (!entity.getWebsite().getId().equals(getWebId())) {
					addActionError("����ɾ������վ������");
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * ��֤�����޸�Ȩ��
	 *
	 * @param entity
	 * @return
	 */
	private boolean vldDownloadRight(Long id) {
		Download entity = downloadMng.findById(id);
		if (entity == null) {
			addActionError("�����²����ڣ�" + id);
			return true;
		}
		// ֻ�ܹ����Լ�����ݵĹ���Ա�����ܹ���������ݡ�
		if (getCmsAdmin().getSelfOnly()
				&& !getCmsAdminId().equals(entity.getAdminInput().getId())) {
			addActionError("�����Լ�����ݲ����޸ģ�" + id);
			return true;
		}
		// ֻ�ܹ�����Ȩ�޵���Ŀ������
		if (!entity.getChannel().adminsContain(getCmsAdminId())) {
			addActionError("��û���������������Ŀ��Ȩ�ޣ�" + id);
			return true;
		}
		return false;
	}

	private boolean vldUploadRule() {
		// �ϴ�����
		uploadRule = (UploadRule) contextPvd.getSessionAttr(UploadRule.KEY
				+ uploadRuleId);
		if (uploadRule == null) {
			addActionError("û���ҵ��ϴ����򣬲������ύ");
			return true;
		}
		return false;
	}

	private boolean vldChannel(Long chnlId, boolean allowLeaf, Download bean) {
		if (chnlId == null) {
			addActionError("��ĿID����Ϊ��");
		}
		CmsChannel c = cmsChannelMng.findById(chnlId);
		if (c == null) {
			addActionError("����Ŀ�����ڣ�" + chnlId);
			return true;
		}
		if (!c.getHasChild()) {
			addActionError("����Ŀ�����������ݣ�" + c.getName());
			return true;
		}
		if (!allowLeaf && !c.isTreeLeaf()) {
			addActionError("ֻ��ĩ����Ŀ����������ݣ�" + c.getName());
			return true;
		}
		if (!c.getWebsite().getId().equals(getWebId())) {
			addActionError("���Ǳ�վ�����Ŀ��" + chnlId);
			return true;
		}
		if (!c.getAdmins().contains(getCmsAdmin())) {
			addActionError("��û�и���Ŀ��Ȩ�ޣ�" + chnlId);
			return true;
		}
		if (bean != null) {
			bean.setChannel(c);
		}
		return false;
	}

	private boolean vldContentCtg(Long ctgId, Download bean) {
		ContentCtg po = contentCtgMng.findById(ctgId);
		if (po == null) {
			addActionError("���������Բ����ڣ�" + ctgId);
			return true;
		}
		if (!po.getWebsite().getId().equals(getWeb().getRootWebId())) {
			addActionError("���Ǳ�ϵ����վ���������ԣ�" + ctgId);
			return true;
		}
		if (bean != null) {
			bean.setContentCtg(po);
		}
		return false;
	}

	private boolean vldMemberGroup(CmsMemberGroup group, Download bean,
			boolean onSave) {
		// ��Ϊ���ֶ�
		if (group == null) {
			return false;
		}
		Long id = group.getId();
		if (id != null) {
			CmsMemberGroup po = cmsMemberGroupMng.findById(id);
			if (po == null) {
				addActionError("�û�Ա�鲻���ڣ�" + id);
				return true;
			}
			if (!po.getWebsite().getId().equals(getWeb().getRootWebId())) {
				addActionError("���Ǳ�ϵ����վ�Ļ�Ա�飺" + id);
				return true;
			}
			if (bean != null) {
				bean.setGroup(po);
			}
		} else {
			if (onSave) {
				bean.setGroup(null);
			}
		}
		return false;
	}

	private boolean vldWebsite(Long id, Download bean) {
		Download entity = downloadMng.findById(id);
		if (!entity.getWebsite().getId().equals(getWebId())) {
			addActionError("ֻ���޸ı�վ����ݣ�" + id);
			return true;
		}
		if (bean != null) {
			bean.setWebsite(getWeb());
		}
		return false;
	}

	/**
	 * ����bean
	 *
	 * @return
	 */
	private boolean vldBean() {
		// ����checkbox
		if (bean.getBold() == null) {
			bean.setBold(false);
		}
		// ����tag
		String tags = bean.getTags();
		if (!StringUtils.isBlank(tags)) {
			bean.setTags(BCConvert.qj2bj(tags));
		}
		// ����timestamp
		Date d = bean.getReleaseDate();
		if (d != null) {
			bean.setReleaseDate(new Timestamp(d.getTime()));
		}
		return false;
	}

	private void addUploadRule() {
		UploadRule rule = new UploadRule(getWeb().getUploadRoot().toString(),
				Download.UPLOAD_PATH, true);
		Set<String> downloadset = new HashSet<String>();
		for (String s : UploadRule.DEF_IMG_ACCEPT) {
			downloadset.add(s);
		}
		downloadset.add("doc");
		downloadset.add("rar");
		downloadset.add("zip");
		downloadset.add("xls");
		rule.setAcceptImg(downloadset);
		uploadRuleId = rule.hashCode();
		contextPvd.setSessionAttr(UploadRule.KEY + uploadRuleId, rule);
	}

	private void removeUploadRule() {
		// ɾ��δ��ʹ�õ�ͼƬ
		//uploadRule.clearUploadFile();
		// ����ϴ�����
		contextPvd.removeAttribute(UploadRule.KEY + uploadRuleId);
	}

	@Autowired
	private DownloadMng downloadMng;
	@Autowired
	private CmsChannelMng cmsChannelMng;
	@Autowired
	private DownTypeMng downTypeMng;
	@Autowired
	private ContentCtgMng contentCtgMng;
	@Autowired
	private CmsMemberGroupMng cmsMemberGroupMng;

	private Download bean;
	private CmsChannel treeRoot;
	private Long chnlId;

	private CmsChannel chnl;
	private List<ContentCtg> contentCtgList;
	private List<CmsMemberGroup> memberGroupList;
	private List<CmsChannel> chnlList;
	private List<String> tplContentList;
	private List<DownType> downTypeList;

	private int uploadRuleId;
	private UploadRule uploadRule;

	private long topTime = 0;

	private boolean selfOnly = false;
	private boolean queryMy = false;
	private int queryStatus = 0;
	private String queryTitle = "";
	private String downloadAttch;
	private int queryOrder = 0;

	public Download getBean() {
		return bean;
	}

	public void setBean(Download bean) {
		this.bean = bean;
	}

	public CmsChannel getTreeRoot() {
		return treeRoot;
	}

	public void setTreeRoot(CmsChannel treeRoot) {
		this.treeRoot = treeRoot;
	}

	public Long getChnlId() {
		return chnlId;
	}

	public void setChnlId(Long chnlId) {
		this.chnlId = chnlId;
	}

	public CmsChannel getChnl() {
		return chnl;
	}

	public void setChnl(CmsChannel chnl) {
		this.chnl = chnl;
	}

	public List<ContentCtg> getContentCtgList() {
		return contentCtgList;
	}

	public void setContentCtgList(List<ContentCtg> contentCtgList) {
		this.contentCtgList = contentCtgList;
	}

	public List<CmsMemberGroup> getMemberGroupList() {
		return memberGroupList;
	}

	public void setMemberGroupList(List<CmsMemberGroup> memberGroupList) {
		this.memberGroupList = memberGroupList;
	}

	public List<CmsChannel> getChnlList() {
		return chnlList;
	}

	public void setChnlList(List<CmsChannel> chnlList) {
		this.chnlList = chnlList;
	}

	public List<String> getTplContentList() {
		return tplContentList;
	}

	public void setTplContentList(List<String> tplContentList) {
		this.tplContentList = tplContentList;
	}

	public int getUploadRuleId() {
		return uploadRuleId;
	}

	public void setUploadRuleId(int uploadRuleId) {
		this.uploadRuleId = uploadRuleId;
	}

	public long getTopTime() {
		return topTime;
	}

	public void setTopTime(long topTime) {
		this.topTime = topTime;
	}

	public boolean isSelfOnly() {
		return selfOnly;
	}

	public void setSelfOnly(boolean selfOnly) {
		this.selfOnly = selfOnly;
	}

	public boolean isQueryMy() {
		return queryMy;
	}

	public void setQueryMy(boolean queryMy) {
		this.queryMy = queryMy;
	}

	public int getQueryStatus() {
		return queryStatus;
	}

	public void setQueryStatus(int queryStatus) {
		this.queryStatus = queryStatus;
	}

	public String getQueryTitle() {
		return queryTitle;
	}

	public void setQueryTitle(String queryTitle) {
		this.queryTitle = queryTitle;
	}

	public int getQueryOrder() {
		return queryOrder;
	}

	public void setQueryOrder(int queryOrder) {
		this.queryOrder = queryOrder;
	}

	public List<DownType> getDownTypeList() {
		return downTypeList;
	}

	public void setDownTypeList(List<DownType> downTypeList) {
		this.downTypeList = downTypeList;
	}

	public String getDownloadAttch() {
		return downloadAttch;
	}

	public void setDownloadAttch(String downloadAttch) {
		this.downloadAttch = downloadAttch;
	}
}