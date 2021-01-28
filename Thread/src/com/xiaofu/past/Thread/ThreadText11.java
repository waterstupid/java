package com.xiaofu.past.Thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 该程序用来实现线程的第三种方式
 * 实现Callable接口
 * @author fmk
 * @date 2020/5/2
 **/
public class ThreadText11 {
    public static void main(String[] args) {
        FutureTask future=new FutureTask(new Callable01());
        //调用run()方法
        future.run();
        try {
            //可以得到线程的返回值
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }
}

class Callable01 implements Callable{
    @Override
    public Object call() throws Exception {
        System.out.println("call begin...");
        Thread.sleep(1000);
        int a=100;
        int b=200;
        return a+b;
    }
}
