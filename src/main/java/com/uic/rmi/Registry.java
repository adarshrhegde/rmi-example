package com.uic.rmi;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class Registry {

    static java.rmi.registry.Registry registry = null;
    public static java.rmi.registry.Registry getRegistry(){

        if(registry == null) {
            try {
                java.rmi.registry.Registry registry = LocateRegistry.createRegistry(0);
                return registry;
            } catch (RemoteException e) {
                e.printStackTrace();
            }

        } else {
            return  registry;
        }
        return null;
    }
}
