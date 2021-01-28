package com.xiaofu.thread;
class Ticket01{
    // 该变量没有Volatile修饰,所以线程修改它是对其他线程不可见的
    int count = 10;
    public void updateCount(){
        if (count > 0){
            count--;
        }
    }

}

public class JMMText01 {
    public static void main(String[] args) {
        Ticket01 ticket = new Ticket01();
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"****开始");
            /*try {
                //让当前线程休眠1秒钟
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
            ticket.updateCount();
            System.out.println(Thread.currentThread().getName()+"****结束");
            },"A").start();


        while (ticket.count == 10){
            // A线程对变量的修改如果不进行通知，主线程是不知道，我们需要进行通知
        }
        System.out.println(Thread.currentThread().getName()+":update new value,"+ticket.count);



    }
}
