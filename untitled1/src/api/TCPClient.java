package api;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPClient {
    public static void main(String[] args) throws IOException {
        Socket socket = null;
        FileInputStream fis = null;
        OutputStream os = null;

        InetAddress inet = InetAddress.getByName("127.0.0.1");
        socket = new Socket(inet,9999);
        fis = new FileInputStream("C:\\FileTest\\A\\lxy.png");
        os = socket.getOutputStream();
        int readLen = 0;
        byte[] buffer = new byte[1024];
        while ((readLen = fis.read(buffer)) != -1) {
            os.write(buffer, 0, readLen);
        }

        socket.close();
        fis.close();
        os.close();


    }
}
