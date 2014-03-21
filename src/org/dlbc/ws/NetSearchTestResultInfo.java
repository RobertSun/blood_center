
package org.dlbc.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for NetSearchTestResultInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="NetSearchTestResultInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ErrorInfo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TestResultID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ArcID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NetSearchTestResultInfo", propOrder = {
    "status",
    "errorInfo",
    "testResultID",
    "arcID"
})
public class NetSearchTestResultInfo {

    @XmlElement(name = "Status")
    protected String status;
    @XmlElement(name = "ErrorInfo")
    protected String errorInfo;
    @XmlElement(name = "TestResultID")
    protected String testResultID;
    @XmlElement(name = "ArcID")
    protected String arcID;

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatus(String value) {
        this.status = value;
    }

    /**
     * Gets the value of the errorInfo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getErrorInfo() {
        return errorInfo;
    }

    /**
     * Sets the value of the errorInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setErrorInfo(String value) {
        this.errorInfo = value;
    }

    /**
     * Gets the value of the testResultID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTestResultID() {
        return testResultID;
    }

    /**
     * Sets the value of the testResultID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTestResultID(String value) {
        this.testResultID = value;
    }

    /**
     * Gets the value of the arcID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArcID() {
        return arcID;
    }

    /**
     * Sets the value of the arcID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArcID(String value) {
        this.arcID = value;
    }

}
