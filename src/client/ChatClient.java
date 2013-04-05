/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package client;


import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import contract.IChatMessage;
/**
 *
 * @author jrestr76
 */
public class ChatClient {
    
    private IChatMessage connect(String host, int port, String chatRoom) {
        try {
                // create stub on port
            Registry stub = LocateRegistry.getRegistry(host, port);
                // search for broadcast service
            IChatMessage objRemote = (IChatMessage) stub.lookup(chatRoom);
            return objRemote;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }
    
    public static void main(String[] args) {
        ChatClient myClient;
        String h, u;                // h:host u:username
        int p;                      // p:port
        if (args.length >= 3) {
            u = args[0];
            try {
                h = args[1];
                p = Integer.parseInt(args[2]);
            } catch (Exception e) {
                h = "127.0.0.1";
                p = 1099;
            }
            myClient = new ChatClient();
            IChatMessage objRemote = myClient.connect(h, p, "broadcast");
            if (objRemote == null) {
                System.out.println("=> Incorrect host or port.");
            } else {
                System.out.println("=> Connection succesful.");
                Thread[] t = new Thread[2];
                t[0] = new Thread( new PollingThread(objRemote, u) );
                t[1] = new Thread( new TypingThread(objRemote, u) );
                
                t[0].start();
                t[1].start();
                
                while (t[1].isAlive()) {}
                t[0].interrupt();
                System.out.println("=> Process terminated.");
            }
        } else {
            System.out.println("=> Not enough information, hots and port required.");
        }
    }
    
}
