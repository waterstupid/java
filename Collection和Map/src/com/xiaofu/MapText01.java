package com.xiaofu;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * 该程序用来测试Map集合中的常用方法
 * 1.put(K k,V v) 往集合中存储数据
 * 2.get(K k) 从集合中获取元素
 * 3.size() 返回集合中元素的个数
 * 4.remove(K k) 从集合中删除某个元素
 * 5.isEmpty() 判断集合是否为空
 * 6.containsKey(K k) 判断集合中是否包含某个元素
 * 7.containsValue(V v) 通过value判断结合中是否包含某个元素
 * 8.keySet() 得到map集合的所有key值，返回一个set集合
 * 9.entrySet() 将map集合转换成set集合，set集合中保存的元素的格式是key=value
 */
public class MapText01 {
    public static void main(String[] args) {
        Map<Integer,String> map=new HashMap<>();
        //1.put(K k,V v) 往集合中存储数据
        map.put(1,"jack");
        map.put(2,"mike");
        map.put(3,"john");
        map.put(4,"king");

        //2.get(K k) 从集合中获取元素
        String value = map.get(1);
        System.out.println(value);

        //3.size() 返回集合中元素的个数
        System.out.println(map.size());

        //4.remove(K k) 从集合中删除某个元素
        map.remove(1);

        //5.isEmpty() 判断集合是否为空
        boolean flag = map.isEmpty();
        System.out.println(flag);

        //6.containsKey(K k) 判断集合中是否包含某个元素
        System.out.println(map.containsKey(2));

        //7.containsValue(V v) 通过value判断结合中是否包含某个元素
        System.out.println(map.containsValue("king"));

        //8.keySet() 得到map集合的所有key值，返回一个set集合
        Set<Integer> set = map.keySet();
        //遍历这个Map集合
        for(Integer element:set){
            System.out.println(map.get(element));
        }

        //9.entrySet() 将map集合转换成set集合，set集合中保存的元素的格式是key=value
        Set<Map.Entry<Integer, String>> entries = map.entrySet();
        //遍历这个集合
        for(Map.Entry<Integer, String> entry:entries){
            System.out.println("key ="+entry.getKey()+"value ="+entry.getValue());
        }



    }
}
