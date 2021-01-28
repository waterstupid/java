package com.xiaofu.review;

/**
 * 1.首先我们要了解程序，进程和线程
 * 程序:是为了完成某种让任务，用某种语言写出来的一段代码集合,是由一些静态代码组成的
 * 进程:可以看成程序的一次执行过程,或是正在运行的程序
 * 线程:进程细分又可以分为线程，线程是程序中执行的一条路径,线程作为独立的调度单位，每个线程都
 * 有独立的栈和程序计数器，但是每个线程都是共享进程的内存空间的，在java中，每个线程共享进程
 * 的方法区内存和堆内存，因为每个线程都可以操作相同变量，这样在加快效率的同时，也会带来一些
 * 安全隐患
 *
 * 并行:多个cpu执行多个任务
 * 并发:一个cpu执行多个任务，采用时间片的方式来调度线程
 *
 * 2.线程的创建
 * 1.继承Thread
 * 2.实现Runnable接口
 * 3.实现Callable接口
 * 4.使用线程池来创建线程
 * 3.两者的联系和区别:
 * 继承是将逻辑代码放入重写的run()方法当中
 * 而实现也是将逻辑代码放入重写的run()方法当中
 * 4.在开发中一般使用实现这种方式比较多，因为java中单继承的特性，当一个类继承另一个类的时候，
 * 就不能再继承其他类，而是接口是支持多继承的
 * 2.多个线程可以共享接口实现类中的对象，非常适合多个线程操控共享资源
 *
 *
 *
 */
// 1.继承Thread类
class MyThread extends Thread{
    // 2.重写当中的run()方法
    @Override
    public void run() {
        try {
            // 让当前线程睡眠100ms
            sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i <100 ; i++) {
            // 输出0-100之间所有的偶数
            if( i % 2 == 0){
                System.out.println(getName()+"--->"+i);
            }
        }

    }
}
public class ThreadText01{
    public static void main(String[] args) {
        // 开启主线程
        // 创建线程
        Thread thread= new MyThread();

        // 调用其中的start()方法,start()的方法有两个作用 1.开启线程 2.调用run()方法
        // 开启线程
        thread.start();
        for (int i = 0; i <100 ; i++) {
            if( i % 2 != 0){
                System.out.println(Thread.currentThread().getName()+"--->"+i);
            }
        }


    }




}
