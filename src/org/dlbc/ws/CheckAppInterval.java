
package org.dlbc.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idTypeID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sexID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="birthday" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="donKindID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="appStartDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="appEndDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "idTypeID",
    "idCode",
    "name",
    "sexID",
    "birthday",
    "donKindID",
    "appStartDate",
    "appEndDate"
})
@XmlRootElement(name = "CheckAppInterval")
public class CheckAppInterval {

    protected String idTypeID;
    protected String idCode;
    protected String name;
    protected String sexID;
    @XmlElement(required = true, nillable = true)
    protected XMLGregorianCalendar birthday;
    protected String donKindID;
    @XmlElement(required = true)
    protected XMLGregorianCalendar appStartDate;
    @XmlElement(required = true, nillable = true)
    protected XMLGregorianCalendar appEndDate;

    /**
     * Gets the value of the idTypeID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdTypeID() {
        return idTypeID;
    }

    /**
     * Sets the value of the idTypeID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdTypeID(String value) {
        this.idTypeID = value;
    }

    /**
     * Gets the value of the idCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdCode() {
        return idCode;
    }

    /**
     * Sets the value of the idCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdCode(String value) {
        this.idCode = value;
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
     * Gets the value of the donKindID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDonKindID() {
        return donKindID;
    }

    /**
     * Sets the value of the donKindID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDonKindID(String value) {
        this.donKindID = value;
    }

    /**
     * Gets the value of the appStartDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getAppStartDate() {
        return appStartDate;
    }

    /**
     * Sets the value of the appStartDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setAppStartDate(XMLGregorianCalendar value) {
        this.appStartDate = value;
    }

    /**
     * Gets the value of the appEndDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getAppEndDate() {
        return appEndDate;
    }

    /**
     * Sets the value of the appEndDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setAppEndDate(XMLGregorianCalendar value) {
        this.appEndDate = value;
    }

}
