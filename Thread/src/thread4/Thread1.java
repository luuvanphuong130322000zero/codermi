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
import java.util.Scanner;
public class Thread1 extends Thread{
    static public int dodai=100;
    static public int[] arr=new int[dodai];
    Scanner sc=new Scanner(System.in);
    @Override
    public void run(){
        System.out.println("nhap do dai");
        dodai=sc.nextInt();
        for(int i=0;i<dodai;i++){
            System.out.println("Nhap phan tu thu "+(i+1)+": ");
            arr[i]=sc.nextInt();
        }
    }
}

