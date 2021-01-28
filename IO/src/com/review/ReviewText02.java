package com.review;

import com.xiaofu.io.FileOutputStreamText01;

import java.io.*;

/**
 * @author fmk
 * @date 2020/5/3
 **/
public class ReviewText02 {
    public static void main(String[] args) {
        try {
            /*
            FileOutputStream out=new FileOutputStream("index08");
            byte [] b={97,98,99,100};
            out.write(b);

             */
            FileWriter writer= new FileWriter("index08");
            writer.write("我是一个中国人，加油");
            //out.flush();
            writer.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
