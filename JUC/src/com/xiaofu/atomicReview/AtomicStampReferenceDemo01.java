package com.xiaofu.atomicReview;

import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * 该类用来解决ABA问题
 */
public class AtomicStampReferenceDemo01 {
    public static void main(String[] args) {
        // 初始化值为1,版本号为1
        AtomicStampedReference<Integer> atomic = new AtomicStampedReference<>(1,1);
        new Thread(()->{
            // 线程 A 期望主物理内存的值为1 如果为1改变成2020,期望主物理内存中版本号为1，如果是1，则改变为原来的值加1
            System.out.println(atomic.compareAndSet(1, 20, 1, atomic.getStamp() + 1));
            System.out.println("当前版本号:"+atomic.getStamp());// 2
            System.out.println("当前引用:"+atomic.getReference()); //2020

            System.out.println(atomic.compareAndSet(20, 1, 2, atomic.getStamp() + 1));
            // 线程 A 期望主物理内存的值为2020 如果为2020改变成1,期望主物理内存中版本号为2，如果是2，则改变为原来的值加1
            System.out.println("当前版本号:"+atomic.getStamp()); // 3
            System.out.println("当前引用:"+atomic.getReference());// 1

        },"A").start();
        try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}
        // 主物理内存来修改值
        // Main线程 期望主物理内存的值为1 如果为1改变成2020,期望主物理内存中版本号为1，如果是1，则改变为2
        // 其实现在主物理内存中的值是1,但是版本号为3,所以这里解决了ABA问题，也就是利用版本号来进行控制
        System.out.println(atomic.compareAndSet(1, 2020, 1, 2));// false
        System.out.println("当前版本号:"+atomic.getStamp()); // 3
        System.out.println("当前引用:"+atomic.getReference());// 1



    }
}
