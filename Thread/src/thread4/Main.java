/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread4;

/**
 *
 * @author hp
 */
import java.util.logging.Level;
import java.util.logging.Logger;
public class Main {
    public static void main(String args[]){
        new Thread1().start();
        Thread2 t=new Thread2();
        try {
            t.sleep(10000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        t.start();
    }
}
