package com.review01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * BufferedReader
 * 1.这是一个字符输入流，同样也是一个缓冲流
 * 2.该流每次都是以字符的方式来读取文件的
 * 3.其中有一个特殊方法readLine()读取一行的数据,如果下一行没有的话，则返回null
 *
 *
 */
public class BufferedReaderText {
    public static void main(String[] args) {
        BufferedReader buffered = null;
        try {
            // 造流
            buffered = new BufferedReader(new FileReader("IO//index02"));

            // 读取文件
            String data;
            while((data = buffered.readLine()) != null){
                // 一行一行输出
                System.out.println(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (buffered != null) {
                // 关闭流
                try {
                    buffered.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }




    }
}
