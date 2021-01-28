package com.xiaofu.net;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 该程序用来模拟服务器
 * @author fmk
 * @date 2020/5/11
 **/
public class Server {
    public static void main(String[] args) throws IOException {
        // 创建一个服务器对象
        ServerSocket server = new ServerSocket(8888);
        // 获取上传文件的客户端,这里会阻塞程序,当有客户端连接服务器的时候
        // 阻塞才会结束，如果没有，则会一直继续下去
        Socket socket = server.accept();
        // 如果没有客户端连接服务端这里的程序就会一直阻塞下去
        System.out.println("abc");
        // 获取网络输入流
        InputStream is = socket.getInputStream();
        byte [] bytes=new byte[1024];
        // 读取上传的文件
        is.read(bytes);
        System.out.println(new String(bytes));
        // 向客户端输出上传成功
        // 获取网络输出流
        socket.getOutputStream().write("上传成功".getBytes());

    }
}
