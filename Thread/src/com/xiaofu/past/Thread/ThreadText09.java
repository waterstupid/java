package com.xiaofu.past.Thread;

/**
 * 该程序用来测试如何采用合理的方式来结束线程的睡眠
 * 1.采用打标记的方式
 * @author fmk
 * @date 2020/5/1
 **/
public class ThreadText09 {
    public static void main(String[] args) {
        MyThread02 t=new MyThread02();
        t.setName("t1");
        //开启线程
        t.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //结束线程
        t.flag=false;

    }
}

class MyThread02 extends Thread{
    boolean flag=true;
    @Override
    public void run() {
            for (int i = 0; i <10 ; i++) {
                if(flag){
                    System.out.println(Thread.currentThread().getName()+"--->"+i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else{
                    //如果不为false，则结束这个方法
                    System.out.println(Thread.currentThread().getName() + "--->结束");
                    return;
                }
        }

    }
}
