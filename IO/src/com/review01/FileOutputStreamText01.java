package com.review01;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * FileOutputStream
 * 该流是文件流，也就是节点流,是每次以字节的方式向文件中写入数据的
 *
 */

public class FileOutputStreamText01 {
    public static void main(String[] args) {
        FileOutputStream out = null;
        try {
            // 造流
            out = new FileOutputStream("IO//text");
            // 向文件中写数据,以byte数组的方式写入到文件中
            out.write("我是一个中国人".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(out != null){
                    // 关闭流
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }





    }


}
