package com.xiaofu.chat;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * @author fmk
 * @date 2020/5/11
 **/
public class ServerUpgrade03 {
    public static void main(String[] args) throws IOException {
        System.out.println("======服务器3.0=======");
        ServerSocket server=new ServerSocket(9999);
        while(true){
            Thread thread=new Thread(new Chat(server));
            thread.start();
        }
    }
}
