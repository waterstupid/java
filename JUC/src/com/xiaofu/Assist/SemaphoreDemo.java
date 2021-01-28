package com.xiaofu.Assist;

import java.util.concurrent.Semaphore;
// 该类可用控制线程的并发数量
public class SemaphoreDemo {
    public static void main(String[] args) {
        // 这是一个信号计数量,可以控制线程的并发数
        Semaphore semaphore = new Semaphore(4);
        for(int i = 0; i<10;i++){
            new Thread(() ->{
                try {
                    // 从信号量获取许可证，阻止可用
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+"抢占到了车位");
                    Thread.sleep(1000);
                    // 从信号量中释放许可证
                    semaphore.release();
                    System.out.println(Thread.currentThread().getName()+"释放了车位");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            },String.valueOf(i)).start();
        }




    }


}
