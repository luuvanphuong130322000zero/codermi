/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi.server;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class RMIServer {

    public static void main(String[] args) {
        try {
            //xdvt tao cong
            LocateRegistry.createRegistry(5000);
            Naming.bind("rmi://localhost:5000/MyServices", new MathObject());
            System.out.println("Server San Sang !!!!");
        } catch (Exception e) {
        }
    }

}
