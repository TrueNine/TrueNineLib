package _02java中级._08网络编程._01发送接受UDP;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

/**
 * @author TrueNine
 * @version 1.0
 * @date 2020/5/3
 */
public class Client {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket();

        String str = null;
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入一段语句");
            str = scanner.nextLine();
            byte[] data = str.getBytes();
            DatagramPacket packet = new DatagramPacket(
                    data,
                    0,
                    data.length,
                    InetAddress.getByName("localhost"),
                    1521
            );
            socket.send(packet);

        } while (!"88".equalsIgnoreCase(str));
        socket.close();
    }
}
