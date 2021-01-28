package com.xiaofu.abstractText;

public abstract class AbstractText02 extends AbstractText01{
    // 定义实例变量
    String name = "张三";
    // 定义静态变量
    static int age= 12;
    // 定义实例方法
    public void doSome(){
        System.out.println("do some");
    }
    // 定义静态方法
    public static void doOther(){
        System.out.println("do Other");
    }
    // 定义构造方法
    public AbstractText02(){
        System.out.println("abstract类的构造方法执行");
    }

    // 定义抽象方法
    // 注意:抽线中的方法不能省略public abstract
    public abstract void fly();




}
