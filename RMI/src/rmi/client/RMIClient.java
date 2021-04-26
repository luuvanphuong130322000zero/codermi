/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi.client;

// import sau khi build file jar RMISever để bên Client hiểu đc dịch vụ Imath đã đc định nghĩa bên sever
import java.rmi.Naming;
import rmi.server.IMath;

public class RMIClient {

    public static void main(String[] args) {
        try {
            IMath imath = (IMath) Naming.lookup("rmi://localhost:5000/MyServices");
            // khai báo rs (kết quả) để chạy thử dịch vụ cộng 2 số bên sever
            float rs = imath.chia(4, 3);
            System.out.println("Ket Qua:" + rs);
        } catch (Exception e) {
        }
    }
}
