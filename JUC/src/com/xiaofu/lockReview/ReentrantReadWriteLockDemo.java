package com.xiaofu.lockReview;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 该类用来展示读写锁:
 * 在平常的业务逻辑中，有很多情况的要求我们读数据的时候不加锁保证并发性，但是写数据的时候需要
 * 加锁，来保证数据的安全性，所以现在如果要满足这个需求，那么就要用到我们的读写锁,JUC下的一个
 * 类:ReentrantReadWriteLock
 * 该类的特点就是:读时不上锁，写数据的时候需要上锁
 * 读锁(共享锁)
 * 写锁(排他锁)
 *
 *
 *
 */
public class ReentrantReadWriteLockDemo {
    public static void main(String[] args) {
        Resource resource = new Resource();
        // 10个线程负责读数据
        for(int i = 0; i<10;i++){
            new Thread(() ->{
                resource.read();
            },String.valueOf(i)).start();
        }
        // 另外10个线程负责写数据
        for(int i = 0; i<10;i++){
            new Thread(() ->{
                resource.write();
            },String.valueOf(i)).start();
        }


    }

}
class Resource{
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public void read(){
        lock.readLock().lock();
        try{
            System.out.println(Thread.currentThread().getName()+"->\t read come in..");
            try {Thread.sleep(500);} catch (InterruptedException e) {e.printStackTrace();}
            System.out.println(Thread.currentThread().getName()+"->\t read end..");
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            lock.readLock().unlock();
        }

    }
    public void write(){
        lock.writeLock().lock();
        try{
            System.out.println(Thread.currentThread().getName()+"->\t write come in..");
            try {Thread.sleep(500);} catch (InterruptedException e) {e.printStackTrace();}
            System.out.println(Thread.currentThread().getName()+"->\t write end..");
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            lock.writeLock().unlock();
        }


    }



}
