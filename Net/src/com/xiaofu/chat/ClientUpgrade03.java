package com.xiaofu.chat;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author fmk
 * @date 2020/5/11
 **/
public class ClientUpgrade03 {
    public static void main(String[] args) {
        System.out.println("======客户端3.0=========");
        System.out.println("请输入您的名称:");
        try {
                Socket socket=new Socket("localhost",9999);
                new Thread(new Send(socket)).start();
                new Thread(new Read(socket)).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


