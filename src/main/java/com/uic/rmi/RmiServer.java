package com.uic.rmi;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 * The server class
 */
public class RmiServer {

    Registry registry;


    public void getRegistry(){
        try {
            registry = LocateRegistry.getRegistry(0);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
    public void setupServer(){

        try {
            System.out.println("Starting server");


            //Binding stubs to server
            Alexa alexa = new Alexa();
            VirtualAssistant alexaStub = (VirtualAssistant) UnicastRemoteObject.exportObject(alexa, 0);

            GoogleAssistant googleAssistant = new GoogleAssistant();
            VirtualAssistant googleStub = (VirtualAssistant) UnicastRemoteObject.exportObject(googleAssistant, 0);

            // Binding the stubs to the registry
            registry.bind("alexa", alexaStub);
            registry.bind("google", googleStub);
            Thread.sleep(5000);
            System.out.println("Stubs have been bounded at server");

        } catch (Exception e) {
            System.out.println("Exception occured while setting up server");
            e.printStackTrace();
        }


    }



    public static void main(String[] args){

        RmiServer rmiServer = new RmiServer();

        rmiServer.getRegistry();
        rmiServer.setupServer();



    }
}
