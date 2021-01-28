package com.xiaofu.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 该程序用来测试FileInputStream（字节输入流）中的方法
 * @author fmk
 * @date 2020/5/1
 **/
public class FileInputStreamText03 {
    public static void main(String[] args) {
        FileInputStream in=null;
        try {
            in=new FileInputStream("index03");
            //1. available() 返回文件还未读取的字节数
            System.out.println(in.available());
            byte [] b=new byte[in.available()];
            in.read(b);
            //将byte数组变为字符串，这样就可以一次性读取
            System.out.println(new String(b));

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (in != null) {

                }
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
