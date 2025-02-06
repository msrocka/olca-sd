
package org.openlca.xmile.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "gf", namespace = Xmile.NS)
public class Gf implements Variable {

	@XmlElement(namespace = Xmile.NS)
	protected MinMaxType xscale;
	@XmlElement(namespace = Xmile.NS)
	protected MinMaxType yscale;
	@XmlElement(namespace = Xmile.NS)
	protected PointsType xpts;
	@XmlElement(namespace = Xmile.NS, required = true)
	protected PointsType ypts;
	@XmlAttribute(name = "name")
	protected String name;
	@XmlAttribute(name = "type")
	protected String type;

	/**
	 * Gets the value of the xscale property.
	 *
	 * @return possible object is
	 * {@link MinMaxType }
	 */
	public MinMaxType getXscale() {
		return xscale;
	}

	/**
	 * Sets the value of the xscale property.
	 *
	 * @param value allowed object is
	 *              {@link MinMaxType }
	 */
	public void setXscale(MinMaxType value) {
		this.xscale = value;
	}

	/**
	 * Gets the value of the yscale property.
	 *
	 * @return possible object is
	 * {@link MinMaxType }
	 */
	public MinMaxType getYscale() {
		return yscale;
	}

	/**
	 * Sets the value of the yscale property.
	 *
	 * @param value allowed object is
	 *              {@link MinMaxType }
	 */
	public void setYscale(MinMaxType value) {
		this.yscale = value;
	}

	/**
	 * Gets the value of the xpts property.
	 *
	 * @return possible object is
	 * {@link PointsType }
	 */
	public PointsType getXpts() {
		return xpts;
	}

	/**
	 * Sets the value of the xpts property.
	 *
	 * @param value allowed object is
	 *              {@link PointsType }
	 */
	public void setXpts(PointsType value) {
		this.xpts = value;
	}

	/**
	 * Gets the value of the ypts property.
	 *
	 * @return possible object is
	 * {@link PointsType }
	 */
	public PointsType getYpts() {
		return ypts;
	}

	/**
	 * Sets the value of the ypts property.
	 *
	 * @param value allowed object is
	 *              {@link PointsType }
	 */
	public void setYpts(PointsType value) {
		this.ypts = value;
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
	 * Gets the value of the type property.
	 *
	 * @return possible object is
	 * {@link String }
	 */
	public String getType() {
		if (type == null) {
			return "continuous";
		} else {
			return type;
		}
	}

	/**
	 * Sets the value of the type property.
	 *
	 * @param value allowed object is
	 *              {@link String }
	 */
	public void setType(String value) {
		this.type = value;
	}

}
