package com.jeecms.auxiliary.entity;

public class ReturnMsg {
	private java.lang.String returnState;//返回标识  0:成功  1：失败
	private java.lang.String returnMessage;//返回信息
	private java.lang.String arcID;//检验结果标识  0-检验不合格；1-检验合格
	
	public java.lang.String getArcID() {
		return arcID;
	}
	public void setArcID(java.lang.String arcID) {
		this.arcID = arcID;
	}
	public java.lang.String getReturnState() {
		return returnState;
	}
	public void setReturnState(java.lang.String returnState) {
		this.returnState = returnState;
	}
	public java.lang.String getReturnMessage() {
		return returnMessage;
	}
	public void setReturnMessage(java.lang.String returnMessage) {
		this.returnMessage = returnMessage;
	}
	
}
