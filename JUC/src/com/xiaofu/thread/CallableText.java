package com.xiaofu.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 在jdk1.5之后新增了两种创建线程的方式
 * 1.实现Callable接口
 * 2.使用Executors创建线程池
 *
 */
public class CallableText {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 由于Thread的构造方法中不能传递Callable接口类型的对象
        // 所以我们想其他办法，所以找到了一个类FutureTask
        // 该类实现了Runnable接口，其中的构造方法可用传递Callable类型的参数
        FutureTask<Integer> futureTask = new FutureTask<Integer>(()->{
            System.out.println(Thread.currentThread().getName()+"到此一游");
            try {Thread.sleep(3000);} catch (InterruptedException e) {e.printStackTrace();}
            return 10+20;
        });
        // futureTask实现了Runnable接口，其实自己就是一个线程
        new Thread(futureTask).start();
        // System.out.println("result:"+futureTask.get());
        System.out.println(Thread.currentThread().getName()+"到此一游");
        // 如果要使用FutureTask的get()方法得到方法的返回值，那么建议将这一行代码放到最后一行
        // get()方法会使当前线程进入阻塞状态，直到实现Callable的线程中的方法执行完毕之后
        // 才会不阻塞
        System.out.println("result:"+futureTask.get());

    }


}
