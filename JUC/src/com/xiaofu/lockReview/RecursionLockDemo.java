package com.xiaofu.lockReview;

import java.nio.file.attribute.AclEntryPermission;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 该类用来阐述递归锁的概念
 * synchronized和ReentrantLock都是递归锁(可重入锁)
 * 所谓递归锁就是在一个现成话获取到锁信息的时候，该线程可以进入该锁修饰的所有同步方法中
 */
public class RecursionLockDemo {
    public static void main(String[] args) {
        Data data = new Data();
        // 说明synchronized是一把递归锁
        new Thread(()->{
            data.method01();
        },"A").start();
        new Thread(()->{
            data.method03();
        },"B").start();



    }
}
class Data{
    Lock lock = new ReentrantLock();
    public synchronized void method01(){
        System.out.println(Thread.currentThread().getName()+"-->\t method01 set in");
        method02();
        System.out.println(Thread.currentThread().getName()+"-->\t method01 end....");
    }
    public synchronized  void method02(){
        System.out.println(Thread.currentThread().getName()+"-->\t method02 set in");
        System.out.println(Thread.currentThread().getName()+"-->\t method02 end");

    }
    // 该方法用来验证ReentrantLock也是一把递归锁
    public void method03(){
        lock.lock();
        try{
            System.out.println(Thread.currentThread().getName()+"-->\t method03 set in");
            method04();
            System.out.println(Thread.currentThread().getName()+"-->\t method04 end");
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public void method04(){
        lock.lock();
        try{
            System.out.println(Thread.currentThread().getName()+"-->\t method04 set in");
            System.out.println(Thread.currentThread().getName()+"-->\t method04 end");

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
    }



}
