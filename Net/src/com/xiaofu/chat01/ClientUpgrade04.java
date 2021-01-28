package com.xiaofu.chat01;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * 这是客户端3.0
 * @author fmk
 * @date 2020/5/11
 **/
public class ClientUpgrade04 {
    public static void main(String[] args) throws IOException {
        System.out.println("======客户端3.0=========");
        Socket socket=new Socket("localhost",9999);
        BufferedReader buf=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("您是管理员,请输入您的名称:");
        String name = "管理员"+buf.readLine();
        new Thread(new Send(socket,name)).start();
        new Thread(new Read(socket)).start();
    }
}


