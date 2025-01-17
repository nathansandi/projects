/**
 * GetClientByVatNumberRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package pt.victoria.hub.b2c.SmcService;

public class GetClientByVatNumberRequest  extends pt.victoria.hub.b2c.ws.common.AbstractWebRequest  implements java.io.Serializable {
    private java.lang.String vatNumber;

    public GetClientByVatNumberRequest() {
    }

    public GetClientByVatNumberRequest(
           java.lang.String webUser,
           java.lang.String applicationCode,
           java.lang.String vatNumber) {
        super(
            webUser,
            applicationCode);
        this.vatNumber = vatNumber;
    }


    /**
     * Gets the vatNumber value for this GetClientByVatNumberRequest.
     * 
     * @return vatNumber
     */
    public java.lang.String getVatNumber() {
        return vatNumber;
    }


    /**
     * Sets the vatNumber value for this GetClientByVatNumberRequest.
     * 
     * @param vatNumber
     */
    public void setVatNumber(java.lang.String vatNumber) {
        this.vatNumber = vatNumber;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetClientByVatNumberRequest)) return false;
        GetClientByVatNumberRequest other = (GetClientByVatNumberRequest) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.vatNumber==null && other.getVatNumber()==null) || 
             (this.vatNumber!=null &&
              this.vatNumber.equals(other.getVatNumber())));
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
        if (getVatNumber() != null) {
            _hashCode += getVatNumber().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetClientByVatNumberRequest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://b2c.hub.victoria.pt/SmcService/", ">GetClientByVatNumberRequest"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("vatNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("", "VatNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
