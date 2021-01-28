package com.xiaofu;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 该类用来测试Collection中的方法
 *
 *
 *
 */
public class CollectionText01 {
    public static void main(String[] args) {
        // 创建一个Collection集合
        Collection coo=new ArrayList();
        // 1. void add(Object o)方法,注意:集合当中保存的都是内存地址，集合当中不能保存对象或者基本数据类型
        coo.add(100);//自动装箱
        coo.add("小红");//保存字符串类型的值,其保存的是内存地址
        coo.add(new Object());

        // 2. int size()这个方法可以返回集合当中元素的个数
        System.out.println(coo.size());//3

        // 3. void clear(),这个方法可以清除集合当中所有的元素
        coo.clear();
        System.out.println(coo.size());//0

        // 4. boolean isEmpty()这个方法可以判断集合当中是否还有元素，如果没有，则放回true，如果有，则返回false
        boolean flag = coo.isEmpty();
        System.out.println(flag);//true

        // 5. boolean contains(Object value)这个方法可以判断集合当中是否包含某个元素
        coo.add("小明");
        System.out.println(coo.contains("小明"));//true

        // 6.remove(Object value)这个方法可以将集合中指定的元素移除
        coo.remove("小明");
        System.out.println(coo.size());

        // 7.toArray()这个方法可以将集合变成一个数组
        coo.add(100);//自动装箱
        coo.add("小红");//保存字符串类型的值,其保存的是内存地址
        coo.add(new Object());
        Object[] objects = coo.toArray();
        for (int i = 0; i <objects.length ; i++) {
            System.out.println(objects[i]);
        }





    }


}
