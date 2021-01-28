package com.xiaofu.past.Thread;

/**
 * 该程序用来测验线程的生命周期
 * 1.新建状态（线程刚被new出来）
 * 2.就绪状态（start()方法被调用）
 * 3.运行状态（run()方法被调用）
 * 4.阻塞状态（遇到阻塞事件的时候）
 * 5.结束状态
 * @author fmk
 * @date 2020/5/1
 **/
public class ThreadText04 {
    public static void main(String[] args) {
        //新建状态
        Thread t=new Thread(new Runnable02());
        //就绪状态，调用start()方法
        t.start();
        //然后调用start()方法之后，抢占cpu时间片，一旦抢占到，便会调用run()方法，进入到运行状态
        for (int i = 0; i <1000 ; i++) {
            System.out.println("主线程---->"+i);
        }
    }
}

class Runnable02 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i <1000 ; i++) {
            System.out.println("分支线程---->"+i);
        }
        //一旦run()方法结束后，线程会进入结束状态
    }
}
