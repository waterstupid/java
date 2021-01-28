package com.xiaofu;

import org.junit.Test;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * URL:表示统一的资源定位符,它表示Internet某一资源的地址
 * 一般是五部分组成:
 * http://localhost:8080/myweb/index.jsp?usename='zs'
 * http:协议
 * localhost:访问服务器的Ip地址
 * 8080:访问程序的端口号
 * myweb：工程名称
 * index.jsp:资源地址
 * username='zs':参数列表
 *
 */
public class UrlText01{

    @Test
    public void getUrl() throws IOException {
        URL url = new URL("http://localhost:8089/myweb/timg.jpg");
        // 输出协议名称
        System.out.println(url.getProtocol());
        // 输出主机号
        System.out.println(url.getHost());
        // 输出端口号
        System.out.println(url.getPort());
        // 获取URL的文件路径
        System.out.println(url.getPath());
        // 获取URL的文件名
        System.out.println(url.getFile());
        // 将该图片下载
        // 可以通过此对象来获取输入输出流
        URLConnection connection = url.openConnection();
        /*BufferedInputStream in = new BufferedInputStream(connection.getInputStream());
        BufferedOutputStream out = new BufferedOutputStream(connection.getOutputStream());*/
        InputStream in = connection.getInputStream();
        FileOutputStream out = new FileOutputStream("timg02.jpg");
        byte [] b = new byte[1024];
        int count;
        while((count = in.read(b)) != -1){
            out.write(b,0,count);
        }
    }
}
