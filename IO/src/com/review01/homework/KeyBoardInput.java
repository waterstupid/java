package com.review01.homework;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 从键盘输入字符串，要求将读取到的整行字符串转成大写输出。然后继续
 * 进行输入操作，直至当输入“e”或者“exit”时，退出程序。
 *
 * 我们要用到System.in 该变量返回的是一个InputStream,默认读取键盘输入
 */
public class KeyBoardInput {
    public static void main(String[] args) {
        // 1.造流
        // 将inputStream转换成一个reader
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            while(true){
                System.out.println("请输入你想要输入的字符串:");
                String value = reader.readLine();
                if("e".equals(value) || "exit".equals(value)){
                    System.out.println("程序运行结束");
                    break;
                }
                // 将输入的字符串转换为大写
                value = value.toUpperCase();
                System.out.println(value);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    }
    @Test
    public void keyboard01(){
        // system.in默认获取键盘输入
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("请输入您想要的输入的字符串");
            while(true){

                String value = reader.readLine();
                if("e".equals(value) || "exit".equals(value)){
                    break;
                }else{
                    // 将字符串转换为大写
                    System.out.println(value.toUpperCase());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }




    }





}
