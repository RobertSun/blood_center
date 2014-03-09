package com.jeecms.download.action;

import static com.jeecms.cms.Constants.DOWNLOAD_SYS;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@SuppressWarnings({ "serial", "unchecked" })
@Scope("prototype")
@Controller("download.channelAct")
public class ChannelAct extends com.jeecms.cms.action.CmsChannelAct {
	@Override
	protected String getSysType() {
		return DOWNLOAD_SYS;
	}
}
