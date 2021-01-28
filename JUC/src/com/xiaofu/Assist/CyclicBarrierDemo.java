package com.xiaofu.Assist;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {
    public static void main(String[] args) {
        CyclicBarrier cyclic = new CyclicBarrier(7,()->{
            System.out.println("集齐7颗龙珠召唤神龙");
        });
        for(int i = 0; i<7;i++){
            final int temp = i;
            new Thread(() ->{
                System.out.println(Thread.currentThread().getName()+"集齐到了"+temp+"颗龙珠");
                try {
                    // 在这里也会有一个计时器来进行加法,如果计时器到了7就会执行一个特别的线程
                    cyclic.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        }





    }


}
