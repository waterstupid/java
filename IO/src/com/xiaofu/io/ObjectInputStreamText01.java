package com.xiaofu.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * 该程序用来测试反序列化
 * 将保存在硬盘中的对象读取到内存中
 * 调用方法： Object  readObject()
 * @author fmk
 * @date 2020/5/1
 **/
public class ObjectInputStreamText01 {
    public static void main(String[] args) {
        ObjectInputStream in=null;
        try {
            //在这里FileInputStream是一个节点流，in是一个包装流
            in=new ObjectInputStream(new FileInputStream("index09"));
            Object obj = in.readObject();
            System.out.println(obj);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }finally{
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
