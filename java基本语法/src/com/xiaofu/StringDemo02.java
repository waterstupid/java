package com.xiaofu;

public class StringDemo02 {
    public static void main(String[] args) {
        String s = new String("a")+new String("b");
        String s1 = s.intern();
        System.out.println(s == s1);// true


    }
}
