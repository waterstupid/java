package com.xiaofu.review;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 实现Callable接口是创建线程的第三种方式,实现Callable接口需要重写其中的call()方法，与run()方法不同的地方在于，
 * Callable接口支持泛型，也就说call()方法的返回值我们自由定义，call()方法可以有返回值，可以抛出异常，可以支持泛型的
 * 使用，可以结合FutureTask来获取返回值
 *
 * Future接口
 * 一个future的计算结果，里面定义的方法可以用来检测计算结果是否完成，等待计算结果的完成和获取计算结果的完成等等。我们一般
 * 使用的都是Future接口的实现类,也就是FutureTask,FutureTask实现了Runnable接口，所以它自身就是一个线程，更因为Future
 * Task中的构造方法的参数可以是Callable接口的实现类，所以FutureTask将Callable接口的实现类和线程关联了起来
 *
 * get()方法使用的注意场景:
 * get()方法会使当前线程从运行状态进入到阻塞状态，直到计算结果完成之后，该线程才会重新运行，所以考虑效率问题，一般将get()
 * 方法放到最后一行
 *
 *
 *
 *
 */
public class CallableDemo01 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // FutureTask实现了Runnable接口，所以使一个可提交的线程
        FutureTask<String> future = new FutureTask<>(() -> {
            try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}
            for (int i = 0; i < 100; i++) {
                System.out.println(i);
            }
            return "success";
        });
        new Thread(future,"A线程").start();
        // 获取计算结果的返回值,该程序会阻塞在这里，直到计算结果的完成
        System.out.println(future.get());
        System.out.println("计算结果计算完成");


    }





}
