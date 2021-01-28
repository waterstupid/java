package com.xiaofu.chatRoom;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author fmk
 * @date 2020/5/14
 **/
public class Read implements Runnable{
    private Socket socket;
    private InputStream in;
    private OutputStream out;
    public Read(Socket socket) {
        this.socket = socket;
        try {
            in=socket.getInputStream();
            out=socket.getOutputStream();
        } catch (IOException e) {
            release(in,out);
            e.printStackTrace();
        }
    }
    @Override
    public void run() {
        while(true){
            String msg = this.read();
            if (msg != null) {
                System.out.println(msg);
            }
        }
    }
    /**
     * 这是读取服务器传来的数据
     */
    public String read(){
        byte[] bytes=new byte[1024];
        int temp=0;
        try {
            if((temp=in.read(bytes)) != -1){
                return new String(bytes,0,temp);
            }
        } catch (IOException e) {
            release(in,out);
            e.printStackTrace();
        }
        return null;
    }
    /**
     * 这是刷新流的方法
     * @param targets
     */
    public void release(Closeable... targets){
        for (Closeable c : targets) {
            if(c != null){
                try {
                    c.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }


}
