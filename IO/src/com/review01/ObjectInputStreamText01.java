package com.review01;

import org.junit.Test;

import java.io.*;

/**
 * ObjectInputStream和ObjectOutputStream
 * 1.这两个流都是字节流
 * 2.这两个流都是用来处理和对象有关
 * 3.ObjectOutputStream 可以将基本数据类型或者引用数据类型的数据写入文件中
 *
 * 二:什么是序列化和反序列化？
 * 序列化:将java中的对象以二进制的形式写入到文件中就叫做序列化
 * 反序列化:可以将保存再文件中的二进制数据源返还成一个java对象的过程就叫做反序列化
 *
 * 三:序列化需要注意的点
 * 1.首先，被序列化的对象要实现一个Serializable接口,该接口中没有方法，只是一个标识接口
 * 2.类中需要有一个序列化版本号来指定版本号
 * 3.对象中的其他属性如果是引用类型也要实现Serializable接口
 * 4.被static和transient修饰的变量不会参与序列化,因为序列化只序列和对象相关的属性
 *

 */



public class ObjectInputStreamText01 {
    /**
     * 该方法用来将对象序列化
     */
    @Test
    public void writeObject(){
        ObjectOutputStream out = null;
        try {
            // 造流
            out = new ObjectOutputStream(new FileOutputStream("data.txt"));
            // 写入对象
            User user = new User( 1, "张三");
            out.writeObject(user);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                // 关闭流
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 该方法用于将对象进行反序列化
     */
    @Test
    public void readObject(){
        ObjectInputStream in = null;
        try {
            // 造流
            in = new ObjectInputStream(new FileInputStream("data.txt"));

            // 读取对象
            User user = (User) in.readObject();
            System.out.println(user);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                //关闭
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }





}
