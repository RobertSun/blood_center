package com.jeecms.cms.action;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;

import com.jeecms.cms.entity.ChnlModel;
import com.jeecms.cms.entity.ChnlModelItem;
import com.jeecms.cms.entity.CmsAdmin;
import com.jeecms.cms.entity.CmsChannel;
import com.jeecms.cms.entity.CmsMemberGroup;
import com.jeecms.cms.manager.ChnlModelMng;
import com.jeecms.cms.manager.CmsChannelMng;
import com.jeecms.cms.manager.CmsMemberGroupMng;
import com.jeecms.common.util.SelectTreeUtils;
import com.jeecms.core.util.UploadRule;

@SuppressWarnings({ "serial", "unchecked" })
public abstract class CmsChannelAct extends com.jeecms.cms.CmsSysAction {
	private static final Logger log = LoggerFactory
			.getLogger(CmsChannelAct.class);

	public String left() {
		// ��
		treeRoot = new CmsChannel();
		treeRoot.setName("��Ŀ¼");
		treeRoot.setTreeLeaf(false);
		ChnlModel model = new ChnlModel();
		model.setShortName("");
		treeRoot.setModel(model);
		// ���ݡ�ȡ�����б?�ҳ����˵���
		Set<CmsChannel> chnlSet = new LinkedHashSet<CmsChannel>();
		CmsChannel chnl = cmsChannelMng.getRoot(getWebId(), getSysType());
		if (chnl != null) {
			chnlSet.add(chnl);
		}
		treeRoot.setTreeChild(chnlSet);
		return LEFT;
	}

	@SuppressWarnings("unchecked")
	public String list() {
		if (pid == null) {
			// �г�����Ŀ
			list = new ArrayList<CmsChannel>();
			CmsChannel c = cmsChannelMng.getRoot(getWebId(), getSysType());
			if (c != null) {
				list.add(c);
			}
			// ����ҳ�����������ҳ
			hasChild = list.size() > 0 ? false : true;
		} else {
			// �г�����Ŀ������Ŀ
			CmsChannel c = cmsChannelMng.findById(pid);
			// ��Ŀ���������Ȩ�ޣ�ֻ���Ʋ���Ȩ��
			this.list = new ArrayList<CmsChannel>(c.getChild());
			hasChild = c.getHasChild();
		}
		// ͬһϵ����վ����ģ��
		models = chnlModelMng.getModels(getRootWebId(), getSysType(), false);
		return LIST;
	}

	public String add() {
		model = chnlModelMng.findById(modelId);
		itemMap = model.getDiplayItemMap(ChnlModel.CHANNEL_ITEM);
		if (pid != null) {
			parent = cmsChannelMng.findById(pid);
		}
		handleParentRight(parent);
		String root = contextPvd.getAppRoot();
		tplChannlList = model.tplChannlList(getConfig(), getSysType(), root);
		tplContentList = model.tplContentList(getConfig(), getSysType(), root);
		// �����ϴ�����
		addUploadRule();
		return ADD;
	}

	@SuppressWarnings("unchecked")
	public String edit() {
		bean = cmsChannelMng.findById(id);
		model = bean.getModel();
		itemMap = model.getDiplayItemMap(ChnlModel.CHANNEL_ITEM);

		hasChild = model.getHasChild();
		if (hasChild) {
			models = chnlModelMng
					.getModels(getRootWebId(), getSysType(), false);
		}

		handleParentRight(bean.getParent());

		String root = contextPvd.getAppRoot();
		tplChannlList = model.tplChannlList(getConfig(), getSysType(), root);
		String indexTpl = bean.getTplIndex();
		// ��ǰģ�岻��Ĭ�Ϸ����С�
		if (!StringUtils.isBlank(indexTpl) && !tplChannlList.contains(indexTpl)) {
			tplChannlList.add(indexTpl);
		}
		tplContentList = model.tplContentList(getConfig(), getSysType(), root);
		String contentTpl = bean.getTplContent();
		// ��ǰģ�岻��Ĭ�Ϸ����С�
		if (!StringUtils.isBlank(contentTpl)
				&& !tplContentList.contains(contentTpl)) {
			tplContentList.add(contentTpl);
		}
		chnlList = cmsChannelMng.getChnlsAndExclude(getWebId(), getSysType(),
				bean.getId());
		chnlList = SelectTreeUtils.handleTreeChild(chnlList);
		chnlList = SelectTreeUtils.webTree(chnlList);
		// �����ϴ�����
		addUploadRule();
		return EDIT;
	}

	public String save() {
		// ��������Ŀ���Ȩ��
		bean.setSysType(getSysType());
		cmsChannelMng.saveChannel(bean, getCmsAdmin(), filterAdmins(admins),
				uploadRule);
		// ����ϴ�����
		removeUploadRule();
		log.info("��� ��Ŀ �ɹ�:{}", bean.getName());
		return list();
	}

	public String update() {
		bean = cmsChannelMng.updateChannel(bean, getCmsAdmin(),
				filterAdmins(admins), uploadRule);
		// ����ϴ�����
		removeUploadRule();
		log.info("�޸� ��Ŀ �ɹ�:{}", bean.getName());
		return list();
	}

	public String delete() {
		try {
			if (id != null) {
				bean = cmsChannelMng.deleteById(id);
				log.info("ɾ�� ��Ŀ �ɹ�:{}", bean.getName());
			} else {
				for (CmsChannel b : cmsChannelMng.deleteById(ids)) {
					log.info("ɾ�� ��Ŀ �ɹ�:{}", b.getName());
				}
			}
		} catch (DataIntegrityViolationException e) {
			addActionError("��¼�ѱ����á�����ɾ���ĵ�����ɾ����Ŀ");
			return SHOW_ERROR;
		}
		return list();
	}

	public String priorityUpdate() {
		for (int i = 0; i < wids.length; i++) {
			CmsChannel f = cmsChannelMng.findById(wids[i]);
			f.setPriority(prioritys[i]);
			cmsChannelMng.update(f);
		}
		return list();
	}

	public String checkPath() {
		if (bean == null) {
			return renderText("false");
		}
		String path = bean.getPath();
		if (StringUtils.isBlank(path)) {
			return renderText("false");
		}
		if (path.equals(origPath)) {
			return renderText("true");
		}
		if (cmsChannelMng.getByPath(getWebId(), path) == null) {
			return renderText("true");
		}
		return renderText("false");
	}

	public boolean validateList() {
		if (hasErrors()) {
			return true;
		}
		if (pid != null) {
			if (vldParendRight(pid, null)) {
				return true;
			}
		}
		return false;
	}

	public boolean validateAdd() {
		if (hasErrors()) {
			return true;
		}
		if (pid != null) {
			// ��鸸�ڵ��Ƿ�Ϸ�
			if (vldParendRight(pid, null)) {
				return true;
			}
		} else {
			// ����Ƿ��Ѿ��и�ڵ�
			if (vldMultiRootChnl()) {
				return true;
			}
		}
		vldModel(modelId, null);
		return false;
	}

	public boolean validateSave() {
		if (hasErrors()) {
			return true;
		}
		vldBean(bean);
		// ��֤�ϴ�����
		if (vldUploadRule()) {
			return true;
		}
		bean.setWebsite(getWeb());
		bean.setConfig(getConfig());
		if (pid != null) {
			// ��鸸�ڵ��Ƿ�Ϸ�
			if (vldParendRight(pid, bean)) {
				return true;
			}
		} else {
			// ����Ƿ��Ѿ��и�ڵ�
			if (vldMultiRootChnl()) {
				return true;
			}
			bean.setParent(null);
		}
		if (vldModel(bean.getModel().getId(), bean)) {
			return true;
		}
		if (vldGroupContribute(bean.getGroupContribute(), bean, true)) {
			return true;
		}
		if (vldGroupVisit(bean.getGroupVisit(), bean, true)) {
			return true;
		}
		return false;
	}

	public boolean validateEdit() {
		if (hasErrors()) {
			return true;
		}
		if (vldExist(id)) {
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
		vldBean(bean);
		// ��֤�ϴ�����
		if (vldUploadRule()) {
			return true;
		}
		if (vldExist(bean.getId())) {
			return true;
		}
		if (vldWebsite(bean.getId(), bean)) {
			return true;
		}
		if (vldModel(bean.getModel().getId(), null)) {
			return true;
		}
		if (vldGroupContribute(bean.getGroupContribute(), bean, false)) {
			return true;
		}
		if (vldGroupVisit(bean.getGroupVisit(), bean, false)) {
			return true;
		}
		// ��鸸��Ŀ
		CmsChannel parent = bean.getParent();
		// �޸ĸ���Ŀ
		if (parent != null) {
			Long pid = parent.getId();
			if (pid == null) {
				addActionError("�������óɸ���Ŀ");
				return true;
			}
			if (pid.equals(bean.getId())) {
				addActionError("���ܰ��Լ����ó��Լ��ĸ���Ŀ");
				return true;
			}
			// ����Ƿ�Ϊ�Լ�������Ŀ
			if (cmsChannelMng.isChild(bean.getId(), pid)) {
				addActionError("���ܰ�����Ŀ���óɸ���Ŀ");
				return true;
			}
			// ��鸸�ڵ��Ƿ�Ϸ�
			if (vldParendRight(pid, null)) {
				return true;
			}
		}
		return false;
	}

	public boolean validateDelete() {
		if (hasErrors()) {
			return true;
		}
		CmsChannel po;
		if (id == null && (ids == null || ids.length <= 0)) {
			addActionError("ID����Ϊ��");
			return true;
		} else {
			if (id != null) {
				ids = new Long[] { id };
			}
			for (Long id : ids) {
				po = cmsChannelMng.findById(id);
				if (!po.getWebsite().getId().equals(getWebId())) {
					addActionError("����ɾ������վ������");
					return true;
				}
				Set<CmsChannel> child = po.getChild();
				if (child != null && child.size() > 0) {
					addActionError("����ɾ���ӽڵ�");
					return true;
				}
			}
		}
		return false;
	}

	private boolean vldMultiRootChnl() {
		CmsChannel c = cmsChannelMng.getRoot(getWebId(), getSysType());
		if (c != null) {
			addActionError("�Ѿ����ڸ���Ŀ������Ŀ����Ϊ��");
			return true;
		}
		return false;
	}

	private boolean vldParendRight(Long pid, CmsChannel bean) {
		CmsChannel c = cmsChannelMng.findById(pid);
		if (c == null) {
			addActionError("����Ŀ�����ڣ�" + pid);
			return true;
		}
		if (!getWebId().equals(c.getWebsite().getId())) {
			addActionError("���ܷ�������վ�����Ŀ��" + pid);
			return true;
		}
		if (!getSysType().equals(c.getSysType())) {
			addActionError("���Ǳ�ϵͳ����Ŀ��" + pid);
			return true;
		}
		if (!c.getHasChild()) {
			addActionError("����Ŀ����ӵ������Ŀ��" + pid);
			return true;
		}
		if (bean != null) {
			bean.setParent(c);
		}
		return false;
	}

	private boolean vldModel(Long modelId, CmsChannel bean) {
		ChnlModel model = chnlModelMng.findById(modelId);
		if (model == null) {
			addActionError("ģ�Ͳ����ڣ�" + modelId);
			return true;
		}
		if (!model.getWebsite().getId().equals(getRootWebId())) {
			addActionError("���Ǳ�ϵ����վ��ģ�ͣ�" + modelId);
			return true;
		}
		if (bean != null) {
			bean.setModel(model);
		}
		return false;
	}

	private boolean vldGroupVisit(CmsMemberGroup group, CmsChannel bean,
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
			if (!po.getWebsite().getId().equals(getRootWebId())) {
				addActionError("���Ǳ�ϵ����վ�Ļ�Ա�飺" + id);
				return true;
			}
			if (bean != null) {
				bean.setGroupVisit(po);
			}
		} else {
			if (onSave) {
				bean.setGroupVisit(null);
			}
		}
		return false;
	}

	private boolean vldGroupContribute(CmsMemberGroup group, CmsChannel bean,
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
			if (!po.getWebsite().getId().equals(getRootWebId())) {
				addActionError("���Ǳ�ϵ����վ�Ļ�Ա�飺" + id);
				return true;
			}
			if (bean != null) {
				bean.setGroupContribute(po);
			}
		} else {
			if (onSave) {
				bean.setGroupContribute(null);
			}
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

	private boolean vldWebsite(Long id, CmsChannel bean) {
		CmsChannel entity = cmsChannelMng.findById(id);
		if (!entity.getWebsite().getId().equals(getWebId())) {
			addActionError("ֻ���޸ı�վ����ݣ�" + id);
			return true;
		}
		if (bean != null) {
			bean.setWebsite(getWeb());
		}
		return false;
	}

	private boolean vldExist(Long id) {
		CmsChannel entity = cmsChannelMng.findById(id);
		if (entity == null) {
			addActionError("��ݲ����ڣ�" + id);
			return true;
		}
		return false;
	}

	private List<CmsAdmin> filterAdmins(List<CmsAdmin> admins) {
		List<CmsAdmin> plist = new ArrayList<CmsAdmin>();
		if (admins == null || admins.size() <= 0) {
			return plist;
		}
		Long id;
		CmsAdmin po;
		for (int i = 0; i < admins.size(); i++) {
			id = admins.get(i).getId();
			if (id == null) {
				continue;
			}
			po = cmsAdminMng.findById(id);
			if (po == null) {
				continue;
			}
			if (!po.getWebsite().getId().equals(getWebId())) {
				continue;
			}
			plist.add(po);
		}
		return plist;
	}

	private boolean vldBean(CmsChannel bean) {
		bean.setAdmins(null);
		bean.setSysType(getSysType());
		return false;
	}

	private void addUploadRule() {
		UploadRule rule = new UploadRule(getWeb().getUploadRoot().toString(),
				CmsChannel.UPLOAD_PATH, true);
		uploadRuleId = rule.hashCode();
		contextPvd.setSessionAttr(UploadRule.KEY + uploadRuleId, rule);
	}

	private void removeUploadRule() {
		// ɾ��δ��ʹ�õ�ͼƬ
		//uploadRule.clearUploadFile();
		// ����ϴ�����
		contextPvd.removeAttribute(UploadRule.KEY + uploadRuleId);
	}

	private void handleParentRight(CmsChannel parent) {
		// ���Ȩ��
		int visitLevel = Integer.MIN_VALUE;
		// Ͷ��Ȩ��
		int contriLevel = Integer.MIN_VALUE;
		if (parent != null) {
			CmsMemberGroup group = parent.getGroupVisit();
			if (group != null) {
				visitLevel = group.getLevel();
			}
			group = parent.getGroupContribute();
			if (group != null) {
				contriLevel = group.getLevel();
			} else {
				contriLevel = Integer.MAX_VALUE;
			}
			// ����Ȩ��
			admins = new ArrayList<CmsAdmin>(parent.getAdmins());
		} else {
			admins = cmsAdminMng.getList(getWebId());
		}
		groupVisitList = cmsMemberGroupMng.getList(getRootWebId(), visitLevel,
				true);
		groupContributeList = cmsMemberGroupMng.getList(getRootWebId(),
				contriLevel, true);
	}

	protected abstract String getSysType();

	@Autowired
	private CmsChannelMng cmsChannelMng;
	@Autowired
	private ChnlModelMng chnlModelMng;
	@Autowired
	private CmsMemberGroupMng cmsMemberGroupMng;

	private CmsChannel bean;
	private CmsChannel parent;
	private CmsChannel treeRoot;
	private Long pid;
	private List<ChnlModel> models;
	private List<String> tplChannlList;
	private List<String> tplContentList;
	private List<CmsMemberGroup> groupVisitList;
	private List<CmsMemberGroup> groupContributeList;
	private List<CmsChannel> chnlList;
	private List<CmsAdmin> admins;
	private ChnlModel model;
	private Long modelId;
	private Map<String, ChnlModelItem> itemMap;
	private boolean hasChild;

	private Long[] wids;
	private int[] prioritys;

	private UploadRule uploadRule;
	private int uploadRuleId;

	private String origPath;

	public CmsChannel getBean() {
		return bean;
	}

	public void setBean(CmsChannel bean) {
		this.bean = bean;
	}

	public CmsChannel getTreeRoot() {
		return treeRoot;
	}

	public void setTreeRoot(CmsChannel treeRoot) {
		this.treeRoot = treeRoot;
	}

	public Long getPid() {
		return pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}

	public Long[] getWids() {
		return wids;
	}

	public void setWids(Long[] wids) {
		this.wids = wids;
	}

	public int[] getPrioritys() {
		return prioritys;
	}

	public void setPrioritys(int[] prioritys) {
		this.prioritys = prioritys;
	}

	public List<ChnlModel> getModels() {
		return models;
	}

	public void setModels(List<ChnlModel> models) {
		this.models = models;
	}

	public ChnlModel getModel() {
		return model;
	}

	public void setModel(ChnlModel model) {
		this.model = model;
	}

	public Long getModelId() {
		return modelId;
	}

	public void setModelId(Long modelId) {
		this.modelId = modelId;
	}

	public Map<String, ChnlModelItem> getItemMap() {
		return itemMap;
	}

	public void setItemMap(Map<String, ChnlModelItem> itemMap) {
		this.itemMap = itemMap;
	}

	public boolean isHasChild() {
		return hasChild;
	}

	public void setHasChild(boolean hasChild) {
		this.hasChild = hasChild;
	}

	public CmsChannel getParent() {
		return parent;
	}

	public void setParent(CmsChannel parent) {
		this.parent = parent;
	}

	public List<String> getTplChannlList() {
		return tplChannlList;
	}

	public void setTplChannlList(List<String> tplChannlList) {
		this.tplChannlList = tplChannlList;
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

	public UploadRule getUploadRule() {
		return uploadRule;
	}

	public void setUploadRule(UploadRule uploadRule) {
		this.uploadRule = uploadRule;
	}

	public List<CmsMemberGroup> getGroupVisitList() {
		return groupVisitList;
	}

	public void setGroupVisitList(List<CmsMemberGroup> groupVisitList) {
		this.groupVisitList = groupVisitList;
	}

	public List<CmsMemberGroup> getGroupContributeList() {
		return groupContributeList;
	}

	public void setGroupContributeList(List<CmsMemberGroup> groupContributeList) {
		this.groupContributeList = groupContributeList;
	}

	public List<CmsAdmin> getAdmins() {
		return admins;
	}

	public void setAdmins(List<CmsAdmin> admins) {
		this.admins = admins;
	}

	public List<CmsChannel> getChnlList() {
		return chnlList;
	}

	public void setChnlList(List<CmsChannel> chnlList) {
		this.chnlList = chnlList;
	}

	public String getOrigPath() {
		return origPath;
	}

	public void setOrigPath(String origPath) {
		this.origPath = origPath;
	}
}
