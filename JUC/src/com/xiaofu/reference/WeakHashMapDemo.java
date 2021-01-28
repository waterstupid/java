package com.xiaofu.reference;

import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

public class WeakHashMapDemo {
    public static void main(String[] args) {
        // 在HashMap中，即使key这个引用指向的对象被回收掉，也不会应用HashMap中的存储值
        /*Map<Object,Object> map = new HashMap<>();
        Object key = new Object();
        map.put(key,new Object());
        System.out.println("回收之前,map="+map);
        key = null;
        System.gc();
        System.out.println("回收之后,map="+map);
        */
        // 但是WeakMap就不一样
        WeakHashMap<Object,Object> weakMap = new WeakHashMap<>();
        Object o = new Object();
        weakMap.put(o,new Object());
        System.out.println("回收之前,Map="+weakMap);
        o = null;
        System.gc();
        System.out.println("回收之后，Map="+weakMap); // null





    }


}
