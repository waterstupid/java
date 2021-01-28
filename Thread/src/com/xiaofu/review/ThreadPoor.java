package com.xiaofu.review;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 创建线程的第四种方式：
 * 使用线程池来创建线程
 * 思路:创建一个线程池提前放好线程在里面，需要用到线程的时候从线程池中获取，用完了线程之后，就将
 * 线程归还到线程池中，这样可以避免线程频繁创建和销毁，重而重复利用，可以提高效率
 * 使用线程池的好处:
 * 1.提高响应速度(每次不用创建线程，而是直接从线程池中获得)
 * 2.降低资源消耗
 * 3.方便线程管理
 *
 * 与线程池有关的的类:
 * Executors:这是一个线程工具类，可以用来获取线程池
 * ExecutorService:这是真正的有关线程池的接口,唯一子类ThreadPoorExecutor
 *
 */
public class ThreadPoor{
    public static void main(String[] args){
        // 创建只能装10个线程的线程池
        //ExecutorService service = Executors.newFixedThreadPool(10);
        ThreadPoolExecutor service = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);
        System.out.println(service.getClass().getName());
        // 该方法用来执行一个线程
        service.execute(new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <100 ; i++) {
                    if( i % 2 ==0 ){
                        System.out.println(i);
                    }
                }
            }
        }));
        // 该方法用来关闭线程池
        service.shutdown();
    }


}
