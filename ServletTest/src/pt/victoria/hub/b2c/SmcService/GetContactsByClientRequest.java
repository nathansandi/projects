/**
 * GetContactsByClientRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package pt.victoria.hub.b2c.SmcService;

public class GetContactsByClientRequest  extends pt.victoria.hub.b2c.ws.common.AbstractWebRequest  implements java.io.Serializable {
    private pt.victoria.hub.Model.Client.Client client;

    public GetContactsByClientRequest() {
    }

    public GetContactsByClientRequest(
           java.lang.String webUser,
           java.lang.String applicationCode,
           pt.victoria.hub.Model.Client.Client client) {
        super(
            webUser,
            applicationCode);
        this.client = client;
    }


    /**
     * Gets the client value for this GetContactsByClientRequest.
     * 
     * @return client
     */
    public pt.victoria.hub.Model.Client.Client getClient() {
        return client;
    }


    /**
     * Sets the client value for this GetContactsByClientRequest.
     * 
     * @param client
     */
    public void setClient(pt.victoria.hub.Model.Client.Client client) {
        this.client = client;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetContactsByClientRequest)) return false;
        GetContactsByClientRequest other = (GetContactsByClientRequest) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.client==null && other.getClient()==null) || 
             (this.client!=null &&
              this.client.equals(other.getClient())));
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
        if (getClient() != null) {
            _hashCode += getClient().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetContactsByClientRequest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://b2c.hub.victoria.pt/SmcService/", ">GetContactsByClientRequest"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("client");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Client"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://hub.victoria.pt/Model/Client/", "Client"));
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
