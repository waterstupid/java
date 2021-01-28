package com.xiaofu.past.Thread;

/**
 * 该程序采用匿名内部类的方式来实现线程的创建
 * @author fmk
 * @date 2020/5/1
 **/
public class ThreadText03 {
    public static void main(String[] args) {
        //这里可以采用匿名内部类的方式,开启线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("分支线程开始运行....");
                System.out.println("分支线程运行结束....");
            }
        }).start();
        System.out.println("主线程结束....");


    }
}
