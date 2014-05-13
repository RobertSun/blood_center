package com.jeecms.auxiliary.entity;

import com.jeecms.auxiliary.entity.base.BaseBooking;

public class Booking extends BaseBooking {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private java.lang.String sexName;//性别
	private java.lang.String papersTypeName;//证件类型
	private java.lang.String donateBloodTypeName;//献血类型
	private java.lang.String appStateInfo;//预约状态：0-未预约；1-预约成功；-1-预约失败
	
	public java.lang.String getSexName() {
		if("1".equals(this.getSex())){
			sexName = "男";
		}else if("2".equals(this.getSex())){
			sexName = "女";
		}else{
			sexName = "未知";
		}
		return sexName;
	}
	public void setSexName(java.lang.String sexName) {
		this.sexName = sexName;
	}
	public java.lang.String getPapersTypeName() {
		if("0".equals(this.getPapersType())){
			papersTypeName = "身份证";
		}else if("1".equals(this.getPapersType())){
			papersTypeName = "军人证";
		}else if("2".equals(this.getPapersType())){
			papersTypeName = "护照";
		}else if("3".equals(this.getPapersType())){
			papersTypeName = "其它";
		}else if("4".equals(this.getPapersType())){
			papersTypeName = "献血证";
		}else{
			papersTypeName = "未知";
		}
		return papersTypeName;
	}
	public void setPapersTypeName(java.lang.String papersTypeName) {
		this.papersTypeName = papersTypeName;
	}
	public java.lang.String getDonateBloodTypeName() {
		if("101".equals(this.getDonateBloodType())){
			donateBloodTypeName = "全血";
		}else if("301".equals(this.getDonateBloodType())){
			donateBloodTypeName = "单采血小板";
		}else{
			donateBloodTypeName = "未知";
		}
		return donateBloodTypeName;
	}
	public void setDonateBloodTypeName(java.lang.String donateBloodTypeName) {
		this.donateBloodTypeName = donateBloodTypeName;
	}
	public java.lang.String getAppStateInfo() {
		if(this.getAppState() == 1){
			appStateInfo = "预约成功";
		}else if(this.getAppState() == -1){
			appStateInfo = "预约失败";
		}else{
			appStateInfo = "未预约";
		}
		return appStateInfo;
	}
	public void setAppStateInfo(java.lang.String appStateInfo) {
		this.appStateInfo = appStateInfo;
	}
	
	
}
