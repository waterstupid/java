package com.xiaofu.interfacetext;

public interface InterfaceText02 {
    // 除了构造方法之外其他所有的内容都可以被继承
    // 接口中 public static final 可以省略
    String NAME = "张三";

    // 可以定义静态方法
    static void doSome(){
        System.out.println("do Some 执行");
    }

    // 可以定义抽象方法
    void doOther();

    // 在java 8之后,抽象方法之前可以加入default关键字,代表这个抽象方法可以有方法体
     default void doHomework() {
        System.out.println("do Homework");

    }


}
