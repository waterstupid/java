package com.xiaofu.chatRoom;
import java.io.*;
import java.net.Socket;

/**
 * @author fmk
 * @date 2020/5/14
 **/
public class Send implements Runnable{
    private BufferedReader buf;
    private InputStream in;
    private Socket socket;
    private OutputStream out;
    private String name;
    public Send(Socket socket,String name){
        this.socket=socket;
        this.name=name;
        try {
            in=socket.getInputStream();
            out=socket.getOutputStream();
            out.write(name.getBytes());
            buf=new BufferedReader(new InputStreamReader(System.in));
        } catch (IOException e) {
            release(buf,in,out);
            e.printStackTrace();
        }
    }
    @Override
    public void run() {
        while(true){
            this.send();
        }
    }

    /**
     * 该方法用来发送数据
     */
    public void send(){
        String msg=getMsg();
        try {
            // 将内容写入服务器当中
            if(msg != null){
                out.write(msg.getBytes());
            }
        } catch (IOException e) {
            release(buf,in,out);
            e.printStackTrace();
        }


    }

    private String getMsg() {
        try {
            // 获取键盘输入
            String value = buf.readLine();
            return value;
        } catch (IOException e) {
            release(buf,in,out);
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 该方法用来将流进行关闭
     * @param target
     */
    public void release(Closeable ... target){
        for (Closeable c : target) {
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

