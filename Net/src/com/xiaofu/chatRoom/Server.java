package com.xiaofu.chatRoom;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * @author fmk
 * @date 2020/5/15
 **/
public class Server {
    public static void main(String[] args) throws IOException {
        System.out.println("===服务端====");
        ServerSocket server=new ServerSocket(8888);
        while(true){
            Thread chat=new Thread(new Chat(server));
            chat.start();
        }
    }
}
