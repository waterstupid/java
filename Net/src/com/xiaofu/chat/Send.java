package com.xiaofu.chat;

import com.xiaofu.utils.Utils;

import java.io.*;
import java.net.Socket;

/**
 * @author fmk
 * @date 2020/5/12
 **/
public class Send implements Runnable {
    private Socket socket=null;
    private InputStream in=null;
    private OutputStream out=null;
    private BufferedReader buf=null;
    private boolean flag=true;
    private String name;
    public Send(Socket socket){
        this.socket=socket;
        try {
            in=socket.getInputStream();
            out=socket.getOutputStream();
            buf=new BufferedReader(new InputStreamReader(System.in));
            // 将名字传输过去
        } catch (IOException e) {
            this.release();
            e.printStackTrace();
        }
    }

    /**
     * 该方法用来将用户键盘输入的数据，发送到服务器上
     */
    public void send(){
        String msg = this.getMsgString();
        if(!msg.equals("")){
            try {
                out.write(msg.getBytes());
            } catch (IOException e) {
                this.release();
                e.printStackTrace();
            }
        }
    }

    /**
     * 该方法用来获取用户的键盘输入
     * @return 用户的键盘输入
     */
    public String getMsgString(){
        try {
            return buf.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            this.release();
        }
        return "";
    }

    @Override
    public void run() {
        while(flag){
            this.send();
        }
        this.release();
    }

    /**
     * 该方法用来进行刷新
     */
    public void release(){
        this.flag=false;
        Utils.closeAll(out,in,buf);
    }
    public void sendName(){
        try {
            out.write(this.name.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
