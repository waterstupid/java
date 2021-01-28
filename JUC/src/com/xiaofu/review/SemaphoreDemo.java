package com.xiaofu.review;

import java.util.concurrent.Semaphore;

public class SemaphoreDemo {
    public static void main(String[] args) {
        Semaphore semaphore =new Semaphore(3);
        for(int i = 1; i<=10;i++){
            new Thread(() ->{
                try {
                    // 抢占到该资源
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+"抢占到了车位");
                    Thread.sleep(2000);
                    // 释放该资源
                    semaphore.release();
                    System.out.println(Thread.currentThread().getName()+"释放了车位");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        }




    }
}
