package com.xiaofu;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 除了知道IP地址和端口的作用之外，我们还需要了解两个传输层的两个协议
 * TCP/UDP
 * 1.什么是TCP协议？
 * TCP协议是一种点对点的通信，是可靠的,面向连接的一种通信协议，需要经历三次握手和四次挥手，三次
 * 握手是要确定双方有没有准备好通信，而四次挥手是要确定双方是否决定好退出，可以传输较大的文件，
 * 传输完毕后，需要是释放已经确立的连接，所以效率低，且TCP需要有客户端和服务端。
 *
 * 2.什么是UDP协议？
 * UDP协议是一种面向无连接不可靠的协议,发送前不需要建立连接，也不需要知道对方是否已经准备好，
 * 所以是一种不可靠的协议，每个数据报的大小不能超过64K
 *
 *
 *
 */
public class TcpText {
    /**
     * 需求:客户端发送内容给服务端，服务端将内容打印到控制台上。
     * 这里需要用try..catch...finally
     * @throws IOException
     */
    @Test
    public void client() throws IOException {
        // 首先得到需要连接服务器的IP地址,也就是本机地址
        // 和服务器上程序的端口号
        InetAddress localhost = InetAddress.getByName("localhost");
        Socket socket = new Socket(localhost,9090);

        // 需要向服务器发送数据
        OutputStream out = socket.getOutputStream();
        // 这里有一个编码
        out.write("hello world".getBytes());

        // 关闭流
        out.close();
        socket.close();


    }

    @Test
    public void server() throws IOException {
        // 建立服务端的Socket
        ServerSocket server = new ServerSocket(9090);
        // 获取客户端
        Socket socket = server.accept();

        // 读取客户端传来的信心
        InputStream in = socket.getInputStream();
        int count;
        byte [] b =new byte[10];
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        while((count = in.read(b)) != -1){
            /// 将数据写到ByteArrayOutputStream的内置缓存区中
            out.write(b,0,count);
        }
        System.out.println(out.toString());
        // 将流进行关闭
        in.close();
        socket.close();
        server.close();


    }




}
