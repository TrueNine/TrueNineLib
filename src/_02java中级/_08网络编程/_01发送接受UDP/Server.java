package _02java中级._08网络编程._01发送接受UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @author TrueNine
 * @version 1.0
 * @date 2020/5/3
 */
public class Server {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(1521);

        while (true) {
            byte[] data = new byte[1024];
            DatagramPacket packet = new DatagramPacket(
                    data,
                    data.length
            );

            socket.receive(packet);

            byte[] data1 = packet.getData();
            String str = new String(data1);
            System.out.println("ip: " + packet.getAddress()
                    + "端口: " + packet.getPort()
                    + "套接字: " + packet.getSocketAddress()
                    + " 说||: " + new String(data1));

            if ("88".equalsIgnoreCase(str)) {
                break;
            }
        }
        socket.close();
    }
}
