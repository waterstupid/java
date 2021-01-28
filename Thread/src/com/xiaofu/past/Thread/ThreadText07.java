package com.xiaofu.past.Thread;

/**
 * 该程序用来测验sleep中的面试题
 * 问题：线程t1是否会等待主线程运行，然后运行？
 * 不会,虽然采用了t.sleep(long l)的，但是因为sleep()是一个静态方法，和引用没有关系
 * 即使使用了引用去调用，但是底层还是会Thread.sleep(long l)去调用，阻塞的是当前线程
 * 所以t1线程不会等待主线程的运行
 *
 *
 * @author fmk
 * @date 2020/5/1
 **/
public class ThreadText07 {
    public static void main(String[] args) {
        //使用匿名内部类的方式来创建一个线程
        Thread t=new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <10 ; i++) {
                    System.out.println(Thread.currentThread().getName()+"--->"+i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        t.setName("t1");
        t.start();
        try {
            t.sleep(1000*10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("hello world");


    }
}
