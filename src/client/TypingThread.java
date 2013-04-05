/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package client;


import java.io.*;
import java.lang.Runnable;
import contract.IChatMessage;
/**
 *
 * @author jrestr76
 */
public class TypingThread implements Runnable {
    private IChatMessage myMessage;
    private String username;
    
    public TypingThread(IChatMessage remote, String username) {
        this.myMessage = remote;
        this.username = username;
    }
    
    @Override
    public void run() {
        BufferedReader bufer = new BufferedReader(new InputStreamReader(System.in));
        String keyboard;
        do {
            try {
                System.out.print(username + ": ");
                keyboard = bufer.readLine();
                myMessage.send(keyboard);
            } catch (IOException e) {
                keyboard = "";
            }
        } while (!keyboard.equals("/halt"));
        System.out.println("=> Process terminated.");
    }
    
}
