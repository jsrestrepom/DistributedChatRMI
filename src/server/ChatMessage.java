/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server;


import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
    // import contract/interface
import contract.IChatMessage;
/**
 *
 * @author jrestr76
 */
public class ChatMessage extends UnicastRemoteObject implements IChatMessage {
    private ArrayList chatLog;
    private int currentUsers;
    
    public ChatMessage() throws RemoteException {
        this.chatLog = new ArrayList();
        this.currentUsers = 0;
    }
    
    @Override
    public void connect() throws RemoteException {
        currentUsers += 1;
    }
    
    @Override
    public void disconnect() throws RemoteException {
        currentUsers = (currentUsers == 0) ? 0 : currentUsers-1;
    }   
    
    @Override
    public void send(String msj) throws RemoteException {
        chatLog.add(msj);
    }
    
    @Override
    public ArrayList pull() throws RemoteException {
        return chatLog;
    }
    
}
