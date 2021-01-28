package com.review;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * BufferedInputStream
 * 是一个字符缓冲输入流,是一个包装流
 *
 *
 *
 *
 */
public class BufferedInputStreamText {
    public static void main(String[] args) {
        BufferedInputStream buffer = null;
        try {
            // 注意:FileInputStream 对 buffer来说是一个节点流,buffer是一个包装流
            buffer = new BufferedInputStream(new FileInputStream("IO//index04"));
            // 以byte数组的方式读入
            byte [] b = new byte[4];
            int readCount = 0;
            while((readCount = buffer.read(b)) != -1){
                System.out.println(new String(b,0,readCount));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
