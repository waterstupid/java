package com.xiaofu.atomicReview;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 1.该类用来体会使用AtomicInteger来保证i++的原子性，底层其实使用到的原理是CAS
 * 所谓CAS就是Compare And Swap(比较并且交换),是拿当前期望值和主物理内存的值进行相比较，如果
 * 相等，则进行修改，如果不相等，底层其实是采用了一个do..while..循环，会一直循环判断两个值
 * 是否一致
 * 深入底层源码:
 * AtomicInteger其实是调用了Unsafe类中的方法
 * Unsafe类:提供java可以像C,C++一样利用指针去操控内存，首先AtomicInteger的底层是有一个private volatile int value,
 * 该值是用来保存初始变量值的,我们需要直到AtomicInteger这个对象的内存地址，和这个value变量的内存地址，那么我们就可以通过
 * 指针去操控内存空间了，value变量的内存地址是通过Unsafe类中的一个方法得到的，再深入底层
 * Unsafe:其实最终是调用了Unsafe类中的getAndIntAdd()这个方法，这个方法中有一个do..while()循环，首先是通过AtomicInteger
 * 这个对象的内存地址和value的内存地址来获取当前主物理内存中变量的值，注意:使用的方法是getIntVolatile()这个方法才是原子性的，不会
 * 被打断，那么执行完这个方法之后，线程是有可能cpu的时间片执行完毕，从而从运行状态到就绪状态，其他线程这时候有可能去修改这个变量的值，
 * 然后上一个线程又再次抢占到了cpu的执行权，这个时候会调用Unsafe类中的一个本地方法，也就是compareAndSwapInt()这个方法，这个方法
 * 底层才是采用了CAS的思想，这个方法会再一次获取主物理内存中变量的值，如果这个值和之前获取的值相同，那么方法返回true，跳出循环，如果
 * 不相等，方法返回false,然后再继续循环，直到两次主物理内存的值一致才退出循环。
 *
 * 2.CAS的优缺点
 * 1.并发性高
 * 缺点:
 * 1.因为是循环，所以对cpu的消耗很大，如果线程数量一多，就会一直循环等待
 * 2.只能对单个变量进行原子操作
 * 3.会产生ABA问题
 *
 *
 * 3.ABA问题
 * 就是在进行期望值和主物理内存值比较的时候，有可能其他线程将这个值改变了多次，只不过组最后一次改回的值
 * 是期望值，这样就会造成一种错觉，没有其他线程改变过主物理内存中的值
 *
 * 4.怎么解决ABA问题
 * 采用一个原子引用更新，也就是使用AtomicStampReference这个类可以解决，底层就是用一个版本号来控制，每次
 * 改变主物理内存值的时候，也会对版本号进行一个改变，每次比较期望值和主物理内存值的时候，也会对期望版本号和主物理
 * 内存的版本号进行一个比较
 *
 *
 *
 *
 */
public class AtomicDemo01 {
    public static void main(String[] args) {
        Count count = new Count();
        for(int i = 0; i< 3;i++){
            new Thread(() ->{
                for(int j = 0 ; j < 10 ; j++){
                    count.addCount();
                }
            },String.valueOf(i)).start();
        }


    }
}
class Count{
    private AtomicInteger integer = new AtomicInteger(0);

    public void addCount(){
        // 没有加synchronized关键字也能保存线程安全问题
        System.out.println(Thread.currentThread().getName()+"->"+integer.getAndIncrement());
    }

}

