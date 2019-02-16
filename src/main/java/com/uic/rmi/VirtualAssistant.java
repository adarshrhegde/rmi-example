package com.uic.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Remote Interface
 */
public interface VirtualAssistant extends Remote {

    void sayHello() throws RemoteException;

    void askQuestion(String question) throws RemoteException;

    boolean compareInstances(VirtualAssistant va1, VirtualAssistant va2)throws RemoteException;

}
