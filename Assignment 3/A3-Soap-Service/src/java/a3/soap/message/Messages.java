/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a3.soap.message;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.annotation.Resource;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.sql.DataSource;

/**
 *
 * @author dongyinsheng
 */
@WebService(serviceName = "Messages")
public class Messages {

    @Resource(name = "messages")
    private DataSource messages;

    /**
     * Web service operation
     */
    @WebMethod(operationName = "addMessage")
    public void addMessage(@WebParam(name = "newMessage") String newMessage){
        try {
            //TODO write your implementation code here:
            Connection con = messages.getConnection();
            PreparedStatement ps = con.prepareStatement("insert into messages(message) values(?)");
            ps.setString(1,newMessage);
            ps.executeUpdate();
            
        } catch (SQLException ex) {
            System.err.println(ex.getNextException());
        }
    }

    /**
     * Web service operation
     * @return 
     */
    @WebMethod(operationName = "showAllMessage")
    public String showAllMessage(){
        String list = "";
        try {
            //TODO write your implementation code here:
            Connection con = messages.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select message from messages");
            while(rs.next())
            {
                list  += rs.getString("message") +"\t";
            }
        } catch (SQLException ex) {
            System.err.print(ex.getNextException());
        }
        return list;
    }
}
