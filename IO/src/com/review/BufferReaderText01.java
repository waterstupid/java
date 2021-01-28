package com.review;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

public class BufferReaderText01 {
    public static void main(String[] args) {
        BufferedReader buffer = null;
        try {
            buffer = new BufferedReader(new InputStreamReader(new FileInputStream("IO//index04")));
            char [] b =new char[4];
            int readCount = 0;
            while((readCount = buffer.read(b)) != -1){
                System.out.println(new String(b,0,readCount));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }




}
