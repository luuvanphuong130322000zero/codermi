/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IMath extends Remote {

    public int cong(int a, int b) throws RemoteException;

    public int tru(int a, int b) throws RemoteException;

    public int nhan(int a, int b) throws RemoteException;
    
    public float chia(int a, int b) throws RemoteException;
    
}
