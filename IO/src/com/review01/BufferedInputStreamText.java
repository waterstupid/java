package com.review01;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * BufferedInputStream
 * 1.这是一个字节输入流,同样也是用来读取文件的
 * 2.这是一个缓冲流，也就是一个处理流
 * 3.使用该流的效率一般比使用FileInputStream的效率高
 * 4.工作中常用的都是BufferedInputStream
 * 5.BufferedInputStream效率高的主要原因是其中有个8KB缓冲区,该缓冲区可以加快效率
 *
 */
public class BufferedInputStreamText {
    public static void main(String[] args) {
        BufferedInputStream buffered = null;
        try {
            // buffered是一个处理流,FileInputStream是一个节点流
            buffered = new BufferedInputStream(new FileInputStream("IO//index02"));
            // 读取文件
            int readCount;
            byte [] b = new byte[4];
            while((readCount = buffered.read(b)) != -1){
                System.out.println(new String(b,0,readCount));
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
