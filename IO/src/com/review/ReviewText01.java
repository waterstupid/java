package com.review;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 复习一下
 * @author fmk
 * @date 2020/5/3
 **/
public class ReviewText01 {
    public static void main(String[] args) {
        try {
            FileInputStream in=new FileInputStream("IO//index03");
            byte [] b=new byte[4];
            int readCount=0;
            while((readCount=in.read(b)) != -1){
                System.out.print(new String(b,0,readCount));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
