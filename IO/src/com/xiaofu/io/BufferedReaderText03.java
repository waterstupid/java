package com.xiaofu.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderText03 {
    public static void main(String[] args) {
        try {
            // 读取一个文件
            // 注意：在IDEA IO流的相对路径就是在整个目录之下
            // 而getResourceBundle()传递的文件名，是在src目录下的
            BufferedReader rea=new BufferedReader(new FileReader("index08"));
            String value;
            // BufferedReader中独有的方法readLine()方法，可以读取一行
            // 如果读取不到数据，则返回Null
            while((value=rea.readLine())!= null){
                System.out.println(value);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
