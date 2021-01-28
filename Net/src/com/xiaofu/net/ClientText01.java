package com.xiaofu.net;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 该程序用来完成文件的上传
 * @author fmk
 * @date 2020/5/11
 **/
public class ClientText01 {
    public static void main(String[] args) throws IOException {
        // 首先创建一个客户端
        Socket socket=new Socket("192.168.0.102",8888);
        OutputStream out = socket.getOutputStream();
        // 然后客户端需要使用本地输入流，来读取指定要上传文件中的数据
        FileInputStream fis=new FileInputStream("C:\\Java\\DataText2.java");
        byte[] bytes=new byte[1024];
        int temp=0;
        while((temp=fis.read(bytes)) != -1){
            // 然后再通过网络输出流上传到服务器当中
            out.write(bytes,0,temp);
        }
        // 需要将这个流关闭
        socket.shutdownOutput();
        // 然后通过网络输入流读取服务端返回的数据
        byte[] byte1=new byte[1024];
        socket.getInputStream().read(byte1);
        System.out.println(new String(byte1));
        // 关闭流
        socket.close();
        out.close();




    }
}
