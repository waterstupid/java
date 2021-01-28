package com.xiaofu.threadpool;

import java.util.concurrent.*;

public class ThreadPoolExecutorDemo {
    public static void main(String[] args) {
        // 定义该线程池的意义为:线程池中核心数量为3,线程池中最大的工作线程数量为5,
        // 空余线程在超过5s之后没工作就会被销毁，阻塞队列的容量为5,采用的拒绝策略是
        // 直接抛出异常终止程序运行
        ThreadPoolExecutor executor = new ThreadPoolExecutor(3
                ,5,10L,
                TimeUnit.SECONDS,new ArrayBlockingQueue<Runnable>(5),
                Executors.defaultThreadFactory(),new ThreadPoolExecutor.CallerRunsPolicy()
                );
        for (int i = 1; i <=13; i++) {
            executor.execute(()->{
                System.out.println(Thread.currentThread().getName()+"\t执行任务");
                //while(true);
            });
        }
        executor.shutdown();


    }
}
