package com.xiaofu.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPoolDemo {
    public static void main(String[] args) {
        // 底层也是new ThreadPoolExecutor() maximumPoolSize为Integer.MAX_VALUE
        // 可以进行扩容，遇强则强，之前创建的工作线程如果空闲则可重用
        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 1; i <=10 ; i++) {
            executor.execute(()->{
                System.out.println(Thread.currentThread().getName()+"\t执行任务");
            });
            try {Thread.sleep(500);} catch (InterruptedException e) {e.printStackTrace();}
        }
        executor.shutdown();



    }
}
