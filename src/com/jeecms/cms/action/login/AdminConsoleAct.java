package com.jeecms.cms.action.login;

import static com.jeecms.common.util.ComUtils.JSESSION_URL;

import java.util.List;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.jeecms.common.util.PwdEncoder;
import com.jeecms.core.JeeCoreAction;
import com.jeecms.core.entity.Website;

@SuppressWarnings("serial")
@Scope("prototype")
@Controller("cms.adminConsoleAct")
public class AdminConsoleAct extends JeeCoreAction {
	public String index() {
		// ��վ�����
		websiteList = websiteMng.getListByUserId(getUserId());
		sessionAppend = ";" + JSESSION_URL + "="
				+ contextPvd.getSessionId(false);
		return INDEX;
	}

	public String main() {
		return "main";
	}

	public String left() {
		return LEFT;
	}

	public String right() {
		if (pwdEncoder.isPasswordValid(getUser().getPassword(), "password")) {
			pwdWarn = true;
		}
		props = System.getProperties();
		Runtime runtime = Runtime.getRuntime();
		freeMemoery = runtime.freeMemory();
		totalMemory = runtime.totalMemory();
		usedMemory = totalMemory - freeMemoery;
		maxMemory = runtime.maxMemory();
		useableMemory = maxMemory - totalMemory + freeMemoery;
		return RIGHT;
	}

	@Autowired
	private PwdEncoder pwdEncoder;
	private String sessionAppend;
	private List<Website> websiteList;
	private Properties props;
	private long freeMemoery;
	private long totalMemory;
	private long maxMemory;
	private long usedMemory;
	private long useableMemory;
	private boolean pwdWarn = false;

	public String getSessionAppend() {
		return sessionAppend;
	}

	public void setSessionAppend(String sessionAppend) {
		this.sessionAppend = sessionAppend;
	}

	public List<Website> getWebsiteList() {
		return websiteList;
	}

	public void setWebsiteList(List<Website> websiteList) {
		this.websiteList = websiteList;
	}

	public Properties getProps() {
		return props;
	}

	public void setProps(Properties props) {
		this.props = props;
	}

	public long getFreeMemoery() {
		return freeMemoery;
	}

	public void setFreeMemoery(long freeMemoery) {
		this.freeMemoery = freeMemoery;
	}

	public long getTotalMemory() {
		return totalMemory;
	}

	public void setTotalMemory(long totalMemory) {
		this.totalMemory = totalMemory;
	}

	public boolean isPwdWarn() {
		return pwdWarn;
	}

	public void setPwdWarn(boolean pwdWarn) {
		this.pwdWarn = pwdWarn;
	}

	public long getMaxMemory() {
		return maxMemory;
	}

	public long getUseableMemory() {
		return useableMemory;
	}

	public long getUsedMemory() {
		return usedMemory;
	}

	public void setUsedMemory(long usedMemory) {
		this.usedMemory = usedMemory;
	}
}
