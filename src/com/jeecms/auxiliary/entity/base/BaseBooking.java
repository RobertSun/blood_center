package com.jeecms.auxiliary.entity.base;

import java.io.Serializable;

public abstract class BaseBooking implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Long id;

	// fields
	private java.lang.String papersType;//证件类型id
	private java.lang.String papersNumber;//证件号码
	private java.lang.String name;//姓名
	private java.lang.String sex;//性别id
	private java.util.Date birthday;//出生日期
	private java.lang.String donateBloodType;//献血类型id
	private java.lang.String bloodType;//血型
	private java.lang.String mobile;//手机
	private java.lang.String telephone;//固定电话
	private java.lang.String qq;//QQ号码
	private java.lang.String place;//预约地点id
	private java.lang.String placeName;//预约地点名称
	private java.util.Date startDate;//预约开始时间
	private java.util.Date endDate;//预约结束时间
	private java.util.Date createTime;
	private java.util.Date checkTime;
	private java.lang.Boolean check;
	private int appState;// 预约状态：0-未预约；1-预约成功；-1-预约失败
	private java.lang.String errInfo;//预约返回信息
	// many to one
	private com.jeecms.core.entity.Website website;
	
	/**
	 * Return the value associated with the column: WEBSITE_ID
	 */
	public com.jeecms.core.entity.Website getWebsite () {
		return website;
	}

	/**
	 * Set the value related to the column: WEBSITE_ID
	 * @param website the WEBSITE_ID value
	 */
	public void setWebsite (com.jeecms.core.entity.Website website) {
		this.website = website;
	}
	public java.lang.String getPapersType() {
		return papersType;
	}
	public void setPapersType(java.lang.String papersType) {
		this.papersType = papersType;
	}
	public java.lang.String getPapersNumber() {
		return papersNumber;
	}
	public void setPapersNumber(java.lang.String papersNumber) {
		this.papersNumber = papersNumber;
	}
	public java.lang.String getName() {
		return name;
	}
	public void setName(java.lang.String name) {
		this.name = name;
	}
	public java.lang.String getSex() {
		return sex;
	}
	public void setSex(java.lang.String sex) {
		this.sex = sex;
	}
	public java.util.Date getBirthday() {
		return birthday;
	}
	public void setBirthday(java.util.Date birthday) {
		this.birthday = birthday;
	}
	public java.lang.String getDonateBloodType() {
		return donateBloodType;
	}
	public void setDonateBloodType(java.lang.String donateBloodType) {
		this.donateBloodType = donateBloodType;
	}
	public java.lang.String getBloodType() {
		return bloodType;
	}
	public void setBloodType(java.lang.String bloodType) {
		this.bloodType = bloodType;
	}
	public java.lang.String getMobile() {
		return mobile;
	}
	public void setMobile(java.lang.String mobile) {
		this.mobile = mobile;
	}
	public java.lang.String getTelephone() {
		return telephone;
	}
	public void setTelephone(java.lang.String telephone) {
		this.telephone = telephone;
	}
	public java.lang.String getQq() {
		return qq;
	}
	public void setQq(java.lang.String qq) {
		this.qq = qq;
	}
	public java.lang.String getPlace() {
		return place;
	}
	public void setPlace(java.lang.String place) {
		this.place = place;
	}
	public java.util.Date getStartDate() {
		return startDate;
	}
	public void setStartDate(java.util.Date startDate) {
		this.startDate = startDate;
	}
	public java.util.Date getEndDate() {
		return endDate;
	}
	public void setEndDate(java.util.Date endDate) {
		this.endDate = endDate;
	}
	public java.util.Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}
	public java.util.Date getCheckTime() {
		return checkTime;
	}
	public void setCheckTime(java.util.Date checkTime) {
		this.checkTime = checkTime;
	}
	public java.lang.Boolean getCheck() {
		return check;
	}
	public void setCheck(java.lang.Boolean check) {
		this.check = check;
	}
	
	public java.lang.Long getId() {
		return id;
	}
	public void setId(java.lang.Long id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}
	
	public java.lang.String getPlaceName() {
		return placeName;
	}

	public void setPlaceName(java.lang.String placeName) {
		this.placeName = placeName;
	}

	public int getAppState() {
		return appState;
	}

	public void setAppState(int appState) {
		this.appState = appState;
	}

	public java.lang.String getErrInfo() {
		return errInfo;
	}

	public void setErrInfo(java.lang.String errInfo) {
		this.errInfo = errInfo;
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}
}
