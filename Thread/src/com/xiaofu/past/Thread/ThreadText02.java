package com.xiaofu.past.Thread;

/**
 * 该程序用来测验实现线程的第二种方法，实现Runnable接口，并重写run()方法
 *
 * @author fmk
 * @date 2020/5/1
 **/
public class ThreadText02 {
    public static void main(String[] args) {
        //调用有参构造，可以将Runnable接口的实现类传递进去
        Thread t=new Thread(new Runnable01());
        //开启线程
        t.start();
        System.out.println("主线程结束......");
    }


}

class Runnable01 implements Runnable{

    @Override
    public void run() {
        System.out.println("分支线程执行....");
        System.out.println("分支线程结束....");
    }
}
