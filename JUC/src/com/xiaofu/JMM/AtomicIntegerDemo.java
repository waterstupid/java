package com.xiaofu.JMM;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 怎么解决volatile不保证原子性的问题？
 * 1.可以使用AtomicInteger来解决
 *
 * 为什么可以使用AtomicInteger来解决原子性的问题？
 * 是采用了CAS的原理。CAS就是Compare And Swap,就是比较交换,首先AtomicInteger
 * 底层使用到了Unsafe类，该类是sun公司自带的一个类，该类中有很多方法是native方法，这些
 * native方法都采用CAS的思想，在使用getAndIncrement()方法的时候，其实是调用了Unsafe
 * 类中的getAndAddInt()方法，这个方法需要三个参数，第一个参数就是AtomicInteger本身，
 * 第二个参数就是该对象的内存地址，第三个参数就是每次要加上的值，该方法的底层就是有一个do..while
 * 循环，首先通过对象和内存地址,准确得到该对象在主物理内存的值,然后再过一会，判断这个时候得到的
 * 主物理内存的对象值和上一次得到的值是否一致，如果一致就加上1，如果不一致，则继续比较，直到
 * 一致为止。
 * 简单言之，因为这个方法没有加锁，所以多个线程可以并发的访问，当一个线程第一次运行getIntVolatile()
 * 方法的时候，得到了此时主内存共享变量的内存快照，由于没有加锁，该线程有可能挂起，然后其他线程进入到了
 * 该方法中看，改变主物理内存的值，所以当上一个线程重新进入到运行的时候，再一次从主物理内存中得到共享变量
 * 的内存快照，这时候的内存快照肯定和上一次不一致，因为有线程修改了它，所以它会进行继续比较，而不是更新主物理
 * 内存的值，这样就保证了原子性，即每次线程都会通过循环获取主物理内存中共享变量最新的值
 *
 * CAS是cpu的一个原语操纵，是不能被分割的
 *
 *
 *
 */
class Data02{
    AtomicInteger integer = new AtomicInteger(0);
    public void addInteger(){
        integer.getAndIncrement();
    }
}
public class AtomicIntegerDemo {
    public static void main(String[] args) {
        Data02 d = new Data02();
        for(int i = 0; i<20;i++){
            new Thread(() ->{
                for (int j = 0; j <1000 ; j++) {
                    d.addInteger();
                }
            },String.valueOf(i)).start();
        }
        try {Thread.sleep(2000);} catch (InterruptedException e) {e.printStackTrace();}
        System.out.println(Thread.currentThread().getName()+"\t update new value="+d.integer);




    }

}
