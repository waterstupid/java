package com.xiaofu.past.Thread;

/**
 * 该程序用来测试Thread中的Sleep()方法
 * 1.首先这是一个Thread类中的静态方法
 * 2.该静态方法是用来使当前线程进入睡眠状态，且睡眠时间可以自己定义
 * 3.static void sleep(long millis)
 * 使当前正在执行的线程以指定的毫秒数暂停（暂时停止执行），具体取决于系统定时器和调度程序的精度和准确性
 * @author fmk
 * @date 2020/5/1
 **/
public class ThreadText06 {
    public static void main(String[] args) {
        Thread02 t=new Thread02();
        t.setName("t1");
        t.start();
        try {
            //让当前线程睡眠10秒
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("主线程结束");

    }
}

class Thread02 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i <5; i++) {
            System.out.println(Thread.currentThread().getName()+"--->"+i);
            try {
                //这里会为什么只能try...catch..去捕捉异常，不能抛出，因为子类不能比父类抛出更多的
                //异常，Runnable接口中并没有抛出异常，所以这里不能抛出异常，只能try..catch...处理
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
