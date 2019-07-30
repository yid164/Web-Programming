/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author dongyinsheng
 */
@Path("/messagesController")
public class MessagesController {
  
    @GET
    @Path("/getAllMessages")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<MessagesModel> getAllMessageInJSON() throws ClassNotFoundException, SQLException
    {

        ArrayList<MessagesModel> list = new ArrayList<MessagesModel>();
        Connection con = null;
        String username = "root";
        String password = "iloveyou00";
        String query = "select message, id from messages";
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull",username,password);
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        while(rs.next())
        {
            MessagesModel mm = new MessagesModel();
            mm.setMessage(rs.getString("message"));
            mm.setId(rs.getInt("id"));
            list.add(mm);
        }
        //GenericEntity generic = new GenericEntity<List<MessagesModel>>(list){};
        return list;
    }
    
    
    @POST
    @Path("/addMessage")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addMessageInJSON(MessagesModel message) throws ClassNotFoundException, SQLException
    {
        //MessagesModel mm = new MessagesModel();
        //mm.setMessage(message);
        Connection con = null;
        String username = "root";
        String password = "iloveyou00";
        String query = "insert into mysql.messages (message, id) values(?,?)";
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull",username,password);
        PreparedStatement pst = con.prepareStatement(query);
        pst.setString(1, message.getMessage());
        pst.setInt(2, message.getId());
        int i = pst.executeUpdate();
        String result = "";
        if(i>0)
        {
            result = "Message saved : " + message.getMessage();
        }
	return Response.status(201).entity(result).build();
    }
    
    @GET
    @Path("/countMessages")
    //@Produces(MediaType.APPLICATION_JSON)
    public int countMessages() throws SQLException, ClassNotFoundException
    {
        Connection con = null;
        String username = "root";
        String password = "iloveyou00";
        String query = "SELECT COUNT(message) FROM mysql.messages";
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull",username,password);
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        int i = 0;
        if(rs.next())
        {
            i = rs.getInt(1);
        }
        return i;
    }
}
