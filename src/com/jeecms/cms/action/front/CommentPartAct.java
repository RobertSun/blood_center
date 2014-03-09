package com.jeecms.cms.action.front;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.jeecms.cms.CmsPartAction;
import com.jeecms.cms.Constants;
import com.jeecms.cms.entity.CmsComment;
import com.jeecms.cms.manager.CmsCommentMng;
import com.jeecms.common.page.Pagination;

@Scope("prototype")
@Controller("cms.commentPartAct")
public class CommentPartAct extends CmsPartAction {
	public String commentList() {
		pagination = getCommentForTag();
		return handleResult("CommentList");
	}

	public String commentListInner() {
		pagination = getCommentForTag();
		contextPvd.setRequestAttr(INNER_PAGE, pagination);
		return SUCCESS;
	}

	private Pagination getCommentForTag() {
		int pOrderBy;
		if (orderBy == -1) {
			pOrderBy = getConfig().getCommentOderBy();
		} else {
			pOrderBy = orderBy;
		}
		Boolean pCheck;
		if ("2".equals(check)) {
			if (getConfig().getCommentNeedCheck()) {
				pCheck = true;
			} else {
				pCheck = null;
			}
		} else {
			pCheck = cb(check);
		}
		String pType = CmsComment.getDocType(docType);
		return cmsCommentMng.getCommentForTag(docId, pType, pCheck,
				cb(recommend), false, cbs(rcmFirst), pOrderBy, isSplitPage(),
				firstResult, pageNo, checkPageSize());
	}

	@Autowired
	private CmsCommentMng cmsCommentMng;

	private Long docId;
	private String docType;
	private String check;
	private String recommend;
	private String rcmFirst;

	@Override
	public String getSysType() {
		return Constants.COMMON_SYS;
	}

	public Long getDocId() {
		return docId;
	}

	public void setDocId(Long docId) {
		this.docId = docId;
	}

	public String getDocType() {
		return docType;
	}

	public void setDocType(String docType) {
		this.docType = docType;
	}

	public String getCheck() {
		return check;
	}

	public void setCheck(String check) {
		this.check = check;
	}

	public String getRecommend() {
		return recommend;
	}

	public void setRecommend(String recommend) {
		this.recommend = recommend;
	}

	public String getRcmFirst() {
		return rcmFirst;
	}

	public void setRcmFirst(String rcmFirst) {
		this.rcmFirst = rcmFirst;
	}
}
