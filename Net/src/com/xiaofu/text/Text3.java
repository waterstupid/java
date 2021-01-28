package com.xiaofu.text;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author fmk
 * @date 2020/5/15
 **/
public class Text3 {
    public static void main(String[] args) {
        try {
            FileInputStream in=new FileInputStream("index03");
            byte[] bytes=new byte[1024];
            int i = in.read(bytes);
            System.out.println(i);
            System.out.println(in.read(bytes));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
