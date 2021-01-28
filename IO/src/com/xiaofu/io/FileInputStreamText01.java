package com.xiaofu.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 该程序用来是测试字节输入流中的方法
 * FileInputStream可以用来读取任何文件，是字节输入流，每次是以字节的方式读入
 * @author fmk
 * @date 2020/4/30
 **/
public class FileInputStreamText01 {
    public static void main(String[] args) {
        FileInputStream in=null;
        try {
            //调用构造方法
             in=new FileInputStream("IO//index");
            // 1. 可以调用read()方法读取
            int readCount=0;
           /* while((readCount=in.read())!= -1){
                int read = in.read();
                System.out.println(read);
            }*/
           /*
            System.out.println(in.read());
            System.out.println(in.read());
            System.out.println(in.read());
            System.out.println(in.read());
            System.out.println(in.read());
            System.out.println(in.read());*/
           while((readCount=in.read()) != -1){
               System.out.println(readCount);
           }
            System.out.println("===========");

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

}
