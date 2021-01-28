package com.xiaofu.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Ticket1{
    private int count = 40;
    private final Lock lock = new ReentrantLock();
    public void sellTicket(){
        lock.lock();
        try {
            if( count > 0){
                System.out.println(Thread.currentThread().getName()+"卖票,票号:"+count);
                count--;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

/**
 * 该类使用Lambda表达式的方法来模拟卖票
 * 口诀:复制小括号-->箭头不变-->落地大符号
 * 注意:什么时候可以使用lambda表达式,当一个接口中只有一个抽象方法的时候,这个时候就可以使用lambda表达式
 * 在jdk1.8之后,接口中的抽象方法可以用default修饰，可以有方法体，同时也可以有静态方法，
 * 这个时候即使有两个方法，lambda表达式也可以使用
 */
public class Text02 {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        // 使用lambda表达式来创建线程
        /*new Thread(() ->{
            for (int i = 0; i <50 ; i++) {
                ticket.sellTicket();
            }
        }).start();
        new Thread(() ->{
            for (int i = 0; i <50 ; i++) {
                ticket.sellTicket();
            }
        }).start();*/
        new Thread(() -> { for (int i = 0; i <50 ; i++) ticket.sellTicket(); },"A站台").start();
        new Thread(() -> { for (int i = 0; i <50 ; i++) ticket.sellTicket(); },"B站台").start();

    }



}
