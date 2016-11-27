
package org.java.webservice.permission.service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.java.webservice.permission.service package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetUploadAuth_QNAME = new QName("http://service.java.org/", "getUploadAuth");
    private final static QName _GetUploadAuthResponse_QNAME = new QName("http://service.java.org/", "getUploadAuthResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.java.webservice.permission.service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetUploadAuth }
     * 
     */
    public GetUploadAuth createGetUploadAuth() {
        return new GetUploadAuth();
    }

    /**
     * Create an instance of {@link GetUploadAuthResponse }
     * 
     */
    public GetUploadAuthResponse createGetUploadAuthResponse() {
        return new GetUploadAuthResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUploadAuth }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.java.org/", name = "getUploadAuth")
    public JAXBElement<GetUploadAuth> createGetUploadAuth(GetUploadAuth value) {
        return new JAXBElement<GetUploadAuth>(_GetUploadAuth_QNAME, GetUploadAuth.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUploadAuthResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.java.org/", name = "getUploadAuthResponse")
    public JAXBElement<GetUploadAuthResponse> createGetUploadAuthResponse(GetUploadAuthResponse value) {
        return new JAXBElement<GetUploadAuthResponse>(_GetUploadAuthResponse_QNAME, GetUploadAuthResponse.class, null, value);
    }

}
