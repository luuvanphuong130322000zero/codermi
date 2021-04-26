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
import static thread4.Thread1.arr;
import static thread4.Thread1.dodai;

public class Thread2 extends Thread {

    @Override
    public void run() {
        int sum = 0;
        for (int i = 0; i < dodai; i++) {
            sum += arr[i];
        }
        System.out.println("tong phan tu trong mang : " + sum);
    }
}
