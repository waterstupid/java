package com.review01;

import java.io.*;

/**
 * InputStreamReader:
 * 1.这是一个输入流
 * 作用:将字节输入流转换为字符输入流 (解码)
 * 是将一个字节输入流转换位字符输入流
 *
 * OutputStreamWriter:
 * 1.这是一个输出流，转换流
 * 2作用:是将一个字符输出流转换为字节输出流 (编码)
 *
 *
 */
public class InputStreamReaderText {
    public static void main(String[] args) {
        InputStreamReader in = null;
        OutputStreamWriter out = null;
        try {
            // 造流
            in = new InputStreamReader(new FileInputStream("IO//dbcp.txt"));
            out = new OutputStreamWriter(new FileOutputStream("IO//dbcp01.txt"));

            // 一边读一边写
            char [] c = new char[1024];
            int readCount;
            while((readCount = in.read(c)) != -1){
                // 写入到文件当中
                out.write(new String(c,0,readCount));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                // 将流进行关闭
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }









    }


}
