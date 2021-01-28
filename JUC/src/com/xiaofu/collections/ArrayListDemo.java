package com.xiaofu.collections;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 解决ArrayList不安全有三个方法
 * 1.使用Vector
 * 2.使用集合工具类Collections.synchronizedList()
 * 3.使用CopyOnWriterArrayList() 提高读写效率，写实复制，读写分离
 *
 *
 */
public class ArrayListDemo {
    public static void main(String[] args) {
        // List list = new ArrayList<Object>();
        // 首先因为ArrayList中的add方法没有加上synchronized关键字，所以在多个线程并发修改的时候，会出现异常
        // 1.解决办法,使用Vector,Vector中的每个方法都是线程安全的，但是效率较慢
        // List list = new Vector();
        // 2.使用Collections.synchronizedList() 使用工具类让ArrayList变得是线程安全的
        // List list = Collections.synchronizedList(new ArrayList<>());
        // 3.使用CopyOnWriterArrayList
        List list = new CopyOnWriteArrayList<>();
        for(int i = 0; i<30;i++){
            new Thread(() ->{
                list.add(new Object());
                System.out.println(list);
                },String.valueOf(i)).start();
        }
    }
}
