package com.jeecms.cms.action;

import static com.jeecms.cms.Constants.ARTICLE_SYS;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;

import com.jeecms.article.entity.Article;
import com.jeecms.cms.entity.ChnlModel;
import com.jeecms.cms.entity.CmsTopic;
import com.jeecms.cms.manager.CmsTopicMng;
import com.jeecms.common.hibernate3.OrderBy;
import com.jeecms.core.util.UploadRule;

@SuppressWarnings({ "serial", "unchecked" })
@Scope("prototype")
@Controller("cms.cmsTopicAct")
public class CmsTopicAct extends com.jeecms.cms.CmsSysAction {
	private static final Logger log = LoggerFactory
			.getLogger(CmsTopicAct.class);

	public String list() {
		this.pagination = cmsTopicMng.findAll(pageNo, getCookieCount(), OrderBy
				.asc("priority"), OrderBy.desc("id"));
		return LIST;
	}

	public String add() {
		tplList = ChnlModel.tplList(getConfig(), ARTICLE_SYS, contextPvd
				.getAppRoot(), "topic");
		// �����ϴ�����
		addUploadRule();
		return ADD;
	}

	public String save() {
		bean.setWebsite(getRootWeb());
		cmsTopicMng.saveTopic(bean, articleIds);
		log.info("���� ר�� �ɹ�:{}", bean.getName());
		return list();
	}

	public String edit() {
		this.bean = cmsTopicMng.findById(id);
		tplList = ChnlModel.tplList(getConfig(), ARTICLE_SYS, contextPvd
				.getAppRoot(), "topic");
		// �����ϴ�����
		addUploadRule();
		return EDIT;
	}

	public String update() {
		cmsTopicMng.updateTopic(bean, articleIds);
		log.info("�޸� ר�� �ɹ�:{}", bean.getName());
		return list();
	}

	public String delete() {
		try {
			for (CmsTopic o : cmsTopicMng.deleteById(ids)) {
				log.info("ɾ�� ר�� �ɹ�:{}", o.getName());
			}
		} catch (DataIntegrityViolationException e) {
			addActionError("ר�ⱻ���ã�����ɾ��!");
			log.info("ר�ⱻ���ã�����ɾ��:{}", bean.getName());
			return SHOW_ERROR;
		}
		return list();
	}

	public boolean validateSave() {
		if (hasErrors()) {
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
		return false;
	}

	public boolean validateUpdate() {
		if (hasErrors()) {
			return true;
		}
		if (vldExist(bean.getId())) {
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
			if (vldExist(id)) {
				return true;
			}
		}
		return false;
	}

	private boolean vldExist(Long id) {
		CmsTopic entity = cmsTopicMng.findById(id);
		if (entity == null) {
			addActionError("���ⲻ���ڣ�" + id);
			return true;
		}
		return false;
	}

	private void addUploadRule() {
		UploadRule rule = new UploadRule(getWeb().getUploadRoot().toString(),
				Article.UPLOAD_PATH, true, true, false);
		uploadRuleId = rule.hashCode();
		contextPvd.setSessionAttr(UploadRule.KEY + uploadRuleId, rule);
	}

	private CmsTopic bean;
	private int uploadRuleId;
	private String articleIds;
	private List<String> tplList;

	@Autowired
	private CmsTopicMng cmsTopicMng;

	public CmsTopic getBean() {
		return bean;
	}

	public void setBean(CmsTopic bean) {
		this.bean = bean;
	}

	public List<String> getTplList() {
		return tplList;
	}

	public void setTplList(List<String> tplList) {
		this.tplList = tplList;
	}

	public int getUploadRuleId() {
		return uploadRuleId;
	}

	public void setUploadRuleId(int uploadRuleId) {
		this.uploadRuleId = uploadRuleId;
	}

	public String getArticleIds() {
		return articleIds;
	}

	public void setArticleIds(String articleIds) {
		this.articleIds = articleIds;
	}

}