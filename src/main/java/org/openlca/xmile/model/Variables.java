
package org.openlca.xmile.model;


import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElements;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

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
