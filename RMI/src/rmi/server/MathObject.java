/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class MathObject extends UnicastRemoteObject implements IMath {
//dinh nghia pt xay dung

    public MathObject() throws RemoteException {
        //goi den ptxd
        super();
    }

    @Override
    public int cong(int a, int b) throws RemoteException {
        return a + b;
    }

    @Override
    public int tru(int a, int b) throws RemoteException {
        return a - b;
    }

    @Override
    public int nhan(int a, int b) throws RemoteException {
        return a * b;
    }

    @Override
    public float chia(int a, int b) throws RemoteException {
        return (float) a / b;
    }

}
