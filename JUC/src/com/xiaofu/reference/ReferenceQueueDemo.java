package com.xiaofu.reference;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

public class ReferenceQueueDemo {
    public static void main(String[] args) {
        // 这是引用队列
        ReferenceQueue<Object> queue = new ReferenceQueue<>();
        Object a = new Object();
        // 这是弱引用，不管内存空间是否足够，都会被垃圾回收器回收
        WeakReference<Object> reference = new WeakReference<>(a,queue);
        System.out.println("回收之前,reference="+reference.get());
        System.out.println("回收之前,queue="+queue.poll()); // null
        a = null;
        // 开始垃圾回收
        System.gc();
        System.out.println("回收之后,reference="+reference.get()); // null
        System.out.println("回收之后,queue="+queue.poll());






    }
}
