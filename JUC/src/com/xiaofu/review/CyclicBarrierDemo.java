package com.xiaofu.review;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {
    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(7,()->{
            System.out.println(Thread.currentThread().getName()+"\t 神龙出现");
        });
        for(int i = 1; i<=7;i++){
            int finalI = i;
            new Thread(() ->{
                final int temp = finalI;
                System.out.println(Thread.currentThread().getName()+"\t 集齐第"+ temp +"颗龙珠");
                try {
                    barrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        }





    }
}
