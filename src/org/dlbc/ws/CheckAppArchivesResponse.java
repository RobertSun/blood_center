
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
 *         &lt;element name="CheckAppArchivesResult" type="{http://tempuri.org/}NetAppReturnInfo" minOccurs="0"/>
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
    "checkAppArchivesResult"
})
@XmlRootElement(name = "CheckAppArchivesResponse")
public class CheckAppArchivesResponse {

    @XmlElement(name = "CheckAppArchivesResult")
    protected NetAppReturnInfo checkAppArchivesResult;

    /**
     * Gets the value of the checkAppArchivesResult property.
     * 
     * @return
     *     possible object is
     *     {@link NetAppReturnInfo }
     *     
     */
    public NetAppReturnInfo getCheckAppArchivesResult() {
        return checkAppArchivesResult;
    }

    /**
     * Sets the value of the checkAppArchivesResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link NetAppReturnInfo }
     *     
     */
    public void setCheckAppArchivesResult(NetAppReturnInfo value) {
        this.checkAppArchivesResult = value;
    }

}
