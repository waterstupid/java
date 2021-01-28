package com.xiaofu.io;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 该程序用来测试BufferedInputStream（缓冲输入流）
 * @author fmk
 * @date 2020/4/30
 **/
public class BufferedInputStreamText01 {
    public static void main(String[] args) {
        BufferedInputStream buf=null;
        try {
            //注意：在这里FileInputStream是一个节点流，而buf是一个包装流
            buf=new BufferedInputStream(new FileInputStream("IO//index04"));
            byte [] b =new byte[5];
            int readCount=0;
            while((readCount=buf.read(b))!= -1){
                System.out.print(new String(b,0,readCount));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            if (buf != null) {
                try {
                    buf.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
