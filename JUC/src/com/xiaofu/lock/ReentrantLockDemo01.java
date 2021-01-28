package com.xiaofu.lock;

import java.io.OutputStreamWriter;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 也就是说synchronized和ReentrantLock都是可重入锁
 * 同一个线程获取外层函数的锁之后，内部的递归函数依然可以获取该锁的代码
 * 也就说线程可以进入它所拥有锁的所有同步代码块
 */
class MyData01 implements Runnable{
    private Lock lock = new ReentrantLock();
    public void method01(){
        // lock()和unlock()需要配对使用
        // 要不然就会照成死锁
        lock.lock();
        lock.lock();
        try{
            System.out.println("method01 start");
            method02();
            System.out.println("method01 start");
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            lock.unlock();
            lock.unlock();
        }


    }

    public void method02() {
        lock.lock();
        try{
            System.out.println("method 02 start");
            try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}
            System.out.println("method 02 end");
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
    }


    @Override
    public void run() {
        method01();
    }
}
public class ReentrantLockDemo01 {
    public static void main(String[] args) {
        Thread t = new Thread(new MyData01());
        t.start();



    }
}
