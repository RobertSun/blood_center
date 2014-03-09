package com.jeecms.cms.manager;

import com.jeecms.cms.entity.CmsConfig;
import com.jeecms.core.JeeCoreManager;
import com.jeecms.core.entity.User;
import com.jeecms.core.entity.Website;

public interface CmsConfigMng extends JeeCoreManager<CmsConfig> {

	public void saveWebsite(Website currWeb, Website w, User user);
}