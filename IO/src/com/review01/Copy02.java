package com.review01;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 注意:字符流只能处理纯文本文件,对于不是纯文本文件不能处理,比如图片视频等
 * 目前字符流:FileReader,FileWriter
 *
 *
 *
 */
public class Copy02 {
    public static void copy(String srcName,String targetName){
        FileReader reader = null;
        FileWriter writer = null;
        try {
            // 造流
            reader = new FileReader("IO//"+srcName);
            writer = new FileWriter("IO//"+targetName);
            // 一边读取文件一边写入
            char [] c = new char[4];
            int readCount;
            long start = System.currentTimeMillis();
            while((readCount = reader.read(c)) != -1){
                writer.write(c,0,readCount);
            }
            long end = System.currentTimeMillis();
            System.out.println("文件复制用了"+(end-start)+"ms");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭流
            if (writer != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (reader != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        // 测试用字符流的方式来复制一张图片
        // 注意:使用这种方式复制一张图片是打不开的
        copy("timg.jpg","timg02.jpg");
        copy("index02","index022");


    }


}
