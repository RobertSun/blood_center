
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
 *         &lt;element name="GetTestResultSearchVerifyCodeByDonCodeResult" type="{http://tempuri.org/}NetSearchTestResultInfo" minOccurs="0"/>
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
    "getTestResultSearchVerifyCodeByDonCodeResult"
})
@XmlRootElement(name = "GetTestResultSearchVerifyCodeByDonCodeResponse")
public class GetTestResultSearchVerifyCodeByDonCodeResponse {

    @XmlElement(name = "GetTestResultSearchVerifyCodeByDonCodeResult")
    protected NetSearchTestResultInfo getTestResultSearchVerifyCodeByDonCodeResult;

    /**
     * Gets the value of the getTestResultSearchVerifyCodeByDonCodeResult property.
     * 
     * @return
     *     possible object is
     *     {@link NetSearchTestResultInfo }
     *     
     */
    public NetSearchTestResultInfo getGetTestResultSearchVerifyCodeByDonCodeResult() {
        return getTestResultSearchVerifyCodeByDonCodeResult;
    }

    /**
     * Sets the value of the getTestResultSearchVerifyCodeByDonCodeResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link NetSearchTestResultInfo }
     *     
     */
    public void setGetTestResultSearchVerifyCodeByDonCodeResult(NetSearchTestResultInfo value) {
        this.getTestResultSearchVerifyCodeByDonCodeResult = value;
    }

}
