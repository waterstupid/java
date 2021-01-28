package com.review01;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * BufferedOutputStream
 * 1.这是一个缓冲流,字节输出流
 * 2.每次写入文件是以字节的方式写入到文件中的
 *
 *
 */
public class BufferedOutputStreamText {
    public static void main(String[] args) {
        BufferedOutputStream out = null;
        try {
            // 1.造流
            out = new BufferedOutputStream(new FileOutputStream("IO//text03"));
            // 2.写数据
            out.write("我是一个中国人".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                // 3.关闭流
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
