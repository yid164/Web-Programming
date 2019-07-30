/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import rest.ALLMESSAGES;
import rest.IDMessage;
import rest.MessageToBePosted;

/**
 *
 * @author duke
 */
@WebServlet(name = "RetrieveMessageSinceLastVisit", urlPatterns = {"/RetrieveMessageSinceLastVisit"})
public class RetrieveMessageSinceLastVisit extends HttpServlet {
    
    int i = 0;
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        ArrayList<MessageToBePosted> toBePosted = new ArrayList();
        changeTBP(toBePosted);
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");            
            out.println("<link rel=\"stylesheet\" href=\"http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css\">");
            out.println("<script src=\"http://code.jquery.com/jquery-1.11.3.min.js\"></script>");
            out.println("<script src=\"http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js\"></script>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div id=\"RetrieveMessageSinceLastVisit\" data-role=\"page\">");
            out.println("<div data-role=\"header\"> <h1>What is newly posted</h1> </div> ");
            out.println("<div data-role=\"navbar\">");
            out.println("<ul>");
            out.println("<li><a href=\"http://localhost:8080/JQuery/\" data-icon=\"home\" data-transition=\"flow\">Main Page</a></li>");
            out.println("<li><a href=\"http://localhost:8080/JQuery/#PostMessageWithID\" data-icon=\"arrow-r\" data-transition=\"flow\">Post Message</a></li>");
            out.println("<li><a href=\"http://localhost:8080/Assignment4/RetriveAllMessages\" data-icon=\"arrow-r\" data-transition=\"flow\">All messages</a></li>");
            out.println("<li><a href=\"http://localhost:8080/Assignment4/RetrieveMessageSinceLastVisit\" class=\"ui-btn-active ui-state-persist\" data-icon=\"arrow-r\" data-transition=\"flow\">What's new</a></li>");
            out.println("<li><a href=\"http://localhost:8080/Assignment4/#LISTS\" data-icon=\"arrow-r\" data-transition=\"flow\">Messages in List</a></li>");
            out.println("</ul>");
            out.println("</div>");
            out.println("<div data-role=\"content\"> ");
            out.println("<form class=\"ui-filterable\">");
            out.println("<input id=\"myFilter\" data-type=\"search\" placeholder=\"search by name\">");
            out.println("</form>");
            out.println("<ul data-role=\"listview\" data-filter=\"true\" data-input=\"#myFilter\" data-inset=\"true\">");
            
            for ( MessageToBePosted tbp : toBePosted){
                out.println("<div data-role=\"collapsible\">");
                out.println("<h4>ID: " + tbp.ID + "</h4>");
                out.println("<ul data-role=\"listview\">");
                for (String msg : tbp.Message){
                    out.println("<li>" + msg + "</li>");
                }
                out.println(" </ul>");
                out.println("</div>");
            } 
            
            out.println("</ul>");
            out.println("</div>");
            out.println("<div data-role=\"footer\"> ");
            out.println("<h1>Created by Duke Rong </h1> ");
            out.println("</div>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    private void changeTBP(ArrayList<MessageToBePosted> toBePosted){
        ALLMESSAGES allmessages = new ALLMESSAGES();
        List<IDMessage> temp = allmessages.sayHello().subList(i, allmessages.sayHello().size());
         for ( IDMessage idm : temp){
            boolean found = false;
            for ( MessageToBePosted tbp : toBePosted){
                // If id already exist, add the message under that id
                if (tbp.ID == idm.ID){
                    tbp.addMessage(idm.message);
                    found = true;
                }
            }
            // If id does not exist in toBePosted, create new and add it into it
            if(!found) {
                MessageToBePosted mtbp = new MessageToBePosted();
                mtbp.ID = idm.ID;
                mtbp.addMessage(idm.message);
                toBePosted.add(mtbp);
            }
         }
        i = allmessages.sayHello().size();
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
