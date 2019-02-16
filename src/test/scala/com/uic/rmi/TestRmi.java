package com.uic.rmi;

public class TestRmi {

    public void testRmi(){
        RmiMain rmiMain = new RmiMain();

        rmiMain.setupRegistry();
        rmiMain.setupServer();


        assert(rmiMain.executeClient() == true);
    }
}
