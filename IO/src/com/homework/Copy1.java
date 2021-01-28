package com.homework;

import org.junit.Test;

import java.io.*;

/**
 * 4.	使用缓冲流实现a.jpg文件复制为b.jpg文件的操作
 */
public class Copy1 {

    @Test
    public void copy(){
        BufferedInputStream in = null;
        BufferedOutputStream out = null;
        try {
            in = new BufferedInputStream(new FileInputStream("timg.jpg"));
            out = new BufferedOutputStream(new FileOutputStream("b.jpg"));

            int count;
            byte [] b = new byte[1024];
            while((count = in.read(b)) != -1){
                out.write(b,0,count);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
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
