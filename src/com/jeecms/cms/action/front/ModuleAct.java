package com.jeecms.cms.action.front;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.jeecms.cms.CmsIndeAction;

@SuppressWarnings("unchecked")
@Scope("prototype")
@Controller("cms.moduleAct")
public class ModuleAct extends CmsIndeAction{

	private String btypef;
	private String btypem;
	private List<String> msgList;
	
	public List<String> getMsgList() {
		return msgList;
	}

	public void setMsgList(List<String> msgList) {
		this.msgList = msgList;
	}

	public String getBtypef() {
		return btypef;
	}

	public void setBtypef(String btypef) {
		this.btypef = btypef;
	}

	public String getBtypem() {
		return btypem;
	}

	public void setBtypem(String btypem) {
		this.btypem = btypem;
	}
	
	private static Map<String, String> posRstMap = new HashMap<String, String>(){
		private static final long serialVersionUID = -289973892697398335L;

		{
			put("O-O", "O");
			put("A-O", "A,O");
			put("A-A", "A,O");
			put("B-O","B,O");
			put("B-B","B,O");
			put("A-B","A,B,AB,O");
			put("AB-O","A,B");
			put("AB-B","A,B,AB");
			put("AB-A","A,B,AB");
			put("AB-AB","A,B,AB");
			
			put("O-A", "A,O");
			put("O-B","B,O");
			put("B-A","A,B,AB,O");
			put("O-AB","A,B");
			put("B-AB","A,B,AB");
			put("A-AB","A,B,AB");
		}
	};
	private static Map<String, String> imposRstMap = new HashMap<String, String>(){
		private static final long serialVersionUID = 79419052958115199L;

		{
			put("O-O", "A,B,AB");
			put("A-O", "B,AB");
			put("A-A", "B,AB");
			put("B-O","A,AB");
			put("B-B","A,AB");
			put("A-B","无");
			put("AB-O","O,AB");
			put("AB-B","O");
			put("AB-A","O");
			put("AB-AB","O");
			
			put("O-O", "A,B,AB");
			put("O-A", "B,AB");
			put("O-B","A,AB");
			put("B-A","无");
			put("O-AB","O,AB");
			put("B-AB","O");
			put("A-AB","O");
		}
	};
	
	public String pung(){
		msgList = new ArrayList<String>();
		msgList.add("母亲血型：" + btypem);
		msgList.add("父亲血型：" + btypef);
		
		String pos = posRstMap.get(btypef + "-" + btypem);
		pos = pos == null ? "无" : pos;
		String impos = imposRstMap.get(btypef + "-" + btypem); 
		impos = impos == null ? "无" : impos;
		
		msgList.add("子女可能有的血型：" + pos);
		msgList.add("子女不可能有的血型：" + impos);
		
		return handleResult("pung");
	}
	
	protected String getSysType(){
		return "article";
	}
}
