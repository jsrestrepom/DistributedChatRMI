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
        boolean typing = true;
        while (typing) {
            try {
                keyboard = bufer.readLine();
                if (keyboard.length() > 0) {
                    if (keyboard.equals("/halt")) {
                        typing = false;
                        continue;
                    }
                    myMessage.send(username + ": " + keyboard);
                }
            } catch (IOException e) {
                continue;
            }
        }
    }
    
}
