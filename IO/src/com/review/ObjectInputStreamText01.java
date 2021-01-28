package com.review;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * ObjectInputStream 是一个对象输入流,是用来读取文件中对象的
 * 这是一个包装流
 * 这个也叫做对象的反序列化
 *
 */
public class ObjectInputStreamText01 {
    public static void main(String[] args) {
        ObjectInputStream in = null;
        try {
            in = new ObjectInputStream(new FileInputStream("IO//index10"));
            User user = (User) in.readObject();
            System.out.println(user);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


}
