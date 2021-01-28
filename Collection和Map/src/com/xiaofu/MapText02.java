package com.xiaofu;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 改程序用来测试如何遍历Map结合
 * 两种方式：
 * 1.通过keySet()方法得到所有的Key,然后通过get(K key)的方式，来得到所有的value，效率较低
 * 2.通过entrySet()方法将Map集合转换成一个Set集合，Set集合保存的其实是节点，然后对该Set集合进行遍历
 * 该方法效率较快，适合大数据的时候使用
 *
 */
public class MapText02 {
    public static void main(String[] args) {
        Map<Integer,String> map=new HashMap<>();
        map.put(1,"jack");
        map.put(2,"mike");
        map.put(3,"john");
        map.put(4,"king");
        //第一种方式，首先得到所有的key，然后通过get()方法去获取所有的value
        Set<Integer> set = map.keySet();
        //迭代器方式去遍历
        Iterator<Integer> it = set.iterator();
        while(it.hasNext()){
            Integer key = it.next();
            String value = map.get(key);
            System.out.println(value);
        }
        System.out.println("================");
        //利用增强for循环去遍历
        for(Integer element:set){
            System.out.println(map.get(element));
        }

        //第二种方式，将Map集合转换成一个Set集合，然后遍历
        Set<Map.Entry<Integer, String>> entrySet = map.entrySet();
        //通过增强for循环去遍历
        for (Map.Entry<Integer, String> entry:entrySet){
            System.out.println("key ="+entry.getKey()+",value= "+entry.getValue());
        }
        //通过迭代器去遍历
        Iterator<Map.Entry<Integer, String>> it1 = entrySet.iterator();
        while(it1.hasNext()){
            Map.Entry<Integer, String> node = it1.next();
            System.out.println("key=" +node.getKey()+",value="+node.getValue());
        }


    }


}
