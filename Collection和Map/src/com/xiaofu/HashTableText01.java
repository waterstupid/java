package com.xiaofu;

import java.util.Hashtable;
import java.util.Map;

/**
 * 该程序用来测试HashTable
 * Hashtable是线程安全的，但是键值对不能存储null
 */
public class HashTableText01 {
    public static void main(String[] args) {
        Map<Integer,String> map=new Hashtable<>();
//        map.put(null,null); 这里会报空指针异常


    }
}
