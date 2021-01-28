package com.xiaofu.JMM;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 那么怎么解决Volatile不保证原子性呢
 * 可以在方法上加锁，比如synchronized和Lock,但是使用这两个都会降低线程的并发性，效率较低
 * 所以还可以使用到AtomicInteger中来处理类似++的问题，这样不用加锁，可以提高效率
 *
 *
 */
class Ticket01{
    // 使用atomic下的原子包
    AtomicInteger integer = new AtomicInteger();
    public void addTicket(){
        integer.getAndIncrement();
    }

}
public class VolatileDemo03 {
    public static void main(String[] args) {
        Ticket01 ticket = new Ticket01();
        for(int i = 0; i<20;i++){
            new Thread(() ->{
                for (int j = 0; j <1000 ; j++) {
                    ticket.addTicket();
                }
            },String.valueOf(i)).start();
        }
        try {Thread.sleep(2000);} catch (InterruptedException e) {e.printStackTrace();}
        System.out.println("update new value ="+ticket.integer);



    }
}
