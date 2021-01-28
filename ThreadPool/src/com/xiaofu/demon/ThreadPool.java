package com.xiaofu.demon;

import java.util.*;

/**
 * @author fmk
 * @date 2020/5/14
 **/
public class ThreadPool {
    // 这是一个容器
    List<Runnable> tasks=new ArrayList<Runnable>();
    // 初始线程
    private int num=0;
    // 核心线程
    private int corePoolSize;
    // 最大线程
    private int maxPoolSize;
    // 线程队列
    private int workQueue;

    public ThreadPool(int corePoolSize, int maxPoolSize, int workQueue) {
        this.corePoolSize = corePoolSize;
        this.maxPoolSize = maxPoolSize;
        this.workQueue = workQueue;
    }
    // 线程池中有一个提交方法
    public void submit(Runnable r){
        if(tasks.size()>=maxPoolSize){
            System.out.println("线程池已满，线程"+r+"抛弃了");
        }else{
            tasks.add(r);
            executeThread(r);
        }
    }

    private void executeThread(Runnable r) {
        if(tasks.size()<corePoolSize){
            new Worker(tasks,"核心线程").start();
            num++;
        }else if(tasks.size()<maxPoolSize){
            new Worker(tasks,"非核心线程").start();
            num++;
        }else{
            System.out.println("线程"+r+"被缓存了.....");
        }
    }

}
