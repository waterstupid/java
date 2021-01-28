package com.review01;

import java.io.*;

/**
 * OutputStreamWriter
 * 1.这是一个转化流，将字符输出流转换为字节输出流(也就是编码)
 *
 *
 */
public class OutputStreamWriterText {

    public static void main(String[] args) {
       /* OutputStreamWriter writer = null;
        try {
            // 指定以GBK的方式来进行编码,就是将写入的中文难按照GBK这种编码格式来进行编码
            writer = new OutputStreamWriter
                    (new FileOutputStream("IO//count01.txt"),"GBK");
            // 这里要按照GBK的方式来读取
            // 写
            writer.write("我是一个中国人");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }*/
        read1();
    }

    private static void read(){
        InputStreamReader reader = null;
        try {
            reader = new InputStreamReader(new FileInputStream("IO//count01.txt"),"GBK");
            char [] c = new char[4];
            int readCount;
            while((readCount = reader.read(c)) != -1){
                System.out.print(new String(c,0,readCount));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }
    private static void read1(){
        FileInputStream in = null;
        try {
            in = new FileInputStream("IO//count01.txt");
            byte [] b = new byte[4];
            int readCount;
            while((readCount = in.read(b)) != -1){
                System.out.print(new String(b,0,readCount,"GBK"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }

}
