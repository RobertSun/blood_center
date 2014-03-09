package com.jeecms.auxiliary.action.front;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.jeecms.auxiliary.AuxiPartAction;
import com.jeecms.auxiliary.manager.MsgCtgMng;
import com.jeecms.auxiliary.manager.MsgMng;

/**
 * 留言板标签类
 * 
 * @author liufang
 * 
 */
@Scope("prototype")
@Controller("auxiliary.msgPartAct")
public class MsgPartAct extends AuxiPartAction {
	/**
	 * 留言列表
	 * 
	 * @return
	 */
	public String msgList() {
		pagination = msgMng.getForTag(getWebId(), ctgId, recommend == 1 ? true
				: false, getConfig().getMsgNeedCheck(), orderBy, "1"
				.equals(isPage) ? true : false, firstResult, pageNo, count);
		return handleResult("MsgList");
	}

	/**
	 * 留言列表Inner
	 * 
	 * @return
	 */
	public String msgListInner() {
		pagination = msgMng.getForTag(getWebId(), ctgId, recommend == 1 ? true
				: false, getConfig().getMsgNeedCheck(), orderBy, "1"
				.equals(isPage) ? true : false, firstResult, pageNo, count);
		contextPvd.setRequestAttr(INNER_PAGE, pagination);
		return SUCCESS;
	}

	/**
	 * 留言类别列表
	 * 
	 * @return
	 */
	public String msgCtgListInner() {
		list = msgCtgMng.findAll();
		contextPvd.setRequestAttr(INNER_LIST, list);
		return SUCCESS;
	}

	@Autowired
	private MsgMng msgMng;
	@Autowired
	private MsgCtgMng msgCtgMng;
	private Long ctgId;
	private int recommend;

	public int getRecommend() {
		return recommend;
	}

	public void setRecommend(int recommend) {
		this.recommend = recommend;
	}

	public Long getCtgId() {
		return ctgId;
	}

	public void setCtgId(Long ctgId) {
		this.ctgId = ctgId;
	}
}
