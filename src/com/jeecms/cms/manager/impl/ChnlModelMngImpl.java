package com.jeecms.cms.manager.impl;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.jeecms.cms.dao.ChnlModelDao;
import com.jeecms.cms.entity.ChnlModel;
import com.jeecms.cms.entity.ChnlModelItem;
import com.jeecms.cms.manager.ChnlModelItemMng;
import com.jeecms.cms.manager.ChnlModelMng;
import com.jeecms.common.hibernate3.Condition;
import com.jeecms.common.hibernate3.OrderBy;
import com.jeecms.core.JeeCoreManagerImpl;
import com.jeecms.core.entity.Website;

@Service
@Transactional
public class ChnlModelMngImpl extends JeeCoreManagerImpl<ChnlModel> implements
		ChnlModelMng {

	public Long[] getHasChildIds(Long webId) {
		List<ChnlModel> list = getDao().getHasChild(webId);
		Long[] ids = null;
		if (list != null && list.size() > 0) {
			ids = new Long[list.size()];
			for (int i = 0; i < list.size(); i++) {
				ids[i] = list.get(i).getId();
			}
		}
		return ids;
	}

	public List<ChnlModel> getModels(Long webId, boolean all) {
		ChnlModel model = new ChnlModel();
		model.setWebsite(new Website(webId));
		if (!all) {
			model.setDisplay(true);
		}
		return findByEgList(model, new Condition[] { OrderBy
				.asc(ChnlModel.PROP_PRIORITY) });
	}

	public List<ChnlModel> getModels(Long webId, String sysType, boolean all) {
		Assert.hasText(sysType);
		List<ChnlModel> list = getModels(webId, all);
		ChnlModel model;
		String type;
		for (int i = 0; i < list.size(); i++) {
			model = list.get(i);
			type = model.getSysType();
			if (!StringUtils.isBlank(type) && !sysType.equals(type)) {
				list.remove(i);
				i--;
				continue;
			}
		}
		return list;
	}

	public ChnlModel updateModel(ChnlModel model, List<ChnlModelItem> modelItems) {
		ChnlModel pmodel = findById(model.getId());
		if (modelItems != null) {
			// 删除模型项
			Set<ChnlModelItem> origItems = pmodel.getItems();
			Set<ChnlModelItem> delItems = new HashSet<ChnlModelItem>();
			for (ChnlModelItem oitem : origItems) {
				boolean contain = false;
				for (ChnlModelItem item : modelItems) {
					if (item != null && item.getId().equals(oitem.getId())) {
						contain = true;
						break;
					}
				}
				if (!contain) {
					delItems.add(oitem);
				}
			}
			origItems.removeAll(delItems);
			// 更新模型项
			ChnlModelItem pitem;
			for (ChnlModelItem item : modelItems) {
				if (item == null) {
					continue;
				}
				pitem = chnlModelItemMng.findById(item.getId());
				// 不属于模型下的模型项不允许修改。
				if (pitem.getModel().getId().equals(pmodel.getId())) {
					// 布尔型为null即为false
					if (item.getChecked() == null) {
						item.setChecked(false);
					}
					// 不允许改变所属模型
					item.setModel(null);
					chnlModelItemMng.updateDefault(item);
				}
			}
		}
		updateDefault(model);
		return pmodel;
	}

	public ChnlModel save(ChnlModel model) {
		super.save(model);
		return model;
	}

	public ChnlModel findById(Serializable id) {
		ChnlModel model = super.findById(id);
		return model;
	}

	public ChnlModel deleteById(Serializable id) {
		ChnlModel model = super.deleteById(id);
		return model;
	}

	@Autowired
	private ChnlModelItemMng chnlModelItemMng;

	@Autowired
	public void setDao(ChnlModelDao dao) {
		super.setDao(dao);
	}

	public ChnlModelDao getDao() {
		return (ChnlModelDao) super.getDao();
	}

}
