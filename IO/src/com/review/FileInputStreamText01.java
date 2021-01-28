package com.review;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * FileInputStream 是一个字节输入流,是用来读取文件的,是以一个一个字节来读取文件的，FileInputSt
 * tream一定为节点流,不可能为包装流
 * FileInputStream:该流可以读取所有的文件
 *
 * 一定为节点流:FileInputStream,FileOutputStream,FileReader,FileWriter,
 *
 * 一定为包装流:BufferedInputStream,BufferedOutputStream,BufferedReader,BufferedWriter
 * ,ObjectInputStream,ObjectOutputStream,DataInputStream,DataOutputStream
 *
 * 可能为包装流,也可能为节点流:InputStreamReader,OutputStreamWriter(两种转换流)
 *
 */
public class FileInputStreamText01 {

    public static void main(String[] args) {
        FileInputStream in = null;
        try {
            in = new FileInputStream("IO//index01");
            // 每次读取4个字节
            byte [] b =new byte[4];
            int readCount= 0;
            // 以byte数组的方式来读取文件
            while((readCount = in.read(b)) !=-1){
                System.out.println(new String(b,0,readCount));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


}
