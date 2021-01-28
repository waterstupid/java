package com.collection.linked;

import java.io.Serializable;
import java.util.*;

public class Text implements Serializable {
    private static final long serialVersionUID = -4779374974975820567L;

    public static void main(String[] args) {
        /*List<String> list =new LinkedList<>();
        list.add("jack");
        list.add("king");
        list.add("mike");*/
        //JDK 13.0.1 ArrayList在创建对象的时候，并没有为底层的数组设置默认初始容量
        //而是将一个默认空的数组赋给了底层的保存数据的数组
        List<String> list=new ArrayList<String>();


        //JDK 13.0.1 是在调用add方法的时候，这个时候，底层才会把底层保存数据的数组初始容量设置为10
      /*  list.add("abc");

        List<String> list01=new Vector<>();
        List<String> list02=new Vector<>(20,10);
        list01.add("abc");
        list01.add("abc");
        list01.add("abc");
        list01.add("abc");
        list01.add("abc");
        list01.add("abc");
        list01.add("abc");
        list01.add("abc");
        list01.add("abc");
        list01.add("abc");
        list01.add("abc");
        System.out.println(15>>1);
        Map map=new HashMap();*/
        SortedMap<Integer,String> sorted=new TreeMap<>();
        sorted.put(1,"jack");
        sorted.put(2,"john");






    }

}
