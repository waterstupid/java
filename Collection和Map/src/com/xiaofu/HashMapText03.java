package com.xiaofu;

import java.util.HashMap;
import java.util.Map;

/**
 * HashMap中的键值对都能存储Null
 */

public class HashMapText03 {
    public static void main(String[] args) {
        Map map=new HashMap();
        map.put(null,null);

        System.out.println(map.size());//1
        map.put(null,"jack");
        System.out.println(map.size());//1
        System.out.println(map.get(null));//jack

    }
}
