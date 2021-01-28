package com.xiaofu.homework;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 编写生产者消费者多线程程序，设有一个最大库存量为4的电视机仓库，
 * 生产10台电视机，一边生产一边销售（消费）。
 */
public class Demo02 {
    public static void main(String[] args) {
        Produce produce = new Produce();
        new Thread(()->{produce.produce();},"生产者").start();
        new Thread(()->{produce.consumer();},"消费者").start();



    }
}
class Produce{
    private AtomicInteger atomic = new AtomicInteger();
    private BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(4);
    public void produce(){
        while(true){
            if(atomic.getAndIncrement() >= 10){
                break;
            }else{
                try {
                    if(queue.offer(atomic.get(),3, TimeUnit.SECONDS)){
                        System.out.println(Thread.currentThread().getName()+"->\t开始生产电视机，当前电视机:"+atomic.get());
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public void consumer(){
        try {
            while(queue.poll(3, TimeUnit.SECONDS) != null){
                System.out.println(Thread.currentThread().getName()+"->\t消费成功，当前电视机剩余:"+(atomic.get()-1));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
