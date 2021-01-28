package com.xiaofu.review;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * jdk5.0之后新增加了两种创建线程的方式
 * 1.实现Callable接口
 * 2.使用线程池来创建线程
 *
 * 实现Callable接口和实现Runnable接口的不同点:
 * 1.需要重写call()方法
 * 2.方法可以有返回值
 * 3.方法可以抛出异常
 * 4.支持泛型类的返回值
 * 5.可以配合FutureTask来获取方法的返回值
 *
 * Future:
 * 是一个接口,用来对Callable和Runnable结执行果的查询，是否完成和获取结构
 * FutureTask:使Future接口的唯一实现类，同时也实现了Runnable接口，可以被当作
 * 线程执行，又可以作为Future来获取Callable的结果
 *
 *
 */
class Callable01 implements Callable{
    // 来重写call()方法
    @Override
    public Object call() throws Exception {
        for (int i = 0; i <100 ; i++) {
            if(i % 2 == 0){
                System.out.println(Thread.currentThread().getName()+"-->"+i);
            }
        }
        return "success";
    }
}
public class CallableText01{
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable01 c = new Callable01();
        // 创建FutureTask对象
        FutureTask f =new FutureTask(c);
        System.out.println(1);
        // 创建线程

        Thread t = new Thread(f);
        // 可以获取方法的返回值
        /*try {
            // 可以获取返回值
            Object value = f.get();
            System.out.println("当前方法的返回值为:"+value);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }*/

        // 开启线程
        t.start();
        // 可以使用get()方法获取方法的返回值
        System.out.println(f.get());


    }
}
