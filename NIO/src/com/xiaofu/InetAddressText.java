package com.xiaofu;

import org.junit.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 首先网络编程也叫做Socket编程,要清楚网络编程，则需要弄清楚两个概念
 * 1.什么是IP
 * 我们都知道世界上的计算机有很多,那么怎么样去表达世界上每一台计算机呢，这时候就出现了IP地址的
 * 概念。IP地址就是计算机的唯一标识，IP又分为IPV4和IPV6,IPV4是采用4个字节来标识计算机，但是IPV4
 * 远远不够用,于是出现了IPV6的概念，也就是用16个字节来标识计算机
 *
 * 2.什么是port(端口)
 * 计算机上有许多程序，那么怎么区分这些程序呢，计算机中是采用端口号的方式来区别这些进程,端口号
 * 是用2个字节来表示的。公用的端口号是:0-1023 其他程序使用的端口号:1024-49151,私有端口:49152-65535
 *
 * 所以我如果要在网络上传输数据,计算机的IP地址和程序所在的端口号我们必须要清楚
 * 在java中我们用InetAddress来表示主机的IP地址
 * 在java中我们用Socket来封装IP和端口号
 *
 *
 *
 */
public class InetAddressText {
    @Test
    public void getAddress() throws UnknownHostException {
        // 注意:InetAddress中不能通过构造方法得到该对象,只能通过静态方法
        // 该方法用来得到本机的IP地址
        InetAddress host = InetAddress.getLocalHost();
        // 将本机的地址输出
        System.out.println(host.getHostAddress());
        // 通过另一种方式来得到主机地址
        InetAddress localhost = InetAddress.getByName("127.0.0.1");

        // 对象所含域名
        System.out.println(localhost.getHostName());
        System.out.println(localhost.getHostAddress());
        // 或者也可以通过域名来获取主机地址
        InetAddress localhost1 = InetAddress.getByName("localhost");
        System.out.println(localhost1.getHostAddress());
        System.out.println(localhost1.getHostName());


    }





}
