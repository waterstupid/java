package com.xiaofu.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadExecutorDemo {
    public static void main(String[] args) {
        // 底层new ThreadPoolExecutor()
        // 线程池中只有一个工作线程，也就是maximumPoolSize为1,但是workQueue为
        // LinkedBlockingQueue,所以后面提交的任务都会在阻塞队列中阻塞
        ExecutorService executor = Executors.newSingleThreadExecutor();
        for (int i = 1 ; i <= 10 ; i++) {
            executor.execute(()->{
                System.out.println(Thread.currentThread().getName()+"\t执行任务");
            });
        }
        executor.shutdown();


    }
}
