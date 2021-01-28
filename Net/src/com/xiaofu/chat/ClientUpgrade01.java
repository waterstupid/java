package com.xiaofu.chat;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * 这是一个升级版的客户端
 * 可以实现多人聊天，每个人都能接收到自己发送的消息，且不结束,但是此时存在一个问题，每个
 * 用户必须排队发消息，需要解决这个问题
 * @author fmk
 * @date 2020/5/11
 **/
public class ClientUpgrade01 {
    public static void main(String[] args) {
        System.out.println("===Client=====");
        Socket socket=null;
        OutputStream out=null;
        InputStream in=null;
        boolean flag=true;
        try {
            while(flag) {
                socket = new Socket("localhost", 8888);
                out = socket.getOutputStream();
                Scanner s = new Scanner(System.in);
                out.write(s.next().getBytes());
                // 对流进行附加
                socket.shutdownOutput();
                // 获取服务端返回的数据
                in = socket.getInputStream();
                int temp = 0;
                byte[] bytes = new byte[1024];
                while ((temp = in.read(bytes)) != -1) {
                    System.out.println(new String(bytes, 0, temp));
                }
                out.flush();
            }
        } catch (IOException e) {
            flag=false;
            e.printStackTrace();
        }finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
