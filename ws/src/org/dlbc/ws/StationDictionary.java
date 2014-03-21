
package org.dlbc.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for StationDictionary complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="StationDictionary">
 *   &lt;complexContent>
 *     &lt;extension base="{http://tempuri.org/}SimpleDictionary">
 *       &lt;sequence>
 *         &lt;element name="BloodStationID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StationDictionary", propOrder = {
    "bloodStationID"
})
@XmlSeeAlso({
    CollectPlaceDic.class
})
public class StationDictionary
    extends SimpleDictionary
{

    @XmlElement(name = "BloodStationID")
    protected String bloodStationID;

    /**
     * Gets the value of the bloodStationID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBloodStationID() {
        return bloodStationID;
    }

    /**
     * Sets the value of the bloodStationID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBloodStationID(String value) {
        this.bloodStationID = value;
    }

}
