package com.review01;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 该类是用来测试使用FileInputStream和FileOutputStream来完成对一个图片的复制
 * 注意:非文本的复制只能用字节流来操作,不能用字符流来操作
 */
public class Copy01 {
    /**
     *
     * @param srcName 需要复制的文件名称
     * @param targetName 目标文件名称
     */
    public static void copy(String srcName,String targetName){
        FileInputStream in = null;
        FileOutputStream out = null;
        try {
            // 造流
            in = new FileInputStream(srcName);
            out = new FileOutputStream(targetName);
            byte [] b =new byte[1024];
            int readCount;
            long begin = System.currentTimeMillis();
            // 一边读一边写
            while((readCount = in.read(b)) != -1){
                out.write(b,0,readCount);
            }
            long end = System.currentTimeMillis();
            System.out.println("文件复制一共花了"+(end-begin)+"ms");

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

            try {
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }




    }

    public static void main(String[] args) {

        FileInputStream in = null;
        FileOutputStream out = null;
        try {
            // 造流
            in = new FileInputStream("IO//timg.jpg");
            out = new FileOutputStream("IO//timg01.jpg");
            byte [] b =new byte[1024];
            int readCount;
            // 一边读一边写
            while((readCount = in.read(b)) != -1){
                out.write(b,0,readCount);
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

            try {
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


    }


}
