/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.ws.rs.FormParam;  
import javax.ws.rs.POST;
import javax.ws.rs.Path;  
import javax.ws.rs.Produces;  
  

@Path("/NEWMESSAGE")  
public class NEWMESSAGE {
        
    GoConnection connection = new GoConnection();
    
    public String gg = "";
    
    @POST
    @Path("/add")
    @Produces("text/plain;charset=utf-8")
    public String add(@FormParam("Message") String message, @FormParam("ID") String ID){
        connection.connect();
        try{
            String Query = "insert into web_server (message, id) values (?, ?)";
            PreparedStatement statement = connection.coon.prepareStatement(Query);
            statement.setString(1, message);
            statement.setInt(2, Integer.parseInt(ID));
            statement.executeUpdate();
            connection.coon.close();
        }catch (SQLException e){
            e.fillInStackTrace();
        }
        return "MESSAGE INSERT SUCCESS";
    }
      
}