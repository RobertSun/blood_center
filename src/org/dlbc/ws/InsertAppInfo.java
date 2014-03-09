
package org.dlbc.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;element name="netAppRecordInfo" type="{http://tempuri.org/}NetAppRecordInfo" minOccurs="0"/>
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
    "netAppRecordInfo"
})
@XmlRootElement(name = "InsertAppInfo")
public class InsertAppInfo {

    protected NetAppRecordInfo netAppRecordInfo;

    /**
     * Gets the value of the netAppRecordInfo property.
     * 
     * @return
     *     possible object is
     *     {@link NetAppRecordInfo }
     *     
     */
    public NetAppRecordInfo getNetAppRecordInfo() {
        return netAppRecordInfo;
    }

    /**
     * Sets the value of the netAppRecordInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link NetAppRecordInfo }
     *     
     */
    public void setNetAppRecordInfo(NetAppRecordInfo value) {
        this.netAppRecordInfo = value;
    }

}
