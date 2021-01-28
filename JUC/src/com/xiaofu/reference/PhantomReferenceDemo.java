package com.xiaofu.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

public class PhantomReferenceDemo {
    public static void main(String[] args) {
        // 虚引用一定要和ReferenceQueue队列一起使用
        // 引用队列就是对象在被回收之前会被放入引用队列中
        Object o = new Object();
        ReferenceQueue<Object> queue = new ReferenceQueue<>();
        PhantomReference<Object> reference = new PhantomReference<>(o,queue);
        // 注意，reference.get()方法一直都是返回Null值
        System.out.println("回收之前,reference= "+reference.get());// null
        System.out.println("回收之前,queue= "+queue.poll());// null

        o = null;
        // 开启gc
        System.gc();
        System.out.println("回收之前,reference= "+reference.get());// null
        System.out.println("回收之前,queue= "+queue.poll());




    }
}
