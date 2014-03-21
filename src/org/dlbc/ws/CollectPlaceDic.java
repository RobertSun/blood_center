
package org.dlbc.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CollectPlaceDic complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CollectPlaceDic">
 *   &lt;complexContent>
 *     &lt;extension base="{http://tempuri.org/}StationDictionary">
 *       &lt;sequence>
 *         &lt;element name="PlaceKindID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RegionID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PlaceKindName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RegionName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CollectPlaceDic", propOrder = {
    "placeKindID",
    "regionID",
    "placeKindName",
    "regionName"
})
public class CollectPlaceDic
    extends StationDictionary
{

    @XmlElement(name = "PlaceKindID")
    protected String placeKindID;
    @XmlElement(name = "RegionID")
    protected String regionID;
    @XmlElement(name = "PlaceKindName")
    protected String placeKindName;
    @XmlElement(name = "RegionName")
    protected String regionName;

    /**
     * Gets the value of the placeKindID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlaceKindID() {
        return placeKindID;
    }

    /**
     * Sets the value of the placeKindID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlaceKindID(String value) {
        this.placeKindID = value;
    }

    /**
     * Gets the value of the regionID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegionID() {
        return regionID;
    }

    /**
     * Sets the value of the regionID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegionID(String value) {
        this.regionID = value;
    }

    /**
     * Gets the value of the placeKindName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlaceKindName() {
        return placeKindName;
    }

    /**
     * Sets the value of the placeKindName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlaceKindName(String value) {
        this.placeKindName = value;
    }

    /**
     * Gets the value of the regionName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegionName() {
        return regionName;
    }

    /**
     * Sets the value of the regionName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegionName(String value) {
        this.regionName = value;
    }

}
