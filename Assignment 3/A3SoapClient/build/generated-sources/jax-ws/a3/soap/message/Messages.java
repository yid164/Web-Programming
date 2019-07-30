
package a3.soap.message;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.11-b150120.1832
 * Generated source version: 2.2
 * 
 */
@WebService(name = "Messages", targetNamespace = "http://message.soap.a3/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface Messages {


    /**
     * 
     * @param newMessage
     */
    @WebMethod
    @RequestWrapper(localName = "addMessage", targetNamespace = "http://message.soap.a3/", className = "a3.soap.message.AddMessage")
    @ResponseWrapper(localName = "addMessageResponse", targetNamespace = "http://message.soap.a3/", className = "a3.soap.message.AddMessageResponse")
    @Action(input = "http://message.soap.a3/Messages/addMessageRequest", output = "http://message.soap.a3/Messages/addMessageResponse")
    public void addMessage(
        @WebParam(name = "newMessage", targetNamespace = "")
        String newMessage);

    /**
     * 
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "showAllMessage", targetNamespace = "http://message.soap.a3/", className = "a3.soap.message.ShowAllMessage")
    @ResponseWrapper(localName = "showAllMessageResponse", targetNamespace = "http://message.soap.a3/", className = "a3.soap.message.ShowAllMessageResponse")
    @Action(input = "http://message.soap.a3/Messages/showAllMessageRequest", output = "http://message.soap.a3/Messages/showAllMessageResponse")
    public String showAllMessage();

}
