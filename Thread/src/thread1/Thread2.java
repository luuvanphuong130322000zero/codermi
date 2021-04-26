/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread1;

/**
 *
 * @author hp
 */
import static thread1.Thread1.i;

public class Thread2 extends Thread {

    @Override
    public void run() {
        while (true) {
            System.out.println("Thread B: " + Math.pow(i, 2));
            try {
                Thread.sleep(2000);

            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
