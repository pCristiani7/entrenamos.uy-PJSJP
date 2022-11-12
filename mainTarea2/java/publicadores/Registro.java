/**
 * Registro.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package publicadores;

public class Registro  implements java.io.Serializable {
    private publicadores.Clase clase;

    private java.util.Calendar fecha;

    private publicadores.Socio socio;

    public Registro() {
    }

    public Registro(
           publicadores.Clase clase,
           java.util.Calendar fecha,
           publicadores.Socio socio) {
           this.clase = clase;
           this.fecha = fecha;
           this.socio = socio;
    }


    /**
     * Gets the clase value for this Registro.
     * 
     * @return clase
     */
    public publicadores.Clase getClase() {
        return clase;
    }


    /**
     * Sets the clase value for this Registro.
     * 
     * @param clase
     */
    public void setClase(publicadores.Clase clase) {
        this.clase = clase;
    }


    /**
     * Gets the fecha value for this Registro.
     * 
     * @return fecha
     */
    public java.util.Calendar getFecha() {
        return fecha;
    }


    /**
     * Sets the fecha value for this Registro.
     * 
     * @param fecha
     */
    public void setFecha(java.util.Calendar fecha) {
        this.fecha = fecha;
    }


    /**
     * Gets the socio value for this Registro.
     * 
     * @return socio
     */
    public publicadores.Socio getSocio() {
        return socio;
    }


    /**
     * Sets the socio value for this Registro.
     * 
     * @param socio
     */
    public void setSocio(publicadores.Socio socio) {
        this.socio = socio;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Registro)) return false;
        Registro other = (Registro) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.clase==null && other.getClase()==null) || 
             (this.clase!=null &&
              this.clase.equals(other.getClase()))) &&
            ((this.fecha==null && other.getFecha()==null) || 
             (this.fecha!=null &&
              this.fecha.equals(other.getFecha()))) &&
            ((this.socio==null && other.getSocio()==null) || 
             (this.socio!=null &&
              this.socio.equals(other.getSocio())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getClase() != null) {
            _hashCode += getClase().hashCode();
        }
        if (getFecha() != null) {
            _hashCode += getFecha().hashCode();
        }
        if (getSocio() != null) {
            _hashCode += getSocio().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Registro.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://publicadores/", "registro"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("clase");
        elemField.setXmlName(new javax.xml.namespace.QName("", "clase"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://publicadores/", "clase"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fecha");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fecha"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("socio");
        elemField.setXmlName(new javax.xml.namespace.QName("", "socio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://publicadores/", "socio"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
