package com.xiaofu.review;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 该类用来探讨显示锁机制的有参构造方法形参的使用
 * 如果参数设置为true,则采用公平分配机制
 *
 */
class C implements Runnable{
    // 声明显示锁
    private ReentrantLock lock;

    public C(ReentrantLock lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        for (int i = 0; i <1000 ; i++) {
            /*try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
            // 加锁
            lock.lock();
            try {
                if(i % 2 ==0 ){
                    System.out.println(Thread.currentThread().getName()+"-->"+i);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                // 解锁
                lock.unlock();
            }
        }
    }
}


public class LockText02{
    public static void main(String[] args) {
        // 设置以公平竞争策略的方式来分配锁
        ReentrantLock lock = new ReentrantLock(false);
        C c = new C(lock);
        Thread t1 = new Thread(c);
        Thread t2 = new Thread(c);

        t1.setPriority(10);
        t2.setPriority(5);
        t1.setName("高优先级");
        t2.setName("低优先级");

        // 开启线程
        t2.start();
        t1.start();





    }



}
