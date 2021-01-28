package com.xiaofu.chat;

import com.xiaofu.utils.Utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author fmk
 * @date 2020/5/12
 **/
public class Read implements Runnable {
    private Socket socket=null;
    private InputStream in=null;
    private OutputStream out=null;
    private boolean flag=true;
    public Read(Socket socket){
        this.socket=socket;
        try {
            in=socket.getInputStream();
            out=socket.getOutputStream();
        } catch (IOException e) {
            this.release();
            e.printStackTrace();
        }

    }
    public String read() throws IOException {
        byte[] bytes=new byte[1024];
        int temp=0;
        while((temp=in.read(bytes)) != -1){
            return new String(bytes,0,temp);
        }
        return null;
    }
    /**
     * 该方法是刷新方法
     */
    public void release(){
        this.flag=false;
        Utils.closeAll(out,in);
    }
    @Override
    public void run() {
        while(flag){
            try {
                System.out.println(this.read());
            } catch (IOException e) {
                this.release();
                e.printStackTrace();
            }
        }

    }
}
