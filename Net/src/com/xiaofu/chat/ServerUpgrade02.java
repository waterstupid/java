package com.xiaofu.chat;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 这是一个升级版的服务端
 * 可以实现多人聊天，每个人都能接收到自己发送的消息，且不结束,用户必须排队发消息，
 * 需要解决这个问题，该程序就是用来解决这个问题
 * @author fmk
 * @date 2020/5/11
 **/
public class ServerUpgrade02 {
    public static void main(String[] args) {
        System.out.println("===Server====");
        boolean flag=true;
        try {
            ServerSocket server = new ServerSocket(8888);
            while(flag){
                new Thread(new Runnable() {
                    OutputStream out=null;
                    InputStream in=null;
                    @Override
                    public void run() {
                        try {
                            Socket socket = server.accept();
                            in=socket.getInputStream();
                            out=socket.getOutputStream();
                            byte[] bytes=new byte[1024];
                            int temp=0;
                            while((temp=in.read(bytes)) != -1){
                                System.out.println(new String(bytes,0,temp));
                                out.write(bytes,0,temp);
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }finally{
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
                }).start();
            }
        }catch (IOException e) {
            flag=false;
            e.printStackTrace();
        }
    }
}
