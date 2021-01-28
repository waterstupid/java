package com.xiaofu;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * 该程序用来使用迭代器对集合进行遍历
 * 在Iterator()接口中有三个方法
 * Boolean      hasNext() 如果下一行集合中有元素，则返回true，如果下一行集合中没有元素，则返回false
 * Object       next() 该方法执行一次，迭代器就会下移一位，可以返回当前行的元素
 * void         remove()
 * 注意：所有实现或者继承Collection接口的类都可以使用迭代器去遍历集合当中的元素
 */
public class CollectionText02 {
    public static void main(String[] args) {
        Collection coo=new ArrayList();
        coo.add(100);
        coo.add(200);
        coo.add(300);
        coo.add(400);
        coo.add(300);
        coo.add(400);
        //调用Iterator(),迭代器方法
        Iterator it = coo.iterator();
        while(it.hasNext()){
            Object value = it.next();
            System.out.println(value);
        }
        System.out.println(10>>2);

    }
}
