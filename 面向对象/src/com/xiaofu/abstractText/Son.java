package com.xiaofu.abstractText;

public class Son extends AbstractText02 {
    // 无参构造方法
    public Son(){

    }
    public static void main(String[] args) {
        Son son = new Son();



    }


    @Override
    public void fly() {
        System.out.println("我要飞翔");
    }

    public static void stupid(){
        System.out.println("你是一个stupid");
    }
}
