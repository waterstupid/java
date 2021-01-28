package com.xiaofu.usedclass;

import org.w3c.dom.ls.LSOutput;

/**
 * 该程序用来测试String类中的常用构造方法
 * 1.String s=new String("abc");
 * 2.String s=new String(byte [] b,int start,int end);
 * 3.String s=new String(char[] c,int start,int end);
 * @author fmk
 * @date 2020/5/8
 **/
public class StringText03 {
    public static void main(String[] args) {
        // byte数组只能装整数型的字面量
        byte [] b={97,98,99};
        System.out.println(new String(b));// a b c
        System.out.println(new String(b,0,3));
        char [] c={'中','国','人'};
        System.out.println(new String(c));// 中国人





    }

}
