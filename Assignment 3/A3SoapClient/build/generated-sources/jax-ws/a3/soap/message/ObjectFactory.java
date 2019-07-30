
package a3.soap.message;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the a3.soap.message package. 
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

    private final static QName _AddMessage_QNAME = new QName("http://message.soap.a3/", "addMessage");
    private final static QName _AddMessageResponse_QNAME = new QName("http://message.soap.a3/", "addMessageResponse");
    private final static QName _ShowAllMessage_QNAME = new QName("http://message.soap.a3/", "showAllMessage");
    private final static QName _ShowAllMessageResponse_QNAME = new QName("http://message.soap.a3/", "showAllMessageResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: a3.soap.message
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AddMessage }
     * 
     */
    public AddMessage createAddMessage() {
        return new AddMessage();
    }

    /**
     * Create an instance of {@link AddMessageResponse }
     * 
     */
    public AddMessageResponse createAddMessageResponse() {
        return new AddMessageResponse();
    }

    /**
     * Create an instance of {@link ShowAllMessage }
     * 
     */
    public ShowAllMessage createShowAllMessage() {
        return new ShowAllMessage();
    }

    /**
     * Create an instance of {@link ShowAllMessageResponse }
     * 
     */
    public ShowAllMessageResponse createShowAllMessageResponse() {
        return new ShowAllMessageResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddMessage }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://message.soap.a3/", name = "addMessage")
    public JAXBElement<AddMessage> createAddMessage(AddMessage value) {
        return new JAXBElement<AddMessage>(_AddMessage_QNAME, AddMessage.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddMessageResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://message.soap.a3/", name = "addMessageResponse")
    public JAXBElement<AddMessageResponse> createAddMessageResponse(AddMessageResponse value) {
        return new JAXBElement<AddMessageResponse>(_AddMessageResponse_QNAME, AddMessageResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ShowAllMessage }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://message.soap.a3/", name = "showAllMessage")
    public JAXBElement<ShowAllMessage> createShowAllMessage(ShowAllMessage value) {
        return new JAXBElement<ShowAllMessage>(_ShowAllMessage_QNAME, ShowAllMessage.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ShowAllMessageResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://message.soap.a3/", name = "showAllMessageResponse")
    public JAXBElement<ShowAllMessageResponse> createShowAllMessageResponse(ShowAllMessageResponse value) {
        return new JAXBElement<ShowAllMessageResponse>(_ShowAllMessageResponse_QNAME, ShowAllMessageResponse.class, null, value);
    }

}
