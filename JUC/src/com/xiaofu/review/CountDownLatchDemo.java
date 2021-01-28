package com.xiaofu.review;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
    public static void main(String[] args) {
        CountDownLatch down = new CountDownLatch(7);
        for(int i = 1; i<=7;i++){
            new Thread(() ->{
                System.out.println(Thread.currentThread().getName()+"\t 离开教室");
                // 该方法会使CountDownLatch中计数器的值减1
                down.countDown();
            },String.valueOf(i)).start();
        }
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"\t 最后一个锁门");
            try {
                // await()方法会使当前线程一直阻塞，直到计数器中的值变为0
                down.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"班长").start();


    }
}
