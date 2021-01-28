package com.xiaofu.io;

import java.io.*;

/**
 * 该程序同样用来测试BufferedReader中的方法
 * @author fmk
 * @date 2020/4/30
 **/
public class BufferedReaderText02 {
    public static void main(String[] args) {

        BufferedReader rea=null;
        try {
            rea=new BufferedReader(new InputStreamReader(new FileInputStream("IO//index03")));
            String readCount=null;
            while((readCount=rea.readLine()) != null){
                System.out.println(readCount);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (rea != null) {
                try {
                    rea.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
