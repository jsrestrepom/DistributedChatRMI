/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contract;


import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
/**
 *
 * @author jrestr76
 */
public interface IChatMessage extends Remote {
    void connect() throws RemoteException;
    void disconnect() throws RemoteException;
    
    void send(String msj) throws RemoteException;
    
    ArrayList pull() throws RemoteException;
    
}
