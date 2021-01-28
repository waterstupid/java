package com.review01;

import java.io.*;

/**
 * 该类使用BufferedInputStream和BufferedOutputStream来完成视频的复制
 */
public class Copy03 {
    public static void copy(String srcName,String targetName){
        BufferedInputStream in = null;
        BufferedOutputStream out = null;
        try {
            // 造流
            in = new BufferedInputStream(new FileInputStream(srcName));
            out = new BufferedOutputStream(new FileOutputStream(targetName));
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
        // 比较视频复制的快慢
        // 所以说BufferedInputStream处理速度较快
        copy("E://01.rmvb","E://02.rmvb");
        Copy01.copy("E://01.rmvb","E://03.rmvb");


    }

}
