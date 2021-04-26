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
public class clientchatUDP {

    public static void main(String[] args) throws SocketException, IOException {
        // nhận dữ liệu từ server gửi đến
        BufferedReader clientRead = new BufferedReader(new InputStreamReader(System.in));
        // khởi tạo địa chỉ IP 192.168.10.1
        InetAddress IP = InetAddress.getByName("127.0.0.1");
        // khởi tạo client socket
        DatagramSocket clientSocket = new DatagramSocket();
        while (true) {
            // tạo file gửi và nhận kiểu byte
            byte[] sendbuffer = new byte[1024];
            byte[] receivebuffer = new byte[1024];
            // in ra màn hình dòng Client:  thể hiện là client gửi
            System.out.print("\nClient: ");
            //  khai báo thông điệp nhập vào
            String clientData = clientRead.readLine();
            //lấy thông điệp nhập từ bàn phím
            sendbuffer = clientData.getBytes();
            //đưa vào packet gửi đi với thông điệp, độ dài, địa chỉ và cổng kết nối 
            DatagramPacket sendPacket = new DatagramPacket(sendbuffer, sendbuffer.length, IP, 9999);
            // client gửi packet đi
            clientSocket.send(sendPacket);
            // nếu nhập bye thì kết thúc, đóng kết nối
            if (clientData.equalsIgnoreCase("bye")) {
                System.out.println("Connection ended by client");
                break;
            }
            // tạo packet nhận thông điệp
            DatagramPacket receivePacket
                    = new DatagramPacket(receivebuffer, receivebuffer.length);
            // client nhận packet server gửi
            clientSocket.receive(receivePacket);
            // lấy dữ liệu từ server gửi
            String serverData = new String(receivePacket.getData());
            // in ra màn hình thông điệp server gửi đến
            System.out.print("\nServer: " + serverData);

        }
        // đóng kết nối
        clientSocket.close();
    }
}
