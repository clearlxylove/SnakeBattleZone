package api;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketTCPClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(),9999);
        System.out.println("客户端 socket返回= "+ socket.getClass());

        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("hello,server".getBytes());

        socket.shutdownOutput();

        InputStream inputStream = socket.getInputStream();
        byte[] buffer = new byte[1024];
        int readLen = 0;
        while((readLen=inputStream.read(buffer))!=-1){
            System.out.println(new String(buffer,0,readLen));
        }


        outputStream.close();
        inputStream.close();
        socket.close();
        System.out.println("客户端推出.........");
    }
}
