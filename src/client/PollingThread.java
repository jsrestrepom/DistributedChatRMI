/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package client;


import java.lang.Runnable;
import java.lang.Thread;
import java.util.ArrayList;
import contract.IChatMessage;
/**
 *
 * @author jrestr76
 */
public class PollingThread implements Runnable {
    private IChatMessage myMessage;
    private String username;
    private int lastMessage;
    
    public PollingThread(IChatMessage remote, String username) {
        this.myMessage = remote;
        this.username = username;
        this.lastMessage = 0;
    }
    
    @Override
    public void run() {
        ArrayList log;
        int last;
        while (true) {      // Doing polling
            try {
                log = myMessage.pull();
                for (last = lastMessage ; log.size() > last ; last++) {
                    System.out.println(log.get(last));
                }
                lastMessage = last;
                Thread.sleep(4000);
//            } catch (InterruptedException e) {
//                continue;   //System.err.println(e.getMessage());
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }            
        }
    }
    
}
