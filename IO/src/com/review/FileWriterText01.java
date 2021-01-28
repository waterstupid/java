package com.review;

import java.io.FileWriter;
import java.io.IOException;

/**
 * FileWriter 是一个字符输出流，也是就是说以字符的方式将数据写入到文件中
 *
 * FileWriter 一定是一个节点流
 *
 *
 *
 *
 */
public class FileWriterText01 {
    public static void main(String[] args) {
        FileWriter writer = null;
        try {
            writer = new FileWriter("IO//index09");
            // 可以以字符串的类型输入到文件中
            writer.write("我是中国人");
            writer.write("我");

        } catch (IOException e) {
            e.printStackTrace();
        }


    }



}
