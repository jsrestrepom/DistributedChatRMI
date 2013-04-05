/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server;


import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
/**
 *
 * @author jrestr76
 */
public class ChatServer {
    private int PORT;
    
    public ChatServer() {
        this.PORT = 1099;
    }
    public ChatServer(int port) {
        this.PORT = port;
    }
    
    private void startServer() {
        try {
                // create stub on port
            Registry stub = LocateRegistry.createRegistry(PORT);
                // create a new service on public room
            stub.bind("broadcast", new ChatMessage());
            System.out.println("=> Server running on port " + PORT + "...");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        ChatServer myServer;
        if (args.length > 0) {
            int p;
            try {
                p = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                p = 1099;
            }
            myServer = new ChatServer(p);
        } else {
            myServer = new ChatServer();
        }
        myServer.startServer();
    }
    
}
