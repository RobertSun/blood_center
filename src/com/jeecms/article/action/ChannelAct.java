package com.jeecms.article.action;

import static com.jeecms.cms.Constants.ARTICLE_SYS;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@SuppressWarnings({ "serial", "unchecked" })
@Scope("prototype")
@Controller("article.channelAct")
public class ChannelAct extends com.jeecms.cms.action.CmsChannelAct {
	@Override
	protected String getSysType() {
		return ARTICLE_SYS;
	}
}
