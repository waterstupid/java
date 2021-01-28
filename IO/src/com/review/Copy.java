package com.review;

import java.io.*;

public class Copy {
    public static void main(String[] args) {
        FileInputStream in = null;
        FileOutputStream out = null;
        try {
            in = new FileInputStream("IO//index02");
            out = new FileOutputStream("IO//index07");
            // 一次性获取
            byte [] b = new byte[in.available()];
            // 首先将文件中的内容读取出来
            in.read(b);
            // 然后将内容写入到新文件中
            out.write(b);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(in != null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(out != null){
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


        }


    }



}
