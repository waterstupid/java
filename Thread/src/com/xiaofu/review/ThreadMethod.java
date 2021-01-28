package com.xiaofu.review;

/**
 * Thread中的常用方法有很多:
 * 获取Thread对象
 * 1.static Thread    currentThread()  返回当前线程
 * 2.采用构造器的方法来获取线程对象 new Thread()
 * Thread中的常用方法：
 * 1.getName()    获取当前线程对象的名称
 * 2.setName()    给当前线程指定一个名称
 * 3.join()       如果a线程中调用了b.join()方法的话,a线程从就绪状态到阻塞状态,直到b线程中的run()方法执行完毕之后,a线程采用继续执行
 * 4.static sleep(long millions) 将当前线程从就绪状态变为阻塞状态,放弃cpu的执行权，直到million秒钟过去之后，该线程才会重新回到就绪状态
 * 5.static yield       对调度器的一个暗示，指当前线程可以放弃cpu的执行权，也就是从运行状态重新进入到就绪状态
 * 6.getPriority() 获取当前线程的优先级
 * 7.setPriority() 设置当前线程的优先级
 *
 *
 */
public class ThreadMethod {
    public static void main(String[] args) {
       // 采用匿名内部类的方式来创建一个线程
       Thread t = new Thread(new Runnable() {
           @Override
           public void run() {
               /*try {
                   Thread.sleep(10);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }*/
               // 将副线程钟的优先级设置为10
               Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
               System.out.println("副线程的优先级:"+Thread.currentThread().getPriority());
               for (int i = 0; i <1000; i++) {
                   if(i % 2 == 0){
                       System.out.println(Thread.currentThread().getName()+"-->"+i);
                   }
               }
           }
       });
       t.setName("副线程");
       // 1.start()方法开启线程,调用run()方法
       t.start();
       Thread.currentThread().setName("主线程");
       // 将主线程的优先级设置为1
       Thread.currentThread().setPriority(Thread.NORM_PRIORITY);
        System.out.println("主线程的优先级-->"+Thread.currentThread().getPriority());
        for (int i = 0; i <100; i++) {
            if(i % 20 == 0){
                // 将副线程加入进来，主线程必须得到副线程的执行结束，才能从阻塞状态重新变为就绪状态
               /* try {
                    t.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
                // 指当前线程放弃cpu执行权,从运行状态重新变为就绪状态
                // 但是此时并不一定执行副线程，而是副线程和主线程重新争夺cpu的执行权
                Thread.yield();
            }
            if( i % 2 != 0){
                System.out.println(Thread.currentThread().getName()+"--->"+i);
            }
        }





    }



}


