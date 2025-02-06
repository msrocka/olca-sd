package org.openlca.xmile.model2;


import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;

/*
xs:element name="sim_specs">
    <xs:annotation>
      <xs:documentation>
        Default simulation specifications for this model.
      </xs:documentation>
    </xs:annotation>
    <xs:complexType>
      <xs:all>
        <xs:element name="stop" type="xs:double" minOccurs="1"/>
        <xs:element name="start" type="xs:double" minOccurs="1"/>
        <xs:element name="dt" minOccurs="0" default="1">
          <xs:complexType>
            <xs:simpleContent>
              <xs:extension base="xs:double">
                <xs:attribute name="reciprocal" type="xs:boolean" default="false" use="optional"/>
              </xs:extension>
            </xs:simpleContent>
          </xs:complexType>
        </xs:element>
        <xs:element name="run" minOccurs="0">
          <xs:complexType>
            <xs:attribute name="by" use="required">
              <xs:simpleType>
                <xs:restriction base="xs:string">
                  <xs:enumeration value="all"/>
                  <xs:enumeration value="group"/>
                  <xs:enumeration value="module"/>
                </xs:restriction>
              </xs:simpleType>
            </xs:attribute>
          </xs:complexType>
        </xs:element>
      </xs:all>
      <xs:attribute name="time_units" type="time_unit_type" default="" use="optional"/>
      <xs:attribute name="method" type="method_type" default="euler" use="optional"/>
      <xs:attribute name="pause" type="xs:double" use="optional" default="INF"/>
    </xs:complexType>
  </xs:element>

 */

@XmlAccessorType(XmlAccessType.FIELD)
public class SimSpecs {
}
