/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import rest.ALLMESSAGES;
import rest.Message;
import rest.MessagePost;

/**
 *
 * @author dongyinsheng
 */
public class MessageAll extends HttpServlet {

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
        ArrayList<MessagePost> toBePosted = new ArrayList();
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
            out.println("<div id=\"RetriveAllMessages\" data-role=\"page\">");
            out.println("<div data-role=\"header\"> <h1>All Messages</h1> </div> ");
            out.println("<div data-role=\"navbar\">");
            out.println("<ul>");
            out.println("<li><a href=\"http://localhost:8080/JQuery/\" data-icon=\"home\" data-transition=\"flow\">Home</a></li>");
            out.println("<li><a href=\"http://localhost:8080/JQuery/#addMessage\" data-icon=\"bullets\" data-transition=\"flow\">Add Message</a></li>");
            out.println("<li><a href=\"http://localhost:8080/350A4/MessageAll\" data-icon=\"bullets\" class=\"ui-btn-active ui-state-persist\" data-transition=\"flow\">All messages</a></li>");
            out.println("<li><a href=\"http://localhost:8080/350A4/MessageSinceLastRetrieve\" data-icon=\"bullets\" data-transition=\"flow\">New Message Since Last Retrieve</a></li>");
            out.println("<li><a href=\"http://localhost:8080/350A4/#messageById\" data-icon=\"bullets\" data-transition=\"flow\">Message By ID</a></li>");
            out.println("</ul>");
            out.println("</div>");
            out.println("<div data-role=\"content\"> ");
            out.println("<form class=\"ui-filterable\">");
            out.println("<input id=\"myFilter\" data-type=\"search\" placeholder=\"search by name\">");
            out.println("</form>");
            out.println("<ul data-role=\"listview\" data-filter=\"true\" data-input=\"#myFilter\" data-inset=\"true\">");  
        
            for ( MessagePost tbp : toBePosted){
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
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    private void changeTBP(ArrayList<MessagePost> toBePosted){
        ALLMESSAGES allmessages = new ALLMESSAGES();
         for ( Message ms : allmessages.getAllMessages()){
            boolean found = false;
            for ( MessagePost mp : toBePosted){
                // If id already exist, add the message under that id
                if (mp.ID == ms.ID){
                    mp.addMessage(ms.message);
                    found = true;
                }
            }
            // If id does not exist in toBePosted, create new and add it into it
            if(!found) {
                MessagePost mp = new MessagePost();
                mp.ID = ms.ID;
                mp.addMessage(ms.message);
                toBePosted.add(mp);
            }
        }
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
