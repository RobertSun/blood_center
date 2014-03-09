package com.jeecms.core.manager;

import java.util.List;

public interface TemplateMng {
	public static final String TPL_DEF_SOLUTION = "default";
	public static final String TPL_DEF_INDEX = "index";
	public static final String TPL_DEF_CHANNEL = "channel";
	public static final String TPL_DEF_TOPIC = "topic";
	public static final String TPL_DEF_CONTENT = "content";
	public static final String TPL_DEF_ALONE = "alone";
	public static final String TPL_SUFFIX = ".html";

	public List<String> getIndexTpls(String sysType);

	public List<String> getChannelTpls(String sysType);

	public List<String> getContentTpls(String sysType);

	public List<String> getTopicTpls(String sysType);

	public List<String> getAloneTpls(String sysType);
}
