package com.collection.linked;

/**
 * 该程序用来测试单向链表
 */
public class LinkText {
    public static void main(String[] args) throws DataIsNotExits {
        Link link=new Link();
        //测试add()方法
        link.add("abc");
        link.add("cde");
        link.add("fdz");
        link.add("hjk");
        link.add("jsa");
        link.add("kls");
        //测试size()方法
        int size = link.size();
        System.out.println(size);

        //测试get()方法
        Object value = link.get(4);
        System.out.println(value);

        //测试remove()方法
        link.remove("cde");
        System.out.println(link.get(1));
        System.out.println(link.size());
        link.remove("abc");
        //删除最后一个元素
        link.remove("kls");
        System.out.println(link.get(link.size()-1));
//        link.remove("kslsdf");

        //测试contains(Object object)方法
        boolean flag = link.contains("abc");
        System.out.println(flag);//false


    }

}
