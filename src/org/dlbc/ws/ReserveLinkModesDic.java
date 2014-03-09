
package org.dlbc.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ReserveLinkModesDic complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ReserveLinkModesDic">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ReserveID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LinkModeID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LinkValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LinkModeName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReserveLinkModesDic", propOrder = {
    "id",
    "reserveID",
    "linkModeID",
    "linkValue",
    "linkModeName"
})
public class ReserveLinkModesDic {

    @XmlElement(name = "ID")
    protected String id;
    @XmlElement(name = "ReserveID")
    protected String reserveID;
    @XmlElement(name = "LinkModeID")
    protected String linkModeID;
    @XmlElement(name = "LinkValue")
    protected String linkValue;
    @XmlElement(name = "LinkModeName")
    protected String linkModeName;

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
     * Gets the value of the reserveID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReserveID() {
        return reserveID;
    }

    /**
     * Sets the value of the reserveID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReserveID(String value) {
        this.reserveID = value;
    }

    /**
     * Gets the value of the linkModeID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLinkModeID() {
        return linkModeID;
    }

    /**
     * Sets the value of the linkModeID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLinkModeID(String value) {
        this.linkModeID = value;
    }

    /**
     * Gets the value of the linkValue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLinkValue() {
        return linkValue;
    }

    /**
     * Sets the value of the linkValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLinkValue(String value) {
        this.linkValue = value;
    }

    /**
     * Gets the value of the linkModeName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLinkModeName() {
        return linkModeName;
    }

    /**
     * Sets the value of the linkModeName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLinkModeName(String value) {
        this.linkModeName = value;
    }

}
