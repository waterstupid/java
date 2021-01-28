package com.xiaofu.io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 该程序用来测试字符输入流，注意这种类型的流只能读取纯文本文件，其每次以字符的方式读取
 * @author fmk
 * @date 2020/4/30
 **/
public class FileReaderText01 {
    public static void main(String[] args) {
        FileReader reader = null;
        try {
            //调用有参构造
             reader=new FileReader("IO//index01");
            //1.调用read()方法，每次只能读取一个字符
            //int read = reader.read();//注意，调用该方法返回的是一个int类型的字符
             int readCount=0;
             while((readCount=reader.read())!=-1){
                 System.out.println(readCount);
             }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
