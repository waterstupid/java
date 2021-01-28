package com.xiaofu.lockReview;

import org.junit.Test;

/**
 * synchronized是一个非公平锁，所谓非公平锁就是说优先级高的线程比优先级低的线程获取cpu的时间片的概率较高
 * 但是并不是说优先级低的线程一定在优先级高的线程后面执行，只是说一个概率的问题
 *
 * ReentrantLock 该锁可以是公平锁，也可以是非公平锁，它有一个构造方法，构造方法的参数为true,就是一个公平锁，构造
 * 方法的参数默认为false,是一个非公平锁
 */
public class FairLockDemo {
    public static void main(String[] args) {
        Thread A = new Thread(() -> {
            for (int i = 0; i <10 ; i++) {
                System.out.println(Thread.currentThread().getName()+"->"+i);
            }

        }, "A");

        Thread B = new Thread(() -> {
            for (int i = 0; i <10 ; i++) {
                System.out.println(Thread.currentThread().getName()+"->"+i);
            }
        }, "B");

        Thread C = new Thread(() -> {
            for (int i = 0; i <10 ; i++) {
                System.out.println(Thread.currentThread().getName()+"->"+i);
            }
        }, "C");

        A.setPriority(Thread.MAX_PRIORITY);
        B.setPriority(Thread.NORM_PRIORITY);
        C.setPriority(Thread.MIN_PRIORITY);

        A.start();
        B.start();
        C.start();
    }






}
