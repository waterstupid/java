package com.xiaofu.final01;

import javax.xml.transform.Source;

public class FinalDemo {

    // final修饰的成员变量不能赋系统初始值
    private static final int i=10;
    private final String name="abc";
    int age;
    public FinalDemo(){
        this.age=age;
        System.out.println(2222);
    }
    public FinalDemo(int age){
        // this()括号只能出现在构造方法的第一行
        this();
    }

}
