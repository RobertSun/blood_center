
package org.dlbc.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
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
 *         &lt;element name="InsertAppInfoResult" type="{http://tempuri.org/}NetAppReturnInfo" minOccurs="0"/>
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
    "insertAppInfoResult"
})
@XmlRootElement(name = "InsertAppInfoResponse")
public class InsertAppInfoResponse {

    @XmlElement(name = "InsertAppInfoResult")
    protected NetAppReturnInfo insertAppInfoResult;

    /**
     * Gets the value of the insertAppInfoResult property.
     * 
     * @return
     *     possible object is
     *     {@link NetAppReturnInfo }
     *     
     */
    public NetAppReturnInfo getInsertAppInfoResult() {
        return insertAppInfoResult;
    }

    /**
     * Sets the value of the insertAppInfoResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link NetAppReturnInfo }
     *     
     */
    public void setInsertAppInfoResult(NetAppReturnInfo value) {
        this.insertAppInfoResult = value;
    }

}
