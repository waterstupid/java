package com.xiaofu.threadpool;

import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPoolDemo {
    public static void main(String[] args) {
        // 注意:newFixedThreadPool()底层是调用了new ThreadPoolExecutor()
        // 它的阻塞队列为LinkedBlockingQueue,所以它永远不会使用饱和策略
        // 即永远也不会抛出异常
        ExecutorService executor = Executors.newFixedThreadPool(3);
        for (int i = 1; i <=10; i++) {
            executor.execute(()->{
                System.out.println(Thread.currentThread().getName()+"\t执行任务");
                try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}
            });
        }
        executor.shutdown();

    }
}
