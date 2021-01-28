package com.xiaofu.review;

/**
 * 使用两个线程印 打印 1-100 。线程1, 线程2 交替打印
 * 在Object类中的三个方法
 * wait() 使当前线程放弃对cpu的执行权，同步资源，从而使其他线程可以获得同步资源并修改当中的数据。
 * 当前线程排队等待其他线程使用notify()或者notifyAll()唤醒，唤醒后重新等待对监视器的所有权才能开始
 * 使用
 * notify() 唤醒正在排队等待同步资源优先级较高的线程
 * notifyAll() 唤醒所有正在排队等待同步资源的线程
 *
 * 首先需要注意的是:这三个方法只能出现在同步语句当中，否则会报异常,因为这三个方法是需要锁对象去
 * 调用的，又因为任何对象都可以成为锁，所以这三个方法声明在Object类中
 *
 * wait()和notify()方法的执行条件
 * 当前线程必须要对象的监控权(锁)
 *
 *
 *
 *
 *
 */
class MyRunnable03 implements Runnable{
    private int count = 100;
    @Override
    public synchronized void run() {
        for (int i = 0; i <=count ; i++) {
            notify();
            System.out.println(Thread.currentThread().getName()+"--->"+i);
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


public class ThreadConnectionText {
    public static void main(String [] args){
        MyRunnable03 r = new MyRunnable03();
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);

        t1.setName("线程1");
        t2.setName("线程2");

        t1.start();
        t2.start();
    }


}
