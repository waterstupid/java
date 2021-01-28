package com.xiaofu.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 该类用来展示使用显示锁
 * Lock 和 Condition
 * 来解决线程通信的问题
 * 生产者生产1,消费者消费1
 *
 *
 */
class MyProduct {
    private int count;
    private final Lock lock = new ReentrantLock();
    // 创建condition对象
    private Condition condition = lock.newCondition();

    public void produceCount(){
        lock.lock();
        try{
            // 判断
            while( count != 0){
                condition.await();
            }
            // 干活
            count++;
            System.out.println(Thread.currentThread().getName()+"生产"+count);
            // 把所有的都唤醒
            condition.signalAll();
        }catch(Exception e){

        }finally{
           lock.unlock();
        }


    }
    public void consumeProduct(){
        lock.lock();
        try{
            while(count == 0){
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            count--;
            System.out.println(Thread.currentThread().getName()+"消费"+count);
            condition.signalAll();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
    }
}



public class Text05 {
    public static void main(String[] args) {
        MyProduct product = new MyProduct();
        new Thread(()->{for(int i=0;i<5;i++) product.produceCount();},"生产者1").start();
        new Thread(()->{for(int i=0;i<5;i++) product.consumeProduct();},"消费者1").start();
        new Thread(()->{for(int i=0;i<5;i++) product.consumeProduct();},"消费者2").start();
        new Thread(()->{for(int i=0;i<5;i++) product.produceCount();},"生产者2").start();

        /*new Thread(()->{for(int i=0;i<5;i++) product.consumeProduct();},"消费者3").start();
        new Thread(()->{for(int i=0;i<5;i++) product.produceCount();},"生产者4").start();
        new Thread(()->{for(int i=0;i<5;i++) product.consumeProduct();},"消费者4").start();
*/
    }
}
