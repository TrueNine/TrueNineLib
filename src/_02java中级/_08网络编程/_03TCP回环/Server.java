package _02java中级._08网络编程._03TCP回环;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @author TrueNine
 * @version 1.0
 * @date 2020/5/3
 */
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(25676);

        Socket accept = socket.accept();

        InputStream is = accept.getInputStream();

        BufferedReader br = new BufferedReader(
                new InputStreamReader(is, StandardCharsets.UTF_8)
        );
        String str;
        while (null != (str = br.readLine())) {
            System.out.println(str);
        }

        accept.shutdownInput();

        OutputStream os = accept.getOutputStream();
        os.write(("/" + accept.getRemoteSocketAddress() + "/" + ": 好走不送").getBytes());
        accept.shutdownOutput();

        os.close();
        is.close();
        br.close();
        accept.close();
        socket.close();
    }
}
