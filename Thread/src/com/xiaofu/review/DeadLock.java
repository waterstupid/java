package com.xiaofu.review;

/**
 * 1.什么是死锁？
 * 不同的线程占用彼此所需要的同步资源且都不放弃，等在等待对方释放自己需要的同步资源，就形成了
 * 线程的死锁
 * 2.线程的死锁不会出现异常，错误，只是线程都会进入阻塞状态
 *
 * 2.解决办法
 * 使用特定的算法
 * 少定义同步资源
 * 避免synchronized
 *
 *
 *
 */

class MyRunnable01 implements Runnable{
    private Object obj1;
    private Object obj2;

    public MyRunnable01(Object obj1, Object obj2) {
        this.obj1 = obj1;
        this.obj2 = obj2;
    }

    @Override
    public void run() {
        synchronized (obj1){
            System.out.println("======");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (obj2){

            }
        }

    }
}


class MyRunnable02 implements Runnable{
    private Object obj1;
    private Object obj2;

    public MyRunnable02(Object obj1, Object obj2) {
        this.obj1 = obj1;
        this.obj2 = obj2;
    }

    @Override
    public void run() {
        synchronized (obj2){
            System.out.println("======");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (obj1){

            }
        }

    }
}

public class DeadLock{
    public static void main(String[] args) {
        Object o1 = new Object();
        Object o2 = new Object();
        MyRunnable01 r1 = new MyRunnable01(o1,o2);
        MyRunnable02 r2 = new MyRunnable02(o1,o2);

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);

        // 开启线程
        // 出现死锁情况
        t1.start();
        t2.start();

    }

}
