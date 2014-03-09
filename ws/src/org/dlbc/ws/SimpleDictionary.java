
package org.dlbc.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SimpleDictionary complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SimpleDictionary">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Spell" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Sort" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="IsUsed" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="Describe" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SimpleDictionary", propOrder = {
    "id",
    "name",
    "code",
    "spell",
    "sort",
    "isUsed",
    "describe"
})
@XmlSeeAlso({
    StationDictionary.class
})
public class SimpleDictionary {

    @XmlElement(name = "ID")
    protected String id;
    @XmlElement(name = "Name")
    protected String name;
    @XmlElement(name = "Code")
    protected String code;
    @XmlElement(name = "Spell")
    protected String spell;
    @XmlElement(name = "Sort")
    protected int sort;
    @XmlElement(name = "IsUsed")
    protected boolean isUsed;
    @XmlElement(name = "Describe")
    protected String describe;

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
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the code property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCode() {
        return code;
    }

    /**
     * Sets the value of the code property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCode(String value) {
        this.code = value;
    }

    /**
     * Gets the value of the spell property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpell() {
        return spell;
    }

    /**
     * Sets the value of the spell property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpell(String value) {
        this.spell = value;
    }

    /**
     * Gets the value of the sort property.
     * 
     */
    public int getSort() {
        return sort;
    }

    /**
     * Sets the value of the sort property.
     * 
     */
    public void setSort(int value) {
        this.sort = value;
    }

    /**
     * Gets the value of the isUsed property.
     * 
     */
    public boolean isIsUsed() {
        return isUsed;
    }

    /**
     * Sets the value of the isUsed property.
     * 
     */
    public void setIsUsed(boolean value) {
        this.isUsed = value;
    }

    /**
     * Gets the value of the describe property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescribe() {
        return describe;
    }

    /**
     * Sets the value of the describe property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescribe(String value) {
        this.describe = value;
    }

}
