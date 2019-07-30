/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a3;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author dongyinsheng
 */
@Path("/messages")
public class Messages {
    
    @GET
    @Path("/getMessage")
    @Produces(MediaType.APPLICATION_JSON)
    public String getMessageInJSON()
    {
        return "hello";
    }
    
}
