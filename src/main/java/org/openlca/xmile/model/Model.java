
package org.openlca.xmile.model;


import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlElements;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
	"simSpecs",
	"behavior",
	"variables",
	"views"
})
@XmlRootElement(name = "model", namespace = Xmile.NS)
public class Model {

	@XmlElement(name = "sim_specs", namespace = Xmile.NS)
	protected SimSpecs simSpecs;

	@XmlElement(namespace = Xmile.NS)
	protected Behavior behavior;

	@XmlElementWrapper(name = "variables", namespace = Xmile.NS)
	@XmlElements({
		@XmlElement(name = "stock", namespace = Xmile.NS, type = Stock.class),
		@XmlElement(name = "flow", namespace = Xmile.NS, type = Flow.class),
		@XmlElement(name = "aux", namespace = Xmile.NS, type = Aux.class),
		@XmlElement(name = "gf", namespace = Xmile.NS, type = Gf.class),
		@XmlElement(name = "group", namespace = Xmile.NS, type = Group.class),
		@XmlElement(name = "module", namespace = Xmile.NS, type = Module.class)
	})
	protected List<Variable> variables;

	@XmlElement(namespace = Xmile.NS)
	protected Views views;

	@XmlAttribute(name = "name")
	protected String name;

	@XmlAttribute(name = "resource")
	protected String resource;

	@XmlAttribute(name = "run")
	protected Boolean run;

	@XmlAttribute(name = "password")
	protected String password;

	/**
	 * Gets the value of the simSpecs property.
	 *
	 * @return possible object is
	 * {@link SimSpecs }
	 */
	public SimSpecs getSimSpecs() {
		return simSpecs;
	}

	/**
	 * Sets the value of the simSpecs property.
	 *
	 * @param value allowed object is
	 *              {@link SimSpecs }
	 */
	public void setSimSpecs(SimSpecs value) {
		this.simSpecs = value;
	}

	/**
	 * Gets the value of the behavior property.
	 *
	 * @return possible object is
	 * {@link Behavior }
	 */
	public Behavior getBehavior() {
		return behavior;
	}

	/**
	 * Sets the value of the behavior property.
	 *
	 * @param value allowed object is
	 *              {@link Behavior }
	 */
	public void setBehavior(Behavior value) {
		this.behavior = value;
	}

	public List<Variable> getVariables() {
		if (variables == null) {
			variables = new ArrayList<>();
		}
		return this.variables;
	}

	/**
	 * Gets the value of the views property.
	 *
	 * @return possible object is
	 * {@link Views }
	 */
	public Views getViews() {
		return views;
	}

	/**
	 * Sets the value of the views property.
	 *
	 * @param value allowed object is
	 *              {@link Views }
	 */
	public void setViews(Views value) {
		this.views = value;
	}

	/**
	 * Gets the value of the name property.
	 *
	 * @return possible object is
	 * {@link String }
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the value of the name property.
	 *
	 * @param value allowed object is
	 *              {@link String }
	 */
	public void setName(String value) {
		this.name = value;
	}

	/**
	 * Gets the value of the resource property.
	 *
	 * @return possible object is
	 * {@link String }
	 */
	public String getResource() {
		return resource;
	}

	/**
	 * Sets the value of the resource property.
	 *
	 * @param value allowed object is
	 *              {@link String }
	 */
	public void setResource(String value) {
		this.resource = value;
	}

	/**
	 * Gets the value of the run property.
	 *
	 * @return possible object is
	 * {@link Boolean }
	 */
	public boolean isRun() {
		if (run == null) {
			return false;
		} else {
			return run;
		}
	}

	/**
	 * Sets the value of the run property.
	 *
	 * @param value allowed object is
	 *              {@link Boolean }
	 */
	public void setRun(Boolean value) {
		this.run = value;
	}

	/**
	 * Gets the value of the password property.
	 *
	 * @return possible object is
	 * {@link String }
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the value of the password property.
	 *
	 * @param value allowed object is
	 *              {@link String }
	 */
	public void setPassword(String value) {
		this.password = value;
	}

}
