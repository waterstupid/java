package com.review;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * ObjectOutputStream 是一个包装流,可以将对象以字节流的方式写入到文件中
 * 这种方式也叫做对象的序列化
 *
 *
 */
public class ObjectOutputStreamText01 {
    public static void main(String[] args) {
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(new FileOutputStream("IO//index10"));
            User user = new User();
            user.setId(1);
            user.setName("李四");
            // 将对象写入到文件中
            out.writeObject(user);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
