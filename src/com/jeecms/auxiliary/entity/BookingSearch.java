package com.jeecms.auxiliary.entity;

public class BookingSearch {
	private java.lang.String searchType;//查询类型：1-通过献血码；2-通过证件号
	private java.lang.String idTypeID;//证件类型id
	private java.lang.String idCode;//证件号码
	private java.lang.String donCode;//献血码
	private java.lang.String verifyCodeDon;//验证码-通过献血码
	private java.lang.String verifyCodeID;//验证码-通过证件号
	
	public java.lang.String getSearchType() {
		return searchType;
	}
	public void setSearchType(java.lang.String searchType) {
		this.searchType = searchType;
	}
	public java.lang.String getIdTypeID() {
		return idTypeID;
	}
	public void setIdTypeID(java.lang.String idTypeID) {
		this.idTypeID = idTypeID;
	}
	public java.lang.String getIdCode() {
		return idCode;
	}
	public void setIdCode(java.lang.String idCode) {
		this.idCode = idCode;
	}
	public java.lang.String getDonCode() {
		return donCode;
	}
	public void setDonCode(java.lang.String donCode) {
		this.donCode = donCode;
	}
	public java.lang.String getVerifyCodeDon() {
		return verifyCodeDon;
	}
	public void setVerifyCodeDon(java.lang.String verifyCodeDon) {
		this.verifyCodeDon = verifyCodeDon;
	}
	public java.lang.String getVerifyCodeID() {
		return verifyCodeID;
	}
	public void setVerifyCodeID(java.lang.String verifyCodeID) {
		this.verifyCodeID = verifyCodeID;
	}
	
}
