package api;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketTCPServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务端 在监听9999端口");
        Socket socket = serverSocket.accept();

        System.out.println("socket = "+socket.getClass());


        InputStream inputStream = socket.getInputStream();
        byte[] buffer = new byte[1024];
        int readLen = 0;
        while((readLen = inputStream.read(buffer)) != -1) {
            System.out.println(new String(buffer,0,readLen));
        }


        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("hello,client".getBytes());
        socket.shutdownOutput();

        inputStream.close();
        outputStream.close();
        socket.close();
        serverSocket.close();
    }
}
