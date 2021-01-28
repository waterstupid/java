package com.xiaofu.atomic;

import javax.xml.stream.events.StartDocument;
import java.util.concurrent.atomic.AtomicInteger;

public class ABADemo {
    public static void main(String[] args) {
        /**
         * 该类就展现了ABA的问题,也就是说有两个线程，一个线程在另外一个线程写之前，将
         * 主物理内存的值该变了两次，只不过最后一次将这个值改成原先主物理内存的值而已
         *
         */
        AtomicInteger atomic = new AtomicInteger(5);
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"\t开始修改");
            atomic.compareAndSet(5,2019);
            atomic.compareAndSet(2019,5);
            System.out.println(Thread.currentThread().getName()+"\t修改完毕,结果为"+atomic.get());
        },"A").start();
        new Thread(()->{
            try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}
            System.out.println(Thread.currentThread().getName()+"\t开始修改");
            // 改变原来的值
            System.out.println(atomic.compareAndSet(5, 2020));
            System.out.println(Thread.currentThread().getName()+"\t修改完毕,value="+atomic.get());
        },"B").start();




    }

}
