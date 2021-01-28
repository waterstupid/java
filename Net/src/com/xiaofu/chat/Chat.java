package com.xiaofu.chat;

import com.xiaofu.utils.Utils;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 这是一个升级版的服务端
 * 可以实现多人聊天，每个人都能接收到自己发送的消息，且不结束,用户不必排队等待，且这是
 * 封装版
 * @author fmk
 * @date 2020/5/11
 **/
public class Chat implements Runnable{
    private static int index=1;
    private ServerSocket server=null;
    private OutputStream out=null;
    private InputStream in=null;
    private BufferedInputStream buf=null;
    private boolean flag=false;
    private static CopyOnWriteArrayList<Chat> list=new CopyOnWriteArrayList<>();
    public Chat(ServerSocket server){
        this.server=server;
        try {
            Socket socket = server.accept();
            System.out.println("======客户端("+index+")已经连接=======");
            in=socket.getInputStream();
            out=socket.getOutputStream();
            list.add(this);
            index++;
        } catch (IOException e) {
            e.printStackTrace();
            this.release();
        }
    }
    @Override
    public void run() {
        while(true){
            try {
                String msg = this.read();
                if(msg != null){
                    this.writeOthers(msg);
                }
            } catch (IOException e) {
                this.release();
                e.printStackTrace();
            }
        }
    }

    /**
     * 该方法用来读取客户端传来的数据
     * @return 读取到的数据
     * @throws IOException
     */
    public String read() throws IOException {
        byte[] bytes=new byte[1024*10];
        int temp = in.read(bytes);
        return new String(bytes,0,temp);
    }

    /**
     * 该方法用来返回数据
     * @param msg
     * @throws IOException
     */
    public void write(String msg) throws IOException {
        out.write(msg.getBytes());
    }

    /**
     * 该方法用来释放资源
     */
    public void release(){
        this.flag=false;
        Utils.closeAll(out,in,buf);
    }
    public void writeOthers(String msg){
        for (Chat chat : list) {
            if(this==chat){
                break;
            }else{
                try {
                    chat.write(msg);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
