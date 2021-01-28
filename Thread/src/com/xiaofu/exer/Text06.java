package com.xiaofu.exer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Text06 {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);
        executor.submit(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <100 ; i++) {
                    if( i% 2 ==0){
                        System.out.println(Thread.currentThread().getName()+"->"+i);
                    }
                }
            }
        },"A");


    }
}
