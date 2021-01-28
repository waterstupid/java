package com.review01;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;

/**
 * PrintWriter
 * 1.这是一个打印流，也是默认输出到控制台中
 * 2.当每次打印需要的是字符是,可以使用该流
 */
public class PrintWriterText02 {
    public static void main(String[] args) {

        PrintWriter print = null;
        try {
            print = new PrintWriter(new FileOutputStream("IO//text04"));
            // 输出数据
            print.println("我是一个中国人");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            // 关闭
            print.close();
        }





    }







}
