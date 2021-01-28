package com.xiaofu.past.homework;

/**
 * 该程序用来完成一个火车站售票的问题，假设一共有100张票，一共有两个站台卖票，一次只能卖出一张票
 * @author fmk
 * @date 2020/5/2
 **/
public class HomeWork01 {
    public static void main(String[] args) {
        Ticket ticket=new Ticket(100);
        Thread t1=new Thread(new ZhanTai01(ticket));
        Thread t2=new Thread(new ZhanTai02(ticket));
        t1.setName("站台1");
        t2.setName("站台2");
        t1.start();
        t2.start();



    }
}

class ZhanTai02 implements Runnable{
    Ticket ticket;
    public ZhanTai02(Ticket ticket){
        this.ticket=ticket;
    }
    @Override
    public void run() {
        while(true){
            synchronized (ticket){
                if(ticket.getCount()!=0){
                    ticket.setCount(this.ticket.getCount()-1);
                    System.out.println(Thread.currentThread().getName()
                            +"卖出了一张票，还剩"+ticket.getCount()+"票");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else{
                    System.out.println("票已经卖完");
                    return;
                }
            }
        }
    }
}

class ZhanTai01 implements Runnable{
    Ticket ticket;
    public ZhanTai01(Ticket ticket){
        this.ticket=ticket;
    }

    @Override
    public void run() {
        while(true){
            synchronized (ticket){
                if(ticket.getCount()!=0){
                    ticket.setCount(this.ticket.getCount()-1);
                    System.out.println(Thread.currentThread().getName()
                            +"卖出了一张票，还剩"+ticket.getCount()+"票");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else{
                    System.out.println("票已经卖完");
                    return;
                }
            }
        }
    }
}


class Ticket{
    private int count;
    public Ticket(int count){
        this.count=count;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
