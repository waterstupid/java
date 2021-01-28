package com.xiaofu.volatile01;

/**
 * Volatile 是一个轻量级的Synchronized,是一个关键字
 * Volatile三大特性：
 * 1.可见性:要理解可见性必须就要理解JMM内存模型，那么什么是JMM内存模式呢?JMM内存模式就是规定了线程和线程
 * 之间是如何通信的，线程和线程之间有自己独立的工作内存，JMM规定了线程不能直接修改主内存中的共享变量值，而是
 * 需要通过将主物理内存的值拷贝一份到自己的工作内存，然后在工作内存对这个变量进行修改再写回主内存，可见性就相当于
 * 一种通知机制，就是通知其他线程主物理内存的值已经改变，需要重新去读取主物理内存的值
 * 2.不保证原子性
 * 在数据库事务中我们有接触到原子性,事务是具有原子性的，事务是指一条DML语句或者多条DML语句同时执行成功，或者同时执行失败，
 * 这就是事务的原子性，那么在java中，原子性是指从主物理内存中读取共享变量，在工作内存中修改共享变量的值，然后将共享变量的值
 * 写回到主物理内存中，这个过程是不能被打断的，这就是原子性，但是Volatile不保证原子性
 * 3.禁止指令重排序
 * 指令重排就是在JVM中执行Class字节码中的指令顺序不一定和我们编写java源代码的顺序一致，而是编译器会为了提高程序的执行效率
 * 从而来进行指令重排序，但是指令重排序不能破坏数据一致性，所谓数据一致性就是变量必须申明而且赋值之后才能使用，指令重排不能将
 * 一个未声明的变量用来使用，在单线程环境下，指令重排是没有问题的，但是在多线程环境下，指令重排就会导致一些安全问题
 *
 *
 */
public class VolatileDemo {
    // 主物理内存中的值
    // public static int i =20;
    // 但是加入了volatile就不一样
    public volatile static int i = 20;

    public static void main(String[] args) {
        new Thread(()->{
            try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}
            System.out.println(Thread.currentThread().getName()+"begin....");
            // i = 30,分为三部，从主物理内存中读取i,在自己的工作内存中将i改为30,然后写回主物理内存中
            i = 30;
            System.out.println(Thread.currentThread().getName()+"end......");
        },"A").start();
        // 因为没有通知Mai线程主物理内存的值已经改变，所以Main线程中的值i是一直等于20的
        while(i == 20){
            //System.out.println();
        }
        System.out.println(Thread.currentThread().getName()+"update...,i="+i);






    }
}
