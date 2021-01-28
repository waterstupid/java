package com.xiaofu.chat;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 这是一个升级版的服务端
 * 可以实现多人聊天，每个人都能接收到自己发送的消息，且不结束，但是此时存在一个问题，就是
 * 用户需要排队等待，这个时候就要采用多线程来解这个问题
 * @author fmk
 * @date 2020/5/11
 **/
public class ServerUpgrade01 {
    public static void main(String[] args) {
        System.out.println("===Server====");
        ServerSocket server=null;
        OutputStream out=null;
        InputStream in=null;
        boolean flag=true;
        // 创建服务端对象
        try {
            server = new ServerSocket(8888);
            while (flag) {
                Socket socket = server.accept();
                in = socket.getInputStream();
                out = socket.getOutputStream();
                byte[] bytes = new byte[1024];
                int temp = 0;
                while ((temp = in.read(bytes)) != -1) {
                    System.out.println(new String(bytes, 0, temp));
                    out.write(bytes, 0, temp);
                }
            }
            }catch (IOException e) {
                flag=false;
                e.printStackTrace();
            }finally{
                if (server != null) {
                    try {
                        server.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
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

