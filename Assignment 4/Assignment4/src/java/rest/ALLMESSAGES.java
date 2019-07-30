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
    
    GoConnection connection = new GoConnection();
    
    @GET  
    @Produces(MediaType.TEXT_PLAIN)  
    public ArrayList<IDMessage> sayHello() {   
        ArrayList<IDMessage> info = new ArrayList();
        connection.connect();
        try{
          String Query = "select * from web_server";
          Statement stmt = connection.coon.createStatement();
          ResultSet rs = stmt.executeQuery(Query);
          if(rs.next()){
            IDMessage temp = new IDMessage(rs.getInt("id"), rs.getString("message"));
            info.add(temp);
            while (rs.next()){
                temp = new IDMessage(rs.getInt("id"), rs.getString("message"));
                info.add(temp);
            }
          }
          connection.coon.close();
        }catch (SQLException e){
            e.fillInStackTrace();
        }
        return info ;  
    }  
         
}