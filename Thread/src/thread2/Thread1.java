/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread2;

/**
 *
 * @author hp
 */
import java.util.Scanner;

public class Thread1 extends Thread {

    static public int i;

    @Override
    public void run() {
        while (true) {
            System.out.println("Nhap 1 so tu 0 - 9: ");
            Scanner sc = new Scanner(System.in);
            i = sc.nextInt();
            if (i < 0 || i > 9) {
                break;
            }
        }
    }
}
