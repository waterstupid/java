package com.xiaofu.io;

import java.io.FileNotFoundException;
import java.io.PrintStream;

/**
 * 该程序用来测试PrintStream中的方法
 * @author fmk
 * @date 2020/4/30
 **/
public class PrintStreamText01 {
    public static void main(String[] args) {
        PrintStream out=null;
        try {
            out=new PrintStream("index04");
            // 调用System中的setOut()方法可以重新分配标准输出流，将输出流分配在index04文件中
            // System.out是一个在java.lang.System中的静态变量out，out的类型是PrintStream是一个标准
            // 输出流
            System.setOut(out);
            //向index04文件中输出
            System.out.println("hello world");
            System.out.println("hello world");
            System.out.println("hello world");
            System.out.println("hello world");
            //刷新流
            out.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally{
            if (out != null) {
                //关闭流
                out.close();
            }
        }

    }
}
