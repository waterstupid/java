package com.xiaofu.collections;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * HashSet的底层结构
 * 1.HashSet的底层数据结构就是一个HashMap,也就是说在构造方法中new HashMap()
 * 2.但是HashMap是以键值对的方式存储数据的，但是HashSet是以单个键存储数据的，怎么解决的？
 * 首先在HashSet的put的方法，将添加的元素作为HashMap的key值，而HashMap的value值是不变的
 * ，都是一个present的Object常量
 *
 *
 */
public class SetDemo {
    public static void main(String[] args) {
        // Set set = new HashSet();
        // 这里会出现线程安全问题
        // 1.使用工具类的方法来使HashSet变为线程安全的集合
        // Set set = Collections.synchronizedSet(new HashSet<>());
        // 2.使用CopyOnWriterArraySet()
        Set set = new CopyOnWriteArraySet();
        for(int i = 0; i<30;i++){
            new Thread(() ->{set.add(new Object());
                System.out.println(set);},String.valueOf(i)).start();
        }






    }



}
