package com.xiaofu.review;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolDemo {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(
                3,5,3L,
                TimeUnit.SECONDS,new ArrayBlockingQueue<Runnable>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()
        );
        for (int i = 1; i <=9 ; i++) {
            threadPool.execute(()->{
                System.out.println(Thread.currentThread().getName()+"\t  执行任务");
            });
        }


    }
}
