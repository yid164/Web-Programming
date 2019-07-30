package rest;


import java.util.Properties;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dongyinsheng
 */
@Path("/PubgService")
public class PubgService {
    
    @Path("/UserSendFeedback")
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public String UserSendFeedback(@FormParam("username") String username,@FormParam("userEmailAddress")String userEmailAddress, @FormParam("userFeedback")String userFeedback)
    {
        Properties props = new Properties();
        props.setProperty ("mail.transport.protocol", "smtp");
        props.setProperty("mail.smtp.host", "smtp.gmail.com");
        props.setProperty("mail.smtp.auth", "true");
        props.setProperty("mail.smtp.port", "" + 587);
        props.setProperty("mail.smtp.starttls.enable", "true");
        
        Session mailSession = Session.getDefaultInstance(props,new javax.mail.Authenticator()
        {
            @Override
            protected PasswordAuthentication getPasswordAuthentication()
            {
                return new PasswordAuthentication("coldfireworkk", "YS3062512189");
            }
        });
        
        mailSession.setDebug(true);
        
        try
        {
            Transport transport = mailSession.getTransport();
            MimeMessage message = new MimeMessage(mailSession);
            message.setSubject("User Feedback From: "+ username +" ("+ userEmailAddress+")");
            InternetAddress address = new InternetAddress("Team@FOS.com");
            message.setFrom(address);
            message.setContent("<h1>User Feedback</h1>\n"+userFeedback,"text/html");
            message.addRecipient (Message.RecipientType.TO,
                                  new InternetAddress ("smallofyou@gmail.com"));
            transport.connect();
            transport.sendMessage(message, message.getRecipients (Message.RecipientType.TO));

        }
        catch (MessagingException e)
        {
            System.out.println(e.toString());
        }

        Logger.getAnonymousLogger().info("Email has been sent to our team");
        return "Email has been sent to our team";
        
    }
    
    public static void main(String []args)
    {
        PubgService ps = new PubgService();
        ps.UserSendFeedback("HI", "smallofyou@gmail.com", "good");
    }
}
