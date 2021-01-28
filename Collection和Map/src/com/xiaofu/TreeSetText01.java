package com.xiaofu;

import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * 该程序用来测试TreeSet集合中的特点
 * 无序不可重复，但是可以根据元素的大小来排序
 * 底层的数据结构是平衡二叉树
 */
public class TreeSetText01 {
    public static void main(String[] args) {
        SortedSet<String> set=new TreeSet<>();
        set.add("king");
        set.add("jack");
        set.add("john");
        set.add("mike");
        Iterator<String> it = set.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }


    }
}
