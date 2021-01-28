package com.xiaofu.past.Thread;

/**
 * 该程序用来测验实现线程的第一种方式，继承Thread类，并重写run()方法
 * @author fmk
 * @date 2020/5/1
 **/
public class ThreadText01 {
    public static void main(String[] args) {
        //创建一个线程
        MyThread thread=new MyThread();
        //调用start() 方法
        //start() 方法瞬间执行完毕，创建了一个新的独立的栈内存空间
        //但是start()方法结束，并不会调用run()方法，它只是建立一个新的栈内存空间，启动线程而已
        thread.start();
        System.out.println("主线程结束");
    }


}

/*
创建一个线程
 */
class MyThread extends Thread{
    @Override
    public void run() {
        System.out.println("线程1启动");
        System.out.println("线程1结束");

    }
}