package com.xiaofu.BlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class BlockQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        // 创建一个数组阻塞队列，初始的容量为3
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(3);

        // 测试add()方法抛出异常
        // queue.add("a");
        // queue.add("b");
        // queue.add("c");
        // 第四次就会抛出异常 IllegalStateException: Queue full
        // queue.add("a");
        // 删除队首的元素
        // System.out.println(queue.remove());
        // System.out.println(queue.remove());
        // System.out.println(queue.remove());
        // 第四次就会抛出异常 NoSuchElementException
        // System.out.println(queue.remove());
        // 获取头元素，但是不会删除头元素
        // System.out.println(queue.element());
        // queue.remove();
        // queue.remove();
        // queue.remove();
        // 若队列为空，则会抛出异常
        // System.out.println(queue.element());


        // 测试不抛异常的方法，返回特殊值
        // offer()方法
        // System.out.println(queue.offer("a"));
        //System.out.println(queue.offer("b"));
        // System.out.println(queue.offer("c"));
        // 不会抛出异常，但是返回的值为false
        // System.out.println(queue.offer("d"));
        // poll()获取并移除头元素,如果阻塞队列中为空，则返回null
        // System.out.println(queue.poll());
        // System.out.println(queue.poll());
        // System.out.println(queue.poll());
        // 返回null
        // System.out.println(queue.poll());
        // 不抛异常，返回null
        // System.out.println(queue.peek());

        // 测试阻塞的方法put()
        // queue.put("a");
        // queue.put("b");
        // queue.put("c");
        // System.out.println(111);
        // 队列空间已经满了，会在这里一直阻塞
        // queue.put("d");
        // System.out.println("队列空间已满");
        // 返回并移除队列头部元素
        // System.out.println(queue.take());
        // System.out.println(queue.take());
        // System.out.println(queue.take());
        // System.out.println(1111);
        // 在这里会发生阻塞
        // System.out.println(queue.take());
        // System.out.println(2222);

        // 测试超时的方法 offer
        // 超时三秒就不再阻塞,阻塞3秒如果队列中的元素还是满的，那么就不再阻塞
        // 返回false
        queue.offer("a",3L, TimeUnit.SECONDS);
        queue.offer("a",3L, TimeUnit.SECONDS);
        queue.offer("a",3L, TimeUnit.SECONDS);
        System.out.println("*****");
        System.out.println(queue.offer("a", 3L, TimeUnit.SECONDS));
        // System.out.println("3秒之前");
        // queue.offer("a",3L, TimeUnit.SECONDS);
        // System.out.println("3秒之后开始放行");
        // 向下转型称为强制类型转换，向上转型称为自动类型转换
        queue.poll(1L,TimeUnit.SECONDS);
        queue.poll(1L,TimeUnit.SECONDS);
        queue.poll(1L,TimeUnit.SECONDS);
        System.out.println("1s之前");
        queue.poll(1L,TimeUnit.SECONDS);
        System.out.println("1s之后");


    }


}
