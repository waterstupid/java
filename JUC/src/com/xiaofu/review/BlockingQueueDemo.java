package com.xiaofu.review;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 用BlockingQueue来实现有两个线程，一个线程打印0-100的偶数,一个线程答应0-100的奇数，
 * 两者交替执行
 */
public class BlockingQueueDemo {
    public static void main(String[] args) {
        BlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(2);
        queue.add(()->{
            for (int i = 0; i <100 ; i++) {
                if(i % 2 == 0 ){
                    System.out.println(Thread.currentThread().getName()+"\t->"+i);
                }
            }
        });
        queue.add(()->{
            for (int i = 0; i <100 ; i++) {
                if(i % 2 != 0 ){
                    System.out.println(Thread.currentThread().getName()+"\t->"+i);
                }
            }
        });






    }
}
