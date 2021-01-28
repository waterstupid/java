package com.xiaofu.review;

/**
 * 第二种创建线程的方式就是实现Runnable接口,并重写其中的run()方法
 *
 *
 *
 */
public class ThreadText02 {
    // 开启主线程
    public static void main(String[] args) {
        MyRunnable my = new MyRunnable();
        // 将重写该接口的子类作为形参传入其中的构造函数
        Thread t = new Thread(my);
        // 1. 开启线程  2.调用run()方法
        t.start();

        // 让当前线程睡眠1秒
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i <100 ; i++) {
            if( i % 2 != 0 ){
                // 主线程输入奇数
                System.out.println(Thread.currentThread().getName()+"--->"+i);
            }
        }



    }



}
// 1.实现这个接口
class MyRunnable implements Runnable{
    // 重写其中的run()方法
    @Override
    public void run() {
        for (int i = 0; i <100 ; i++) {
            // 输出偶数
            if( i % 2 ==0 ){
                System.out.println(Thread.currentThread().getName()+"-->"+i);
            }
        }
    }
}

