package com.jeecms.core.manager.impl;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jeecms.core.manager.TemplateMng;

@Service
public class TemplateMngImpl implements TemplateMng {
	private List<String> getTpls(String sysType, final String prefix) {
		// String path = resPathPvd.getWebInnerReal() + SPT + sysType + SPT;
		// String solution = websitePvd.getTplCfg().getSolution(sysType);
		String path = null;
		String solution = null;
		path += solution;
		File baseFile = new File(path);
		String[] names = baseFile.list(new FilenameFilter() {

			public boolean accept(File dir, String name) {
				if (name.startsWith(prefix)) {
					return true;
				} else {
					return false;
				}
			}
		});
		String ftlBase = "/" + sysType + "/" + solution + "/";
		List<String> nameList = new ArrayList<String>();
		for (String name : names) {
			nameList.add(ftlBase + name);
		}
		return nameList;
	}

	public List<String> getIndexTpls(String sysType) {
		return getTpls(sysType, TPL_DEF_INDEX);
	}

	public List<String> getChannelTpls(String sysType) {
		return getTpls(sysType, TPL_DEF_CHANNEL);
	}

	public List<String> getContentTpls(String sysType) {
		return getTpls(sysType, TPL_DEF_CONTENT);
	}

	public List<String> getTopicTpls(String sysType) {
		return getTpls(sysType, TPL_DEF_TOPIC);
	}

	public List<String> getAloneTpls(String sysType) {
		return getTpls(sysType, TPL_DEF_ALONE);
	}
}
