package com.xiaofu.lock;


import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class Book {
    private ReadWriteLock lock = new ReentrantReadWriteLock();
    public void write(){
        // 加写锁
        lock.writeLock().lock();
        try{
            System.out.println(Thread.currentThread().getName()+"\t 开始写入");
            try {Thread.sleep(500);} catch (InterruptedException e) {e.printStackTrace();}
            System.out.println(Thread.currentThread().getName()+"\t 写入完成");
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            lock.writeLock().unlock();
        }

    }
    public void read(){
        // 加读锁
        lock.readLock().lock();
        try{
            System.out.println(Thread.currentThread().getName()+"\t 开始读入");
            try {Thread.sleep(500);} catch (InterruptedException e) {e.printStackTrace();}
            System.out.println(Thread.currentThread().getName()+"\t 读入完成");
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            lock.readLock().unlock();
        }
        }

}

public class ReadWriteLockDemo {
    /**
     * 最后出现的结果就是在一个线程写的时候，其他线程也可以同样进行写，但是这样是不行的，我们
     * 要加写锁，让一个线程进行写操作的时候，其他线程不能干扰
     * @param args
     */
    public static void main(String[] args) {
        start();

    }

    private static void start() {
        Book book = new Book();
        for(int i = 0; i<5;i++){
            new Thread(() ->{book.write();},String.valueOf(i)).start();
        }
        for(int i = 0; i<5;i++){
            new Thread(() ->{book.read();},String.valueOf(i)).start();
        }
    }
}
