package com.xiaofu.io;

import java.io.*;

/**
 * 该程序用来完成复制文件的操作
 * @author fmk
 * @date 2020/4/30
 **/
public class Copy01 {
    public static void main(String[] args) {
        FileInputStream fle=null;
        FileOutputStream out=null;
        try {
            fle=new FileInputStream("index03");
            out=new FileOutputStream("text01");
            byte [] b=new byte[1024];
            int readCount=0;
            //一边读一边写
            while((readCount=fle.read(b)) != -1){
                out.write(b,0,readCount);
            }
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (fle != null) {
                try {
                    fle.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
