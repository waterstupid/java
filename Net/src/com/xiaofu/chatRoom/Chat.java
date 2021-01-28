package com.xiaofu.chatRoom;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 服务端线程
 * @author fmk
 * @date 2020/5/14
 **/
public class Chat implements Runnable {
    private static List<Chat> list= Collections.synchronizedList(new ArrayList<>());
    private ServerSocket server;
    private InputStream in;
    private OutputStream out;
    private static int index;
    private String name;
    private boolean isQuit=false;
    public Chat(ServerSocket server) {
        this.server = server;
        try {
            Socket socket=server.accept();
            System.out.println("客户端"+index+"连接");
            in=socket.getInputStream();
            out=socket.getOutputStream();
            // 得到name
            name = this.receive();
            this.sendOthers("欢迎"+name+"来到小付聊天室",true);
            index++;
            list.add(this);
        } catch (IOException e) {
            release(in,out);
            e.printStackTrace();
        }
    }
    @Override
    public void run() {
        while(true){
            String msg = null;
            try {
                msg = this.receive();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if(!isQuit){
                    if (msg != null) {
                        this.sendOthers(msg,false);
                    }
            }else{
                System.out.println("对不起，您已经被禁言");
            }

        }
    }

    /**
     * 该方法用来将消息发送给其他人
     * @param msg
     */
    public void sendOthers(String msg,boolean isSys){
        for (Chat chat : list) {
            if(chat==this){
                continue;
            }else{
                if(!isSys){
                    chat.send(name+"对大家说:"+msg);
                }else{
                    chat.send(msg);
                }
            }
        }
    }
    /**
     * 该方法用来将客户端传来的数据，返回给客户端
     * @param msg
     */
    public void send(String msg){
        try {
            out.write(msg.getBytes());
        } catch (IOException e) {
            release(in,out);
            e.printStackTrace();
        }
    }

    /**
     * 该方法用来接收用户从客户端上传的数据,如果消息的格式是@xxx:,那就是私聊
     * notspeak:xxx 这就是禁言
     * speak:xxx 这就是恢复
     * 只有管理员能禁言
     * @return 客户上传的数据
     */
    public String receive() throws IOException {
        byte[] bytes=new byte[1024];
        int temp = in.read(bytes);
        String msg=new String(bytes,0,temp);
        if(name != null) {
            if (name.startsWith("管理员:")) {
                // 禁言
                if (msg.startsWith("notspeak:")) {
                    quitSpeak(msg);
                }
            }
        }
        if(msg.startsWith("@")){
            // 私聊消息
            int index = msg.indexOf(":");
            String name = msg.substring(1, index);
            String value=msg.substring(index+1);
            for (Chat chat : list) {
                if(chat.name.equals(name)){
                    chat.send(this.name+"悄悄对你说:"+value);
                }
            }
            return null;
        }else{
            return msg;
        }
    }

    /**
     *该方法用来判断谁被禁言了
     * @param msg
     */
    private void quitSpeak(String msg) {
        int index = msg.indexOf(":");
        String name = msg.substring(index + 1);
        for (Chat chat : list) {
            if(chat.name.equals(name)){
                chat.isQuit=true;
            }
        }
    }

    /**
     * 该方法用来将使用的流进行关闭
     * @param targets
     */
    public void release(Closeable ... targets){
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
