package com.xiaofu.review;

import com.sun.org.apache.xalan.internal.res.XSLTErrorResources_en;

import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * 解决多线程安全的问题，java采用了一中同步机制
 * 1.使用隐示锁(同步方法，同步代码块) synchronized
 * 2.使用显示锁 使用lock机制
 *
 * 使用Lock和synchronized的区别
 * 1.Lock是显示锁，需要手动开启和手动关闭，synchronized是隐士锁，出了作用域之后自动释放锁
 * 2.Lock锁只能代码块锁,而synchronized有方法锁和代码块锁
 * 3.使用Lock锁,JVM可以花更少的时间调度线程,可扩展性好
 *
 *
 *
 */
class B implements Runnable{
    private int ticket=100;
    // 这里需要提供一个锁对象
    // 这里有一个参数默认设置为false,如果设置为true,则是按照公平策略来分配锁,也就是
    // 优先级高的线程先拿到锁
    ReentrantLock lock = new ReentrantLock();
    @Override
    public void run() {
        while(true){
            // 加锁
            lock.lock();
            if(ticket > 0){
                System.out.println(Thread.currentThread().getName()+",票号:"+ticket);
                try {
                    // sleep 是一个静态方法
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                ticket--;
            }else{
                break;
            }
            // 解锁
            lock.unlock();
        }
    }
}


public class LockText01 {
    public static void main(String[] args) {
        B b = new B();
        Thread t = new Thread(b);
        Thread t1 = new Thread(b);
        Thread t2 = new Thread(b);
        t.setName("A站台");
        t1.setName("B站台");
        t2.setName("C站台");
        // 启动线程
        t.start();
        t1.start();
        t2.start();



    }
}
