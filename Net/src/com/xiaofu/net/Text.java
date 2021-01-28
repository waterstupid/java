package com.xiaofu.net;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author fmk
 * @date 2020/5/12
 **/
public class Text {
    public static void main(String[] args) throws IOException {
        while(true){
            Socket socket=new Socket("localhost",9999);
            OutputStream out= socket.getOutputStream();
            out.write("我是中国人".getBytes());
            socket.shutdownOutput();
            InputStream in = socket.getInputStream();
            int temp=0;
            byte[] bytes=new byte[1024];
            while((temp=in.read(bytes)) != -1){
                System.out.println(new String(bytes,0,temp));
            }
            socket.close();
            in.close();
            out.close();
        }

    }
}
