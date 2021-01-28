package com.xiaofu.chat01;

import com.xiaofu.utils.Utils;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 这是一个升级版的服务端线程
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
    private boolean flag=true;
    private String name=null;
    private boolean talk = true;
    public Chat(ServerSocket server){
        this.server=server;
        try {
            Socket socket = server.accept();
            System.out.println("======客户端("+index+")已经连接=======");
            in=socket.getInputStream();
            out=socket.getOutputStream();
            // 在构造方法执行的时候，就应该将传送过来名字进行读取
            name = this.read();
            write("欢迎进入聊天室");
            writeOthers("欢迎"+name+"进入小付聊天室",true);
            index++;
        } catch (IOException e) {
            e.printStackTrace();
            this.release();
        }
    }
    @Override
    public void run() {
        while(flag){
            try {
                    String msg = this.read();
                if(talk){
                    if(msg != null){
                        this.writeOthers(msg,false);
                    }
                }else{
                    this.write("对不起，您已经被管理员禁言");
                }
            } catch (IOException e) {
                this.release();
                e.printStackTrace();
            }
        }
    }

    /**
     * 该方法用来读取客户端传来的数据
     * 如果是私聊，则需要指定数据格式：比如：@xxx:msg
     * 如果是禁言,则也需要指定格式：比如：禁言:xxx;
     * @return 读取到的数据
     * @throws IOException
     */
    public String read() throws IOException {
        byte[] bytes=new byte[1024*10];
        int temp = in.read(bytes);
        String msg= new String(bytes,0,temp);
        if(name != null){
            //判断是否是管理员发送的消息
            if(name.startsWith("管理员")){
                // 则是管理员
                if(msg.startsWith("禁言:")){
                    String name = msg.substring(3);
                    findPerson(name,false);
                    return null;
                }else if(msg.startsWith("解除禁言:")){
                    String name=msg.substring(5);
                    findPerson(name,true);
                    return null;
                }
            }
        }
        if(msg.startsWith("@")){
            int index = msg.indexOf(":");
            String name = msg.substring(1, index);
            String value = msg.substring(index + 1);
            sendPrivate(name,value);
        }else{
            return msg;
        }
        return null;
    }

    /**
     * 该方法用来处理禁言的问题，
     * @param name 禁言人的名字
     */
    private void findPerson(String name,boolean flag) {
        CopyOnWriteArrayList<Chat> list = ServerUpgrade03.list;
        for (Chat chat : list) {
            if(chat.name.equals(name)){
                chat.talk=flag;
            }
        }
    }

    /**
     * 该方法用来处理私聊问题
     * @param name 私聊的名字
     * @param value 私聊的内容
     */
    private void sendPrivate(String name, String value) {
        CopyOnWriteArrayList<Chat> list = ServerUpgrade03.list;
        for (Chat chat : list) {
            if(chat.name.equals(name)){
                try {
                    chat.write(this.name+"悄悄对"+name+"说:"+value);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
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
    public void writeOthers(String msg,boolean isSystem){
        CopyOnWriteArrayList<Chat> list = ServerUpgrade03.list;
        for (Chat chat : list) {
            if(chat == this) {
                continue;
            }else{
                if(!isSystem){
                    try {
                        chat.write(name+"对大家说:"+msg);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
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
}
