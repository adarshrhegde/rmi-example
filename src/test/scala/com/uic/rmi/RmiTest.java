package com.uic.rmi;


public class RmiTest {

    public void testRmi(){
        RmiServer rmiServer = new RmiServer();

        rmiServer.getRegistry();
        rmiServer.setupServer();

        RmiClient rmiClient = new RmiClient();

        assert(rmiClient.executeClient() == true);
    }
}
