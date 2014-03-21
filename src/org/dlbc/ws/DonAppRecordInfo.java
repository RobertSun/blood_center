
package org.dlbc.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for DonAppRecordInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DonAppRecordInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BloodStationID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DeptID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AttachID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ResArcID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AppDonKindID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AppDonKindName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AppCollectPlaceID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AppCollectPlaceName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AppDonBeginDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="AppDonEndDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="AppResultID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AppResultName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FailedCauseID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FailedCauseName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LinkTypeID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LinkTypeName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Phone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Content" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CallID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DonID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DonStatusID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DonStatusName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DonDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="OperatorID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OperatorName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OperateDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="IsSendSuccDon" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="IsSendTipDon" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="NetAppID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IsOver" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="IsCallOut" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="ArcID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IdentityTypeID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IdentityCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SourceID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TempletID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SMSContent" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IsCalled" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="IsCalling" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="IsFirstTelConfirm" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DonAppRecordInfo", propOrder = {
    "id",
    "bloodStationID",
    "deptID",
    "attachID",
    "resArcID",
    "appDonKindID",
    "appDonKindName",
    "appCollectPlaceID",
    "appCollectPlaceName",
    "appDonBeginDate",
    "appDonEndDate",
    "appResultID",
    "appResultName",
    "failedCauseID",
    "failedCauseName",
    "linkTypeID",
    "linkTypeName",
    "phone",
    "content",
    "callID",
    "donID",
    "donStatusID",
    "donStatusName",
    "donDate",
    "operatorID",
    "operatorName",
    "operateDate",
    "isSendSuccDon",
    "isSendTipDon",
    "netAppID",
    "isOver",
    "isCallOut",
    "arcID",
    "identityTypeID",
    "identityCode",
    "name",
    "sourceID",
    "templetID",
    "smsContent",
    "isCalled",
    "isCalling",
    "isFirstTelConfirm"
})
public class DonAppRecordInfo {

    @XmlElement(name = "ID")
    protected String id;
    @XmlElement(name = "BloodStationID")
    protected String bloodStationID;
    @XmlElement(name = "DeptID")
    protected String deptID;
    @XmlElement(name = "AttachID")
    protected String attachID;
    @XmlElement(name = "ResArcID")
    protected String resArcID;
    @XmlElement(name = "AppDonKindID")
    protected String appDonKindID;
    @XmlElement(name = "AppDonKindName")
    protected String appDonKindName;
    @XmlElement(name = "AppCollectPlaceID")
    protected String appCollectPlaceID;
    @XmlElement(name = "AppCollectPlaceName")
    protected String appCollectPlaceName;
    @XmlElement(name = "AppDonBeginDate", required = true, nillable = true)
    protected XMLGregorianCalendar appDonBeginDate;
    @XmlElement(name = "AppDonEndDate", required = true, nillable = true)
    protected XMLGregorianCalendar appDonEndDate;
    @XmlElement(name = "AppResultID")
    protected String appResultID;
    @XmlElement(name = "AppResultName")
    protected String appResultName;
    @XmlElement(name = "FailedCauseID")
    protected String failedCauseID;
    @XmlElement(name = "FailedCauseName")
    protected String failedCauseName;
    @XmlElement(name = "LinkTypeID")
    protected String linkTypeID;
    @XmlElement(name = "LinkTypeName")
    protected String linkTypeName;
    @XmlElement(name = "Phone")
    protected String phone;
    @XmlElement(name = "Content")
    protected String content;
    @XmlElement(name = "CallID")
    protected String callID;
    @XmlElement(name = "DonID")
    protected String donID;
    @XmlElement(name = "DonStatusID")
    protected String donStatusID;
    @XmlElement(name = "DonStatusName")
    protected String donStatusName;
    @XmlElement(name = "DonDate", required = true, nillable = true)
    protected XMLGregorianCalendar donDate;
    @XmlElement(name = "OperatorID")
    protected String operatorID;
    @XmlElement(name = "OperatorName")
    protected String operatorName;
    @XmlElement(name = "OperateDate", required = true)
    protected XMLGregorianCalendar operateDate;
    @XmlElement(name = "IsSendSuccDon")
    protected boolean isSendSuccDon;
    @XmlElement(name = "IsSendTipDon")
    protected boolean isSendTipDon;
    @XmlElement(name = "NetAppID")
    protected String netAppID;
    @XmlElement(name = "IsOver")
    protected boolean isOver;
    @XmlElement(name = "IsCallOut", required = true, type = Boolean.class, nillable = true)
    protected Boolean isCallOut;
    @XmlElement(name = "ArcID")
    protected String arcID;
    @XmlElement(name = "IdentityTypeID")
    protected String identityTypeID;
    @XmlElement(name = "IdentityCode")
    protected String identityCode;
    @XmlElement(name = "Name")
    protected String name;
    @XmlElement(name = "SourceID")
    protected String sourceID;
    @XmlElement(name = "TempletID")
    protected String templetID;
    @XmlElement(name = "SMSContent")
    protected String smsContent;
    @XmlElement(name = "IsCalled", required = true, type = Boolean.class, nillable = true)
    protected Boolean isCalled;
    @XmlElement(name = "IsCalling")
    protected boolean isCalling;
    @XmlElement(name = "IsFirstTelConfirm")
    protected boolean isFirstTelConfirm;

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getID() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setID(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the bloodStationID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBloodStationID() {
        return bloodStationID;
    }

    /**
     * Sets the value of the bloodStationID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBloodStationID(String value) {
        this.bloodStationID = value;
    }

    /**
     * Gets the value of the deptID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeptID() {
        return deptID;
    }

    /**
     * Sets the value of the deptID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeptID(String value) {
        this.deptID = value;
    }

    /**
     * Gets the value of the attachID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAttachID() {
        return attachID;
    }

    /**
     * Sets the value of the attachID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAttachID(String value) {
        this.attachID = value;
    }

    /**
     * Gets the value of the resArcID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResArcID() {
        return resArcID;
    }

    /**
     * Sets the value of the resArcID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResArcID(String value) {
        this.resArcID = value;
    }

    /**
     * Gets the value of the appDonKindID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAppDonKindID() {
        return appDonKindID;
    }

    /**
     * Sets the value of the appDonKindID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAppDonKindID(String value) {
        this.appDonKindID = value;
    }

    /**
     * Gets the value of the appDonKindName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAppDonKindName() {
        return appDonKindName;
    }

    /**
     * Sets the value of the appDonKindName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAppDonKindName(String value) {
        this.appDonKindName = value;
    }

    /**
     * Gets the value of the appCollectPlaceID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAppCollectPlaceID() {
        return appCollectPlaceID;
    }

    /**
     * Sets the value of the appCollectPlaceID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAppCollectPlaceID(String value) {
        this.appCollectPlaceID = value;
    }

    /**
     * Gets the value of the appCollectPlaceName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAppCollectPlaceName() {
        return appCollectPlaceName;
    }

    /**
     * Sets the value of the appCollectPlaceName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAppCollectPlaceName(String value) {
        this.appCollectPlaceName = value;
    }

    /**
     * Gets the value of the appDonBeginDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getAppDonBeginDate() {
        return appDonBeginDate;
    }

    /**
     * Sets the value of the appDonBeginDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setAppDonBeginDate(XMLGregorianCalendar value) {
        this.appDonBeginDate = value;
    }

    /**
     * Gets the value of the appDonEndDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getAppDonEndDate() {
        return appDonEndDate;
    }

    /**
     * Sets the value of the appDonEndDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setAppDonEndDate(XMLGregorianCalendar value) {
        this.appDonEndDate = value;
    }

    /**
     * Gets the value of the appResultID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAppResultID() {
        return appResultID;
    }

    /**
     * Sets the value of the appResultID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAppResultID(String value) {
        this.appResultID = value;
    }

    /**
     * Gets the value of the appResultName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAppResultName() {
        return appResultName;
    }

    /**
     * Sets the value of the appResultName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAppResultName(String value) {
        this.appResultName = value;
    }

    /**
     * Gets the value of the failedCauseID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFailedCauseID() {
        return failedCauseID;
    }

    /**
     * Sets the value of the failedCauseID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFailedCauseID(String value) {
        this.failedCauseID = value;
    }

    /**
     * Gets the value of the failedCauseName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFailedCauseName() {
        return failedCauseName;
    }

    /**
     * Sets the value of the failedCauseName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFailedCauseName(String value) {
        this.failedCauseName = value;
    }

    /**
     * Gets the value of the linkTypeID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLinkTypeID() {
        return linkTypeID;
    }

    /**
     * Sets the value of the linkTypeID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLinkTypeID(String value) {
        this.linkTypeID = value;
    }

    /**
     * Gets the value of the linkTypeName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLinkTypeName() {
        return linkTypeName;
    }

    /**
     * Sets the value of the linkTypeName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLinkTypeName(String value) {
        this.linkTypeName = value;
    }

    /**
     * Gets the value of the phone property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Sets the value of the phone property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPhone(String value) {
        this.phone = value;
    }

    /**
     * Gets the value of the content property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContent() {
        return content;
    }

    /**
     * Sets the value of the content property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContent(String value) {
        this.content = value;
    }

    /**
     * Gets the value of the callID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCallID() {
        return callID;
    }

    /**
     * Sets the value of the callID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCallID(String value) {
        this.callID = value;
    }

    /**
     * Gets the value of the donID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDonID() {
        return donID;
    }

    /**
     * Sets the value of the donID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDonID(String value) {
        this.donID = value;
    }

    /**
     * Gets the value of the donStatusID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDonStatusID() {
        return donStatusID;
    }

    /**
     * Sets the value of the donStatusID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDonStatusID(String value) {
        this.donStatusID = value;
    }

    /**
     * Gets the value of the donStatusName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDonStatusName() {
        return donStatusName;
    }

    /**
     * Sets the value of the donStatusName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDonStatusName(String value) {
        this.donStatusName = value;
    }

    /**
     * Gets the value of the donDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDonDate() {
        return donDate;
    }

    /**
     * Sets the value of the donDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDonDate(XMLGregorianCalendar value) {
        this.donDate = value;
    }

    /**
     * Gets the value of the operatorID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOperatorID() {
        return operatorID;
    }

    /**
     * Sets the value of the operatorID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOperatorID(String value) {
        this.operatorID = value;
    }

    /**
     * Gets the value of the operatorName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOperatorName() {
        return operatorName;
    }

    /**
     * Sets the value of the operatorName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOperatorName(String value) {
        this.operatorName = value;
    }

    /**
     * Gets the value of the operateDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getOperateDate() {
        return operateDate;
    }

    /**
     * Sets the value of the operateDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setOperateDate(XMLGregorianCalendar value) {
        this.operateDate = value;
    }

    /**
     * Gets the value of the isSendSuccDon property.
     * 
     */
    public boolean isIsSendSuccDon() {
        return isSendSuccDon;
    }

    /**
     * Sets the value of the isSendSuccDon property.
     * 
     */
    public void setIsSendSuccDon(boolean value) {
        this.isSendSuccDon = value;
    }

    /**
     * Gets the value of the isSendTipDon property.
     * 
     */
    public boolean isIsSendTipDon() {
        return isSendTipDon;
    }

    /**
     * Sets the value of the isSendTipDon property.
     * 
     */
    public void setIsSendTipDon(boolean value) {
        this.isSendTipDon = value;
    }

    /**
     * Gets the value of the netAppID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNetAppID() {
        return netAppID;
    }

    /**
     * Sets the value of the netAppID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNetAppID(String value) {
        this.netAppID = value;
    }

    /**
     * Gets the value of the isOver property.
     * 
     */
    public boolean isIsOver() {
        return isOver;
    }

    /**
     * Sets the value of the isOver property.
     * 
     */
    public void setIsOver(boolean value) {
        this.isOver = value;
    }

    /**
     * Gets the value of the isCallOut property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsCallOut() {
        return isCallOut;
    }

    /**
     * Sets the value of the isCallOut property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsCallOut(Boolean value) {
        this.isCallOut = value;
    }

    /**
     * Gets the value of the arcID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArcID() {
        return arcID;
    }

    /**
     * Sets the value of the arcID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArcID(String value) {
        this.arcID = value;
    }

    /**
     * Gets the value of the identityTypeID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdentityTypeID() {
        return identityTypeID;
    }

    /**
     * Sets the value of the identityTypeID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdentityTypeID(String value) {
        this.identityTypeID = value;
    }

    /**
     * Gets the value of the identityCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdentityCode() {
        return identityCode;
    }

    /**
     * Sets the value of the identityCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdentityCode(String value) {
        this.identityCode = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the sourceID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSourceID() {
        return sourceID;
    }

    /**
     * Sets the value of the sourceID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSourceID(String value) {
        this.sourceID = value;
    }

    /**
     * Gets the value of the templetID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTempletID() {
        return templetID;
    }

    /**
     * Sets the value of the templetID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTempletID(String value) {
        this.templetID = value;
    }

    /**
     * Gets the value of the smsContent property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSMSContent() {
        return smsContent;
    }

    /**
     * Sets the value of the smsContent property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSMSContent(String value) {
        this.smsContent = value;
    }

    /**
     * Gets the value of the isCalled property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsCalled() {
        return isCalled;
    }

    /**
     * Sets the value of the isCalled property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsCalled(Boolean value) {
        this.isCalled = value;
    }

    /**
     * Gets the value of the isCalling property.
     * 
     */
    public boolean isIsCalling() {
        return isCalling;
    }

    /**
     * Sets the value of the isCalling property.
     * 
     */
    public void setIsCalling(boolean value) {
        this.isCalling = value;
    }

    /**
     * Gets the value of the isFirstTelConfirm property.
     * 
     */
    public boolean isIsFirstTelConfirm() {
        return isFirstTelConfirm;
    }

    /**
     * Sets the value of the isFirstTelConfirm property.
     * 
     */
    public void setIsFirstTelConfirm(boolean value) {
        this.isFirstTelConfirm = value;
    }

}
