package com.xiaofu.chatRoom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * @author fmk
 * @date 2020/5/15
 **/
public class Client {
    public static void main(String[] args) throws IOException {
        System.out.println("=====客户端====");
        BufferedReader buf=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入您的名字:");
        Socket socket=new Socket("localhost",8888);
        Thread read=new Thread(new Read(socket));
        Thread send=new Thread(new Send(socket,buf.readLine()));
        send.start();
        read.start();
    }
}
