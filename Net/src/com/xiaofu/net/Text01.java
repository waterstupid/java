package com.xiaofu.net;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author fmk
 * @date 2020/5/12
 **/
public class Text01 {
    public static void main(String[] args) throws IOException {
        ServerSocket server=new ServerSocket(9999);
        while(true){
            Socket socket = server.accept();
            InputStream in=  socket.getInputStream();
            OutputStream out = socket.getOutputStream();
            byte[] bytes=new byte[1024];
            int temp=0;
            while((temp=in.read(bytes)) != -1){
                System.out.println(new String(bytes,0,temp));
                out.write(bytes,0,temp);
            }
            System.out.println("aaaaaaaaaaaaaaaaaa");
            socket.close();
            in.close();
            out.close();
        }

    }
}
