package com.xiaofu.chat01;

import com.xiaofu.chat01.Chat;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author fmk
 * @date 2020/5/11
 **/
public class ServerUpgrade03 {
    public static CopyOnWriteArrayList<Chat> list=new CopyOnWriteArrayList<>();
    public static void main(String[] args) throws IOException {
        System.out.println("======服务器3.0=======");
        ServerSocket server=new ServerSocket(9999);
        while(true){
            Chat chat=new Chat(server);
            list.add(chat);
            Thread thread=new Thread(chat);
            thread.start();
        }
    }

}
