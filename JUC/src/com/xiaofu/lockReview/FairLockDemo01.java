package com.xiaofu.lockReview;

import java.util.concurrent.locks.ReentrantLock;

public class FairLockDemo01 {
    public static void main(String[] args) {
        Test test = new Test();
        // ReentrantLock默认是一个非公平锁
        Thread A = new Thread(() -> {
            test.print();

        }, "A");

        Thread B = new Thread(() -> {
            test.print();
        }, "B");

        Thread C = new Thread(() -> {
            test.print();
        }, "C");

        /*A.setPriority(Thread.MAX_PRIORITY);
        B.setPriority(Thread.NORM_PRIORITY);
        C.setPriority(Thread.MIN_PRIORITY);*/

        C.start();
        B.start();
        A.start();
    }
}
class Test{
    // 默认是非公平锁
    // 构造方法的参数为true,就是一个公平锁
    private ReentrantLock lock = new ReentrantLock(true);
    public void print(){
        lock.lock();
        try{
            System.out.println(Thread.currentThread().getName()+"-->set in ....");
            System.out.println(Thread.currentThread().getName()+"-->end......");
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            lock.unlock();
        }

    }



}
