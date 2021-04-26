/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socket1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author hp
 */
public class serverTCP {

    public static final void main(final String[] args) throws IOException {
        // khởi tạo serversocket với port là 9999
        ServerSocket server = new ServerSocket(9999);
        // khởi tạo sác thực kết nối ,chờ kết nối
        Socket socket = server.accept();

        // đọc dữ liệu từ client gửi
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        // đẩy dữ liệu từ server về client
        DataInputStream in = new DataInputStream(socket.getInputStream());

        // scanner để đọc text nhập vào
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // dữ liệu nhập vào
            String str = in.readUTF();
            // nếu nhập text là q thì kết thúc
            if (str.equals("q")) {
                break;
            }
            // nếu text khác q thì in ra màn hình Client send: và text client gửi
            System.out.println("Client send:" + str);

            //truyền dữ liệu từ server về 
            String str2 = scanner.nextLine();
            // đẩy dữ liệu về client
            out.writeUTF(str2);

            // gọi hàm đẩy dữ liệu flush();
            out.flush();
        }

        out.close();
        in.close();
        socket.close();
        server.close();
    }

}
