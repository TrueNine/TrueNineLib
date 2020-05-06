package _02java中级._08网络编程._02UDP组播广播;

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


        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        byte[] data = str.getBytes();
        DatagramPacket packet = new DatagramPacket(
                data,
                0,
                data.length,
                InetAddress.getByName("224.0.1.24"),
                1521
        );
        socket.receive(packet);
    }
}
