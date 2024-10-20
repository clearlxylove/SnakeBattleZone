package api;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        Socket socket = null;
        FileOutputStream fos = null;
        InputStream is = null;

        serverSocket = new ServerSocket(9999);
        socket = serverSocket.accept();

        fos = new FileOutputStream("C:\\FileTest\\B\\lxy.png");
        is = socket.getInputStream();
        byte[] buffer = new byte[1024];
        int readLen = 0;
        while((readLen = is.read(buffer))!=-1){
            fos.write(buffer,0,readLen);
        }

        serverSocket.close();
        socket.close();
        fos.close();
        is.close();

    }
}
