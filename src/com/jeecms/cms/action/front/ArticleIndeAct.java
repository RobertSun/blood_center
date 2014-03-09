package com.jeecms.cms.action.front;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;

import com.jeecms.article.entity.Article;
import com.jeecms.article.manager.ArticleMng;
import com.jeecms.cms.CmsMemberAction;
import com.jeecms.cms.entity.CmsChannel;
import com.jeecms.cms.entity.CmsMember;
import com.jeecms.cms.entity.CmsMemberGroup;
import com.jeecms.cms.manager.CmsChannelMng;
import com.jeecms.common.page.Pagination;
import com.jeecms.common.util.HtmlChecker;
import com.jeecms.common.util.SelectTreeUtils;
import com.jeecms.core.util.UploadRule;
import com.octo.captcha.service.image.ImageCaptchaService;

/**
 * 文章投稿模板
 * 
 * @author liufang
 * 
 */
@Scope("prototype")
@Controller("cms.articleIndeAct")
public class ArticleIndeAct extends CmsMemberAction {
	private static final Logger log = LoggerFactory
			.getLogger(ArticleIndeAct.class);

	public String articleMain() {
		String result = checkLoginAndError();
		if (result != null) {
			return result;
		}
		pagination = articleMng.getArticleForMember(getMemberId(), null, null,
				null, null, pageNo, getCookieCount());
		return handleResult("ArticleMain");
	}

	public String articleChecked() {
		String result = checkLoginAndError();
		if (result != null) {
			return result;
		}
		pagination = articleMng.getArticleForMember(getMemberId(), null, null,
				true, null, pageNo, getCookieCount());
		return handleResult("ArticleChecked");
	}

	public String articleUnchecked() {
		String result = checkLoginAndError();
		if (result != null) {
			return result;
		}
		pagination = articleMng.getArticleForMember(getMemberId(), null, false,
				false, false, pageNo, getCookieCount());
		return handleResult("ArticleUnchecked");
	}

	public String articleReject() {
		String result = checkLoginAndError();
		if (result != null) {
			return result;
		}
		pagination = articleMng.getArticleForMember(getMemberId(), null, null,
				null, true, pageNo, getCookieCount());
		return handleResult("ArticleReject");
	}

	public String articleDraft() {
		String result = checkLoginAndError();
		if (result != null) {
			return result;
		}
		pagination = articleMng.getArticleForMember(getMemberId(), null, true,
				null, null, pageNo, getCookieCount());
		return handleResult("ArticleDraft");
	}

	@SuppressWarnings("unchecked")
	public String articleInput() {
		String result = checkLoginAndError();
		if (result != null) {
			return result;
		}
		chnlList = cmsChannelMng.getChnlsForMember(null, getCmsMember()
				.getGroup().getLevel());
		chnlList = SelectTreeUtils.handleTreeChild(chnlList);
		chnlList = SelectTreeUtils.webTree(chnlList);
		addUploadRule();
		return handleResult("ArticleInput");
	}

	public String articleSubmit() {
		String result = validateArticleSubmit();
		if (result != null) {
			return result;
		}
		bean = articleMng.memberSave(bean, getCmsMember(), uploadRule);
		removeUploadRule();
		log.info("会员投稿成功：{}", bean.getTitle());
		addActionMessage("投稿成功");
		return showSuccess();
	}

	@SuppressWarnings("unchecked")
	public String articleEdit() {
		String result = validateArticleEdit();
		if (result != null) {
			return result;
		}
		bean = articleMng.findById(id);
		chnlList = cmsChannelMng.getChnlsForMember(null, getCmsMember()
				.getGroup().getLevel());
		chnlList = SelectTreeUtils.handleTreeChild(chnlList);
		chnlList = SelectTreeUtils.webTree(chnlList);
		addUploadRule();
		return handleResult("ArticleEdit");
	}

	public String articleUpdate() {
		String result = validateArticleUpdate();
		if (result != null) {
			return result;
		}
		articleMng.memberUpdate(bean, getCmsMember(), uploadRule);
		log.info("会员修改稿件成功：{}", bean.getTitle());
		addActionMessage("修改稿件成功");
		return showSuccess();
	}

	public String articleDelete() {
		String result = validateArticleDelete();
		if (result != null) {
			return result;
		}
		try {
			for (Article o : articleMng.deleteById(ids)) {
				log.info("会员删除稿件成功:{}", o.getTitle());
			}
		} catch (DataIntegrityViolationException e) {
			addActionError("记录已被引用，不能删除!");
			return showError();
		}
		addActionMessage("删除稿件成功");
		return showSuccess();
	}

	private String validateArticleSubmit() {
		String result = checkLoginAndError();
		if (result != null) {
			return result;
		}
		if (!imageCaptchaService.validateResponseForID(contextPvd
				.getSessionId(false), checkCode)) {
			addActionError("验证码错误");
			return showError();
		}
		// 验证恶意代码
		if (!HtmlChecker.check(bean.getContent())) {
			addActionError("内容不能包含恶意代码");
			return showError();
		}
		// 验证上传规则
		if (vldUploadRule()) {
			return showError();
		}
		// 验证栏目权限
		if (vldChannel(bean.getChannel().getId(), bean)) {
			return showError();
		}
		return null;
	}

	private String validateArticleEdit() {
		String result = checkLoginAndError();
		if (result != null) {
			return result;
		}
		if (vldRight(id)) {
			return showError();
		}
		return null;
	}

	private String validateArticleUpdate() {
		String result = checkLoginAndError();
		if (result != null) {
			return result;
		}
		if (vldRight(bean.getId())) {
			return showError();
		}
		// 验证恶意代码
		if (!HtmlChecker.check(bean.getContent())) {
			addActionError("内容不能包含恶意代码");
			return showError();
		}
		// 验证上传规则
		if (vldUploadRule()) {
			return showError();
		}
		// 验证栏目权限
		if (vldChannel(bean.getChannel().getId(), bean)) {
			return showError();
		}
		return null;
	}

	private String validateArticleDelete() {
		String result = checkLoginAndError();
		if (result != null) {
			return result;
		}
		if (vldBatch()) {
			return showError();
		}
		for (Long id : ids) {
			if (vldRight(id)) {
				return showError();
			}
		}
		return null;
	}

	private boolean vldChannel(Long chnlId, Article bean) {
		CmsChannel c = cmsChannelMng.findById(chnlId);
		if (c == null) {
			addActionError("该栏目不存在：" + chnlId);
			return true;
		}
		if (!c.getHasChild()) {
			addActionError("该栏目不允许有内容：" + c.getName());
			return true;
		}
		if (!c.isTreeLeaf() || c.getParent() == null) {
			addActionError("只有末级栏目才能添加内容：" + c.getName());
			return true;
		}
		int level = getCmsMember().getGroup().getLevel();
		CmsMemberGroup group = c.getGroupContribute();
		if (group == null || group.getLevel() > level) {
			addActionError("您没有该栏目的权限：" + chnlId);
			return true;
		}
		if (bean != null) {
			bean.setChannel(c);
			bean.setWebsite(c.getWebsite());
		}
		return false;
	}

	private boolean vldUploadRule() {
		// 上传规则
		uploadRule = (UploadRule) contextPvd.getSessionAttr(UploadRule.KEY
				+ uploadRuleId);
		if (uploadRule == null) {
			addActionError("没有找到上传规则，不允许提交");
			return true;
		}
		return false;
	}

	private boolean vldRight(Long id) {
		Article entity = articleMng.findById(id);
		if (entity == null) {
			addActionError("数据不存在：" + id);
			return true;
		}
		if (!getCmsMember().equals(entity.getMember())) {
			addActionError("不能管理不属于自己的数据：" + id);
			return true;
		}
		if (entity.getCheck()) {
			addActionError("不能管理通过终审的数据：" + id);
			return true;
		}
		return false;
	}

	private boolean vldBatch() {
		if (id == null && (ids == null || ids.length <= 0)) {
			addActionError("ID不能为空");
			return true;
		} else {
			if (id != null) {
				ids = new Long[] { id };
			}
		}
		return false;
	}

	private void addUploadRule() {
		uploadRule = (UploadRule) contextPvd.getSessionAttr(UploadRule.KEY
				+ CmsMember.UPLOAD_KEY);
		if (uploadRule == null) {
			uploadRule = new UploadRule(getWeb().getUploadRoot().toString(),
					Article.UPLOAD_PATH, true);
			uploadRule.setAllowFileBrowsing(false);
			// 允许上传大小
			uploadRule.setAllowSize(getCmsMember().getGroup().getUploadSize());
			// 已经上传大小
			uploadRule.setUploadSize(getCmsMember().getUploadToday());
		}
		uploadRuleId = CmsMember.UPLOAD_KEY;
		contextPvd.setSessionAttr(UploadRule.KEY + uploadRuleId, uploadRule);
	}

	private void removeUploadRule() {
		// 删除未被使用的图片
		uploadRule.clearUploadFile();
	}

	@Autowired
	private ImageCaptchaService imageCaptchaService;
	private String checkCode;
	@Autowired
	private ArticleMng articleMng;
	@Autowired
	private CmsChannelMng cmsChannelMng;
	private List<CmsChannel> chnlList;
	private Article bean;
	private Pagination pagination;
	private Long id;
	private Long[] ids;

	private int uploadRuleId;
	private UploadRule uploadRule;

	public List<CmsChannel> getChnlList() {
		return chnlList;
	}

	public void setChnlList(List<CmsChannel> chnlList) {
		this.chnlList = chnlList;
	}

	public int getUploadRuleId() {
		return uploadRuleId;
	}

	public void setUploadRuleId(int uploadRuleId) {
		this.uploadRuleId = uploadRuleId;
	}

	public Article getBean() {
		return bean;
	}

	public void setBean(Article bean) {
		this.bean = bean;
	}

	public Pagination getPagination() {
		return pagination;
	}

	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}

	public String getCheckCode() {
		return checkCode;
	}

	public void setCheckCode(String checkCode) {
		this.checkCode = checkCode;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long[] getIds() {
		return ids;
	}

	public void setIds(Long[] ids) {
		this.ids = ids;
	}
}