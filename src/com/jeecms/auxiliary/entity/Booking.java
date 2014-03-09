package com.jeecms.auxiliary.entity;

import com.jeecms.auxiliary.entity.base.BaseBooking;

public class Booking extends BaseBooking {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private java.lang.String sexName;//�Ա�
	private java.lang.String papersTypeName;//֤������
	private java.lang.String donateBloodTypeName;//��Ѫ����
	private java.lang.String appStateInfo;//ԤԼ״̬��0-δԤԼ��1-ԤԼ�ɹ���-1-ԤԼʧ��
	
	public java.lang.String getSexName() {
		if("1".equals(this.getSex())){
			sexName = "��";
		}else if("2".equals(this.getSex())){
			sexName = "Ů";
		}else{
			sexName = "δ֪";
		}
		return sexName;
	}
	public void setSexName(java.lang.String sexName) {
		this.sexName = sexName;
	}
	public java.lang.String getPapersTypeName() {
		if("0".equals(this.getPapersType())){
			papersTypeName = "���֤";
		}else if("1".equals(this.getPapersType())){
			papersTypeName = "����֤";
		}else if("2".equals(this.getPapersType())){
			papersTypeName = "����";
		}else if("3".equals(this.getPapersType())){
			papersTypeName = "����";
		}else if("4".equals(this.getPapersType())){
			papersTypeName = "��Ѫ֤";
		}else{
			papersTypeName = "δ֪";
		}
		return papersTypeName;
	}
	public void setPapersTypeName(java.lang.String papersTypeName) {
		this.papersTypeName = papersTypeName;
	}
	public java.lang.String getDonateBloodTypeName() {
		if("101".equals(this.getDonateBloodType())){
			donateBloodTypeName = "ȫѪ";
		}else if("301".equals(this.getDonateBloodType())){
			donateBloodTypeName = "����ѪС��";
		}else{
			donateBloodTypeName = "δ֪";
		}
		return donateBloodTypeName;
	}
	public void setDonateBloodTypeName(java.lang.String donateBloodTypeName) {
		this.donateBloodTypeName = donateBloodTypeName;
	}
	public java.lang.String getAppStateInfo() {
		if(this.getAppState() == 1){
			appStateInfo = "ԤԼ�ɹ�";
		}else if(this.getAppState() == -1){
			appStateInfo = "ԤԼʧ��";
		}else{
			appStateInfo = "δԤԼ";
		}
		return appStateInfo;
	}
	public void setAppStateInfo(java.lang.String appStateInfo) {
		this.appStateInfo = appStateInfo;
	}
	
	
}
