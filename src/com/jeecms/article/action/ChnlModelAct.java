package com.jeecms.article.action;

import static com.jeecms.cms.Constants.ARTICLE_SYS;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@SuppressWarnings("serial")
@Scope("prototype")
@Controller("article.chnlModelAct")
public class ChnlModelAct extends com.jeecms.cms.action.ChnlModelAct {
	public String getSysType() {
		return ARTICLE_SYS;
	}
}
