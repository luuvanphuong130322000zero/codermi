/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socket2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 *
 * @author hp
 */
public class serverchatUDP {

    public static void main(String[] args) throws SocketException, IOException {
        //khởi tạo serversocket UDP
        DatagramSocket serverSocket = new DatagramSocket(9999);

        while (true) {
            //khởi tạo file gửi
            byte[] receivebuffer = new byte[1024];
            //khởi tạo file nhận
            byte[] sendbuffer = new byte[1024];
            // tạo packet dữ liệu
            DatagramPacket socket = new DatagramPacket(receivebuffer, receivebuffer.length);
            //mở kết nối 
            serverSocket.receive(socket);
            // khởi tạo địa chỉ server 192.168.10.1
            InetAddress IP = InetAddress.getByName("127.0.0.1");
            // lấy thông tin từ
            int portno = socket.getPort();
            // lấy thông điệp client gửi
            String clientdata = new String(socket.getData());
            // in ra mà hình thông điệp client gửi
            System.out.println("\nClient : " + clientdata);
            // in ra màn hình dòng Server :
            System.out.print("\nServer : ");
            // khởi tạo thông điệp nhập vào
            BufferedReader serverRead = new BufferedReader(new InputStreamReader(System.in));
            // đọc thông điệp nhâp vào từ bàn phím
            String serverdata = serverRead.readLine();
            // lấy thông điệp nhập từ bàn phím server
            sendbuffer = serverdata.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendbuffer, sendbuffer.length, IP, portno);
            // gửi thông điệp , packet
            serverSocket.send(sendPacket);
            //kiểm tra kết nối tới server
            if (serverdata.equalsIgnoreCase("bye")) {
                System.out.println("connection ended by server");
                break;
            }

        }
        // đóng kêt nối
        serverSocket.close();
    }
}
