package com.xiaofu;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/**
该程序用来测ArrayList中的方法
 **/
public class ArrayListText01 {
    public static void main(String[] args) {
        //可以调用无参构造方法，初始长度就是10
        List<String> list=new ArrayList<>();
        //也可以调用有参构造，给ArrayList赋上初始容量为20
        List<String> list01=new ArrayList<>(20);
        list.add("zs");
        list.add("mike");
        list.add("jack");
        list.add("python");
        list.add("zs");
        list.add("zs");
        list.add("zs");
        list.add("zs");
        list.add("zs");
        list.add("zs");
        list.add("zs");
        list.get(10);
        //List中独有的方法
        //1.add(int index,Object value) 可以向指定位置添加元素
        list.add(1,"ls");

        //2. Object get(int index) 可以通过下标来获取集合当中的元素
        String value = list.get(2);
        System.out.println(value);//jack

        //3.int indexOf(Object value) 可以返回指定元素在集合当中第一次出现的下标
        int index = list.indexOf("jack");
        System.out.println(index);//3

        //4. int lastIndexOf(Object value) 可以返回指定元素在指定集合当中最后一次出现的下标
        int zs = list.lastIndexOf("zs");
        System.out.println(zs);//4

        //遍历list集合的三种方式
        //1.list当中特有的遍历方式,有下标集合当中的特有方式
        for (int i = 0; i <list.size() ; i++) {
            System.out.println(list.get(i));
        }
        System.out.println("========================");
        //2.采用增强foreach来遍历该集合
        for(String string:list){
            System.out.println(string);
        }
        System.out.println("========================");
        //3.采用迭代器的方式
        Iterator<String> it = list.iterator();
        while(it.hasNext()){
            String value1 = it.next();
            System.out.println(value1);
        }





    }
}
