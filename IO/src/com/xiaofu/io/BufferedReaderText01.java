package com.xiaofu.io;

import java.io.*;

/**
 * 该程序用来测试BufferedReader中的方法
 * 注意：
 * 1.readLine()这个方法是可以读取一行，但是不会自动换行
 * 2.readLine()这个方法如果读取不到数据，会返回null,而不是-1
 * @author fmk
 * @date 2020/4/30
 **/
public class BufferedReaderText01 {
    public static void main(String[] args) {
        BufferedReader br=null;
        try {
            //FileInputStream相对于InputStreamReader来说是一个节点流，而InputStreamReader
            //相对于br来说也是一个节点流，br是一个包装流
            //br=new BufferedReader(new InputStreamReader(new FileInputStream("index04")));
            br=new BufferedReader(new FileReader("IO//index04"));
            System.out.println(br.readLine());
            //注意：如果readLine()中读取不到元素，是返回null，而不是返回-1
            System.out.println(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            if ( br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}
