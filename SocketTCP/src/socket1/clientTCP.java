/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socket1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author hp
 */
public class clientTCP {

    public static final void main(final String[] args) throws IOException {
// khởi tạo địa chỉ ip tới server 192.168.10.1 
        InetAddress ip = InetAddress.getByName("127.0.0.1");
// khởi tạo client socket có cổng tới server là 9999 và ip: 192.168.10.1
        Socket socket = new Socket(ip, 9999);

        // đọc dữ liệu từ client gửi
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        // đẩy dữ liệu từ server về client
        DataInputStream in = new DataInputStream(socket.getInputStream());

        // scanner để đọc text nhập vào
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // truyển dữ liệu lên server
            String str = scanner.nextLine();
            out.writeUTF(str);

            if (str.equals("q")) {
                break;
            }

            // đọc dữ liệu từ server truyền về
            String str2 = in.readUTF();
            System.out.println("server send:" + str2);
        }

        out.close();
        in.close();
        socket.close();

    }

}
