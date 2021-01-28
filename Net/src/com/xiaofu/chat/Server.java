package com.xiaofu.chat;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 这是一个服务端
 * 完成单人给自己发送消息，单人可以接收到
 * @author fmk
 * @date 2020/5/11
 **/
public class Server {
    public static void main(String[] args) throws IOException {
        // 首先创建出服务端对象
        ServerSocket server=new ServerSocket(8888);
        // 然后获取连接，因为服务端和客户端是遵循TCP协议的，TCP协议是面向连接的
        Socket socket = server.accept();
        System.out.println("客户端已连接");
        // 如果没有客户端连接服务器，服务器就会阻塞，直到有客户端连接，程序才会向下执行
        // 读取客户端上传的数据
        InputStream is = socket.getInputStream();
        OutputStream out = socket.getOutputStream();
        byte[] bytes=new byte[1024];
        int temp=0;
        // 将从客户端获取到的数据返回到客户端中
        while((temp=is.read(bytes)) != -1){
            System.out.println(new String(bytes,0,temp));
            out.write(bytes,0,temp);
        }
        System.out.println("abcddddddddd");
        // 关闭流
        out.flush();
        server.close();
        out.close();
        is.close();
    }
}
