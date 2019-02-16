package com.uic.rmi;

import java.rmi.RemoteException;


/**
 * GoogleAssistant implements the remote interface VirtualAssitant
 */
public class GoogleAssistant implements VirtualAssistant {

    private static final String greeter = "Hey Google";

    @Override
    public void sayHello() {
        System.out.println(greeter);
    }

    @Override
    public void askQuestion(String question) {
        System.out.println(greeter + ", " + question);
    }

    @Override
    public boolean compareInstances(VirtualAssistant google1, VirtualAssistant google2) throws RemoteException {
        return google1 ==google2;
    }
}
