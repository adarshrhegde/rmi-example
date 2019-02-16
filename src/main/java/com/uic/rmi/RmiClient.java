package com.uic.rmi;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RmiClient {

    public boolean executeClient(){

        try {
            System.out.println("Starting client");

            Registry registry = LocateRegistry.getRegistry(0);
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
        RmiClient rmiClient = new RmiClient();
        boolean result = rmiClient.executeClient();
        System.out.println("Result of referential integrity test>> " + result);
    }
}
