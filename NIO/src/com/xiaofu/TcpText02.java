package com.xiaofu;

import org.junit.Test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpText02 {
    /**
     * 客户端发送文件给服务端，服务端将文件保存在本地。
     */
    @Test
    public void client() throws IOException {
        // 设置端口号
        Socket socket = new Socket("127.0.0.1",9091);
        OutputStream out = socket.getOutputStream();
        FileInputStream in = new FileInputStream("timg.jpg");

        // 边读边写
        int count;
        byte [] b =new byte[1024];
        while((count = in.read(b)) != -1){
            out.write(b,0,count);
        }
        // 关闭流
        in.close();
        out.close();
        socket.close();
    }

    @Test
    public void server() throws IOException {
        ServerSocket server = new ServerSocket(9091);
        // 得到连接
        Socket socket = server.accept();
        // 获取输入流
        InputStream in = socket.getInputStream();
        FileOutputStream out = new FileOutputStream("timg01.jpg");

        // 边读边写
        int count;
        byte [] b =new byte[1024];
        while((count = in.read(b)) != -1){
            // 将读取的数据下载到本地
            out.write(b,0,count);
        }

        System.out.println("下载成功");
        // 关闭流
        in.close();
        out.close();
        socket.close();
        server.close();





    }



}
