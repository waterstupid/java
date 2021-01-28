package com.xiaofu.JMM;

/**
 *  volatile有三个特性,第一个是可见性，第二个是不保证原子性，第三个是禁止指令重排序
 *  可见性意思就是在其他线程修改完自己工作内存中变量副本的值之后，然后将这个变量副本又写回
 *  到主内存，可见性就相当于一个通知机制，通知其他线程主物理内存的共享变量已改变，需要重新获取
 *
 *
 */


class MyData{
    // 这里加上了Volatile来表示线程修改的值是可以被其他线程看见的
    volatile int data = 10;
    public void send60(){
        data--;
    }
}
public class VolatileDemo {
    public static void main(String[] args) {
        MyData data = new MyData();
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"\t 开始");
            try {Thread.sleep(3000);} catch (InterruptedException e) {e.printStackTrace();}
            data.send60();
            System.out.println(Thread.currentThread().getName()+"\t 结束");
            },"A").start();
        while(data.data == 10){
            // try {Thread.sleep(500);} catch (InterruptedException e) {e.printStackTrace();}
            // System.out.println(data.data);
            // System.out.println("******");
            // System.out.println();
            // try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}
            // System.out.println(data.data);

        }
        System.out.println(Thread.currentThread().getName()+"\t update new value "+data.data);


    }



}
