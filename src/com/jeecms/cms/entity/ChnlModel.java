package com.jeecms.cms.entity;

import static com.jeecms.core.Constants.FILE_SPT;
import static com.jeecms.core.Constants.SPT;
import static com.jeecms.core.Constants.TPL_SUFFIX;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.lang.StringUtils;

import com.jeecms.cms.Constants;
import com.jeecms.cms.entity.base.BaseChnlModel;
import com.jeecms.core.entity.Website;
import com.jeecms.core.util.PriorityComparator;

public class ChnlModel extends BaseChnlModel {
	/**
	 * 栏目模型项
	 */
	public static final int CHANNEL_ITEM = 1;
	/**
	 * 内容模型项
	 */
	public static final int CONTENT_ITEM = 2;

	/**
	 * 获得模板列表
	 * 
	 * @param root
	 * @param prefix
	 * @return
	 */
	public static List<String> tplList(CmsConfig config, String sysType, String root,
			final String prefix) {
		String solution = config.getSolution(sysType);
		StringBuilder relPath = new StringBuilder();
		relPath.append(SPT).append(sysType).append(SPT).append(solution);
		String path = config.getWebsite().getTplRootReal(root).append(relPath)
				.toString().replace(SPT, FILE_SPT);
		File file = new File(path);
		String[] fns = file.list(new FilenameFilter() {
			public boolean accept(File dir, String name) {
				if (name.startsWith(prefix)) {
					return true;
				} else {
					return false;
				}
			}
		});
		List<String> result = new ArrayList<String>();
		relPath.append(SPT);
		if (fns != null) {
			for (String name : fns) {
				result.add(relPath + name);
			}
		}
		return result;
	}

	/**
	 * 栏目模板列表
	 * 
	 * @param root
	 * @return
	 */
	public List<String> tplChannlList(CmsConfig config, String sysType,
			String root) {
		String prefix = getTplPrefixChannel();
		if (StringUtils.isBlank(prefix)) {
			return new ArrayList<String>();
		} else {
			return tplList(config, sysType, root, prefix);
		}
	}

	/**
	 * 内容模板列表
	 * 
	 * @param root
	 * @return
	 */
	public List<String> tplContentList(CmsConfig config, String sysType,
			String root) {
		String prefix = getTplPrefixContent();
		if (StringUtils.isBlank(prefix)) {
			return new ArrayList<String>();
		} else {
			return tplList(config, sysType, root, prefix);
		}
	}

	/**
	 * 获得默认解决方案模板路径。/WEB-INF/user_base/RES_PATH/template/sysType/default/
	 * 
	 * @return
	 */
	private StringBuilder getTplDef(Website web, String sysType) {
		StringBuilder sb = web.getTplRoot();
		sb.append(SPT).append(sysType).append(SPT).append(
				web.getSolutions().get(sysType)).append(SPT);
		return sb;
	}

	/**
	 * 默认栏目页模板
	 * 
	 * @return
	 */
	public String defIndexTpl(Website web, String sysType) {
		return getTplDef(web, sysType).append(getTplPrefixChannel()).append(
				TPL_SUFFIX).toString();
	}

	/**
	 * 默认内容页模板
	 * 
	 * @return
	 */
	public String defContentTpl(Website web, String sysType) {
		return getTplDef(web, sysType).append(getTplPrefixContent()).append(
				TPL_SUFFIX).toString();
	}

	/**
	 * 表单名称为key，item为value。用于控制界面
	 * 
	 * @return
	 */
	public Map<String, ChnlModelItem> getDiplayItemMap(int itemType) {
		Set<ChnlModelItem> items = getItems(itemType);
		if (items != null) {
			Map<String, ChnlModelItem> itemMap = new LinkedHashMap<String, ChnlModelItem>();
			for (ChnlModelItem it : items) {
				if (it.getChecked()) {
					itemMap.put(it.getName(), it);
				}
			}
			return itemMap;
		} else {
			return null;
		}
	}

	public Set<ChnlModelItem> getItems(int type) {
		Set<ChnlModelItem> wholeItems = getItems();
		if (wholeItems == null) {
			return null;
		}
		Set<ChnlModelItem> items = new TreeSet<ChnlModelItem>(
				new PriorityComparator());
		for (ChnlModelItem item : wholeItems) {
			if (item.getItemType() == type) {
				items.add(item);
			}
		}
		return items;
	}

	public Set<ChnlModelItem> getChnlItems() {
		return getItems(CHANNEL_ITEM);
	}

	public Set<ChnlModelItem> getContentItems() {
		return getItems(CONTENT_ITEM);
	}

	public void addModelItem(ChnlModelItem item) {
		if (item == null) {
			return;
		}
		item.setModel(this);
		Set<ChnlModelItem> items = getItems();
		if (items == null) {
			items = new TreeSet<ChnlModelItem>(new PriorityComparator());
			setItems(items);
		}
		items.add(item);
	}

	public String getSysTypeName() {
		if (StringUtils.isBlank(getSysType())) {
			return "所有系统";
		}
		String name = Constants.CMSSYS_TYPES.get(getSysType());
		if (name == null) {
			name = getSysType();
		}
		return name;
	}

	private static final long serialVersionUID = 1L;

	/* [CONSTRUCTOR MARKER BEGIN] */
	public ChnlModel() {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public ChnlModel(java.lang.Long id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public ChnlModel(java.lang.Long id, com.jeecms.core.entity.Website website,
			java.lang.Integer priority, java.lang.Boolean display,
			java.lang.Boolean hasChild) {

		super(id, website, priority, display, hasChild);
	}

	/* [CONSTRUCTOR MARKER END] */

}