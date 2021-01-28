package com.xiaofu.lock;

import javax.swing.event.TreeSelectionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class MyCached{
    private Map<String,Object> map = new HashMap<>();
    // 不加锁就会导致写操作不一致
    // 但是这样的处理方式并不好，因为导致了读也是线程同步的
    // 读读共享锁 读写排他锁 写写排他锁
    // Lock lock = new ReentrantLock();
    ReadWriteLock lock = new ReentrantReadWriteLock();
    public void put(String key,Object value){
        lock.writeLock().lock();
        try{
            System.out.println(Thread.currentThread().getName()+"\t开始写入");
            try {Thread.sleep(500);} catch (InterruptedException e) {e.printStackTrace();}
            System.out.println(map.put(key, value));
            System.out.println(Thread.currentThread().getName()+"\t写入完成");
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            lock.writeLock().unlock();
        }

    }
    public void get(){
        lock.readLock().lock();
        try{
            System.out.println(Thread.currentThread().getName()+"\t开始读取");
            try {Thread.sleep(500);} catch (InterruptedException e) {e.printStackTrace();}
            System.out.println(Thread.currentThread().getName()+"\t读取完成");
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            lock.readLock().unlock();
        }

    }

}


public class ReadWriteReentrantLockDemo {
    public static void main(String[] args) {
        MyCached cached = new MyCached();
        // 5个线程负责写
        for(int i = 0; i<5;i++){
            new Thread(() ->{
                cached.put(UUID.randomUUID().toString().substring(0,8),UUID.randomUUID().toString().substring(0,8));
            },String.valueOf(i)).start();
        }
        try {Thread.sleep(2000);} catch (InterruptedException e) {e.printStackTrace();}
        // 5个线程负责读
        for(int i = 0; i<5;i++){
            new Thread(() ->{
                cached.get();
            },String.valueOf(i)).start();
        }



    }
}
