/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.ws.rs.GET;  
import javax.ws.rs.Produces;  
import javax.ws.rs.core.MediaType;  
  
public class ALLMESSAGES {  
    
    
    @GET  
    @Produces(MediaType.TEXT_PLAIN)  
    public ArrayList<Message> getAllMessages() {   
        ArrayList<Message> info = new ArrayList();
        try{
          String Query = "select * from A4DB";
          Statement stmt = GoConnection.connect().createStatement();
          ResultSet rs = stmt.executeQuery(Query);
            while (rs.next()){
                Message ms = new Message(rs.getInt("id"), rs.getString("message"));
                info.add(ms);
            }
          GoConnection.connect().close();
        }catch (SQLException e){
            e.fillInStackTrace();
        }
        return info ;  
    }  
         
}