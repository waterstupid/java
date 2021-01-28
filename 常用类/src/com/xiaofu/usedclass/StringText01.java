package com.xiaofu.usedclass;

/**
 * 该程序用来测验java.lang.String类中的特点
 * 1.String是SUN公司写的一个类，在java.lang包中
 * 2.String类是一种引用数据类型
 * 3.String类是被final关键字修饰的，不可变，也不能被继承
 * 4.字符串一旦被创建，就不会被改变，直到销毁
 * 5.字符串的创建有两种方式
 *  1.String s="abc" 用这种方式创建字符串"abc",不会在堆内存中创建出一个对象，但是会在方法区中有一个字符串常量池，会在字符串
 *  常量池中创建一个"abc"的对象，那么下一次如果再有"abc"对象创建，那么就会直接在字符串常量池中取出
 *  2.String s=new String("cde") 用这种方式创建字符串对象，首先会在堆内存中开辟出一块内存空间，用来存放字符串对象，然后会
 *  从方法区的字符串常量池中，寻找有没有"cde"这个字符串，如果没有，则在字符串常量池中创建出来，并将该字符串在常量池中内存地址
 *  保存到堆内存的对象中
 *  6.所以我们还是建议使用第一种方式创建字符串对象，因为第一种不会在堆内存中创建出新的对象，从而浪费内存空间
 * @author fmk
 * @date 2020/5/8
 **/
public class StringText01 {
    public static void main(String[] args) {
        String s="abc";
        String s1=new String("abc");
        String s2="abc";
        // false 因为s引用保存的是"abc"在常量池中的内存地址，而s1保存的是字符串对象在堆内存中的内存地址
        // 所以两者的内存地址是不同的
        System.out.println(s==s1); // false
        System.out.println(s.equals(s1));// true 因为字符串中重写equals()方法
        System.out.println(s==s2);// true






    }
}
