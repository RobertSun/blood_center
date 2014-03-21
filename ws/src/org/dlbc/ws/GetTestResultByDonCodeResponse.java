
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
 *         &lt;element name="GetTestResultByDonCodeResult" type="{http://tempuri.org/}NetSearchTestResultInfo" minOccurs="0"/>
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
    "getTestResultByDonCodeResult"
})
@XmlRootElement(name = "GetTestResultByDonCodeResponse")
public class GetTestResultByDonCodeResponse {

    @XmlElement(name = "GetTestResultByDonCodeResult")
    protected NetSearchTestResultInfo getTestResultByDonCodeResult;

    /**
     * Gets the value of the getTestResultByDonCodeResult property.
     * 
     * @return
     *     possible object is
     *     {@link NetSearchTestResultInfo }
     *     
     */
    public NetSearchTestResultInfo getGetTestResultByDonCodeResult() {
        return getTestResultByDonCodeResult;
    }

    /**
     * Sets the value of the getTestResultByDonCodeResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link NetSearchTestResultInfo }
     *     
     */
    public void setGetTestResultByDonCodeResult(NetSearchTestResultInfo value) {
        this.getTestResultByDonCodeResult = value;
    }

}
