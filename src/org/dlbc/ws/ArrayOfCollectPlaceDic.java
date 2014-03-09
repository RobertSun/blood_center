
package org.dlbc.ws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfCollectPlaceDic complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfCollectPlaceDic">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CollectPlaceDic" type="{http://tempuri.org/}CollectPlaceDic" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfCollectPlaceDic", propOrder = {
    "collectPlaceDic"
})
public class ArrayOfCollectPlaceDic {

    @XmlElement(name = "CollectPlaceDic", nillable = true)
    protected List<CollectPlaceDic> collectPlaceDic;

    /**
     * Gets the value of the collectPlaceDic property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the collectPlaceDic property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCollectPlaceDic().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CollectPlaceDic }
     * 
     * 
     */
    public List<CollectPlaceDic> getCollectPlaceDic() {
        if (collectPlaceDic == null) {
            collectPlaceDic = new ArrayList<CollectPlaceDic>();
        }
        return this.collectPlaceDic;
    }

}
