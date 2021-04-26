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
import java.util.Scanner;
public class Thread1 extends Thread {
    static public int i;
        
        public void run() {
            while (true) {
                Scanner scanner = new Scanner(System.in);
                i=scanner.nextInt();
                System.out.println("Thread A: " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    System.err.println(ex.getMessage());
                }
            }
        }
}
