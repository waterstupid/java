package com.xiaofu;

import org.junit.Test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpText03 {
    /**
     * 从客户端发送文件给服务端，服务端保存到本地。并返回“发送成功”给
     * 客户端。并关闭相应的连接。
     */
    @Test
    public void client() throws IOException {
        // 设置端口号
        Socket socket = new Socket("127.0.0.1",9091);
        OutputStream out = socket.getOutputStream();
        FileInputStream in = new FileInputStream("timg.jpg");
        InputStream input = socket.getInputStream();
        // 边读边写
        int count;
        byte [] b =new byte[1024];
        while((count = in.read(b)) != -1){
            out.write(b,0,count);
        }
        // 关闭输出,给一个标记
        socket.shutdownOutput();

        ByteArrayOutputStream bops = new ByteArrayOutputStream();
        b = new byte[100];
        while((count = input.read(b)) != -1){
            bops.write(b,0,count);
        }
        System.out.println(bops.toString());
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
        OutputStream output = socket.getOutputStream();

        // 边读边写
        int count;
        byte [] b =new byte[1024];
        // 注意:read()方法是一个阻塞方法,只有当客户端发送完数据后,程序才会向下运行
        while((count = in.read(b)) != -1){
            // 将读取的数据下载到本地
            out.write(b,0,count);
        }

        System.out.println("下载成功");
        // 下载成功发送一句发送成功返回给客户端
        output.write("发送成功".getBytes());
        // 关闭流
        in.close();
        out.close();
        socket.close();
        server.close();
    }



}
