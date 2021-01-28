package com.xiaofu.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 该程序用来测试网络编程的一些概念,首先要知道以下几个概念
 * 端口：0-65536 端口是
 * @author fmk
 * @date 2020/5/11
 **/
public class Client {
    public static void main(String[] args) throws IOException {
        // Socket是用于网络编程来模拟客户端的一个类，其构造方法可以访问
        // 某个特定的服务器中的特定软件
        Socket socket=new Socket("192.168.0.102",8888);
        // 然后可以获取网络输出流和网络输入流来向服务器提交数据
        // 获取一个网络输出流，向服务器输出数据
        OutputStream out = socket.getOutputStream();
        // 写数据
        out.write("你好服务器".getBytes());
        // 获取网络输入流
        InputStream is = socket.getInputStream();
        // 读取服务器上传回来的数据
        byte [] bytes=new byte[1024];
        is.read(bytes);
        System.out.println(new String(bytes));
        // 关闭流
        socket.close();
        out.close();
        is.close();
    }



}
