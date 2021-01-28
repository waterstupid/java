package com.xiaofu.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author fmk
 * @date 2020/5/11
 **/
public class Text {
    public static void main(String[] args) {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
