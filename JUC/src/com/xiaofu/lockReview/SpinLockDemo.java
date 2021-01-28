package com.xiaofu.lockReview;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 该类用来手写一个自旋锁,CAS的底层就是一把自旋锁，所谓自旋锁就是一个while循环，
 * 判断当前线程有没有获取锁信息，如果没有，则一直循环，如果有则退出循环，开始一系列的
 * 操作
 */
public class SpinLockDemo {
    public static void main(String[] args) {
        SpinLock lock = new SpinLock();
        for(int i = 0; i<10;i++){
            new Thread(() ->{
                for(int j = 0 ; j < 300; j++){
                    lock.lock();
                    lock.unlock();
                }
            },String.valueOf(i)).start();
        }
    }
}
class SpinLock{
    private int number = 0;
    // 默认值为NUll
    private AtomicReference<Thread> atomic = new AtomicReference<>();
    public void lock(){
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName()+"->\tcome in...");
        try {Thread.sleep(500);} catch (InterruptedException e) {e.printStackTrace();}
        // 期望值为null,如果为Null,则更新为当前线程
        while(!atomic.compareAndSet(null,thread)){

        }
        number++;
        System.out.println(Thread.currentThread().getName()+"->\tnumber= "+number);
        System.out.println(Thread.currentThread().getName()+"-> \tend....");

    }
    public void unlock(){
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName()+"->\tcome in");
        atomic.compareAndSet(thread,null);
        System.out.println(Thread.currentThread().getName()+"->\tend");

    }



}
