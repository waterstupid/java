package com.xiaofu.past.safe01;

/**
 * 该程序用来测试线程安全问题
 * @author fmk
 * @date 2020/5/2
 **/
public class ThreadSafeText01 {
    public static void main(String[] args) {
        Count c=new Count("zs",10000);
        Thread t1=new Thread(new Runnable01(c));
        Thread t2=new Thread(new Runnable01(c));
        t1.setName("张三");
        t2.setName("李四");
        t1.start();
        /*try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        t2.start();

    }



}

class Runnable01 implements Runnable{
    Count count;
    public Runnable01(Count count){
        this.count=count;
    }

    @Override
    public void run() {
        count.transfer(5000);
        System.out.println(Thread.currentThread().getName()+"取出了5000块，还剩"+count.getBalance()+"块");

    }
}
