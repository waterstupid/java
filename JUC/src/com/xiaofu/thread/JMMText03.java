package com.xiaofu.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Ticket02{
    int count = 30;
      Lock lock = new ReentrantLock();
    public void sellTicket(){
        lock.lock();
        try{
            if(count > 0){
                System.out.println(Thread.currentThread().getName()+"卖票，当前票数为:"+count);
                try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}
                count--;
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
    }


}


public class JMMText03 {
    public static void main(String[] args) {
        Ticket02 ticket = new Ticket02();
        new Thread(()->{
            for (int i = 0; i <30 ; i++) {
                ticket.sellTicket();
            }
        },"A").start();
        new Thread(()->{
            for (int i = 0; i <30 ; i++) {
                ticket.sellTicket();
            }
        },"B").start();

    }
}
