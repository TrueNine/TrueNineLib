package _02java中级._08网络编程._03TCP回环;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @author TrueNine
 * @version 1.0
 * @date 2020/5/3
 */
public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(),25676);

        OutputStream os = socket.getOutputStream();
        os.write(("/" + socket.getRemoteSocketAddress() + "/" + ": 我来了").getBytes());
        socket.shutdownOutput();

        InputStream is = socket.getInputStream();
        BufferedReader br = new BufferedReader(
                new InputStreamReader(is, StandardCharsets.UTF_8)
        );
        String str;
        while (null != (str = br.readLine())) {
            System.out.println(str);
        }
        socket.shutdownInput();

        is.close();
        os.close();
        br.close();
        socket.close();
    }
}
