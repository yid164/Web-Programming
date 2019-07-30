/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import rest.ALLMESSAGES;
import rest.NEWMESSAGE;

/**
 *
 * @author dongyinsheng
 */
public class test {
    
    public static void main(String []args)
    {
        NEWMESSAGE add = new NEWMESSAGE();
        add.add("Hello", "9");
        System.out.println(add.gg);
    }
    
}
