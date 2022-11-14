/**
 * Socio.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package publicadores;

public class Socio  extends publicadores.Usuario  implements java.io.Serializable {
    private publicadores.Registro[] registros;

    public Socio() {
    }

    public Socio(
           java.lang.String apellido,
           java.lang.String email,
           java.util.Calendar fecha,
           java.lang.String nickname,
           java.lang.String nombre,
           java.lang.String password,
           byte[] profileImage,
           publicadores.Registro[] registros) {
        super(
            apellido,
            email,
            fecha,
            nickname,
            nombre,
            password,
            profileImage);
        this.registros = registros;
    }


    /**
     * Gets the registros value for this Socio.
     * 
     * @return registros
     */
    public publicadores.Registro[] getRegistros() {
        return registros;
    }


    /**
     * Sets the registros value for this Socio.
     * 
     * @param registros
     */
    public void setRegistros(publicadores.Registro[] registros) {
        this.registros = registros;
    }

    public publicadores.Registro getRegistros(int i) {
        return this.registros[i];
    }

    public void setRegistros(int i, publicadores.Registro _value) {
        this.registros[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Socio)) return false;
        Socio other = (Socio) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.registros==null && other.getRegistros()==null) || 
             (this.registros!=null &&
              java.util.Arrays.equals(this.registros, other.getRegistros())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = super.hashCode();
        if (getRegistros() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getRegistros());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getRegistros(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Socio.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://publicadores/", "socio"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("registros");
        elemField.setXmlName(new javax.xml.namespace.QName("", "registros"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://publicadores/", "registro"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
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
