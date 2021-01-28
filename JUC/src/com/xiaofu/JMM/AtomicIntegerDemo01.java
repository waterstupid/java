package com.xiaofu.JMM;


import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerDemo01 {
    public static void main(String[] args) {
        AtomicInteger integer = new AtomicInteger(5);
        System.out.println("比较是否成功:"+integer.compareAndSet(5, 10)+",成功后的值:"+integer.get());
        System.out.println("比较是否成功:"+integer.compareAndSet(5, 34)+",成功后的值:"+integer.get());



    }
}
