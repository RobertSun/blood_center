
package org.dlbc.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for ReserveInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ReserveInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{http://tempuri.org/}ArcBasicInfo">
 *       &lt;sequence>
 *         &lt;element name="ID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BloodStationID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DeptID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ArcID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CreatorID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CreateDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="RemarkStatus" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="CreatorName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Remark" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RegionProvinceID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RegionCityID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReserveInfo", propOrder = {
    "id",
    "bloodStationID",
    "deptID",
    "arcID",
    "creatorID",
    "createDate",
    "remarkStatus",
    "creatorName",
    "remark",
    "regionProvinceID",
    "regionCityID"
})
public class ReserveInfo
    extends ArcBasicInfo
{

    @XmlElement(name = "ID")
    protected String id;
    @XmlElement(name = "BloodStationID")
    protected String bloodStationID;
    @XmlElement(name = "DeptID")
    protected String deptID;
    @XmlElement(name = "ArcID")
    protected String arcID;
    @XmlElement(name = "CreatorID")
    protected String creatorID;
    @XmlElement(name = "CreateDate", required = true)
    protected XMLGregorianCalendar createDate;
    @XmlElement(name = "RemarkStatus")
    protected boolean remarkStatus;
    @XmlElement(name = "CreatorName")
    protected String creatorName;
    @XmlElement(name = "Remark")
    protected String remark;
    @XmlElement(name = "RegionProvinceID")
    protected String regionProvinceID;
    @XmlElement(name = "RegionCityID")
    protected String regionCityID;

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
     * Gets the value of the creatorID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreatorID() {
        return creatorID;
    }

    /**
     * Sets the value of the creatorID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreatorID(String value) {
        this.creatorID = value;
    }

    /**
     * Gets the value of the createDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCreateDate() {
        return createDate;
    }

    /**
     * Sets the value of the createDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCreateDate(XMLGregorianCalendar value) {
        this.createDate = value;
    }

    /**
     * Gets the value of the remarkStatus property.
     * 
     */
    public boolean isRemarkStatus() {
        return remarkStatus;
    }

    /**
     * Sets the value of the remarkStatus property.
     * 
     */
    public void setRemarkStatus(boolean value) {
        this.remarkStatus = value;
    }

    /**
     * Gets the value of the creatorName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreatorName() {
        return creatorName;
    }

    /**
     * Sets the value of the creatorName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreatorName(String value) {
        this.creatorName = value;
    }

    /**
     * Gets the value of the remark property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRemark() {
        return remark;
    }

    /**
     * Sets the value of the remark property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRemark(String value) {
        this.remark = value;
    }

    /**
     * Gets the value of the regionProvinceID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegionProvinceID() {
        return regionProvinceID;
    }

    /**
     * Sets the value of the regionProvinceID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegionProvinceID(String value) {
        this.regionProvinceID = value;
    }

    /**
     * Gets the value of the regionCityID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegionCityID() {
        return regionCityID;
    }

    /**
     * Sets the value of the regionCityID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegionCityID(String value) {
        this.regionCityID = value;
    }

}
