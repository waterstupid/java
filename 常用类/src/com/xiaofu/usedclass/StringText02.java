package com.xiaofu.usedclass;

/**
 * 该程序用来测试String的特性
 * @author fmk
 * @date 2020/5/8
 **/
public class StringText02 {
    public static void main(String[] args) {
        // 下面两行代码创建出了几个对象
        // 3个,在堆内存中两个，方法区内存的字符串常量池一个
        String s1=new String("abc");
        String s2=new String("abc");
    }
}
