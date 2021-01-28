package com.xiaofu.Assist;

import java.util.concurrent.CountDownLatch;

/**
 *  CountDownLatch 是一个强大的JUC辅助类
 *  它其中提供了两个方法，一个是await()方法，另一个是countDown()方法
 *  首先在构造方法的时候，就需要指定需要先执行的线程数量
 *  在最后执行的那个线程中使用await()方法，此时该线程会被阻塞，直到计数器中的数值变为0，
 *  才会被重新唤醒
 *  在其他先执行的线程中使用countDown()方法，每调用一次countDown()方法，计数中的内容就会减一
 *
 *
 *
 *
 */
public class CountDownLatchDemo {
    public static void main(String[] args) {
        CountDownLatch countDown = new CountDownLatch(7);
        for(int i = 0; i<7;i++){
            new Thread(() ->{
                System.out.println(Thread.currentThread().getName()+":离开了教室");
                // 调用countDown()方法
                countDown.countDown();
            },String.valueOf(i)).start();
        }

        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"最后一个离开教室，把门锁了");
            try {
                // 让班长这个线程在这里等候
                countDown.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"班长").start();



    }
}
