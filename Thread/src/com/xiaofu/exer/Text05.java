package com.xiaofu.exer;
class Ticket{
    private int count = 100;
    public synchronized void sellTicket(){
        if(count > 0 ){
            System.out.println(Thread.currentThread().getName()+"卖票,当前票号:"+count);
            count--;
        }
    }




}
public class Text05 {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        // 创建一个ThreadLoal
        ThreadLocal<Ticket> threadLocal = new ThreadLocal();
        // 将ticket放进去
        threadLocal.set(ticket);
        new Thread(new Runnable() {
            // 定义一个threadLocal变量
            @Override
            public void run() {
                // 取出副本
                Ticket ticket = threadLocal.get();
                for (int i = 0; i <100 ; i++) {
                    ticket.sellTicket();
                }
            }
        },"A").start();
        new Thread(new Runnable() {
            // 定义一个threadLocal变量
            @Override
            public void run() {
                // 取出副本
                Ticket ticket = threadLocal.get();
                for (int i = 0; i <100 ; i++) {
                    ticket.sellTicket();
                }
            }
        },"B").start();






    }




}
