/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;




/**
 *
 * @author dongyinsheng
 */
public class AddMessages {
    
    public static void AddMessages(String message)
    {
        int id = GetCountNumber.countNumber()+1;
        try {

           Client client = Client.create();
	   WebResource webResource = client.resource("http://localhost:8081/A3-RestService/webresources/messagesController/addMessage");
           String input = "{\"id\":"+id+",\"message\":\""+message+"\"}";
           ClientResponse response = webResource.type("application/json").post(ClientResponse.class, input);
           if (response.getStatus() != 201) {
		throw new RuntimeException("Failed : HTTP error code : "
			     + response.getStatus() + response.getLanguage());
           }
           System.out.println("Output from Server .... \n");
           String output = response.getEntity(String.class);
           System.out.println(output);

	  } catch (Exception e) {

		e.printStackTrace();

	  }
    }
    
    public static void main(String args[])
    {
        AddMessages.AddMessages("lll");
    }
    
}
