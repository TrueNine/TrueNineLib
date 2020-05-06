package _02java中级._08网络编程._02UDP组播广播;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

/**
 * 224.0.0.255
 * 239.0.0.255
 * <p>
 * 224.0.1.0
 * <p>
 * 广播改成 255.255.255.255,不需要特殊处理
 *
 * @author TrueNine
 * @version 1.0
 * @date 2020/5/3
 */
public class Server {
    public static void main(String[] args) throws IOException {
        MulticastSocket socket = new MulticastSocket(1521);
        socket.joinGroup(InetAddress.getByName("224.0.1.24"));

        byte[] data = new byte[3];
        DatagramPacket packet = new DatagramPacket(
                data,
                0,
                data.length
        );

        socket.receive(packet);
        byte[] all = packet.getData();
        System.out.println(new String(all));
    }
}
