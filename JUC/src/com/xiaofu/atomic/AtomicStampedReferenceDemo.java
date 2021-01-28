package com.xiaofu.atomic;

import java.util.concurrent.atomic.AtomicStampedReference;

public class AtomicStampedReferenceDemo {
    public static void main(String[] args) {
        // 设置主物理内存的值为10,主物理内存的版本号为1
        AtomicStampedReference<Integer> stampedReference = new AtomicStampedReference<>(10,1);
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"\t update new value");
            // 该方法的意思就是如果主物理内存的版本号和共享变量的值都和期望的一样，那么将版本号和共享变量的值都改变为新值
            // 原子引用更新就是使用版本号来解决ABA问题的
            System.out.println(stampedReference.compareAndSet(10, 100, 1, stampedReference.getStamp() + 1));
            System.out.println(stampedReference.compareAndSet(100, 10, 2, stampedReference.getStamp() + 1));
            // System.out.println(stampedReference.compareAndSet(10, 20, 1, stampedReference.getStamp() + 1));
            // System.out.println(stampedReference.compareAndSet(20, 10, 2, stampedReference.getStamp() + 1));
            System.out.println(Thread.currentThread().getName()+"\t 最终的版本号就是:"+stampedReference.getStamp());
            System.out.println(Thread.currentThread().getName()+"\t 最终的值:"+stampedReference.getReference());
            System.out.println(Thread.currentThread().getName()+"\t finish new value");
        },"A").start();

        new Thread(()->{
            try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}
            System.out.println(stampedReference.compareAndSet(10, 2020, 1, 2));
            System.out.println("当前版本号为:"+stampedReference.getStamp());
            System.out.println("当前的值为:"+stampedReference.getReference());
        },"B").start();


    }
}
