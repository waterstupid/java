package com.xiaofu.Stack;

import java.lang.reflect.Method;

public class Demo01 {
    private static int i=50;
    {
        i = 10;
    }
    static{
        i = 20;
    }
    public Demo01(){
        i = 30;
    }
    public static void method1(){
        i++;
        System.out.println(i);
        method1();

    }

    public static void main(String[] args) {
        method1();


    }
}
