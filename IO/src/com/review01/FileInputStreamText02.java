package com.review01;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * 该类来测试FileInputStream 中的 read(byte[] b) 方法中有关数组的问题
 */
public class FileInputStreamText02 {
    public static void main(String[] args) {
        FileInputStream in = null;
        try {
            // 造流
            in = new FileInputStream("IO//index01");
            // 一次以三个字节的方式来从文件中读取数据
            byte [] b = new byte[3];
            int readCount;
            // 读取文件
            while((readCount = in.read(b)) != -1){
                // 这样是将整个数组内容转换为字符串输出出来，但这样会出现问题
                // 最终的输出结果是helloworldrl,所以不能这样输出,而是应该输出每次从文件中
                // 读取的字节个数
                // System.out.print(new String(b,0,b.length));
                // 这样写就没有问题
                System.out.print(new String(b,0,readCount));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭流
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }




    }


}
