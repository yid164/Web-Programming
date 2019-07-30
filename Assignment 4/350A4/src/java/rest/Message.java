/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

/**
 *
 * @author dongyinsheng
 */
public class Message {
    public int ID;
    public String message;
    public Message(int ID, String message){
        this.ID = ID;
        this.message = message;
    }
    
    public String toString()
    {
        return this.ID + this.message;
    }
    
}
