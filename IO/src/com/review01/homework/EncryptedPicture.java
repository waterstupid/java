package com.review01.homework;

import java.io.*;

/**
 * 实现图片加密操作
 */
public class EncryptedPicture{
    // 该方法用于对图片进行加密
    public static void encrypted(String srcName,String targetName){
        BufferedInputStream in = null;
        BufferedOutputStream out = null;
        try {
            // 1.造流
            in = new BufferedInputStream(new FileInputStream(srcName));
            out = new BufferedOutputStream(new FileOutputStream(targetName));

            // 2.一边读一边写
            byte [] b = new byte[1024];
            int readCount;
            while((readCount = in.read(b)) != -1){
                // 加密就是将图片中的二进制位进行改变
                for (int i = 0; i < readCount; i++) {
                    out.write(b[i]^5);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                // 3.关闭流
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            if (in != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }











    }
    //  该方法用于对图片的解密
    public static void decrypt(String srcName,String targetName){
        BufferedInputStream in = null;
        BufferedOutputStream out = null;
        try {
            // 1.造流
            in = new BufferedInputStream(new FileInputStream(srcName));
            out = new BufferedOutputStream(new FileOutputStream(targetName));

            // 2.一边读一边写
            byte [] b = new byte[1024];
            int readCount;
            while((readCount = in.read(b)) != -1){
                // 加密就是将图片中的二进制位进行改变
                // 用到一个异或操作
                for (int i = 0; i < readCount; i++) {
                    out.write(b[i]^5);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                // 3.关闭流
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            if (in != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }











    }

    public static void main(String[] args) {
        // 首先对图片进行加密
        encrypted("IO//timg.jpg","IO//time04.jpg");
        // 然后对图片进行解密
        decrypt("IO//time04.jpg","IO//time05.jpg");



    }




}
