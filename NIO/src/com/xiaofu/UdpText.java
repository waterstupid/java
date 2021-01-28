package com.xiaofu;

import org.junit.Test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * 实现UDP协议
 */
public class UdpText {
    @Test
    public void server(){
        DatagramSocket ds = null;
        try {
            // 指定监听的端口号
            ds = new DatagramSocket(9090);
            byte [] b = new byte[1024];
            // 将数据读取到byte数组中
            DatagramPacket dp = new DatagramPacket(b,b.length);
            ds.receive(dp);
            System.out.println(new String(dp.getData(),0,b.length));
            System.out.println(dp.getAddress().getHostName());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ds != null) {
                ds.close();
            }
        }


    }
    @Test
    public void send(){
        // 指定端口号
        DatagramSocket dgs = null;
        try {
            dgs = new DatagramSocket();
            byte [] b ="hello world".getBytes();
            // 这就是数据报文,数据报文需要包括需要传输的数据,数据传输到的IP地址和端口号
            DatagramPacket dgp = new DatagramPacket(b,0,b.length,
                    InetAddress.getByName("127.0.0.1"),9090);
            dgs.send(dgp);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (dgs != null) {
                dgs.close();
            }
        }


    }


}
