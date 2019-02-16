package com.uic.rmi;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class RmiMain {

    Registry registry;


    public void setupRegistry(){
        try {
            registry = LocateRegistry.createRegistry(0);
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

            registry.bind("alexa", alexaStub);
            registry.bind("google", googleStub);
            Thread.sleep(5000);
            System.out.println("Stubs have been bounded at server");

        } catch (Exception e) {
            System.out.println("Exception occured while setting up server");
            e.printStackTrace();
        }


    }

    public boolean executeClient(){

        try {
            System.out.println("Starting client");


            // Creating stubs for Alexa
            VirtualAssistant alexastub = (VirtualAssistant) registry.lookup("alexa");
            VirtualAssistant alexastub2 = alexastub;


            return alexastub.compareInstances(alexastub, alexastub2);


        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public static void main(String[] args){

        RmiMain rmiMain = new RmiMain();

        rmiMain.setupRegistry();
        rmiMain.setupServer();

        boolean result = rmiMain.executeClient();
        System.out.print("Result of referential integrity test>> " + result);

    }
}
