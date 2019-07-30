/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import java.util.ArrayList;

/**
 *
 * @author duke
 */
public class MessageToBePosted {
    
    public int ID;
    public ArrayList<String> Message;
    public MessageToBePosted () {
        this.ID = 0;
        this.Message = new ArrayList();
    }
    
    public void addMessage(String message){
        this.Message.add(message);
    }
    
}
