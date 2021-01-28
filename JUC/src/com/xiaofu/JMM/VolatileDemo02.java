package com.xiaofu.JMM;

/**
 * volatile:不能保证原子性，什么是原子性？原子性在数据库中的事务机制中出现，是指一条DML语句
 * 或者多条DML语句必须同时执行成功和同时执行失败。而在java中是指,线程从主物理内存获取变量的副本、
 * 在自己的工作内存中修改值，然后将修改过后的值写回给物理内存，这个过程是不能中断的，要么全部执行成功
 * 、要么全部执行失败，不能在写回给主物理内存的时候，发生线程的挂起，其他线程又来进行这样的操作，这样是不行的。
 *
 *
 */
class Ticket{
    volatile int ticket = 0;
    public void addTicket(){
        ticket++;
    }


}
public class VolatileDemo02 {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        // 20个线程每个线程执行1000次
        for(int i = 0; i<20;i++){
            new Thread(() ->{
                for (int j = 1; j <=1000 ; j++) {
                    ticket.addTicket();
                }
            },String.valueOf(i)).start();
        }
        try {Thread.sleep(2000);} catch (InterruptedException e) {e.printStackTrace();}
        System.out.println("最后的计算结果,ticket="+ticket.ticket);


    }
}
