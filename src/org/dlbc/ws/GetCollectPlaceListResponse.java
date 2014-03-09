
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
 *         &lt;element name="GetCollectPlaceListResult" type="{http://tempuri.org/}ArrayOfCollectPlaceDic" minOccurs="0"/>
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
    "getCollectPlaceListResult"
})
@XmlRootElement(name = "GetCollectPlaceListResponse")
public class GetCollectPlaceListResponse {

    @XmlElement(name = "GetCollectPlaceListResult")
    protected ArrayOfCollectPlaceDic getCollectPlaceListResult;

    /**
     * Gets the value of the getCollectPlaceListResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfCollectPlaceDic }
     *     
     */
    public ArrayOfCollectPlaceDic getGetCollectPlaceListResult() {
        return getCollectPlaceListResult;
    }

    /**
     * Sets the value of the getCollectPlaceListResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfCollectPlaceDic }
     *     
     */
    public void setGetCollectPlaceListResult(ArrayOfCollectPlaceDic value) {
        this.getCollectPlaceListResult = value;
    }

}
