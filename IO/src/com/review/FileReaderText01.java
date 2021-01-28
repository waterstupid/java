package com.review;

import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * 注意:以Reader和Writer结尾的流都是字符流
 *
 *
 * FileReader:一定是一个节点流，这是一个字符输入流，也就是每次是以一个字符的方式从文件中读取数据
 *
 *
 *
 *
 */
public class FileReaderText01 {
    public static void main(String[] args) {
        FileReader reader = null;
        try {
            // 读取文件
            reader = new FileReader("IO//index01");
            // 以字符的方式来读取文件
            // reader.read(); 该方法每次读取一个字符到数组中
            char [] c = new char[4];
            int readCount = 0;
            while((readCount = reader.read(c)) != -1){
                System.out.println(new String(c,0,readCount));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }





}
