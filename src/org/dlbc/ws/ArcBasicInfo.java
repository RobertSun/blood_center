
package org.dlbc.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for ArcBasicInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArcBasicInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="IdentityTypeID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IdentityCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SexID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ABO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RHD" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Birthday" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="PictureID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NationalityID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NationID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MaritalID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PoliticalID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OriginID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OrganizationID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="EducationID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OccupationID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IDCardAddress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RegionID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="StreetID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SocietyRoleID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IdentityTypeName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SexName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NationalityName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NationName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MaritalName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PoliticalName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OriginName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OrganizationName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="EducationName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OccupationName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RegionName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="StreetName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SocietyRoleName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BloodType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Age" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArcBasicInfo", propOrder = {
    "identityTypeID",
    "identityCode",
    "name",
    "sexID",
    "abo",
    "rhd",
    "birthday",
    "pictureID",
    "nationalityID",
    "nationID",
    "maritalID",
    "politicalID",
    "originID",
    "organizationID",
    "educationID",
    "occupationID",
    "idCardAddress",
    "regionID",
    "streetID",
    "societyRoleID",
    "identityTypeName",
    "sexName",
    "nationalityName",
    "nationName",
    "maritalName",
    "politicalName",
    "originName",
    "organizationName",
    "educationName",
    "occupationName",
    "regionName",
    "streetName",
    "societyRoleName",
    "bloodType",
    "age"
})
@XmlSeeAlso({
    ReserveInfo.class
})
public class ArcBasicInfo {

    @XmlElement(name = "IdentityTypeID")
    protected String identityTypeID;
    @XmlElement(name = "IdentityCode")
    protected String identityCode;
    @XmlElement(name = "Name")
    protected String name;
    @XmlElement(name = "SexID")
    protected String sexID;
    @XmlElement(name = "ABO")
    protected String abo;
    @XmlElement(name = "RHD")
    protected String rhd;
    @XmlElement(name = "Birthday", required = true)
    protected XMLGregorianCalendar birthday;
    @XmlElement(name = "PictureID")
    protected String pictureID;
    @XmlElement(name = "NationalityID")
    protected String nationalityID;
    @XmlElement(name = "NationID")
    protected String nationID;
    @XmlElement(name = "MaritalID")
    protected String maritalID;
    @XmlElement(name = "PoliticalID")
    protected String politicalID;
    @XmlElement(name = "OriginID")
    protected String originID;
    @XmlElement(name = "OrganizationID")
    protected String organizationID;
    @XmlElement(name = "EducationID")
    protected String educationID;
    @XmlElement(name = "OccupationID")
    protected String occupationID;
    @XmlElement(name = "IDCardAddress")
    protected String idCardAddress;
    @XmlElement(name = "RegionID")
    protected String regionID;
    @XmlElement(name = "StreetID")
    protected String streetID;
    @XmlElement(name = "SocietyRoleID")
    protected String societyRoleID;
    @XmlElement(name = "IdentityTypeName")
    protected String identityTypeName;
    @XmlElement(name = "SexName")
    protected String sexName;
    @XmlElement(name = "NationalityName")
    protected String nationalityName;
    @XmlElement(name = "NationName")
    protected String nationName;
    @XmlElement(name = "MaritalName")
    protected String maritalName;
    @XmlElement(name = "PoliticalName")
    protected String politicalName;
    @XmlElement(name = "OriginName")
    protected String originName;
    @XmlElement(name = "OrganizationName")
    protected String organizationName;
    @XmlElement(name = "EducationName")
    protected String educationName;
    @XmlElement(name = "OccupationName")
    protected String occupationName;
    @XmlElement(name = "RegionName")
    protected String regionName;
    @XmlElement(name = "StreetName")
    protected String streetName;
    @XmlElement(name = "SocietyRoleName")
    protected String societyRoleName;
    @XmlElement(name = "BloodType")
    protected String bloodType;
    @XmlElement(name = "Age")
    protected int age;

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
     * Gets the value of the sexID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSexID() {
        return sexID;
    }

    /**
     * Sets the value of the sexID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSexID(String value) {
        this.sexID = value;
    }

    /**
     * Gets the value of the abo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getABO() {
        return abo;
    }

    /**
     * Sets the value of the abo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setABO(String value) {
        this.abo = value;
    }

    /**
     * Gets the value of the rhd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRHD() {
        return rhd;
    }

    /**
     * Sets the value of the rhd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRHD(String value) {
        this.rhd = value;
    }

    /**
     * Gets the value of the birthday property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getBirthday() {
        return birthday;
    }

    /**
     * Sets the value of the birthday property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setBirthday(XMLGregorianCalendar value) {
        this.birthday = value;
    }

    /**
     * Gets the value of the pictureID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPictureID() {
        return pictureID;
    }

    /**
     * Sets the value of the pictureID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPictureID(String value) {
        this.pictureID = value;
    }

    /**
     * Gets the value of the nationalityID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNationalityID() {
        return nationalityID;
    }

    /**
     * Sets the value of the nationalityID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNationalityID(String value) {
        this.nationalityID = value;
    }

    /**
     * Gets the value of the nationID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNationID() {
        return nationID;
    }

    /**
     * Sets the value of the nationID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNationID(String value) {
        this.nationID = value;
    }

    /**
     * Gets the value of the maritalID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMaritalID() {
        return maritalID;
    }

    /**
     * Sets the value of the maritalID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMaritalID(String value) {
        this.maritalID = value;
    }

    /**
     * Gets the value of the politicalID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPoliticalID() {
        return politicalID;
    }

    /**
     * Sets the value of the politicalID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPoliticalID(String value) {
        this.politicalID = value;
    }

    /**
     * Gets the value of the originID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOriginID() {
        return originID;
    }

    /**
     * Sets the value of the originID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOriginID(String value) {
        this.originID = value;
    }

    /**
     * Gets the value of the organizationID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrganizationID() {
        return organizationID;
    }

    /**
     * Sets the value of the organizationID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrganizationID(String value) {
        this.organizationID = value;
    }

    /**
     * Gets the value of the educationID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEducationID() {
        return educationID;
    }

    /**
     * Sets the value of the educationID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEducationID(String value) {
        this.educationID = value;
    }

    /**
     * Gets the value of the occupationID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOccupationID() {
        return occupationID;
    }

    /**
     * Sets the value of the occupationID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOccupationID(String value) {
        this.occupationID = value;
    }

    /**
     * Gets the value of the idCardAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIDCardAddress() {
        return idCardAddress;
    }

    /**
     * Sets the value of the idCardAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIDCardAddress(String value) {
        this.idCardAddress = value;
    }

    /**
     * Gets the value of the regionID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegionID() {
        return regionID;
    }

    /**
     * Sets the value of the regionID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegionID(String value) {
        this.regionID = value;
    }

    /**
     * Gets the value of the streetID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStreetID() {
        return streetID;
    }

    /**
     * Sets the value of the streetID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStreetID(String value) {
        this.streetID = value;
    }

    /**
     * Gets the value of the societyRoleID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSocietyRoleID() {
        return societyRoleID;
    }

    /**
     * Sets the value of the societyRoleID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSocietyRoleID(String value) {
        this.societyRoleID = value;
    }

    /**
     * Gets the value of the identityTypeName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdentityTypeName() {
        return identityTypeName;
    }

    /**
     * Sets the value of the identityTypeName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdentityTypeName(String value) {
        this.identityTypeName = value;
    }

    /**
     * Gets the value of the sexName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSexName() {
        return sexName;
    }

    /**
     * Sets the value of the sexName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSexName(String value) {
        this.sexName = value;
    }

    /**
     * Gets the value of the nationalityName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNationalityName() {
        return nationalityName;
    }

    /**
     * Sets the value of the nationalityName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNationalityName(String value) {
        this.nationalityName = value;
    }

    /**
     * Gets the value of the nationName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNationName() {
        return nationName;
    }

    /**
     * Sets the value of the nationName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNationName(String value) {
        this.nationName = value;
    }

    /**
     * Gets the value of the maritalName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMaritalName() {
        return maritalName;
    }

    /**
     * Sets the value of the maritalName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMaritalName(String value) {
        this.maritalName = value;
    }

    /**
     * Gets the value of the politicalName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPoliticalName() {
        return politicalName;
    }

    /**
     * Sets the value of the politicalName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPoliticalName(String value) {
        this.politicalName = value;
    }

    /**
     * Gets the value of the originName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOriginName() {
        return originName;
    }

    /**
     * Sets the value of the originName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOriginName(String value) {
        this.originName = value;
    }

    /**
     * Gets the value of the organizationName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrganizationName() {
        return organizationName;
    }

    /**
     * Sets the value of the organizationName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrganizationName(String value) {
        this.organizationName = value;
    }

    /**
     * Gets the value of the educationName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEducationName() {
        return educationName;
    }

    /**
     * Sets the value of the educationName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEducationName(String value) {
        this.educationName = value;
    }

    /**
     * Gets the value of the occupationName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOccupationName() {
        return occupationName;
    }

    /**
     * Sets the value of the occupationName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOccupationName(String value) {
        this.occupationName = value;
    }

    /**
     * Gets the value of the regionName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegionName() {
        return regionName;
    }

    /**
     * Sets the value of the regionName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegionName(String value) {
        this.regionName = value;
    }

    /**
     * Gets the value of the streetName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStreetName() {
        return streetName;
    }

    /**
     * Sets the value of the streetName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStreetName(String value) {
        this.streetName = value;
    }

    /**
     * Gets the value of the societyRoleName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSocietyRoleName() {
        return societyRoleName;
    }

    /**
     * Sets the value of the societyRoleName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSocietyRoleName(String value) {
        this.societyRoleName = value;
    }

    /**
     * Gets the value of the bloodType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBloodType() {
        return bloodType;
    }

    /**
     * Sets the value of the bloodType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBloodType(String value) {
        this.bloodType = value;
    }

    /**
     * Gets the value of the age property.
     * 
     */
    public int getAge() {
        return age;
    }

    /**
     * Sets the value of the age property.
     * 
     */
    public void setAge(int value) {
        this.age = value;
    }

}
