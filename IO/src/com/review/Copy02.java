package com.review;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Copy02 {
    public static void main(String[] args) {
        FileInputStream in = null;
        FileOutputStream out = null;

        try {
            in = new FileInputStream("IO//index02");
            out = new FileOutputStream("IO//index08");
            byte [] b = new byte[4];
            int readCount = 0;
            while((readCount=in.read(b)) != -1){
                // 一边读一边写
                out.write(b);
            }
        } catch (Exception e) {

        }


    }


}
