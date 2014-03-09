
package org.dlbc.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for NetAppRecordInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="NetAppRecordInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ReserveInfo" type="{http://tempuri.org/}ReserveInfo" minOccurs="0"/>
 *         &lt;element name="ReserveLinkModes" type="{http://tempuri.org/}ArrayOfReserveLinkModesDic" minOccurs="0"/>
 *         &lt;element name="DonAppRecordInfo" type="{http://tempuri.org/}DonAppRecordInfo" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NetAppRecordInfo", propOrder = {
    "reserveInfo",
    "reserveLinkModes",
    "donAppRecordInfo"
})
public class NetAppRecordInfo {

    @XmlElement(name = "ReserveInfo")
    protected ReserveInfo reserveInfo;
    @XmlElement(name = "ReserveLinkModes")
    protected ArrayOfReserveLinkModesDic reserveLinkModes;
    @XmlElement(name = "DonAppRecordInfo")
    protected DonAppRecordInfo donAppRecordInfo;

    /**
     * Gets the value of the reserveInfo property.
     * 
     * @return
     *     possible object is
     *     {@link ReserveInfo }
     *     
     */
    public ReserveInfo getReserveInfo() {
        return reserveInfo;
    }

    /**
     * Sets the value of the reserveInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReserveInfo }
     *     
     */
    public void setReserveInfo(ReserveInfo value) {
        this.reserveInfo = value;
    }

    /**
     * Gets the value of the reserveLinkModes property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfReserveLinkModesDic }
     *     
     */
    public ArrayOfReserveLinkModesDic getReserveLinkModes() {
        return reserveLinkModes;
    }

    /**
     * Sets the value of the reserveLinkModes property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfReserveLinkModesDic }
     *     
     */
    public void setReserveLinkModes(ArrayOfReserveLinkModesDic value) {
        this.reserveLinkModes = value;
    }

    /**
     * Gets the value of the donAppRecordInfo property.
     * 
     * @return
     *     possible object is
     *     {@link DonAppRecordInfo }
     *     
     */
    public DonAppRecordInfo getDonAppRecordInfo() {
        return donAppRecordInfo;
    }

    /**
     * Sets the value of the donAppRecordInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link DonAppRecordInfo }
     *     
     */
    public void setDonAppRecordInfo(DonAppRecordInfo value) {
        this.donAppRecordInfo = value;
    }

}
