package com.jeecms.auxiliary.action;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;

import com.jeecms.auxiliary.entity.MsgCtg;
import com.jeecms.auxiliary.entity.VoteItem;
import com.jeecms.auxiliary.entity.VoteTopic;
import com.jeecms.auxiliary.manager.VoteTopicMng;
import com.jeecms.core.util.PriorityComparator;

@SuppressWarnings({ "serial", "unchecked" })
@Scope("prototype")
@Controller("auxiliary.voteTopicAct")
public class VoteTopicAct extends com.jeecms.auxiliary.AuxiSysAction {
	private static final Logger log = LoggerFactory
			.getLogger(VoteTopicAct.class);

	public String list() {
		this.pagination = voteTopicMng.getPage(getWebId(), pageNo,
				getCookieCount());
		return LIST;
	}

	public String add() {
		return ADD;
	}

	public String save() {
		bean.setItems(notEmptyItems());
		if (hasActionErrors()) {
			return add();
		}
		if (bean.getDisabled() == null) {
			bean.setDisabled(false);
		}
		if (bean.getCurrent() == null) {
			bean.setCurrent(false);
		}
		voteTopicMng.save(bean);
		addActionMessage("��ӳɹ�");
		return list();
	}

	public String edit() {
		this.bean = voteTopicMng.findById(id);
		return EDIT;
	}

	public String update() {
		Set<VoteItem> items = notEmptyItems();
		if (hasActionErrors()) {
			id = bean.getId();
			return edit();
		}
		if (bean.getDisabled() == null) {
			bean.setDisabled(false);
		}
		if (bean.getCurrent() == null) {
			bean.setCurrent(false);
		}
		voteTopicMng.updateTopic(bean, items);
		addActionMessage("�޸ĳɹ�");
		return list();
	}

	public String delete() {
		try {
			for (VoteTopic o : voteTopicMng.deleteById(ids)) {
				log.info("ɾ�� ������� �ɹ�:{}", o.getTitle());
			}
		} catch (DataIntegrityViolationException e) {
			addActionError("��¼�ѱ����ã�����ɾ��!");
			return SHOW_ERROR;
		}
		return list();
	}

	public boolean validateSave() {
		if (hasErrors()) {
			return true;
		}
		bean.setWebsite(getWeb());
		return false;
	}

	public boolean validateEdit() {
		if (hasErrors()) {
			return true;
		}
		if (vldExist(id)) {
			return true;
		}
		if (vldWebsite(id, null)) {
			return true;
		}
		return false;
	}

	public boolean validateUpdate() {
		if (hasErrors()) {
			return true;
		}
		if (vldExist(bean.getId())) {
			return true;
		}
		if (vldWebsite(bean.getId(), null)) {
			return true;
		}
		bean.setWebsite(getWeb());
		return false;
	}

	public boolean validateDelete() {
		if (hasErrors()) {
			return true;
		}
		if (vldBatch()) {
			return true;
		}
		for (Long id : ids) {
			if (vldExist(id)) {
				return true;
			}
			if (vldWebsite(id, null)) {
				return true;
			}
		}
		return false;
	}

	private boolean vldExist(Long id) {
		VoteTopic entity = voteTopicMng.findById(id);
		if (entity == null) {
			addActionError("��ݲ����ڣ�" + id);
			return true;
		}
		return false;
	}

	private boolean vldWebsite(Long id, MsgCtg bean) {
		VoteTopic entity = voteTopicMng.findById(id);
		if (!entity.getWebsite().equals(getWeb())) {
			addActionError("ֻ�ܹ��?վ����ݣ�" + id);
			return true;
		}
		if (bean != null) {
			bean.setWebsite(getWeb());
		}
		return false;
	}

	/**
	 * ȥ��name��idΪ�յĶ��󣬲���idΪ�յĶ��󷵻�
	 *
	 * @return
	 */
	private Set<VoteItem> notEmptyItems() {
		Set<VoteItem> items = new TreeSet<VoteItem>(new PriorityComparator());
		if (voteItems == null) {
			addActionError("ͶƱ���Ϊ�գ�");
		}
		// ȥ�����Ϊ�յ�ͶƱѡ��
		for (VoteItem it : voteItems) {
			if (it != null && !StringUtils.isBlank(it.getTitle())) {
				it.setTopic(bean);
				items.add(it);
			}
		}
		if (items.size() <= 0) {
			addActionError("ͶƱ���Ϊ�գ�");
		}
		return items;
	}

	@Autowired
	private VoteTopicMng voteTopicMng;
	private VoteTopic bean;
	private List<VoteItem> voteItems;

	public VoteTopic getBean() {
		return bean;
	}

	public void setBean(VoteTopic bean) {
		this.bean = bean;
	}

	public List<VoteItem> getVoteItems() {
		return voteItems;
	}

	public void setVoteItems(List<VoteItem> voteItems) {
		this.voteItems = voteItems;
	}
}