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
public class GetCountNumber {
    
    public static int countNumber()
    {
        Client client = Client.create();
            
        WebResource webResource = client.resource("http://localhost:8081/A3-RestService/webresources/messagesController/countMessages");
            
        ClientResponse response = webResource.get(ClientResponse.class);
        
        if(response.getStatus()!=200)
        {
            throw new RuntimeException("Failed: HTTP error code: "+ response.getStatus());
        }
        String number = response.getEntity(String.class);
        int countNumber = Integer.parseInt(number);
        
        return countNumber;
    }
    public static void main(String args[])
    {
        System.out.println(countNumber());
    }
}
