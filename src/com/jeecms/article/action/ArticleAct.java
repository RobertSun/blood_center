package com.jeecms.article.action;

import static com.jeecms.cms.Constants.ARTICLE_SYS;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;

import com.jeecms.article.entity.Article;
import com.jeecms.article.manager.ArticleMng;
import com.jeecms.cms.entity.ChnlModel;
import com.jeecms.cms.entity.ChnlModelItem;
import com.jeecms.cms.entity.CmsAdmin;
import com.jeecms.cms.entity.CmsChannel;
import com.jeecms.cms.entity.CmsMemberGroup;
import com.jeecms.cms.entity.ContentCtg;
import com.jeecms.cms.manager.ChnlModelMng;
import com.jeecms.cms.manager.CmsAdminMng;
import com.jeecms.cms.manager.CmsChannelMng;
import com.jeecms.cms.manager.CmsMemberGroupMng;
import com.jeecms.cms.manager.ContentCtgMng;
import com.jeecms.common.page.Pagination;
import com.jeecms.common.util.BCConvert;
import com.jeecms.common.util.HtmlChecker;
import com.jeecms.common.util.SelectTreeUtils;
import com.jeecms.core.util.UploadRule;

@SuppressWarnings({ "serial", "unchecked" })
@Scope("prototype")
@Controller("article.articleAct")
public class ArticleAct extends com.jeecms.cms.CmsSysAction {
	private static final Logger log = LoggerFactory.getLogger(ArticleAct.class);

	public String left() {
		List<CmsChannel> chnlList = cmsChannelMng.getRightChnl(getWebId(),
				ARTICLE_SYS, getCmsAdminId(), true);
		chnlList = SelectTreeUtils.handleTreeChild(chnlList);
		if (chnlList.size() > 0) {
			treeRoot = chnlList.get(0);
		}
		return LEFT;
	}

	public String listUncheck() {
		pagination = articleMng.getUncheckArticle(getAdminId(), pageNo,
				getCookieCount());
		updateType = "listUncheck";
		return "listUncheck";
	}

	public String list() {
		if (chnlId == null) {
			chnl = cmsChannelMng.getRoot(getWebId(), ARTICLE_SYS, true);
			if (chnl != null) {
				chnlId = chnl.getId();
			}
		} else {
			chnl = cmsChannelMng.findById(chnlId);
		}
		adminList = new ArrayList<CmsAdmin>();
		contentCtgList = contentCtgMng.getList(getRootWebId(), false);
		if (chnl != null) {
			adminList.addAll(chnl.getAdmins());
		}
		selfOnly = getCmsAdmin().getSelfOnly();
		if (selfOnly) {
			queryInputAdminId = getAdminId();
		}
		if (chnlId != null) {
			pagination = articleMng.getRightArticle(getWebId(), chnlId,
					getAdminId(), queryInputAdminId, queryContentCtgId,
					queryDisabled, queryTopTime, queryTopLevel, queryStatus,
					queryTitle, queryOrder, pageNo, getCookieCount());
		} else {
			pagination = new Pagination(1, getCookieCount(), 0, null);
		}
		return LIST;
	}

	// chnlId����Ϊ��
	public String add() {
		contentCtgList = contentCtgMng.getList(getRootWebId(), false);
		memberGroupList = cmsMemberGroupMng.getList(getRootWebId(), 0, true);
		CmsChannel channel = cmsChannelMng.findById(chnlId);
		tplContentList = channel.getModel().tplContentList(getConfig(),
				ARTICLE_SYS, contextPvd.getAppRoot());
		// ֻ��ѡ��ͬһģ�͵���Ŀ
		Long modelId;
		ChnlModel model;
		if (channel.getParent() == null
				&& getConfig().getDefArticleModel() != null) {
			modelId = getConfig().getDefArticleModel().getId();
			model = chnlModelMng.findById(modelId);
		} else {
			model = channel.getModel();
			modelId = model.getId();
		}
		itemMap = model.getDiplayItemMap(ChnlModel.CONTENT_ITEM);
		chnlList = cmsChannelMng.getRightChnl(getWebId(), ARTICLE_SYS, chnlId,
				getCmsAdminId(), modelId, true);
		chnlList = SelectTreeUtils.handleTreeChild(chnlList);
		chnlList = SelectTreeUtils.webTree(chnlList);
		// �����ϴ�����
		addUploadRule();
		return ADD;
	}

	public String edit() {
		bean = articleMng.findById(id);
		itemMap = bean.getChannel().getModel().getDiplayItemMap(
				ChnlModel.CONTENT_ITEM);
		Long webId = bean.getWebsite().getRootWebId();
		contentCtgList = contentCtgMng.getList(webId, false);
		memberGroupList = cmsMemberGroupMng.getList(webId, 0, true);
		tplContentList = bean.getChannel().getModel().tplContentList(
				bean.getConfig(), ARTICLE_SYS, contextPvd.getAppRoot());

		List<CmsChannel> chnlList = cmsChannelMng.getRightChnl(bean
				.getWebsite().getId(), ARTICLE_SYS, getCmsAdminId(), true);
		chnlList = SelectTreeUtils.handleTreeChild(chnlList);
		this.list = SelectTreeUtils.webTree(chnlList);

		// �����ϴ�����
		addUploadRule();
		return EDIT;
	}

	public String save() {
		validateSave();
		articleMng.saveArticle(bean, getCmsAdmin(), uploadRule, getWeb()
				.getResUrl(), getConfig().getCheckCount(), topTime);

		// ����ϴ�����
		// removeUploadRule();

		log.info("��� ���� �ɹ�:{}", bean.getTitle());
		addActionMessage("添加成功");
		return add();
	}

	public String update() {
		validateSave();
		articleMng.updateArticle(bean, getCmsAdmin(), uploadRule, topTime);

		// ����ϴ�����
		removeUploadRule();

		log.info("�޸� ���� �ɹ�:{}", bean.getTitle());
		if (StringUtils.equals(updateType, "listUncheck")) {
			return listUncheck();
		} else if (StringUtils.equals(updateType, "listSignin")) {
			return listSignin();
		} else {
			return list();
		}
	}

	public String delete() {
		try {
			for (Article o : articleMng.deleteById(ids)) {
				log.info("ɾ�� ���� �ɹ�:{}", o.getTitle());
			}
		} catch (DataIntegrityViolationException e) {
			addActionError("删除失败!");
			return SHOW_ERROR;
		}
		return list();
	}

	public String disable() {
		for (Article o : articleMng.disableArticle(ids, getCmsAdmin(), true)) {
			log.info("���� ���� �ɹ�:{}", o.getTitle());
		}
		return list();
	}

	public String undisable() {
		for (Article o : articleMng.disableArticle(ids, getCmsAdmin(), false)) {
			log.info("��� ���� �ɹ�:{}", o.getTitle());
		}
		return list();
	}

	public String checkView() {
		bean = articleMng.findById(id);
		return "checkView";
	}

	public String pass() {
		for (Article o : articleMng.checkArticle(ids, getCmsAdmin())) {
			log.info("���ͨ�� ���� �ɹ�:{}", o.getTitle());
		}
		return listUncheck();
	}

	public String reject() {
		// �������ѡ
		for (Article o : articleMng.rejectArticle(ids, getCmsAdmin(),
				checkOpinion)) {
			log.info("����˻�  ���� �ɹ�:{}", o.getTitle());
		}
		if (StringUtils.equals(updateType, "listSignin")) {
			return listSignin();
		} else {
			return listUncheck();
		}
	}

	public String listSignin() {
		pagination = articleMng.getUnsigninArticle(getAdminId(), pageNo,
				getCookieCount());
		updateType = "listSignin";
		return "listSignin";
	}

	public String signinView() {
		bean = articleMng.findById(id);
		return "signinView";
	}

	public String signin() {
		for (Article o : articleMng.signinArticle(ids, getCmsAdmin())) {
			log.info("ǩ��  ���� �ɹ�:{}", o.getTitle());
		}
		return listSignin();
	}

	public boolean validateAdd() {
		if (hasErrors()) {
			return true;
		}
		if (vldChannel(chnlId, true, null, getWebId())) {
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
		bean.setConfig(getConfig());
		// ��֤��Ŀ
		if (vldChannel(bean.getChannel().getId(), false, bean, getWebId())) {
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
		if (vldArticleRight(id)) {
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
		if (vldArticleRight(bean.getId())) {
			return true;
		}
		// ��֤��Ŀ
		Article entity = articleMng.findById(bean.getId());
		Long webId = entity.getWebsite().getId();
		if (vldChannel(bean.getChannel().getId(), false, null, webId)) {
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
		if (vldBatch()) {
			return true;
		}
		for (Long id : ids) {
			if (vldArticleRight(id)) {
				return true;
			}
		}
		return false;
	}

	public boolean validateDisable() {
		return validateDelete();
	}

	public boolean validateUndisable() {
		return validateDelete();
	}

	public boolean validatePass() {
		return validateDelete();
	}

	public boolean validateReject() {
		return validateDelete();
	}

	public boolean validateCheckView() {
		return validateEdit();
	}

	public boolean validateSigninView() {
		return validateEdit();
	}

	public boolean validateSignin() {
		return validateDelete();
	}

	/**
	 * ��֤�����޸�Ȩ��
	 *
	 * @param entity
	 * @return
	 */
	private boolean vldArticleRight(Long id) {
		Article entity = articleMng.findById(id);
		if (entity == null) {
			addActionError("�����²����ڣ�" + id);
			return true;
		}
		CmsAdmin webAdmin = cmsAdminMng.getAdminByUserId(entity.getWebsite()
				.getId(), getUserId());
		// ֻ�ܹ����Լ�����ݵĹ���Ա�����ܹ���������ݡ�
		CmsAdmin inputAdmin = entity.getAdminInput();
		if (inputAdmin != null && getCmsAdmin().getSelfOnly()
				&& !webAdmin.equals(inputAdmin)) {
			addActionError("����ά���������Լ�����ݣ�" + id);
			return true;
		}
		// ֻ�ܹ�����Ȩ�޵���Ŀ������
		if (webAdmin == null
				|| !entity.getChannel().getAdmins().contains(webAdmin)) {
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
			uploadRule = new UploadRule(getWeb().getUploadRoot().toString(),
					Article.UPLOAD_PATH, true);
			// addActionError("û���ҵ��ϴ����򣬲������ύ");
			// return true;
		}
		return false;
	}

	private boolean vldChannel(Long chnlId, boolean allowLeaf, Article bean,
			Long webId) {
		CmsChannel c = cmsChannelMng.findById(chnlId);
		if (c == null) {
			addActionError("����Ŀ�����ڣ�" + chnlId);
			return true;
		}
		if (!c.getHasChild()) {
			addActionError("����Ŀ�����������ݣ�" + c.getName());
			return true;
		}
		if (!allowLeaf && (!c.isTreeLeaf() || c.getParent() == null)) {
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

	private boolean vldContentCtg(Long ctgId, Article bean) {
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

	private boolean vldMemberGroup(CmsMemberGroup group, Article bean,
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

	/**
	 * ����bean
	 *
	 * @return
	 */
	private boolean vldBean() {
		// ��֤������������¡��մ����ԣ�������֮�䲻�ܿմ�
		String relatedIds = bean.getRelatedIds();
		if (!StringUtils.isBlank(relatedIds)) {
			relatedIds = BCConvert.qj2bj(relatedIds);
			relatedIds = StringUtils.remove(relatedIds, ' ');
			String[] rids = StringUtils.split(relatedIds, ',');
			for (String id : rids) {
				if (StringUtils.isBlank(id) || !StringUtils.isNumeric(id)) {
					addActionError("����������벻�Ϸ���" + relatedIds);
					return true;
				}
			}
			bean.setRelatedIds(relatedIds);
		}
		if (!HtmlChecker.check(bean.getContent())) {
			addActionError("���ݲ��ܰ�������");
			return true;
		}
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
				Article.UPLOAD_PATH, true);
		uploadRuleId = rule.hashCode();
		contextPvd.setSessionAttr(UploadRule.KEY + uploadRuleId, rule);
	}

	private void removeUploadRule() {
		uploadRule.clearUploadFile();
		contextPvd.removeAttribute(UploadRule.KEY + uploadRuleId);
	}

	@Autowired
	private ArticleMng articleMng;
	@Autowired
	private CmsChannelMng cmsChannelMng;
	@Autowired
	private ContentCtgMng contentCtgMng;
	@Autowired
	private CmsMemberGroupMng cmsMemberGroupMng;
	@Autowired
	private CmsAdminMng cmsAdminMng;
	@Autowired
	private ChnlModelMng chnlModelMng;
	private Article bean;
	private Map<String, ChnlModelItem> itemMap;
	private CmsChannel treeRoot;
	private Long chnlId;
	private CmsChannel chnl;
	private List<ContentCtg> contentCtgList;
	private List<CmsMemberGroup> memberGroupList;
	private List<CmsChannel> chnlList;
	private List<String> tplContentList;
	private List<CmsAdmin> adminList;

	private int uploadRuleId;
	private UploadRule uploadRule;

	private long topTime = 0;

	private boolean selfOnly = false;
	private boolean queryDisabled = false;
	private boolean queryTopTime = false;
	private int queryStatus = 0;
	private int queryOrder = 0;
	private int queryTopLevel = 0;
	private String queryTitle = "";
	private Long queryInputAdminId;
	private Long queryContentCtgId;
	/**
	 * ��ʶ���޸�����
	 */
	private String updateType;

	private String checkOpinion;

	public Article getBean() {
		return bean;
	}

	public void setBean(Article bean) {
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

	public List<CmsMemberGroup> getMemberGroupList() {
		return memberGroupList;
	}

	public void setMemberGroupList(List<CmsMemberGroup> memberGroupList) {
		this.memberGroupList = memberGroupList;
	}

	public List<ContentCtg> getContentCtgList() {
		return contentCtgList;
	}

	public void setContentCtgList(List<ContentCtg> contentCtgList) {
		this.contentCtgList = contentCtgList;
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

	public long getTopTime() {
		return topTime;
	}

	public void setTopTime(long topTime) {
		this.topTime = topTime;
	}

	public int getUploadRuleId() {
		return uploadRuleId;
	}

	public void setUploadRuleId(int uploadRuleId) {
		this.uploadRuleId = uploadRuleId;
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

	public boolean isSelfOnly() {
		return selfOnly;
	}

	public void setSelfOnly(boolean selfOnly) {
		this.selfOnly = selfOnly;
	}

	public List<CmsAdmin> getAdminList() {
		return adminList;
	}

	public void setAdminList(List<CmsAdmin> adminList) {
		this.adminList = adminList;
	}

	public boolean isQueryDisabled() {
		return queryDisabled;
	}

	public void setQueryDisabled(boolean queryDisabled) {
		this.queryDisabled = queryDisabled;
	}

	public boolean isQueryTopTime() {
		return queryTopTime;
	}

	public void setQueryTopTime(boolean queryTopTime) {
		this.queryTopTime = queryTopTime;
	}

	public Long getQueryInputAdminId() {
		return queryInputAdminId;
	}

	public void setQueryInputAdminId(Long queryInputAdminId) {
		this.queryInputAdminId = queryInputAdminId;
	}

	public Long getQueryContentCtgId() {
		return queryContentCtgId;
	}

	public void setQueryContentCtgId(Long queryContentCtgId) {
		this.queryContentCtgId = queryContentCtgId;
	}

	public String getCheckOpinion() {
		return checkOpinion;
	}

	public void setCheckOpinion(String checkOpinion) {
		this.checkOpinion = checkOpinion;
	}

	public String getUpdateType() {
		return updateType;
	}

	public void setUpdateType(String updateType) {
		this.updateType = updateType;
	}

	public Map<String, ChnlModelItem> getItemMap() {
		return itemMap;
	}

	public void setItemMap(Map<String, ChnlModelItem> itemMap) {
		this.itemMap = itemMap;
	}

	public int getQueryTopLevel() {
		return queryTopLevel;
	}

	public void setQueryTopLevel(int queryTopLevel) {
		this.queryTopLevel = queryTopLevel;
	}

}