package com.uic.rmi;

import java.rmi.RemoteException;

public class Alexa implements VirtualAssistant {

    private static final String greeter = "Hey Alexa";
    @Override
    public void sayHello() throws RemoteException {
        System.out.println(greeter);
    }

    @Override
    public void askQuestion(String question)  throws RemoteException{
        System.out.println(greeter + ", " + question);
    }

    public boolean compareInstances(VirtualAssistant alexa1, VirtualAssistant alexa2){

        return alexa1 ==alexa2;
    }

}
