package com.xiaofu.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class MapDemo {
    public static void main(String[] args) {
        // HashMap是线程不安全的，所以在多线程并发的情况下，会出现ConcurrentModificationException
        // Map<String,String> map = new HashMap<>();
        // 1.使用ConcurrentHashMap 这是线程安全的
        Map<String,String> map = new ConcurrentHashMap<>();
        for(int i = 0; i<30;i++){
            new Thread(() ->{
                map.put(String.valueOf(UUID.randomUUID()),String.valueOf(System.currentTimeMillis()));
                System.out.println(map);
                },String.valueOf(i)).start();
        }



    }
}
