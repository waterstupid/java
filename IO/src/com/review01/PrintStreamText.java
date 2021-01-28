package com.review01;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * PrintStream
 * 1.这是一个字节输出流，默认输出到控制台上,也是打印流
 * 2.但是可以改变其输出方向，可以让它不输出到控制台上，而是输出到一个文件中
 *
 *
 *
 */
public class PrintStreamText {
    public static void main(String[] args) {
        // 造流
        PrintStream print = null;
        try {
            print = new PrintStream(new FileOutputStream("IO//print.txt"));
            if(print != null){
                // 将默认输出到控制台中改变默认输出到一个文件中
                System.setOut(print);
                print.println("hello world");
                print.println("我是一个中国人");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            // 关闭流
            print.close();

        }





    }


}
