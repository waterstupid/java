package com.xiaofu;

import java.util.HashMap;
import java.util.Map;

/**
 * 底层采用的是哈希表，
 * 其key值的所有取值就是一个HashSet集合，线程不安全的
 *
 * 1.底层实现其实是一个数组，数组中存放的是单向链表，
 * 数组的初始容量是16，其加载因子为0.75，就是说当数组
 * 容量达到原容量的0.75的时候，数组开始扩容
 *
 * 2.数组中每个元素都是单向链表，单向链表中每个节点都
 * 有hash值，key,value，和保存了下一个节点内存地址的节点
 * ,hash值相同的元素一定在同一个单向链表中，hash值不同的
 * 元素也有可能在同一个链表当中（哈希碰撞）
 *
 * 3.put(K k,V v)原理：首先调用k的hashCode()方法，来获取哈希值，然后通过哈希
 * 算法从而得到数组的下标，如果数组下标所在数组位置的内容为空，则直接
 * 将k,v封装成一个节点对象，保存到指定数组位置，如果数组下标所在数组位置
 * 有单向链表，则继续调用k的equals()方法，和单向链表中每个节点的key值进行
 * 比较，如果都是返回false，则将k,v封装成一个节点对象，添加到单向链表的尾部
 * ，如果有一个返回的是true，则对返回true节点对象中的value进行覆盖
 *
 * 4.get(K k)原理：首先还是要通过k调用hashCode()找出hash值，然后通过hash算法
 * ，得到数组下标，如果数组下标所在数组位置的内容为null,则返回null，如果不为
 * null，则与单向链表中每一个key值进行equals()比较，如果都是返回false，则
 * 继续返回null,如果和某一个节点比较返回true,则将该节点中保存的value返回
 * 最终结论：往HashMap和HashSet中存储元素，元素所在的类一定要重写hashCode()
 * 和equals()方法，不然会出现错误
 *
 *
 *
 */
public class HashMapText {
    public static void main(String[] args) {
        Map<Integer,String> map=new HashMap<>();
        map.put(1,"jack");
        map.put(2,"john");
        map.put(3,"mike");
        //HashMap集合中的key值不能重复，如果重复了，value值将会覆盖
        map.put(4,"king");
        map.put(4,"KING");
        System.out.println(map.size());//4
        System.out.println(map.get(4));//KING




    }
}
