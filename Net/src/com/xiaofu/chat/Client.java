package com.xiaofu.chat;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * 这是一个客户端
 * 目标：完成单人给自己发送消息，单人可以接收到
 * @author fmk
 * @date 2020/5/11
 **/
public class Client {
    public static void main(String[] args) throws IOException {
        // 创造一个客户端
        Socket socket=new Socket("localhost",8888);
        // 然后调用键盘输入
        Scanner s=new Scanner(System.in);
        // 获得网络输出流
        OutputStream out = socket.getOutputStream();
        // 将写入的数据通过网络输出流传输到服务端上
        out.write(s.next().getBytes());
        // 对于TCP套接字，任何先前写入的数据将被发送，随后是TCP的正常连接终止序列，这里需要
        // 附加终止序列
        socket.shutdownOutput();
        // 获取服务端返回的响应
        InputStream is = socket.getInputStream();
        byte[] bytes=new byte[1024];
        int temp=0;
        while((temp=is.read(bytes)) != -1){
            System.out.println(new String(bytes,0,temp));
        }
        System.out.println("-=======");
        // 关闭流
        out.flush();
        socket.close();
        out.close();
        is.close();
    }
}
