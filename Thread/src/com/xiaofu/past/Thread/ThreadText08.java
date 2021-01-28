package com.xiaofu.past.Thread;

/**
 * 该程序用来测试如何中止程序的睡眠
 * 采用异常的方式来中止程序的睡眠
 * void interrupt()
 * 中断这个线程。
 * @author fmk
 * @date 2020/5/1
 **/
public class ThreadText08 {
    public static void main(String[] args) {
        Thread t=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"--->"+"运行");
                try {
                    //设定睡眠一天
                    Thread.sleep(1000*60*60*24);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"---->"+"结束");
            }
        });
        t.setName("t1");
        // 开启线程
        t.start();
        // 如何打断线程的睡眠,采用异常的方式去中止线程的睡眠
        t.interrupt();
    }
}
