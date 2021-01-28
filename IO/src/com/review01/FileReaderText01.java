package com.review01;

import java.io.FileReader;
import java.io.IOException;

/**
 * FileReader
 * 1.这是一个节点流,也是一个输入流,也是一个字符流
 * 2.一般用来读取纯文本文件
 * 3.每次以一个字符的方式来读取
 * 4.也可以每次以char [] 数组的方式来读取文件
 *
 *
 */
public class FileReaderText01 {
    public static void main(String[] args) {
        FileReader reader = null;
        try {
            // 1.造流
            reader = new FileReader("IO//count01.txt");

            // 2.读取文件
            // 代表的是每次以4个字符的方式来读取文件
            char [] c= new char[4];
            int readCount;
            while((readCount = reader.read(c)) != -1){
                // 将char数组转换为字符串
                System.out.print(new String(c,0,readCount));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                // 3.关闭流
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }








    }



}
