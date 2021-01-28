package com.xiaofu;

import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * 该程序用来测试SortedSet存储元素的特点
 * 无序且不可以重复，存进去的元素和取出来的元素不一定相同，但是存储进去的元素可以从小到大的顺序排序
 */
public class SortedSetText01 {
    public static void main(String[] args) {
        SortedSet<Integer> set=new TreeSet<>();
        set.add(100);
        set.add(800);
        set.add(500);
        set.add(900);
        set.add(600);
        //使用增强for循环进行遍历
        for(Integer integer:set){
            System.out.println(integer);
        }
        System.out.println("==================");
        //使用迭代器进行遍历
        Iterator<Integer> it = set.iterator();
        while(it.hasNext()){
            Integer next = it.next();
            System.out.println(next);
        }
    }
}
