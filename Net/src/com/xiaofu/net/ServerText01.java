package com.xiaofu.net;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 该程序用来模拟服务器
 * @author fmk
 * @date 2020/5/11
 **/
public class ServerText01 {
    public static void main(String[] args) throws IOException {
        // 首先创建服务器对象
        ServerSocket server=new ServerSocket(8888);
        // 然后得到上传文件的客户端
        // 这里需要循环处理，每有一个客户端发送请求，服务端就应该创建一个线程
        while(true){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try{
                        Socket socket = server.accept();
                        // 然后通过网络输入流来读取客户端上传的文件
                        InputStream is = socket.getInputStream();
                        File file=new File("C:\\upload");
                        if(!file.exists()){
                            // 如果文件目录不存在，则创建出一个目录
                            file.mkdir();
                        }
                        long time = System.currentTimeMillis();
                        FileOutputStream out=new FileOutputStream(file+"\\"+time+".java");
                        byte[] bytes=new byte[1024];
                        int temp=0;
                        while((temp=is.read(bytes)) != -1 ){
                            // 创建一个本地输出流，将读取到的文件输出到本地硬盘当中
                            out.write(bytes,0,temp);
                        }
                        // 然后再通过网络输出流，给客户端输出上传成功的信息
                        socket.getOutputStream().write("上传成功".getBytes());
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
}
