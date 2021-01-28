package com.xiaofu.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Ticket{
    private int ticket=40;
    private final Lock lock = new ReentrantLock();
    // 这里需要使用synchronized修饰
    // 或者使用Lock
    public void sellTicket(){
        lock.lock();
        try{
            // 来进行判断
            if(ticket > 0){
                System.out.println(Thread.currentThread().getName()+"卖票,票号为"+ticket);
                Thread.sleep(100);
                ticket--;
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            lock.unlock();
        }

    }
}

/**
 * 该类用来复习卖票，首先多线程并发记住以下口诀
 * 1.在高聚合低耦合的前提下，线程 操纵 共享资源(首先先把共享资源写出来)
 *
 *
 */
public class Text01 {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        // 创建一个线程,采用匿名内部的方式来创建
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <40 ; i++) {
                    ticket.sellTicket();
                }
            }
        },"A站台").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <40 ; i++) {
                    ticket.sellTicket();
                }
            }
        },"B站台").start();

    }



}
