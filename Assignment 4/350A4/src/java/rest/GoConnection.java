/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author dongyinsheng
 */
public class GoConnection {
    
    
    public static Connection connect()
    {
        Connection coon = null;
        String username = "abc";
        String password = "abc";
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            coon = DriverManager.getConnection("jdbc:derby://localhost:1527/A4DB",username,password);
        }catch(ClassNotFoundException ce)
        {
            System.out.println(ce.getException());
        }catch(SQLException se)
        {
            System.out.println(se.getSQLState());
        }
        return coon;
    }
    
    public static void main(String args[]) throws SQLException
    {
        Statement st = GoConnection.connect().createStatement();
        String query = "select * from A4DB";
        ResultSet rs = st.executeQuery(query);
        while(rs.next())
        {
            System.out.println(rs.getInt("ID"));
        }
        
    }
}
