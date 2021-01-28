package com.review01;

import java.io.FileWriter;
import java.io.IOException;

/**
 * FileWriter:
 * 1.FileWriter是一个字符输出流,也是一个文件流,是用来向文件中写入数据的
 * 2.每次是一个字符的方式向文件中写入
 *
 *
 */
public class FileWriterText {
    public static void main(String[] args) {
        FileWriter writer = null;
        try {
            // 1.造流,注意:这里如果没有该文件,会自动创建这个文件,默认是采用覆盖的方式
            // 当然也可以通过构造函数来改变这种处理方式
            // writer = new FileWriter("IO//text02");
            writer = new FileWriter("IO//text02",true);
            //2.写入数据,write()写入数据的时候默认是不换行的
            writer.write("我是一个中国人\n");
            writer.write("我是一个中国人\n");
            writer.write("我是一个中国人\n");
            System.out.println("写入操作完成");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                // 3.关闭流
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }


}
