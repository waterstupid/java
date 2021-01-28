package com.xiaofu.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 有关线程的通信问题(使用synchronized关键字和wait()、notify(),notifyAll()
 * 方法
 */
class Product{
    private int count = 0;
    private final Lock lock = new ReentrantLock();
    public synchronized void increase() throws InterruptedException {
        /*lock.lock();
        try{

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
        */
        // 判断
        if(count != 0){
            this.wait();
        }
        // 干活
        count++;
        System.out.println(Thread.currentThread().getName()+"生产"+count);
        // 唤醒
        this.notifyAll();

    }

    public synchronized void decrease() throws InterruptedException {
        // 判断
        if(count == 0){
            this.wait();
        }
        // 干活
        count--;
        System.out.println(Thread.currentThread().getName()+"消费"+count);
        // 唤醒
        this.notifyAll();

    }

}

public class Text04 {
    public static void main(String [] args){
        Product product = new Product();
        new Thread(()->{
            for (int i = 0; i <20 ; i++) {
                try {
                    product.increase();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"生产者").start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(()->{
            for (int i = 0; i <20 ; i++) {
                try {
                    product.decrease();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"消费者").start();





    }


}
