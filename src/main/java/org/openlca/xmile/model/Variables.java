
package org.openlca.xmile.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;choice maxOccurs="unbounded" minOccurs="0"&gt;
 *         &lt;element ref="{http://docs.oasis-open.org/xmile/ns/XMILE/v1.0}stock" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://docs.oasis-open.org/xmile/ns/XMILE/v1.0}flow" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://docs.oasis-open.org/xmile/ns/XMILE/v1.0}aux" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://docs.oasis-open.org/xmile/ns/XMILE/v1.0}gf" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://docs.oasis-open.org/xmile/ns/XMILE/v1.0}group" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://docs.oasis-open.org/xmile/ns/XMILE/v1.0}module" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/choice&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "stockOrFlowOrAux"
})
@XmlRootElement(name = "variables", namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0")
public class Variables {

    @XmlElements({
        @XmlElement(name = "stock", namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0", type = Stock.class),
        @XmlElement(name = "flow", namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0", type = Flow.class),
        @XmlElement(name = "aux", namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0", type = Aux.class),
        @XmlElement(name = "gf", namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0", type = Gf.class),
        @XmlElement(name = "group", namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0", type = Group.class),
        @XmlElement(name = "module", namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0", type = Module.class)
    })
    protected List<Object> stockOrFlowOrAux;

    /**
     * Gets the value of the stockOrFlowOrAux property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the stockOrFlowOrAux property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStockOrFlowOrAux().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Stock }
     * {@link Flow }
     * {@link Aux }
     * {@link Gf }
     * {@link Group }
     * {@link Module }
     *
     *
     */
    public List<Object> getStockOrFlowOrAux() {
        if (stockOrFlowOrAux == null) {
            stockOrFlowOrAux = new ArrayList<Object>();
        }
        return this.stockOrFlowOrAux;
    }

}
