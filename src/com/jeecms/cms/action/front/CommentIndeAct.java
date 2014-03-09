package com.jeecms.cms.action.front;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.jeecms.article.entity.Article;
import com.jeecms.article.manager.ArticleMng;
import com.jeecms.cms.CmsIndeAction;
import com.jeecms.cms.entity.CmsComment;
import com.jeecms.cms.manager.CmsCommentMng;
import com.jeecms.common.page.Pagination;
import com.octo.captcha.service.image.ImageCaptchaService;

/**
 * ���۶���ģ��
 *
 * @author liufang
 *
 */
@SuppressWarnings("unchecked")
@Scope("prototype")
@Controller("cms.commentIndeAct")
public class CommentIndeAct extends CmsIndeAction {
	private static final Logger log = LoggerFactory
			.getLogger(CommentIndeAct.class);

	public String comment() {
		String err = validateCommentList();
		if (err != null) {
			return err;
		}
		doc = articleMng.findById(articleId);
		return handleResult("Comment");
	}

	public String commentSubmit() {
		String err = validateCommentSubmit();
		if (err != null) {
			jsonRoot.put("success", false);
			jsonRoot.put("msg", err);
			return SUCCESS;
		}
		cmsCommentMng.save(bean);
		String msg;
		if (getConfig().getCommentNeedCheck()) {
			msg = "���۷���ɹ�����ȴ����";
		} else {
			msg = "���۷���ɹ�";
		}
		jsonRoot.put("success", true);
		jsonRoot.put("msg", msg);
		log.info("���۳ɹ���{}", bean.getContentMember());
		return SUCCESS;
	}

	private String validateCommentList() {
		if (hasErrors()) {
			return showMessage();
		}
		Article entity = articleMng.findById(articleId);
		if (entity == null) {
			addActionError("���²����ڣ�" + articleId);
			return showMessage();
		}
		if (!entity.getAllowComment()) {
			addActionError("�����²��������ۣ�" + entity.getTitle());
			return showMessage();
		}
		return null;
	}

	private String validateCommentSubmit() {
		if (hasErrors()) {
			return "���벻�Ϸ�";
		}
		if (!imageCaptchaService.validateResponseForID(contextPvd
				.getSessionId(false), checkCode)) {
			return "��֤�����";
		}
		bean = preparedBean();
		String err;
		err = vldArticle(articleId, bean);
		if (err != null) {
			return err;
		}
		return null;
	}

	private String vldArticle(Long id, CmsComment bean) {
		Article entity = articleMng.findById(id);
		if (entity == null) {
			return "���۵����²����ڣ�" + id;
		}
		if (!entity.getAllowComment()) {
			return "���²��������ۣ�" + id;
		}
		if (getConfig().getCommentNeedLogin() && getMember() == null) {
			return "��Ҫ��¼��������";
		}
		if (bean != null) {
			bean.setDoc(entity);
			bean.setWebsite(entity.getWebsite());
			bean.setMember(getMember());
		}
		return null;
	}

	private CmsComment preparedBean() {
		CmsComment bean = new CmsComment();
		bean.setTitle(title);
		bean.setContentMember(content);
		return bean;
	}

	@Autowired
	private ImageCaptchaService imageCaptchaService;
	private String checkCode;
	@Autowired
	private ArticleMng articleMng;
	@Autowired
	private CmsCommentMng cmsCommentMng;
	private Map<String, Object> jsonRoot = new HashMap<String, Object>();

	private Pagination pagination;

	private String title;
	private String content;
	private Long articleId;

	private CmsComment bean;
	private Object doc;

	public String getCheckCode() {
		return checkCode;
	}

	public void setCheckCode(String checkCode) {
		this.checkCode = checkCode;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Long getArticleId() {
		return articleId;
	}

	public void setArticleId(Long articleId) {
		this.articleId = articleId;
	}

	public Map<String, Object> getJsonRoot() {
		return jsonRoot;
	}

	public void setJsonRoot(Map<String, Object> jsonRoot) {
		this.jsonRoot = jsonRoot;
	}

	public Pagination getPagination() {
		return pagination;
	}

	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}

	public Object getDoc() {
		return doc;
	}

	public void setDoc(Object doc) {
		this.doc = doc;
	}
}