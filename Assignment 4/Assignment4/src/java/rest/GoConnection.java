/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

/**
 *
 * @author duke
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GoConnection
{

    /**
     * connection
     */
    public Connection coon = null;

    /**
     * username and password filed
     * @return
     */
    public Connection connect()
    {
        String databaseURL = "jdbc:postgresql://elmer.db.elephantsql.com:5432/hblzndoa";
        String user = "hblzndoa";
        String password = "PvfVbBZmOnuFI3haPfT3h4So7RhG_7Kk";
        // the driver is very important
        try
        {
            Class.forName("org.postgresql.Driver");
        }
        catch (Exception e)
        {
            // fail message
            System.err.println("Fail to connect:"+e.getMessage());
        }
        try
        {
            // make the connection
            coon = DriverManager.getConnection(databaseURL,user,password);

        }
        catch (SQLException se)
        {
            se.printStackTrace();
        }
        return coon;
    }
}