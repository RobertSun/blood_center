package com.jeecms.auxiliary.entity;

public class ReturnMsg {
	private java.lang.String returnState;//���ر�ʶ  0:�ɹ�  1��ʧ��
	private java.lang.String returnMessage;//������Ϣ
	private java.lang.String arcID;//��������ʶ  0-���鲻�ϸ�1-����ϸ�
	
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
