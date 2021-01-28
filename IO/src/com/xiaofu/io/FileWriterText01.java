package com.xiaofu.io;

import java.io.FileWriter;
import java.io.IOException;

/**
 * 该程序用来测试FileWriter（字符输出流）中的方法
 * @author fmk
 * @date 2020/4/30
 **/
public class FileWriterText01 {
    public static void main(String[] args) {
        FileWriter writer=null;
        try {
            //调用构造方法
            writer=new FileWriter("index03");
            //调用writer()方法
            writer.write("97");
            //可以直接将字符串写进去
            writer.write("我是一个中国人");
            //当然也可以将将一个char 数组写进去
            char [] c={'我','爱','你','中','国'};
            writer.write(c);
            //刷新
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
