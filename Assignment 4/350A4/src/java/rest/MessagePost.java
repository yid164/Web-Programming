/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import java.util.ArrayList;

/**
 *
 * @author dongyinsheng
 */
public class MessagePost {
    public int ID;
    public ArrayList<String> Message;
    public MessagePost () {
        this.ID = 0;
        this.Message = new ArrayList();
    }
    
    public void addMessage(String message){
        this.Message.add(message);
    }
}
