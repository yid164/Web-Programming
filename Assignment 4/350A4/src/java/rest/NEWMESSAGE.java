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

/**
 *
 * @author dongyinsheng
 */

@Path("/NEWMESSAGE")
public class NEWMESSAGE {
    
    public String gg = "";
    
    @POST
    @Path("/add")
    @Produces("text/plain;charset=utf-8")
    public String add(@FormParam("Message") String message, @FormParam("ID") String ID){
        try{
            String Query = "insert into  A4DB (Message, ID) values (?, ?)";
            PreparedStatement statement = GoConnection.connect().prepareStatement(Query);
            statement.setString(1, message);
            statement.setInt(2, Integer.parseInt(ID));
            statement.executeUpdate();
            //GoConnection.connect().close();
        }catch (SQLException e){
            e.fillInStackTrace();
        }
        return "MESSAGE INSERT SUCCESS";
    }
    
    public static void main(String[] args)
    {
        NEWMESSAGE n = new NEWMESSAGE();
        System.out.println(n.add("JJJ", "10"));
    }
    
}
