/**
 * InstitucionDeportiva.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package publicadores;

public class InstitucionDeportiva  implements java.io.Serializable {
    private publicadores.ActividadDeportiva[] actividadesDeportivas;

    private java.lang.String descripcion;

    private java.lang.String nombre;

    private publicadores.Profesor[] profesores;

    private java.lang.String url;

    public InstitucionDeportiva() {
    }

    public InstitucionDeportiva(
           publicadores.ActividadDeportiva[] actividadesDeportivas,
           java.lang.String descripcion,
           java.lang.String nombre,
           publicadores.Profesor[] profesores,
           java.lang.String url) {
           this.actividadesDeportivas = actividadesDeportivas;
           this.descripcion = descripcion;
           this.nombre = nombre;
           this.profesores = profesores;
           this.url = url;
    }


    /**
     * Gets the actividadesDeportivas value for this InstitucionDeportiva.
     * 
     * @return actividadesDeportivas
     */
    public publicadores.ActividadDeportiva[] getActividadesDeportivas() {
        return actividadesDeportivas;
    }


    /**
     * Sets the actividadesDeportivas value for this InstitucionDeportiva.
     * 
     * @param actividadesDeportivas
     */
    public void setActividadesDeportivas(publicadores.ActividadDeportiva[] actividadesDeportivas) {
        this.actividadesDeportivas = actividadesDeportivas;
    }

    public publicadores.ActividadDeportiva getActividadesDeportivas(int i) {
        return this.actividadesDeportivas[i];
    }

    public void setActividadesDeportivas(int i, publicadores.ActividadDeportiva _value) {
        this.actividadesDeportivas[i] = _value;
    }


    /**
     * Gets the descripcion value for this InstitucionDeportiva.
     * 
     * @return descripcion
     */
    public java.lang.String getDescripcion() {
        return descripcion;
    }


    /**
     * Sets the descripcion value for this InstitucionDeportiva.
     * 
     * @param descripcion
     */
    public void setDescripcion(java.lang.String descripcion) {
        this.descripcion = descripcion;
    }


    /**
     * Gets the nombre value for this InstitucionDeportiva.
     * 
     * @return nombre
     */
    public java.lang.String getNombre() {
        return nombre;
    }


    /**
     * Sets the nombre value for this InstitucionDeportiva.
     * 
     * @param nombre
     */
    public void setNombre(java.lang.String nombre) {
        this.nombre = nombre;
    }


    /**
     * Gets the profesores value for this InstitucionDeportiva.
     * 
     * @return profesores
     */
    public publicadores.Profesor[] getProfesores() {
        return profesores;
    }


    /**
     * Sets the profesores value for this InstitucionDeportiva.
     * 
     * @param profesores
     */
    public void setProfesores(publicadores.Profesor[] profesores) {
        this.profesores = profesores;
    }

    public publicadores.Profesor getProfesores(int i) {
        return this.profesores[i];
    }

    public void setProfesores(int i, publicadores.Profesor _value) {
        this.profesores[i] = _value;
    }


    /**
     * Gets the url value for this InstitucionDeportiva.
     * 
     * @return url
     */
    public java.lang.String getUrl() {
        return url;
    }


    /**
     * Sets the url value for this InstitucionDeportiva.
     * 
     * @param url
     */
    public void setUrl(java.lang.String url) {
        this.url = url;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof InstitucionDeportiva)) return false;
        InstitucionDeportiva other = (InstitucionDeportiva) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.actividadesDeportivas==null && other.getActividadesDeportivas()==null) || 
             (this.actividadesDeportivas!=null &&
              java.util.Arrays.equals(this.actividadesDeportivas, other.getActividadesDeportivas()))) &&
            ((this.descripcion==null && other.getDescripcion()==null) || 
             (this.descripcion!=null &&
              this.descripcion.equals(other.getDescripcion()))) &&
            ((this.nombre==null && other.getNombre()==null) || 
             (this.nombre!=null &&
              this.nombre.equals(other.getNombre()))) &&
            ((this.profesores==null && other.getProfesores()==null) || 
             (this.profesores!=null &&
              java.util.Arrays.equals(this.profesores, other.getProfesores()))) &&
            ((this.url==null && other.getUrl()==null) || 
             (this.url!=null &&
              this.url.equals(other.getUrl())));
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
        if (getActividadesDeportivas() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getActividadesDeportivas());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getActividadesDeportivas(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDescripcion() != null) {
            _hashCode += getDescripcion().hashCode();
        }
        if (getNombre() != null) {
            _hashCode += getNombre().hashCode();
        }
        if (getProfesores() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getProfesores());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getProfesores(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getUrl() != null) {
            _hashCode += getUrl().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(InstitucionDeportiva.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://publicadores/", "institucionDeportiva"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("actividadesDeportivas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "actividadesDeportivas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://publicadores/", "actividadDeportiva"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("descripcion");
        elemField.setXmlName(new javax.xml.namespace.QName("", "descripcion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nombre");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nombre"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("profesores");
        elemField.setXmlName(new javax.xml.namespace.QName("", "profesores"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://publicadores/", "profesor"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("url");
        elemField.setXmlName(new javax.xml.namespace.QName("", "url"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
