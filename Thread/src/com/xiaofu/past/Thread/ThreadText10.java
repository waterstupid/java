package com.xiaofu.past.Thread;

/**
 * 该程序用来测试守护线程
 * 什么是守护线程？
 * 1.守护线程一般都是一个死循环，一般在所有用户线程结束后，守护线程也会结束
 * 2.方法 ：void setDaemon(boolean on)
 * 将此线程标记为 daemon线程或用户线程
 * @author fmk
 * @date 2020/5/2
 **/
public class ThreadText10 {
    public static void main(String[] args) {
        //采用匿名内部类的方式创建一个守护线程
        Thread t=new Thread(new Runnable() {
            @Override
            //这是一个守护线程
            public void run() {
                int i=0;
                while(true){
                    System.out.println(Thread.currentThread().getName()+"--->"+(++i));
                }
            }
        });
        t.setName("守护线程");
        //将线程t变为守护线程
        t.setDaemon(true);
        t.start();
        for (int i = 0; i <10 ; i++) {
            System.out.println(Thread.currentThread().getName()+i);
        }
    }
}
