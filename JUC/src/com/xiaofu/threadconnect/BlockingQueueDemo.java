package com.xiaofu.threadconnect;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class MyBlockingQueue{
    private volatile boolean flag = true;
    private volatile BlockingQueue<String> blockingQueue = null;
    AtomicInteger atomicInteger = new AtomicInteger();

    public MyBlockingQueue(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    public void produce() throws InterruptedException {
        String data="";
        while(flag){
            data = atomicInteger.incrementAndGet()+"";
            // 注意:这里的offer()方法,如果队列中的元素已满，那么就会阻塞两秒,如果这个时候队列还是满的
            // 那么就会返回true,但是2秒钟的时间，在多线程环境下，足够其他消费者线程消费了，所以很难插入数据失败的
            if(blockingQueue.offer(data,2L,TimeUnit.SECONDS)){
                System.out.println(Thread.currentThread().getName()+"\t插入数据成功，data = "+data);
            }else{
                System.out.println(Thread.currentThread().getName()+"\t插入数据失败，data= "+data);
            }
            try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}
        }
        System.out.println("大老板叫停生产，生产停止");


    }

    public void consume() throws InterruptedException {
        String result;
        while(flag){
            result = blockingQueue.poll(2L,TimeUnit.SECONDS);
            if(result == null){
                System.out.println(1);
                flag = false;
                System.out.println("大老板叫停消费,消费停止");
                return;
            }
            System.out.println(Thread.currentThread().getName()+"\t消费数据成功");
        }


    }

    public void stop(){
        flag = false;


    }


}
public class BlockingQueueDemo {
    public static void main(String[] args) {
        MyBlockingQueue blockingQueue = new MyBlockingQueue(new ArrayBlockingQueue<String>(3));
        new Thread(()->{
            try {
                    blockingQueue.produce();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"生产者").start();
        new Thread(()->{
            try {
                    blockingQueue.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"消费者").start();

        try {Thread.sleep(3000);} catch (InterruptedException e) {e.printStackTrace();}
        blockingQueue.stop();



    }
}
