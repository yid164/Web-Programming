/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;


import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import java.util.List;

/**
 *
 * @author dongyinsheng
 */
public class DisplayAllMessages {
    
    public static String allMessages()
    {
        String list = "";
        try{
            //ArrayList<MessagesModel> list =new ArrayList<MessagesModel>();
            Client client = Client.create();
            
            WebResource webResource = client.resource("http://localhost:8081/A3-RestService/webresources/messagesController/getAllMessages");
            
            ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);
            
            /**
            if(response.getStatus()!=201||response.getStatus()!=200)
            {
                throw new RuntimeException("Failed: HTTP error code: "+ response.getStatus());
            }
            * **/
            //ArrayList<String> list = response.getEntity(ArrayList.class);
            /**List<MessagesModel> messages
            = response.getEntity(new GenericType<List<MessagesModel>>(){});
            //System.out.println("Output from server ... \n");
            //System.out.println(list);
            StringBuilder builder = new StringBuilder("=== Messages ===\n");
            for (MessagesModel u: messages) {
            builder.append("Name: ").append(u.getMessage()).append("\n");   
            builder.append("==================");
            System.out.println(builder.toString());
            }
            **/
            if(response.getStatus()!=200)
            {
                throw new RuntimeException("Failed: HTTP error code: "+ response.getStatus());
            }
            
            list = response.getEntity(String.class);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return list;
    }
    
    public static void main(String args[])
    {
        allMessages();
    }
    
}
