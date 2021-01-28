package com.xiaofu.atomic;

import java.util.concurrent.atomic.AtomicStampedReference;

public class AtomicStampedReferenceDemo01 {
    public static void main(String[] args) {
        AtomicStampedReference<Integer> reference = new AtomicStampedReference<>(1,1);

        new Thread(()->{
            System.out.println(reference.compareAndSet(1, 2019, 1, reference.getStamp()+1));
            System.out.println("当前的版本号1为:"+reference.getStamp());
            System.out.println("当前的value1为:"+reference.getReference());
            System.out.println(reference.compareAndSet(2019, 1,2
                    , reference.getStamp()+1));
            System.out.println("当前的版本号2为:"+reference.getStamp());
            System.out.println("当前的value2为:"+reference.getReference());

        },"A").start();


    }
}
