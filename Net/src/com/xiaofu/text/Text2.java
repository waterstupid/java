package com.xiaofu.text;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author fmk
 * @date 2020/5/12
 **/
public class Text2 {
    public static void main(String[] args) throws IOException {
        System.out.println("====服务端===");
        ServerSocket server=new ServerSocket(9999);
        int index=1;
        while(true){
            Socket socket = server.accept();
            System.out.println("客户端"+index+"已连接");
            index++;
        }
    }
}
