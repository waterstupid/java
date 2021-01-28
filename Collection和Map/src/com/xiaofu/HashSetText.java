package com.xiaofu;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
    该程序用来测试HashSet集合存储元素的特点
    无序且不可以重复：
    无序：值存进去的顺序和取出来的顺序不一定相同
    不可重复：值不能存储相同的值
 **/
public class HashSetText {
    public static void main(String[] args) {
        Set<String> set=new HashSet<>();
        set.add("abc");
        set.add("cde");
        set.add("efg");
        set.add("fjd");
        set.add("adfs");
        set.add("ds");
        set.add("ad");
        set.add("efg");
        set.add("efg");
        //遍历
        for(String string:set){
            System.out.println(string);
        }
        System.out.println("===========");
        //利用迭代器进行遍历集合
        Iterator<String> it = set.iterator();
        while(it.hasNext()) {
            String next = it.next();
            System.out.println(next);
        }
    }
}
